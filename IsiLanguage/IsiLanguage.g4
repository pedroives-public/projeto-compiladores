grammar IsiLanguage;

@header{
	import io.compiler.datastructures.IsiSymbol;
	import io.compiler.datastructures.IsiVariable;
	import io.compiler.datastructures.IsiSymbolTable;
	import io.compiler.exceptions.IsiSemanticException;
	import io.compiler.ast.IsiProgram;
	import io.compiler.ast.AbstractCommand;
	import io.compiler.ast.CommandLeitura;
	import io.compiler.ast.CommandEscrita;
	import io.compiler.ast.CommandAtribuicao;
	import io.compiler.ast.CommandDecisao;
	import io.compiler.ast.CommandLoopFor;
	import io.compiler.ast.CommandLoopWhile;
	import io.compiler.ast.CommandLoopDoWhile;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.logging.*;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private Stack<String> conditionStack = new Stack<String>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	private String _atribuicaoVariavel;
	private String _atribuicaoValor;
	
	private String _exprWhile;
	private String _exprFor;
	private ArrayList<AbstractCommand> commandList;
	
	private int _varType = -1;
	
	public void verificaID(){
		String id = ((TokenStream) _input).LT(-1).getText();
	
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Variable " + id + " not declared");
		}
	}
	
	public void adicionaSymbol() {
		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = null;
		symbol = new IsiVariable(_varName, _tipo, _varValue);
		
		if (!symbolTable.exists(_varName)) {
			symbolTable.add(symbol);
		} else {
			throw new IsiSemanticException("Variable " + _varName + " already declared");
		}
	}
	
	public void checaUsoVariavel(){
 		for (String s : symbolTable.keySet()) {
 			if(((IsiVariable) symbolTable.get(s)).getValue() == null){
 				
 				Logger logger  = Logger.getLogger(IsiLanguageParser.class.getName()); 
  
        		// Set logger
        		logger.setLevel(Level.WARNING);
  
        		// Warning method 
        		logger.warning("Variable " + s + " never used"); 
 			}
		}
 	}
 	
 	public void verificaAtribuicao(){
 		_varName = ((TokenStream) _input).LT(-1).getText();
 		if(((IsiVariable) symbolTable.get(_varName)).getValue() == null){
 				Logger logger  = Logger.getLogger(IsiLanguageParser.class.getName()); 
  
        		// Set logger
        		logger.setLevel(Level.WARNING);
  
        		// Warning method 
        		logger.warning("Variable " + _varName + " not initialized"); 
 		}
 	}
 	
	public void atribuiValor(){
	    IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
	    var.setValue(_exprContent);
	}

	public void verificaTipoVariavel(int tipoAtual) {
		if (_varType == -1) {
			_varType = tipoAtual;
		} else if (_varType != tipoAtual) {
			throw new IsiSemanticException ("Mixing variables of type " + IsiVariable.getIsiType(tipoAtual) + " with " + IsiVariable.getIsiType(_varType));
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'start' bloco 'end;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	  checaUsoVariavel();
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo 
				ID 				{	adicionaSymbol();	
									_exprID = _input.LT(-1).getText();
								} 
				(	ATTR 		{ 	_exprContent = "";	
									_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
								}
					expr		{	atribuiValor();			
									CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);	
									stack.peek().add(cmd);
								}
				)?
				
				(
					VIR 
					ID 			{ 	adicionaSymbol(); 			
									_exprID = _input.LT(-1).getText();
								}
					(	
						ATTR 	{ 	_exprContent = "";	
									_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
								}
						expr	{	atribuiValor();			
									CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
									stack.peek().add(cmd);
								}
					)?
				)* SC
			;
           
tipo    :	INT_DECL		{	_tipo = IsiVariable.INT;		} 
		|	STRING_DECL 	{	_tipo = IsiVariable.TEXT;	}
		|	DOUBLE_DECL		{	_tipo = IsiVariable.DOUBLE;	}
		|	BOOLEAN_DECL	{	_tipo = IsiVariable.BOOLEAN;	}
		|	CHAR_DECL		{	_tipo = IsiVariable.CHAR;	}
		;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd | decl)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
 		|  forC  
 		|  whileC
 		|  doWhileC
		;
		
