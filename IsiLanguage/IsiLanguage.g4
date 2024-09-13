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
	private String _exprDoWhile;
	private String _exprFor;
	private String _exprForInit;
	private String _exprForInitID;
	private String _exprForCondition;
	private String _exprForUpdate;
	
	private ArrayList<AbstractCommand> commandList;
	
	private int _varType = -1;
	
	private boolean _inLogicalExpr = false;
	
	public void verificaID() {
	    String id = ((TokenStream) _input).LT(-1).getText();
	    if (!symbolTable.exists(id)) {
	        throw new IsiSemanticException("Variable " + id + " not declared");
	    } else {
	        // Mark the variable as used
	        ((IsiVariable) symbolTable.get(id)).setUsed(true);
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
	
	public void checaUsoVariavel() {
	    for (String s : symbolTable.keySet()) {
	        IsiVariable var = (IsiVariable) symbolTable.get(s);
	        if (!var.isUsed()) {
	            Logger logger = Logger.getLogger(IsiLanguageParser.class.getName());
	            logger.setLevel(Level.WARNING);
	            logger.warning("Variable " + s + " declared but never used");
	        }
	    }
	}

 	
 	public void verificaAtribuicao() {
	    _varName = ((TokenStream) _input).LT(-1).getText();
	    IsiVariable var = (IsiVariable) symbolTable.get(_varName);
	    if (var.getValue() == null) {
	        Logger logger = Logger.getLogger(IsiLanguageParser.class.getName());
	        logger.setLevel(Level.WARNING);
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
	    } else {
	        if (_inLogicalExpr) {
	            if ((tipoAtual == IsiVariable.INT || tipoAtual == IsiVariable.DOUBLE) &&
	                (_varType == IsiVariable.INT || _varType == IsiVariable.DOUBLE)) {
	                // Types are compatible for relational operators
	            } else if (tipoAtual != _varType) {
	                throw new IsiSemanticException("Type mismatch in logical expression: cannot mix " +
	                    IsiVariable.getIsiType(tipoAtual) + " with " + IsiVariable.getIsiType(_varType));
	            }
	        } else {
	            if ((_varType == IsiVariable.INT || _varType == IsiVariable.DOUBLE) &&
	                (tipoAtual == IsiVariable.INT || tipoAtual == IsiVariable.DOUBLE)) {
	                if (_varType == IsiVariable.INT && tipoAtual == IsiVariable.DOUBLE) {
	                    _varType = IsiVariable.DOUBLE;
	                }
	            } else if (_varType != tipoAtual) {
	                throw new IsiSemanticException("Type mismatch: cannot mix " +
	                    IsiVariable.getIsiType(tipoAtual) + " with " + IsiVariable.getIsiType(_varType));
	            }
	        }
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
		
cmdleitura
    : 'leia' AP
      ID { verificaID(); _readID = _input.LT(-1).getText(); }
      FP
      SC
      {
          IsiVariable var = (IsiVariable) symbolTable.get(_readID);
          var.setValue("initialized"); // Mark the variable as initialized
          CommandLeitura cmd = new CommandLeitura(_readID, var);
          stack.peek().add(cmd);
      }
    ;


			
cmdescrita
    : 'escreva'
      AP
      ( ID { verificaID(); _writeID = _input.LT(-1).getText(); }
      | STRING_VAL { _writeID = _input.LT(-1).getText(); }
      )
      FP
      SC
      { CommandEscrita cmd = new CommandEscrita(_writeID); stack.peek().add(cmd); }
    ;

			
cmdattrib
    : ( (tipo ID) { adicionaSymbol(); } | ID { verificaID(); } )
      { _exprID = _input.LT(-1).getText(); }
      ATTR { _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_exprID)).getType(); }
      expr
      SC
      {
        atribuiValor();
        _varType = -1;
        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
        stack.peek().add(cmd);
      }
    ;


			
			
cmdselecao
    : IF
      AP
      { _exprContent = ""; listaFalse = null; }
      expr { _exprDecision = _exprContent; _exprContent = ""; _varType = -1; }
      FP
      ACH { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); conditionStack.push(_exprDecision); }
      (cmd)+
      FCH { listaTrue = stack.pop(); }
      (ELSE ACH { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); } (cmd)+ FCH { listaFalse = stack.pop(); })?
      { CommandDecisao cmd = new CommandDecisao(conditionStack.pop(), listaTrue, listaFalse); stack.peek().add(cmd); }
    ;

				
whileC
    : WHILE
      AP
      { _exprContent = ""; }
      expr { _exprWhile = _exprContent; _exprContent = ""; _varType = -1; }
      FP
      ACH { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); conditionStack.push(_exprWhile); }
      (cmd | incDec)+
      FCH { CommandLoopWhile cmd = new CommandLoopWhile(conditionStack.pop(), stack.pop()); stack.peek().add(cmd); }
    ;


        
