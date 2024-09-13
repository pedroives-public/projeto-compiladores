// Generated from IsiLanguage.g4 by ANTLR 4.13.2
package io.compiler.parser;

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT_DECL=5, INT_VAL=6, DOUBLE_DECL=7, 
		DOUBLE_VAL=8, STRING_DECL=9, STRING_VAL=10, BOOLEAN_DECL=11, BOOLEAN_VAL=12, 
		CHAR_DECL=13, CHAR_VAL=14, AP=15, FP=16, SC=17, OP_S=18, OP_M=19, OP_INCREM=20, 
		ATTR=21, IF=22, ELSE=23, DO=24, FOR=25, WHILE=26, VIR=27, ACH=28, FCH=29, 
		OPREL=30, EQUALS=31, NOT_EQUALS=32, LOGICAL_AND=33, LOGICAL_OR=34, LOGICAL_NOT=35, 
		ID=36, WS=37;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_whileC = 10, RULE_doWhileC = 11, RULE_forC = 12, 
		RULE_incDec = 13, RULE_expr = 14, RULE_logical_or_expr = 15, RULE_logical_and_expr = 16, 
		RULE_logical_not_expr = 17, RULE_equality_expr = 18, RULE_relational_expr = 19, 
		RULE_arith_expr = 20, RULE_term = 21, RULE_factor = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "whileC", "doWhileC", "forC", "incDec", "expr", 
			"logical_or_expr", "logical_and_expr", "logical_not_expr", "equality_expr", 
			"relational_expr", "arith_expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'start'", "'end;'", "'leia'", "'escreva'", "'inteiro'", null, 
			"'real'", null, null, null, "'booleano'", null, "'caractere'", null, 
			"'('", "')'", "';'", null, null, null, "'='", "'se'", "'senao'", "'faca'", 
			"'para'", "'enquanto'", "','", "'{'", "'}'", null, "'=='", "'!='", "'&&'", 
			"'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT_DECL", "INT_VAL", "DOUBLE_DECL", "DOUBLE_VAL", 
			"STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", "BOOLEAN_VAL", "CHAR_DECL", 
			"CHAR_VAL", "AP", "FP", "SC", "OP_S", "OP_M", "OP_INCREM", "ATTR", "IF", 
			"ELSE", "DO", "FOR", "WHILE", "VIR", "ACH", "FCH", "OPREL", "EQUALS", 
			"NOT_EQUALS", "LOGICAL_AND", "LOGICAL_OR", "LOGICAL_NOT", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public IsiLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			bloco();
			setState(48);
			match(T__1);
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	  checaUsoVariavel();
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(51);
					declaravar();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public List<TerminalNode> ATTR() { return getTokens(IsiLanguageParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(IsiLanguageParser.ATTR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(IsiLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLanguageParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			tipo();
			setState(57);
			match(ID);
				adicionaSymbol();	
												_exprID = _input.LT(-1).getText();
											
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(59);
				match(ATTR);
				 	_exprContent = "";	
													_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
												
				setState(61);
				expr();
					atribuiValor();			
													CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);	
													stack.peek().add(cmd);
												
				}
			}

			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(66);
				match(VIR);
				setState(67);
				match(ID);
				 	adicionaSymbol(); 			
													_exprID = _input.LT(-1).getText();
												
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATTR) {
					{
					setState(69);
					match(ATTR);
					 	_exprContent = "";	
														_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
													
					setState(71);
					expr();
						atribuiValor();			
														CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
														stack.peek().add(cmd);
													
					}
				}

				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT_DECL() { return getToken(IsiLanguageParser.INT_DECL, 0); }
		public TerminalNode STRING_DECL() { return getToken(IsiLanguageParser.STRING_DECL, 0); }
		public TerminalNode DOUBLE_DECL() { return getToken(IsiLanguageParser.DOUBLE_DECL, 0); }
		public TerminalNode BOOLEAN_DECL() { return getToken(IsiLanguageParser.BOOLEAN_DECL, 0); }
		public TerminalNode CHAR_DECL() { return getToken(IsiLanguageParser.CHAR_DECL, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(INT_DECL);
					_tipo = IsiVariable.INT;		
				}
				break;
			case STRING_DECL:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(STRING_DECL);
					_tipo = IsiVariable.TEXT;	
				}
				break;
			case DOUBLE_DECL:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(DOUBLE_DECL);
					_tipo = IsiVariable.DOUBLE;	
				}
				break;
			case BOOLEAN_DECL:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				match(BOOLEAN_DECL);
					_tipo = IsiVariable.BOOLEAN;	
				}
				break;
			case CHAR_DECL:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				match(CHAR_DECL);
					_tipo = IsiVariable.CHAR;	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(96);
					cmd();
					}
					break;
				case 2:
					{
					setState(97);
					decl();
					}
					break;
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public ForCContext forC() {
			return getRuleContext(ForCContext.class,0);
		}
		public WhileCContext whileC() {
			return getRuleContext(WhileCContext.class,0);
		}
		public DoWhileCContext doWhileC() {
			return getRuleContext(DoWhileCContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				cmdleitura();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				cmdescrita();
				}
				break;
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				cmdattrib();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				cmdselecao();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				forC();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				whileC();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				doWhileC();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__2);
			setState(112);
			match(AP);
			setState(113);
			match(ID);
			 verificaID(); _readID = _input.LT(-1).getText(); 
			setState(115);
			match(FP);
			setState(116);
			match(SC);

			          IsiVariable var = (IsiVariable) symbolTable.get(_readID);
			          var.setValue("initialized"); // Mark the variable as initialized
			          CommandLeitura cmd = new CommandLeitura(_readID, var);
			          stack.peek().add(cmd);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode STRING_VAL() { return getToken(IsiLanguageParser.STRING_VAL, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__3);
			setState(120);
			match(AP);
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(121);
				match(ID);
				 verificaID(); _writeID = _input.LT(-1).getText(); 
				}
				break;
			case STRING_VAL:
				{
				setState(123);
				match(STRING_VAL);
				 _writeID = _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(127);
			match(FP);
			setState(128);
			match(SC);
			 CommandEscrita cmd = new CommandEscrita(_writeID); stack.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ATTR() { return getToken(IsiLanguageParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
				{
				{
				setState(131);
				tipo();
				setState(132);
				match(ID);
				}
				 adicionaSymbol(); 
				}
				break;
			case ID:
				{
				setState(136);
				match(ID);
				 verificaID(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprID = _input.LT(-1).getText(); 
			setState(141);
			match(ATTR);
			 _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_exprID)).getType(); 
			setState(143);
			expr();
			setState(144);
			match(SC);

			        atribuiValor();
			        _varType = -1;
			        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			        stack.peek().add(cmd);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(IsiLanguageParser.IF, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLanguageParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(IsiLanguageParser.ELSE, 0); }
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(IF);
			setState(148);
			match(AP);
			 _exprContent = ""; listaFalse = null; 
			setState(150);
			expr();
			 _exprDecision = _exprContent; _exprContent = ""; _varType = -1; 
			setState(152);
			match(FP);
			setState(153);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); conditionStack.push(_exprDecision); 
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				cmd();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
			setState(160);
			match(FCH);
			 listaTrue = stack.pop(); 
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(162);
				match(ELSE);
				setState(163);
				match(ACH);
				 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); 
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165);
					cmd();
					}
					}
					setState(168); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
				setState(170);
				match(FCH);
				 listaFalse = stack.pop(); 
				}
			}

			 CommandDecisao cmd = new CommandDecisao(conditionStack.pop(), listaTrue, listaFalse); stack.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileCContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(IsiLanguageParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLanguageParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<IncDecContext> incDec() {
			return getRuleContexts(IncDecContext.class);
		}
		public IncDecContext incDec(int i) {
			return getRuleContext(IncDecContext.class,i);
		}
		public WhileCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterWhileC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitWhileC(this);
		}
	}

	public final WhileCContext whileC() throws RecognitionException {
		WhileCContext _localctx = new WhileCContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileC);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(WHILE);
			setState(178);
			match(AP);
			 _exprContent = ""; 
			setState(180);
			expr();
			 _exprWhile = _exprContent; _exprContent = ""; _varType = -1; 
			setState(182);
			match(FP);
			setState(183);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); conditionStack.push(_exprWhile); 
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(187);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(185);
					cmd();
					}
					break;
				case 2:
					{
					setState(186);
					incDec();
					}
					break;
				}
				}
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
			setState(191);
			match(FCH);
			 CommandLoopWhile cmd = new CommandLoopWhile(conditionStack.pop(), stack.pop()); stack.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileCContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(IsiLanguageParser.DO, 0); }
		public TerminalNode ACH() { return getToken(IsiLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLanguageParser.FCH, 0); }
		public TerminalNode WHILE() { return getToken(IsiLanguageParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<IncDecContext> incDec() {
			return getRuleContexts(IncDecContext.class);
		}
		public IncDecContext incDec(int i) {
			return getRuleContext(IncDecContext.class,i);
		}
		public DoWhileCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterDoWhileC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitDoWhileC(this);
		}
	}

	public final DoWhileCContext doWhileC() throws RecognitionException {
		DoWhileCContext _localctx = new DoWhileCContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_doWhileC);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(DO);
			setState(195);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); 
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(197);
					cmd();
					}
					break;
				case 2:
					{
					setState(198);
					incDec();
					}
					break;
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
			setState(203);
			match(FCH);
			setState(204);
			match(WHILE);
			setState(205);
			match(AP);
			 _exprContent = ""; 
			setState(207);
			expr();
			 _exprDoWhile = _exprContent; _exprContent = ""; _varType = -1; 
			setState(209);
			match(FP);
			setState(210);
			match(SC);
			 CommandLoopDoWhile cmd = new CommandLoopDoWhile(_exprDoWhile, stack.pop()); stack.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForCContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(IsiLanguageParser.FOR, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public List<TerminalNode> ATTR() { return getTokens(IsiLanguageParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(IsiLanguageParser.ATTR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SC() { return getTokens(IsiLanguageParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(IsiLanguageParser.SC, i);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLanguageParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public TerminalNode OP_INCREM() { return getToken(IsiLanguageParser.OP_INCREM, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<IncDecContext> incDec() {
			return getRuleContexts(IncDecContext.class);
		}
		public IncDecContext incDec(int i) {
			return getRuleContext(IncDecContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ForCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterForC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitForC(this);
		}
	}

	public final ForCContext forC() throws RecognitionException {
		ForCContext _localctx = new ForCContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forC);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(FOR);
			setState(214);
			match(AP);
			 _exprContent = ""; 
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
				{
				{
				setState(216);
				tipo();
				setState(217);
				match(ID);
				}
				 adicionaSymbol(); 
				}
				break;
			case ID:
				{
				setState(221);
				match(ID);
				 verificaID(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprForInitID = _input.LT(-1).getText(); 
			setState(226);
			match(ATTR);
			 _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_exprForInitID)).getType(); 
			setState(228);
			expr();
			 atribuiValor(); _exprForInit = _exprForInitID + " = " + _exprContent; 
			setState(230);
			match(SC);
			 _exprContent = ""; 
			setState(232);
			expr();
			 _exprForCondition = _exprContent; _exprContent = ""; _varType = -1; 
			setState(234);
			match(SC);
			 _exprContent = ""; 
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(236);
				match(ID);
				 verificaID(); 
				setState(238);
				match(OP_INCREM);
				 _exprForUpdate = _input.LT(-2).getText() + _input.LT(-1).getText(); 
				}
				break;
			case 2:
				{
				setState(240);
				match(ID);
				 verificaID(); 
				setState(242);
				match(ATTR);
				 _exprContent = ""; _varType = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType(); 
				setState(244);
				expr();
				 _exprForUpdate = _input.LT(-4).getText() + " = " + _exprContent; 
				}
				break;
			}
			setState(249);
			match(FP);
			setState(250);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); 
			setState(254); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(252);
					cmd();
					}
					break;
				case 2:
					{
					setState(253);
					incDec();
					}
					break;
				}
				}
				setState(256); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68841122488L) != 0) );
			setState(258);
			match(FCH);

			          String forCondition = _exprForInit + "; " + _exprForCondition + "; " + _exprForUpdate;
			          CommandLoopFor cmd = new CommandLoopFor(forCondition, stack.pop());
			          stack.peek().add(cmd);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncDecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode OP_INCREM() { return getToken(IsiLanguageParser.OP_INCREM, 0); }
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
		public IncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitIncDec(this);
		}
	}

	public final IncDecContext incDec() throws RecognitionException {
		IncDecContext _localctx = new IncDecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_incDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ID);
			 verificaID(); _exprID = _input.LT(-1).getText(); 
			setState(263);
			match(OP_INCREM);
			 _exprContent = _exprID + _input.LT(-1).getText(); 
			setState(265);
			match(SC);
			 CommandAtribuicao cmd = new CommandAtribuicao("", _exprContent); cmd.setIncrementDecrement(true); stack.peek().add(cmd); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Logical_or_exprContext logical_or_expr() {
			return getRuleContext(Logical_or_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			logical_or_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_or_exprContext extends ParserRuleContext {
		public List<Logical_and_exprContext> logical_and_expr() {
			return getRuleContexts(Logical_and_exprContext.class);
		}
		public Logical_and_exprContext logical_and_expr(int i) {
			return getRuleContext(Logical_and_exprContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OR() { return getTokens(IsiLanguageParser.LOGICAL_OR); }
		public TerminalNode LOGICAL_OR(int i) {
			return getToken(IsiLanguageParser.LOGICAL_OR, i);
		}
		public Logical_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterLogical_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitLogical_or_expr(this);
		}
	}

	public final Logical_or_exprContext logical_or_expr() throws RecognitionException {
		Logical_or_exprContext _localctx = new Logical_or_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logical_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 _inLogicalExpr = true; 
			setState(271);
			logical_and_expr();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OR) {
				{
				{
				setState(272);
				match(LOGICAL_OR);
				 _exprContent += " || "; 
				setState(274);
				logical_and_expr();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _inLogicalExpr = false; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_and_exprContext extends ParserRuleContext {
		public List<Logical_not_exprContext> logical_not_expr() {
			return getRuleContexts(Logical_not_exprContext.class);
		}
		public Logical_not_exprContext logical_not_expr(int i) {
			return getRuleContext(Logical_not_exprContext.class,i);
		}
		public List<TerminalNode> LOGICAL_AND() { return getTokens(IsiLanguageParser.LOGICAL_AND); }
		public TerminalNode LOGICAL_AND(int i) {
			return getToken(IsiLanguageParser.LOGICAL_AND, i);
		}
		public Logical_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterLogical_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitLogical_and_expr(this);
		}
	}

	public final Logical_and_exprContext logical_and_expr() throws RecognitionException {
		Logical_and_exprContext _localctx = new Logical_and_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logical_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			logical_not_expr();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_AND) {
				{
				{
				setState(283);
				match(LOGICAL_AND);
				 _exprContent += " && "; 
				setState(285);
				logical_not_expr();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_not_exprContext extends ParserRuleContext {
		public TerminalNode LOGICAL_NOT() { return getToken(IsiLanguageParser.LOGICAL_NOT, 0); }
		public Logical_not_exprContext logical_not_expr() {
			return getRuleContext(Logical_not_exprContext.class,0);
		}
		public Equality_exprContext equality_expr() {
			return getRuleContext(Equality_exprContext.class,0);
		}
		public Logical_not_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_not_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterLogical_not_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitLogical_not_expr(this);
		}
	}

	public final Logical_not_exprContext logical_not_expr() throws RecognitionException {
		Logical_not_exprContext _localctx = new Logical_not_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logical_not_expr);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(LOGICAL_NOT);
				 _exprContent += "!"; 
				setState(293);
				logical_not_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				equality_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Equality_exprContext extends ParserRuleContext {
		public List<Relational_exprContext> relational_expr() {
			return getRuleContexts(Relational_exprContext.class);
		}
		public Relational_exprContext relational_expr(int i) {
			return getRuleContext(Relational_exprContext.class,i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(IsiLanguageParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(IsiLanguageParser.EQUALS, i);
		}
		public List<TerminalNode> NOT_EQUALS() { return getTokens(IsiLanguageParser.NOT_EQUALS); }
		public TerminalNode NOT_EQUALS(int i) {
			return getToken(IsiLanguageParser.NOT_EQUALS, i);
		}
		public Equality_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterEquality_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitEquality_expr(this);
		}
	}

	public final Equality_exprContext equality_expr() throws RecognitionException {
		Equality_exprContext _localctx = new Equality_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equality_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			relational_expr();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUALS || _la==NOT_EQUALS) {
				{
				{
				setState(298);
				_la = _input.LA(1);
				if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 _exprContent += _input.LT(-1).getText(); 
				setState(300);
				relational_expr();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Relational_exprContext extends ParserRuleContext {
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
		public Relational_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterRelational_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitRelational_expr(this);
		}
	}

	public final Relational_exprContext relational_expr() throws RecognitionException {
		Relational_exprContext _localctx = new Relational_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relational_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			arith_expr();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(307);
				match(OPREL);
				 _exprContent += _input.LT(-1).getText(); 
				setState(309);
				arith_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arith_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> OP_S() { return getTokens(IsiLanguageParser.OP_S); }
		public TerminalNode OP_S(int i) {
			return getToken(IsiLanguageParser.OP_S, i);
		}
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterArith_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitArith_expr(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arith_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			term();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_S) {
				{
				{
				setState(313);
				match(OP_S);
				 _exprContent += _input.LT(-1).getText(); 
				setState(315);
				term();
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> OP_M() { return getTokens(IsiLanguageParser.OP_M); }
		public TerminalNode OP_M(int i) {
			return getToken(IsiLanguageParser.OP_M, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			factor();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_M) {
				{
				{
				setState(322);
				match(OP_M);
				 _exprContent += _input.LT(-1).getText(); 
				setState(324);
				factor();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(IsiLanguageParser.INT_VAL, 0); }
		public TerminalNode DOUBLE_VAL() { return getToken(IsiLanguageParser.DOUBLE_VAL, 0); }
		public TerminalNode STRING_VAL() { return getToken(IsiLanguageParser.STRING_VAL, 0); }
		public TerminalNode BOOLEAN_VAL() { return getToken(IsiLanguageParser.BOOLEAN_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(IsiLanguageParser.CHAR_VAL, 0); }
		public TerminalNode LOGICAL_NOT() { return getToken(IsiLanguageParser.LOGICAL_NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factor);
		try {
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				match(ID);
				 verificaID(); 
				    		verificaAtribuicao();
				    		int type = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
				    		verificaTipoVariavel(type);
				    		_exprContent += _input.LT(-1).getText(); 
				}
				break;
			case INT_VAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(INT_VAL);
				 verificaTipoVariavel(IsiVariable.INT); _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case DOUBLE_VAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				match(DOUBLE_VAL);
				 verificaTipoVariavel(IsiVariable.DOUBLE); _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case STRING_VAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				match(STRING_VAL);
				 verificaTipoVariavel(IsiVariable.TEXT); _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case BOOLEAN_VAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				match(BOOLEAN_VAL);
				 verificaTipoVariavel(IsiVariable.BOOLEAN); _exprContent += ((_input.LT(-1).getText()).equals("verdadeiro") ? "true" : "false"); 
				}
				break;
			case CHAR_VAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(340);
				match(CHAR_VAL);
				 verificaTipoVariavel(IsiVariable.CHAR); _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case LOGICAL_NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(342);
				match(LOGICAL_NOT);
				 _exprContent += "!"; 
				setState(344);
				factor();
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 8);
				{
				setState(345);
				match(AP);
				 _exprContent += "("; 
				setState(347);
				expr();
				setState(348);
				match(FP);
				 _exprContent += ")"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u0162\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u00015\b\u0001\u000b\u0001\f\u00016\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002K\b\u0002\u0005\u0002M\b\u0002\n\u0002\f\u0002P\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"^\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004c\b\u0004\u000b"+
		"\u0004\f\u0004d\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005n\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007~\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"\u008b\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u009d\b\t\u000b\t\f\t\u009e\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0004\t\u00a7\b\t\u000b\t\f\t\u00a8\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00ae\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00bc\b\n\u000b\n\f\n\u00bd"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0004\u000b\u00c8\b\u000b\u000b\u000b\f\u000b\u00c9\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e0\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00f8\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u00ff\b\f\u000b\f\f\f\u0100\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u0114\b\u000f\n\u000f\f\u000f\u0117\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u011f\b\u0010"+
		"\n\u0010\f\u0010\u0122\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0128\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u012e\b\u0012\n\u0012\f\u0012\u0131\t\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0137\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u013d\b\u0014\n\u0014"+
		"\f\u0014\u0140\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u0146\b\u0015\n\u0015\f\u0015\u0149\t\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0160\b\u0016\u0001\u0016\u0000\u0000\u0017"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,\u0000\u0001\u0001\u0000\u001f \u0175\u0000.\u0001"+
		"\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000"+
		"\u0000\u0006]\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\nm\u0001"+
		"\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000ew\u0001\u0000\u0000"+
		"\u0000\u0010\u008a\u0001\u0000\u0000\u0000\u0012\u0093\u0001\u0000\u0000"+
		"\u0000\u0014\u00b1\u0001\u0000\u0000\u0000\u0016\u00c2\u0001\u0000\u0000"+
		"\u0000\u0018\u00d5\u0001\u0000\u0000\u0000\u001a\u0105\u0001\u0000\u0000"+
		"\u0000\u001c\u010c\u0001\u0000\u0000\u0000\u001e\u010e\u0001\u0000\u0000"+
		"\u0000 \u011a\u0001\u0000\u0000\u0000\"\u0127\u0001\u0000\u0000\u0000"+
		"$\u0129\u0001\u0000\u0000\u0000&\u0132\u0001\u0000\u0000\u0000(\u0138"+
		"\u0001\u0000\u0000\u0000*\u0141\u0001\u0000\u0000\u0000,\u015f\u0001\u0000"+
		"\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0003\b\u0004\u000001\u0005\u0002"+
		"\u0000\u000012\u0006\u0000\uffff\uffff\u00002\u0001\u0001\u0000\u0000"+
		"\u000035\u0003\u0004\u0002\u000043\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007\u0003"+
		"\u0001\u0000\u0000\u000089\u0003\u0006\u0003\u00009:\u0005$\u0000\u0000"+
		":@\u0006\u0002\uffff\uffff\u0000;<\u0005\u0015\u0000\u0000<=\u0006\u0002"+
		"\uffff\uffff\u0000=>\u0003\u001c\u000e\u0000>?\u0006\u0002\uffff\uffff"+
		"\u0000?A\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000AN\u0001\u0000\u0000\u0000BC\u0005\u001b\u0000\u0000CD\u0005"+
		"$\u0000\u0000DJ\u0006\u0002\uffff\uffff\u0000EF\u0005\u0015\u0000\u0000"+
		"FG\u0006\u0002\uffff\uffff\u0000GH\u0003\u001c\u000e\u0000HI\u0006\u0002"+
		"\uffff\uffff\u0000IK\u0001\u0000\u0000\u0000JE\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LB\u0001\u0000\u0000"+
		"\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0005"+
		"\u0011\u0000\u0000R\u0005\u0001\u0000\u0000\u0000ST\u0005\u0005\u0000"+
		"\u0000T^\u0006\u0003\uffff\uffff\u0000UV\u0005\t\u0000\u0000V^\u0006\u0003"+
		"\uffff\uffff\u0000WX\u0005\u0007\u0000\u0000X^\u0006\u0003\uffff\uffff"+
		"\u0000YZ\u0005\u000b\u0000\u0000Z^\u0006\u0003\uffff\uffff\u0000[\\\u0005"+
		"\r\u0000\u0000\\^\u0006\u0003\uffff\uffff\u0000]S\u0001\u0000\u0000\u0000"+
		"]U\u0001\u0000\u0000\u0000]W\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000_b\u0006"+
		"\u0004\uffff\uffff\u0000`c\u0003\n\u0005\u0000ac\u0003\u0002\u0001\u0000"+
		"b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\t\u0001\u0000"+
		"\u0000\u0000fn\u0003\f\u0006\u0000gn\u0003\u000e\u0007\u0000hn\u0003\u0010"+
		"\b\u0000in\u0003\u0012\t\u0000jn\u0003\u0018\f\u0000kn\u0003\u0014\n\u0000"+
		"ln\u0003\u0016\u000b\u0000mf\u0001\u0000\u0000\u0000mg\u0001\u0000\u0000"+
		"\u0000mh\u0001\u0000\u0000\u0000mi\u0001\u0000\u0000\u0000mj\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000n\u000b"+
		"\u0001\u0000\u0000\u0000op\u0005\u0003\u0000\u0000pq\u0005\u000f\u0000"+
		"\u0000qr\u0005$\u0000\u0000rs\u0006\u0006\uffff\uffff\u0000st\u0005\u0010"+
		"\u0000\u0000tu\u0005\u0011\u0000\u0000uv\u0006\u0006\uffff\uffff\u0000"+
		"v\r\u0001\u0000\u0000\u0000wx\u0005\u0004\u0000\u0000x}\u0005\u000f\u0000"+
		"\u0000yz\u0005$\u0000\u0000z~\u0006\u0007\uffff\uffff\u0000{|\u0005\n"+
		"\u0000\u0000|~\u0006\u0007\uffff\uffff\u0000}y\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005\u0010\u0000\u0000\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0082"+
		"\u0006\u0007\uffff\uffff\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0003\u0006\u0003\u0000\u0084\u0085\u0005$\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0006\b\uffff\uffff\u0000\u0087\u008b"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005$\u0000\u0000\u0089\u008b\u0006"+
		"\b\uffff\uffff\u0000\u008a\u0083\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0006"+
		"\b\uffff\uffff\u0000\u008d\u008e\u0005\u0015\u0000\u0000\u008e\u008f\u0006"+
		"\b\uffff\uffff\u0000\u008f\u0090\u0003\u001c\u000e\u0000\u0090\u0091\u0005"+
		"\u0011\u0000\u0000\u0091\u0092\u0006\b\uffff\uffff\u0000\u0092\u0011\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0016\u0000\u0000\u0094\u0095\u0005"+
		"\u000f\u0000\u0000\u0095\u0096\u0006\t\uffff\uffff\u0000\u0096\u0097\u0003"+
		"\u001c\u000e\u0000\u0097\u0098\u0006\t\uffff\uffff\u0000\u0098\u0099\u0005"+
		"\u0010\u0000\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a\u009c\u0006"+
		"\t\uffff\uffff\u0000\u009b\u009d\u0003\n\u0005\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0005\u001d\u0000\u0000\u00a1\u00ad\u0006"+
		"\t\uffff\uffff\u0000\u00a2\u00a3\u0005\u0017\u0000\u0000\u00a3\u00a4\u0005"+
		"\u001c\u0000\u0000\u00a4\u00a6\u0006\t\uffff\uffff\u0000\u00a5\u00a7\u0003"+
		"\n\u0005\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u001d"+
		"\u0000\u0000\u00ab\u00ac\u0006\t\uffff\uffff\u0000\u00ac\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ad\u00a2\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0006\t\uffff"+
		"\uffff\u0000\u00b0\u0013\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u001a"+
		"\u0000\u0000\u00b2\u00b3\u0005\u000f\u0000\u0000\u00b3\u00b4\u0006\n\uffff"+
		"\uffff\u0000\u00b4\u00b5\u0003\u001c\u000e\u0000\u00b5\u00b6\u0006\n\uffff"+
		"\uffff\u0000\u00b6\u00b7\u0005\u0010\u0000\u0000\u00b7\u00b8\u0005\u001c"+
		"\u0000\u0000\u00b8\u00bb\u0006\n\uffff\uffff\u0000\u00b9\u00bc\u0003\n"+
		"\u0005\u0000\u00ba\u00bc\u0003\u001a\r\u0000\u00bb\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u001d\u0000"+
		"\u0000\u00c0\u00c1\u0006\n\uffff\uffff\u0000\u00c1\u0015\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u00c4\u0005\u001c\u0000"+
		"\u0000\u00c4\u00c7\u0006\u000b\uffff\uffff\u0000\u00c5\u00c8\u0003\n\u0005"+
		"\u0000\u00c6\u00c8\u0003\u001a\r\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u001d\u0000\u0000"+
		"\u00cc\u00cd\u0005\u001a\u0000\u0000\u00cd\u00ce\u0005\u000f\u0000\u0000"+
		"\u00ce\u00cf\u0006\u000b\uffff\uffff\u0000\u00cf\u00d0\u0003\u001c\u000e"+
		"\u0000\u00d0\u00d1\u0006\u000b\uffff\uffff\u0000\u00d1\u00d2\u0005\u0010"+
		"\u0000\u0000\u00d2\u00d3\u0005\u0011\u0000\u0000\u00d3\u00d4\u0006\u000b"+
		"\uffff\uffff\u0000\u00d4\u0017\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005"+
		"\u0019\u0000\u0000\u00d6\u00d7\u0005\u000f\u0000\u0000\u00d7\u00df\u0006"+
		"\f\uffff\uffff\u0000\u00d8\u00d9\u0003\u0006\u0003\u0000\u00d9\u00da\u0005"+
		"$\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0006\f"+
		"\uffff\uffff\u0000\u00dc\u00e0\u0001\u0000\u0000\u0000\u00dd\u00de\u0005"+
		"$\u0000\u0000\u00de\u00e0\u0006\f\uffff\uffff\u0000\u00df\u00d8\u0001"+
		"\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e2\u0006\f\uffff\uffff\u0000\u00e2\u00e3\u0005"+
		"\u0015\u0000\u0000\u00e3\u00e4\u0006\f\uffff\uffff\u0000\u00e4\u00e5\u0003"+
		"\u001c\u000e\u0000\u00e5\u00e6\u0006\f\uffff\uffff\u0000\u00e6\u00e7\u0005"+
		"\u0011\u0000\u0000\u00e7\u00e8\u0006\f\uffff\uffff\u0000\u00e8\u00e9\u0003"+
		"\u001c\u000e\u0000\u00e9\u00ea\u0006\f\uffff\uffff\u0000\u00ea\u00eb\u0005"+
		"\u0011\u0000\u0000\u00eb\u00f7\u0006\f\uffff\uffff\u0000\u00ec\u00ed\u0005"+
		"$\u0000\u0000\u00ed\u00ee\u0006\f\uffff\uffff\u0000\u00ee\u00ef\u0005"+
		"\u0014\u0000\u0000\u00ef\u00f8\u0006\f\uffff\uffff\u0000\u00f0\u00f1\u0005"+
		"$\u0000\u0000\u00f1\u00f2\u0006\f\uffff\uffff\u0000\u00f2\u00f3\u0005"+
		"\u0015\u0000\u0000\u00f3\u00f4\u0006\f\uffff\uffff\u0000\u00f4\u00f5\u0003"+
		"\u001c\u000e\u0000\u00f5\u00f6\u0006\f\uffff\uffff\u0000\u00f6\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f7\u00ec\u0001\u0000\u0000\u0000\u00f7\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005"+
		"\u0010\u0000\u0000\u00fa\u00fb\u0005\u001c\u0000\u0000\u00fb\u00fe\u0006"+
		"\f\uffff\uffff\u0000\u00fc\u00ff\u0003\n\u0005\u0000\u00fd\u00ff\u0003"+
		"\u001a\r\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00fd\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0005\u001d\u0000\u0000\u0103\u0104\u0006\f\uffff"+
		"\uffff\u0000\u0104\u0019\u0001\u0000\u0000\u0000\u0105\u0106\u0005$\u0000"+
		"\u0000\u0106\u0107\u0006\r\uffff\uffff\u0000\u0107\u0108\u0005\u0014\u0000"+
		"\u0000\u0108\u0109\u0006\r\uffff\uffff\u0000\u0109\u010a\u0005\u0011\u0000"+
		"\u0000\u010a\u010b\u0006\r\uffff\uffff\u0000\u010b\u001b\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0003\u001e\u000f\u0000\u010d\u001d\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0006\u000f\uffff\uffff\u0000\u010f\u0115\u0003 \u0010"+
		"\u0000\u0110\u0111\u0005\"\u0000\u0000\u0111\u0112\u0006\u000f\uffff\uffff"+
		"\u0000\u0112\u0114\u0003 \u0010\u0000\u0113\u0110\u0001\u0000\u0000\u0000"+
		"\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u0119\u0006\u000f\uffff\uffff"+
		"\u0000\u0119\u001f\u0001\u0000\u0000\u0000\u011a\u0120\u0003\"\u0011\u0000"+
		"\u011b\u011c\u0005!\u0000\u0000\u011c\u011d\u0006\u0010\uffff\uffff\u0000"+
		"\u011d\u011f\u0003\"\u0011\u0000\u011e\u011b\u0001\u0000\u0000\u0000\u011f"+
		"\u0122\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121!\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0005#\u0000\u0000\u0124\u0125\u0006"+
		"\u0011\uffff\uffff\u0000\u0125\u0128\u0003\"\u0011\u0000\u0126\u0128\u0003"+
		"$\u0012\u0000\u0127\u0123\u0001\u0000\u0000\u0000\u0127\u0126\u0001\u0000"+
		"\u0000\u0000\u0128#\u0001\u0000\u0000\u0000\u0129\u012f\u0003&\u0013\u0000"+
		"\u012a\u012b\u0007\u0000\u0000\u0000\u012b\u012c\u0006\u0012\uffff\uffff"+
		"\u0000\u012c\u012e\u0003&\u0013\u0000\u012d\u012a\u0001\u0000\u0000\u0000"+
		"\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000"+
		"\u012f\u0130\u0001\u0000\u0000\u0000\u0130%\u0001\u0000\u0000\u0000\u0131"+
		"\u012f\u0001\u0000\u0000\u0000\u0132\u0136\u0003(\u0014\u0000\u0133\u0134"+
		"\u0005\u001e\u0000\u0000\u0134\u0135\u0006\u0013\uffff\uffff\u0000\u0135"+
		"\u0137\u0003(\u0014\u0000\u0136\u0133\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\'\u0001\u0000\u0000\u0000\u0138\u013e\u0003"+
		"*\u0015\u0000\u0139\u013a\u0005\u0012\u0000\u0000\u013a\u013b\u0006\u0014"+
		"\uffff\uffff\u0000\u013b\u013d\u0003*\u0015\u0000\u013c\u0139\u0001\u0000"+
		"\u0000\u0000\u013d\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f)\u0001\u0000\u0000"+
		"\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0147\u0003,\u0016\u0000"+
		"\u0142\u0143\u0005\u0013\u0000\u0000\u0143\u0144\u0006\u0015\uffff\uffff"+
		"\u0000\u0144\u0146\u0003,\u0016\u0000\u0145\u0142\u0001\u0000\u0000\u0000"+
		"\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000"+
		"\u0147\u0148\u0001\u0000\u0000\u0000\u0148+\u0001\u0000\u0000\u0000\u0149"+
		"\u0147\u0001\u0000\u0000\u0000\u014a\u014b\u0005$\u0000\u0000\u014b\u0160"+
		"\u0006\u0016\uffff\uffff\u0000\u014c\u014d\u0005\u0006\u0000\u0000\u014d"+
		"\u0160\u0006\u0016\uffff\uffff\u0000\u014e\u014f\u0005\b\u0000\u0000\u014f"+
		"\u0160\u0006\u0016\uffff\uffff\u0000\u0150\u0151\u0005\n\u0000\u0000\u0151"+
		"\u0160\u0006\u0016\uffff\uffff\u0000\u0152\u0153\u0005\f\u0000\u0000\u0153"+
		"\u0160\u0006\u0016\uffff\uffff\u0000\u0154\u0155\u0005\u000e\u0000\u0000"+
		"\u0155\u0160\u0006\u0016\uffff\uffff\u0000\u0156\u0157\u0005#\u0000\u0000"+
		"\u0157\u0158\u0006\u0016\uffff\uffff\u0000\u0158\u0160\u0003,\u0016\u0000"+
		"\u0159\u015a\u0005\u000f\u0000\u0000\u015a\u015b\u0006\u0016\uffff\uffff"+
		"\u0000\u015b\u015c\u0003\u001c\u000e\u0000\u015c\u015d\u0005\u0010\u0000"+
		"\u0000\u015d\u015e\u0006\u0016\uffff\uffff\u0000\u015e\u0160\u0001\u0000"+
		"\u0000\u0000\u015f\u014a\u0001\u0000\u0000\u0000\u015f\u014c\u0001\u0000"+
		"\u0000\u0000\u015f\u014e\u0001\u0000\u0000\u0000\u015f\u0150\u0001\u0000"+
		"\u0000\u0000\u015f\u0152\u0001\u0000\u0000\u0000\u015f\u0154\u0001\u0000"+
		"\u0000\u0000\u015f\u0156\u0001\u0000\u0000\u0000\u015f\u0159\u0001\u0000"+
		"\u0000\u0000\u0160-\u0001\u0000\u0000\u0000\u001d6@JN]bdm}\u008a\u009e"+
		"\u00a8\u00ad\u00bb\u00bd\u00c7\u00c9\u00df\u00f7\u00fe\u0100\u0115\u0120"+
		"\u0127\u012f\u0136\u013e\u0147\u015f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}