cmdleitura	: 'scanf' AP
                     ID { verificaID();
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'printf' 
                 AP 
                 ID { verificaID();
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  (
					(tipo ID)			{ 	adicionaSymbol(); 						} 
					| ID 				{ 	verificaID(); 							}
				)						{	_exprID = _input.LT(-1).getText();		}
				ATTR 					{ 	_exprContent = "";	
											_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
										}
				expr
				SC						{	
											atribuiValor();
											CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);	
											stack.peek().add(cmd);
										}
			;
			
			
cmdselecao 	:	IF	
					AP
					ID				{	_exprDecision = _input.LT(-1).getText();
										verificaAtribuicao();
										_exprContent = "";
									}
					OPREL 			{	_exprDecision += _input.LT(-1).getText();		}
					expr			{	_exprDecision += _exprContent;					}
					FP 
					ACH 			{	curThread = new ArrayList<AbstractCommand>();	
										stack.push(curThread);
										conditionStack.push(_exprDecision);
									}
					(cmd)+ 
					FCH			{	listaTrue = stack.pop();					}
					( 
					ELSE	
					ACH			{	curThread = new ArrayList<AbstractCommand>();	
										stack.push(curThread);
									} 
					(cmd)+ 
					FCH			{	listaFalse = stack.pop(); 				}
					)?				{	CommandDecisao cmd = new CommandDecisao(conditionStack.pop(), listaTrue, listaFalse);
										stack.peek().add(cmd);
									}
				;
				
whileC    : 	WHILE
	            AP
	            ID      {   _exprWhile = _input.LT(-1).getText();
	                        verificaAtribuicao();
	                        _exprContent = "";
	                    }
	
	            OPREL   {   _exprWhile += _input.LT(-1).getText();
	                    }
	            expr    {   _exprWhile += _input.LT(-1).getText();
	                    }
	            FP
	            ACH { curThread = new ArrayList<AbstractCommand>();
	                  stack.push(curThread);
	                  conditionStack.push(_exprWhile);
	                }
	            (cmd | incDec)+
	            FCH {   CommandLoopWhile cmd = new CommandLoopWhile(conditionStack.pop(), stack.pop());
	                    stack.peek().add(cmd);
	                }
        ;
        
doWhileC    :   DO 
                ACH { curThread = new ArrayList<AbstractCommand>();
	                  stack.push(curThread);
	                  conditionStack.push(_exprWhile);
	                }
                (cmd | incDec)+ 
                FCH 
                WHILE 
                AP 
                ID    {    _exprWhile = _input.LT(-1).getText();
                           verificaAtribuicao();
                           _exprContent = "";
                      }
                OPREL {    _exprWhile += _input.LT(-1).getText();        }
                expr  {    _exprWhile += _exprContent;        }
                FP 
                SC
                {
                    CommandLoopDoWhile cmd = new CommandLoopDoWhile(_exprWhile, stack.pop());
                    stack.peek().add(cmd);
                }
            ;
	
forC	: 	FOR 
			AP 
			ID 				{ 	verificaID(); 
								_exprID = _input.LT(-1).getText();
								_atribuicaoVariavel = _input.LT(-1).getText();
							
							} 
			ATTR 			{ 	_exprContent = "";	
								_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
							}
			expr 
			SC				{	_exprFor = _exprID + " = " + _exprContent + ";";	
								atribuiValor();
							}	
			ID 				{	
								if (_exprID.equals(_input.LT(-1).getText()) == false) {
									throw new IsiSemanticException("Expected variable -> " + _exprID);
								}
								
								_exprFor += _input.LT(-1).getText();
								verificaAtribuicao();
							}
			OPREL 			{	_exprFor += _input.LT(-1).getText();		
								_exprContent = "";
							}
			expr			{	_exprFor += _exprContent;					}
			SC 				{	_exprFor += _input.LT(-1).getText();		}
			ID 				{	
								if (_exprID.equals(_input.LT(-1).getText()) == false) {
									throw new IsiSemanticException("Expected variable -> " + _exprID);
								}
								_exprFor += _input.LT(-1).getText();
								verificaAtribuicao();
							}
			OP_INCREM		{	_exprFor += _input.LT(-1).getText();		}
			FP 
			ACH				{	curThread = new ArrayList<AbstractCommand>();	
								stack.push(curThread);
								conditionStack.push(_exprFor);
							}
			(cmd | incDec)+ 
			FCH				{
								CommandLoopFor cmd = new CommandLoopFor(conditionStack.pop(), stack.pop());
								stack.peek().add(cmd);
							}
		;
		
incDec  : ID        {  verificaID();
                      _exprID = _input.LT(-1).getText();
                    } 
          OP_INCREM {   
                        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprID + _input.LT(-1).getText());
                        cmd.setIncrementDecrement(true);
                        stack.peek().add(cmd);
                    }
          SC        
        ;
			
expr	:  	(
					(	
						term ( 
						OP_S { _exprContent += _input.LT(-1).getText();	}
						term )*
					)
			)
		;
		
term	:  	(
					(	
						factor ( 
						OP_M { _exprContent += _input.LT(-1).getText();	}
						factor )*
					)
			)
		;
			
factor	: 	( 
					ID 					{	verificaID();	
											verificaAtribuicao();
											int type = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
											verificaTipoVariavel(type);
										}  
					| INT_VAL			{	verificaTipoVariavel(IsiVariable.INT);			}
					| DOUBLE_VAL		{	verificaTipoVariavel(IsiVariable.DOUBLE);		}
					| STRING_VAL		{	verificaTipoVariavel(IsiVariable.TEXT);			}
					| BOOLEAN_VAL {
				            verificaTipoVariavel(IsiVariable.BOOLEAN);
				            String booleanInput = _input.LT(-1).getText();
				            _exprContent += booleanInput.equals("false") ? "false" : "true";
				        }
				    | CHAR_VAL {
				            verificaTipoVariavel(IsiVariable.CHAR);
				            _exprContent += _input.LT(-1).getText();
				        }
					| AP { _exprContent += "("; } expr FP
				) 	{	_exprContent += _input.LT(-1).getText();	}
		;
			
			
INT_DECL	: 'integer' 
			;

INT_VAL		: [0-9]+
			;
			
DOUBLE_DECL : 'double' 
			;

DOUBLE_VAL	: [0-9]+ ('.' [0-9]+)?
			;
 
STRING_DECL : 'text' | 'string'
			;

STRING_VAL	: '"' ([a-z]|[A-Z]|[0-9]|' ')* '"'
			;

BOOLEAN_DECL	: 'boolean'
				;

BOOLEAN_VAL : 'true' | 'false'
			;

CHAR_DECL 	: 'char' 
			;

CHAR_VAL	: 	'"'
				([a-z]|[A-Z]|[0-9])
				'"'
			;
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP_S	: '+' | '-' 
		;

OP_M	: '*' | '/'
		;
	
OP_INCREM	:	'++'
			|	'--'
			;
	
ATTR : '='
	 ;
	
IF	: 'if'
	;

ELSE 	: 'else'
		;

DO	:	'do'
	;
		
FOR	: 'for' 
	;

WHILE : 'while'
	  ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;