doWhileC
    : DO
      ACH { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); }
      (cmd | incDec)+
      FCH
      WHILE
      AP
      { _exprContent = ""; }
      expr { _exprDoWhile = _exprContent; _exprContent = ""; _varType = -1; }
      FP
      SC
      { CommandLoopDoWhile cmd = new CommandLoopDoWhile(_exprDoWhile, stack.pop()); stack.peek().add(cmd); }
    ;

	
forC
    : FOR
      AP
      { _exprContent = ""; }
      ( (tipo ID) { adicionaSymbol(); } | ID { verificaID(); } ) { _exprForInitID = _input.LT(-1).getText(); }
      ATTR { _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_exprForInitID)).getType(); }
      expr { atribuiValor(); _exprForInit = _exprForInitID + " = " + _exprContent; }
      SC
      { _exprContent = ""; }
      expr { _exprForCondition = _exprContent; _exprContent = ""; _varType = -1; }
      SC
      { _exprContent = ""; }
      (ID { verificaID(); } OP_INCREM { _exprForUpdate = _input.LT(-2).getText() + _input.LT(-1).getText(); }
       | ID { verificaID(); } ATTR { _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType(); } expr { _exprForUpdate = _input.LT(-4).getText() + " = " + _exprContent; }
      )
      FP
      ACH { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); }
      (cmd | incDec)+
      FCH
      {
          String forCondition = _exprForInit + "; " + _exprForCondition + "; " + _exprForUpdate;
          CommandLoopFor cmd = new CommandLoopFor(forCondition, stack.pop());
          stack.peek().add(cmd);
      }
    ;

		
incDec
    : ID { verificaID(); _exprID = _input.LT(-1).getText(); }
      OP_INCREM { _exprContent = _exprID + _input.LT(-1).getText(); }
      SC
      { CommandAtribuicao cmd = new CommandAtribuicao("", _exprContent); cmd.setIncrementDecrement(true); stack.peek().add(cmd); }
    ;

			
expr
    : logical_or_expr
    ;



logical_or_expr
    : { _inLogicalExpr = true; }
      logical_and_expr (LOGICAL_OR { _exprContent += " || "; } logical_and_expr)*
      { _inLogicalExpr = false; }
    ;


logical_and_expr
    : logical_not_expr (LOGICAL_AND { _exprContent += " && "; } logical_not_expr)*
    ;

logical_not_expr
    : LOGICAL_NOT { _exprContent += "!"; } logical_not_expr
    | equality_expr
    ;


equality_expr
    : relational_expr ( (EQUALS | NOT_EQUALS) { _exprContent += _input.LT(-1).getText(); } relational_expr )*
    ;

relational_expr
    : arith_expr (OPREL { _exprContent += _input.LT(-1).getText(); } arith_expr)?
    ;

arith_expr
    : term (OP_S { _exprContent += _input.LT(-1).getText(); } term)*
    ;

term
    : factor (OP_M { _exprContent += _input.LT(-1).getText(); } factor)*
    ;

factor
    : ID { verificaID(); 
    		verificaAtribuicao();
    		int type = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
    		verificaTipoVariavel(type);
    		_exprContent += _input.LT(-1).getText(); }
    | INT_VAL { verificaTipoVariavel(IsiVariable.INT); _exprContent += _input.LT(-1).getText(); }
    | DOUBLE_VAL { verificaTipoVariavel(IsiVariable.DOUBLE); _exprContent += _input.LT(-1).getText(); }
    | STRING_VAL { verificaTipoVariavel(IsiVariable.TEXT); _exprContent += _input.LT(-1).getText(); }
    | BOOLEAN_VAL { verificaTipoVariavel(IsiVariable.BOOLEAN); _exprContent += ((_input.LT(-1).getText()).equals("verdadeiro") ? "true" : "false"); }
    | CHAR_VAL { verificaTipoVariavel(IsiVariable.CHAR); _exprContent += _input.LT(-1).getText(); }
    | LOGICAL_NOT { _exprContent += "!"; } factor
    | AP { _exprContent += "("; } expr FP { _exprContent += ")"; }
    ;


			
			
INT_DECL	: 'inteiro' 
			;

INT_VAL		: [0-9]+
			;
			
DOUBLE_DECL : 'real' 
			;

DOUBLE_VAL	: [0-9]+ ('.' [0-9]+)?
			;
 
STRING_DECL : 'texto' | 'string'
			;

STRING_VAL : '"' (~["\r\n])* '"' ;


BOOLEAN_DECL	: 'booleano'
				;

BOOLEAN_VAL : 'verdadeiro' | 'falso'
			;

CHAR_DECL 	: 'caractere' 
			;

CHAR_VAL : '\'' . '\'' ;
	
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
	
IF	: 'se'
	;

ELSE 	: 'senao'
		;

DO	:	'faca'
	;
		
FOR	: 'para' 
	;

WHILE : 'enquanto'
	  ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
OPREL : '>' | '<' | '>=' | '<=' ;

EQUALS     : '==' ;
NOT_EQUALS : '!=' ;
      
LOGICAL_AND : '&&' ;
LOGICAL_OR  : '||' ;
LOGICAL_NOT : '!' ;

      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;