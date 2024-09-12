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
		OPREL=30, ID=31, WS=32;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_whileC = 10, RULE_doWhileC = 11, RULE_forC = 12, 
		RULE_incDec = 13, RULE_expr = 14, RULE_term = 15, RULE_factor = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "whileC", "doWhileC", "forC", "incDec", "expr", 
			"term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'start'", "'end;'", "'scanf'", "'printf'", "'integer'", null, 
			"'double'", null, null, null, "'boolean'", null, "'char'", null, "'('", 
			"')'", "';'", null, null, null, "'='", "'if'", "'else'", "'do'", "'for'", 
			"'while'", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT_DECL", "INT_VAL", "DOUBLE_DECL", "DOUBLE_VAL", 
			"STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", "BOOLEAN_VAL", "CHAR_DECL", 
			"CHAR_VAL", "AP", "FP", "SC", "OP_S", "OP_M", "OP_INCREM", "ATTR", "IF", 
			"ELSE", "DO", "FOR", "WHILE", "VIR", "ACH", "FCH", "OPREL", "ID", "WS"
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
			setState(34);
			match(T__0);
			setState(35);
			bloco();
			setState(36);
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
			setState(40); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(39);
					declaravar();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
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
			setState(44);
			tipo();
			setState(45);
			match(ID);
				adicionaSymbol();	
												_exprID = _input.LT(-1).getText();
											
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(47);
				match(ATTR);
				 	_exprContent = "";	
													_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
												
				setState(49);
				expr();
					atribuiValor();			
													CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);	
													stack.peek().add(cmd);
												
				}
			}

			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(54);
				match(VIR);
				setState(55);
				match(ID);
				 	adicionaSymbol(); 			
													_exprID = _input.LT(-1).getText();
												
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATTR) {
					{
					setState(57);
					match(ATTR);
					 	_exprContent = "";	
														_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
													
					setState(59);
					expr();
						atribuiValor();			
														CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
														stack.peek().add(cmd);
													
					}
				}

				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(INT_DECL);
					_tipo = IsiVariable.INT;		
				}
				break;
			case STRING_DECL:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(STRING_DECL);
					_tipo = IsiVariable.TEXT;	
				}
				break;
			case DOUBLE_DECL:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(DOUBLE_DECL);
					_tipo = IsiVariable.DOUBLE;	
				}
				break;
			case BOOLEAN_DECL:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(BOOLEAN_DECL);
					_tipo = IsiVariable.BOOLEAN;	
				}
				break;
			case CHAR_DECL:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
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
			          
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(84);
					cmd();
					}
					break;
				case 2:
					{
					setState(85);
					decl();
					}
					break;
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				cmdleitura();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
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
				setState(92);
				cmdattrib();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				cmdselecao();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				forC();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				whileC();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
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
			setState(99);
			match(T__2);
			setState(100);
			match(AP);
			setState(101);
			match(ID);
			 verificaID();
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(103);
			match(FP);
			setState(104);
			match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
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
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLanguageParser.SC, 0); }
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
			setState(107);
			match(T__3);
			setState(108);
			match(AP);
			setState(109);
			match(ID);
			 verificaID();
				                  _writeID = _input.LT(-1).getText();
			                     
			setState(111);
			match(FP);
			setState(112);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
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
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
				{
				{
				setState(115);
				tipo();
				setState(116);
				match(ID);
				}
				 	adicionaSymbol(); 						
				}
				break;
			case ID:
				{
				setState(120);
				match(ID);
				 	verificaID(); 							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprID = _input.LT(-1).getText();		
			setState(125);
			match(ATTR);
			 	_exprContent = "";	
														_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
													
			setState(127);
			expr();
			setState(128);
			match(SC);
				
														atribuiValor();
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
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
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
			setState(131);
			match(IF);
			setState(132);
			match(AP);
			setState(133);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verificaAtribuicao();
													_exprContent = "";
												
			setState(135);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(137);
			expr();
				_exprDecision += _exprContent;					
			setState(139);
			match(FP);
			setState(140);
			match(ACH);
				curThread = new ArrayList<AbstractCommand>();	
													stack.push(curThread);
													conditionStack.push(_exprDecision);
												
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				cmd();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
			setState(147);
			match(FCH);
				listaTrue = stack.pop();					
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(149);
				match(ELSE);
				setState(150);
				match(ACH);
					curThread = new ArrayList<AbstractCommand>();	
														stack.push(curThread);
													
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(152);
					cmd();
					}
					}
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
				setState(157);
				match(FCH);
					listaFalse = stack.pop(); 				
				}
			}

				CommandDecisao cmd = new CommandDecisao(conditionStack.pop(), listaTrue, listaFalse);
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
	public static class WhileCContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(IsiLanguageParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
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
			setState(164);
			match(WHILE);
			setState(165);
			match(AP);
			setState(166);
			match(ID);
			   _exprWhile = _input.LT(-1).getText();
				                        verificaAtribuicao();
				                        _exprContent = "";
				                    
			setState(168);
			match(OPREL);
			   _exprWhile += _input.LT(-1).getText();
				                    
			setState(170);
			expr();
			   _exprWhile += _input.LT(-1).getText();
				                    
			setState(172);
			match(FP);
			setState(173);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>();
				                  stack.push(curThread);
				                  conditionStack.push(_exprWhile);
				                
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(177);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(175);
					cmd();
					}
					break;
				case 2:
					{
					setState(176);
					incDec();
					}
					break;
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
			setState(181);
			match(FCH);
			   CommandLoopWhile cmd = new CommandLoopWhile(conditionStack.pop(), stack.pop());
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
	public static class DoWhileCContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(IsiLanguageParser.DO, 0); }
		public TerminalNode ACH() { return getToken(IsiLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLanguageParser.FCH, 0); }
		public TerminalNode WHILE() { return getToken(IsiLanguageParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
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
			setState(184);
			match(DO);
			setState(185);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>();
				                  stack.push(curThread);
				                  conditionStack.push(_exprWhile);
				                
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(187);
					cmd();
					}
					break;
				case 2:
					{
					setState(188);
					incDec();
					}
					break;
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
			setState(193);
			match(FCH);
			setState(194);
			match(WHILE);
			setState(195);
			match(AP);
			setState(196);
			match(ID);
			    _exprWhile = _input.LT(-1).getText();
			                           verificaAtribuicao();
			                           _exprContent = "";
			                      
			setState(198);
			match(OPREL);
			    _exprWhile += _input.LT(-1).getText();        
			setState(200);
			expr();
			    _exprWhile += _exprContent;        
			setState(202);
			match(FP);
			setState(203);
			match(SC);

			                    CommandLoopDoWhile cmd = new CommandLoopDoWhile(_exprWhile, stack.pop());
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
	public static class ForCContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(IsiLanguageParser.FOR, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public TerminalNode ATTR() { return getToken(IsiLanguageParser.ATTR, 0); }
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
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
		public TerminalNode OP_INCREM() { return getToken(IsiLanguageParser.OP_INCREM, 0); }
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
			setState(206);
			match(FOR);
			setState(207);
			match(AP);
			setState(208);
			match(ID);
			 	verificaID(); 
											_exprID = _input.LT(-1).getText();
											_atribuicaoVariavel = _input.LT(-1).getText();
										
										
			setState(210);
			match(ATTR);
			 	_exprContent = "";	
											_varType = ((IsiVariable) symbolTable.get(_exprID)).getType();
										
			setState(212);
			expr();
			setState(213);
			match(SC);
				_exprFor = _exprID + " = " + _exprContent + ";";	
											atribuiValor();
										
			setState(215);
			match(ID);
				
											if (_exprID.equals(_input.LT(-1).getText()) == false) {
												throw new IsiSemanticException("Expected variable -> " + _exprID);
											}
											
											_exprFor += _input.LT(-1).getText();
											verificaAtribuicao();
										
			setState(217);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
											_exprContent = "";
										
			setState(219);
			expr();
				_exprFor += _exprContent;					
			setState(221);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(223);
			match(ID);
				
											if (_exprID.equals(_input.LT(-1).getText()) == false) {
												throw new IsiSemanticException("Expected variable -> " + _exprID);
											}
											_exprFor += _input.LT(-1).getText();
											verificaAtribuicao();
										
			setState(225);
			match(OP_INCREM);
				_exprFor += _input.LT(-1).getText();		
			setState(227);
			match(FP);
			setState(228);
			match(ACH);
				curThread = new ArrayList<AbstractCommand>();	
											stack.push(curThread);
											conditionStack.push(_exprFor);
										
			setState(232); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(230);
					cmd();
					}
					break;
				case 2:
					{
					setState(231);
					incDec();
					}
					break;
				}
				}
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2269129400L) != 0) );
			setState(236);
			match(FCH);

											CommandLoopFor cmd = new CommandLoopFor(conditionStack.pop(), stack.pop());
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
			setState(239);
			match(ID);
			  verificaID();
			                      _exprID = _input.LT(-1).getText();
			                    
			setState(241);
			match(OP_INCREM);
			   
			                        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprID + _input.LT(-1).getText());
			                        cmd.setIncrementDecrement(true);
			                        stack.peek().add(cmd);
			                    
			setState(243);
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
	public static class ExprContext extends ParserRuleContext {
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(245);
			term();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_S) {
				{
				{
				setState(246);
				match(OP_S);
				 _exprContent += _input.LT(-1).getText();	
				setState(248);
				term();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 30, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(254);
			factor();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_M) {
				{
				{
				setState(255);
				match(OP_M);
				 _exprContent += _input.LT(-1).getText();	
				setState(257);
				factor();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(IsiLanguageParser.INT_VAL, 0); }
		public TerminalNode DOUBLE_VAL() { return getToken(IsiLanguageParser.DOUBLE_VAL, 0); }
		public TerminalNode STRING_VAL() { return getToken(IsiLanguageParser.STRING_VAL, 0); }
		public TerminalNode BOOLEAN_VAL() { return getToken(IsiLanguageParser.BOOLEAN_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(IsiLanguageParser.CHAR_VAL, 0); }
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
		enterRule(_localctx, 32, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(263);
				match(ID);
					verificaID();	
															verificaAtribuicao();
															int type = ((IsiVariable) symbolTable.get(_input.LT(-1).getText())).getType();
															verificaTipoVariavel(type);
														
				}
				break;
			case INT_VAL:
				{
				setState(265);
				match(INT_VAL);
					verificaTipoVariavel(IsiVariable.INT);			
				}
				break;
			case DOUBLE_VAL:
				{
				setState(267);
				match(DOUBLE_VAL);
					verificaTipoVariavel(IsiVariable.DOUBLE);		
				}
				break;
			case STRING_VAL:
				{
				setState(269);
				match(STRING_VAL);
					verificaTipoVariavel(IsiVariable.TEXT);			
				}
				break;
			case BOOLEAN_VAL:
				{
				setState(271);
				match(BOOLEAN_VAL);

								            verificaTipoVariavel(IsiVariable.BOOLEAN);
								            String booleanInput = _input.LT(-1).getText();
								            _exprContent += booleanInput.equals("false") ? "false" : "true";
								        
				}
				break;
			case CHAR_VAL:
				{
				setState(273);
				match(CHAR_VAL);

								            verificaTipoVariavel(IsiVariable.CHAR);
								            _exprContent += _input.LT(-1).getText();
								        
				}
				break;
			case AP:
				{
				setState(275);
				match(AP);
				 _exprContent += "("; 
				setState(277);
				expr();
				setState(278);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprContent += _input.LT(-1).getText();	
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
		"\u0004\u0001 \u011d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u0001)\b\u0001\u000b\u0001\f\u0001*\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u00025\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002?\b\u0002\u0005\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"R\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004W\b\u0004\u000b"+
		"\u0004\f\u0004X\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005b\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b{\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0090\b\t\u000b\t\f"+
		"\t\u0091\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u009a"+
		"\b\t\u000b\t\f\t\u009b\u0001\t\u0001\t\u0001\t\u0003\t\u00a1\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00b2\b\n\u000b\n\f"+
		"\n\u00b3\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0004\u000b\u00be\b\u000b\u000b\u000b\f\u000b\u00bf"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0004\f\u00e9\b\f\u000b\f\f\f\u00ea\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00fa\b\u000e\n\u000e\f\u000e\u00fd\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0103\b\u000f"+
		"\n\u000f\f\u000f\u0106\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0119\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0000\u012d\u0000\"\u0001"+
		"\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004,\u0001\u0000\u0000"+
		"\u0000\u0006Q\u0001\u0000\u0000\u0000\bS\u0001\u0000\u0000\u0000\na\u0001"+
		"\u0000\u0000\u0000\fc\u0001\u0000\u0000\u0000\u000ek\u0001\u0000\u0000"+
		"\u0000\u0010z\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000\u0000"+
		"\u0014\u00a4\u0001\u0000\u0000\u0000\u0016\u00b8\u0001\u0000\u0000\u0000"+
		"\u0018\u00ce\u0001\u0000\u0000\u0000\u001a\u00ef\u0001\u0000\u0000\u0000"+
		"\u001c\u00f5\u0001\u0000\u0000\u0000\u001e\u00fe\u0001\u0000\u0000\u0000"+
		" \u0118\u0001\u0000\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0003\b\u0004"+
		"\u0000$%\u0005\u0002\u0000\u0000%&\u0006\u0000\uffff\uffff\u0000&\u0001"+
		"\u0001\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000(\'\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0003\u0006\u0003\u0000"+
		"-.\u0005\u001f\u0000\u0000.4\u0006\u0002\uffff\uffff\u0000/0\u0005\u0015"+
		"\u0000\u000001\u0006\u0002\uffff\uffff\u000012\u0003\u001c\u000e\u0000"+
		"23\u0006\u0002\uffff\uffff\u000035\u0001\u0000\u0000\u00004/\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u00005B\u0001\u0000\u0000\u000067\u0005"+
		"\u001b\u0000\u000078\u0005\u001f\u0000\u00008>\u0006\u0002\uffff\uffff"+
		"\u00009:\u0005\u0015\u0000\u0000:;\u0006\u0002\uffff\uffff\u0000;<\u0003"+
		"\u001c\u000e\u0000<=\u0006\u0002\uffff\uffff\u0000=?\u0001\u0000\u0000"+
		"\u0000>9\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000"+
		"\u0000\u0000@6\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000EF\u0005\u0011\u0000\u0000F\u0005\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0005\u0000\u0000HR\u0006\u0003\uffff\uffff\u0000"+
		"IJ\u0005\t\u0000\u0000JR\u0006\u0003\uffff\uffff\u0000KL\u0005\u0007\u0000"+
		"\u0000LR\u0006\u0003\uffff\uffff\u0000MN\u0005\u000b\u0000\u0000NR\u0006"+
		"\u0003\uffff\uffff\u0000OP\u0005\r\u0000\u0000PR\u0006\u0003\uffff\uffff"+
		"\u0000QG\u0001\u0000\u0000\u0000QI\u0001\u0000\u0000\u0000QK\u0001\u0000"+
		"\u0000\u0000QM\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000R\u0007"+
		"\u0001\u0000\u0000\u0000SV\u0006\u0004\uffff\uffff\u0000TW\u0003\n\u0005"+
		"\u0000UW\u0003\u0002\u0001\u0000VT\u0001\u0000\u0000\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y\t\u0001\u0000\u0000\u0000Zb\u0003\f\u0006\u0000[b"+
		"\u0003\u000e\u0007\u0000\\b\u0003\u0010\b\u0000]b\u0003\u0012\t\u0000"+
		"^b\u0003\u0018\f\u0000_b\u0003\u0014\n\u0000`b\u0003\u0016\u000b\u0000"+
		"aZ\u0001\u0000\u0000\u0000a[\u0001\u0000\u0000\u0000a\\\u0001\u0000\u0000"+
		"\u0000a]\u0001\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000a`\u0001\u0000\u0000\u0000b\u000b\u0001\u0000\u0000\u0000"+
		"cd\u0005\u0003\u0000\u0000de\u0005\u000f\u0000\u0000ef\u0005\u001f\u0000"+
		"\u0000fg\u0006\u0006\uffff\uffff\u0000gh\u0005\u0010\u0000\u0000hi\u0005"+
		"\u0011\u0000\u0000ij\u0006\u0006\uffff\uffff\u0000j\r\u0001\u0000\u0000"+
		"\u0000kl\u0005\u0004\u0000\u0000lm\u0005\u000f\u0000\u0000mn\u0005\u001f"+
		"\u0000\u0000no\u0006\u0007\uffff\uffff\u0000op\u0005\u0010\u0000\u0000"+
		"pq\u0005\u0011\u0000\u0000qr\u0006\u0007\uffff\uffff\u0000r\u000f\u0001"+
		"\u0000\u0000\u0000st\u0003\u0006\u0003\u0000tu\u0005\u001f\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vw\u0006\b\uffff\uffff\u0000w{\u0001\u0000\u0000"+
		"\u0000xy\u0005\u001f\u0000\u0000y{\u0006\b\uffff\uffff\u0000zs\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0006"+
		"\b\uffff\uffff\u0000}~\u0005\u0015\u0000\u0000~\u007f\u0006\b\uffff\uffff"+
		"\u0000\u007f\u0080\u0003\u001c\u000e\u0000\u0080\u0081\u0005\u0011\u0000"+
		"\u0000\u0081\u0082\u0006\b\uffff\uffff\u0000\u0082\u0011\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005\u0016\u0000\u0000\u0084\u0085\u0005\u000f\u0000"+
		"\u0000\u0085\u0086\u0005\u001f\u0000\u0000\u0086\u0087\u0006\t\uffff\uffff"+
		"\u0000\u0087\u0088\u0005\u001e\u0000\u0000\u0088\u0089\u0006\t\uffff\uffff"+
		"\u0000\u0089\u008a\u0003\u001c\u000e\u0000\u008a\u008b\u0006\t\uffff\uffff"+
		"\u0000\u008b\u008c\u0005\u0010\u0000\u0000\u008c\u008d\u0005\u001c\u0000"+
		"\u0000\u008d\u008f\u0006\t\uffff\uffff\u0000\u008e\u0090\u0003\n\u0005"+
		"\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u001d\u0000"+
		"\u0000\u0094\u00a0\u0006\t\uffff\uffff\u0000\u0095\u0096\u0005\u0017\u0000"+
		"\u0000\u0096\u0097\u0005\u001c\u0000\u0000\u0097\u0099\u0006\t\uffff\uffff"+
		"\u0000\u0098\u009a\u0003\n\u0005\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0005\u001d\u0000\u0000\u009e\u009f\u0006\t\uffff\uffff\u0000"+
		"\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u0095\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0006\t\uffff\uffff\u0000\u00a3\u0013\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0005\u001a\u0000\u0000\u00a5\u00a6\u0005\u000f\u0000\u0000"+
		"\u00a6\u00a7\u0005\u001f\u0000\u0000\u00a7\u00a8\u0006\n\uffff\uffff\u0000"+
		"\u00a8\u00a9\u0005\u001e\u0000\u0000\u00a9\u00aa\u0006\n\uffff\uffff\u0000"+
		"\u00aa\u00ab\u0003\u001c\u000e\u0000\u00ab\u00ac\u0006\n\uffff\uffff\u0000"+
		"\u00ac\u00ad\u0005\u0010\u0000\u0000\u00ad\u00ae\u0005\u001c\u0000\u0000"+
		"\u00ae\u00b1\u0006\n\uffff\uffff\u0000\u00af\u00b2\u0003\n\u0005\u0000"+
		"\u00b0\u00b2\u0003\u001a\r\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u001d\u0000\u0000\u00b6"+
		"\u00b7\u0006\n\uffff\uffff\u0000\u00b7\u0015\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005\u0018\u0000\u0000\u00b9\u00ba\u0005\u001c\u0000\u0000\u00ba"+
		"\u00bd\u0006\u000b\uffff\uffff\u0000\u00bb\u00be\u0003\n\u0005\u0000\u00bc"+
		"\u00be\u0003\u001a\r\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u001d\u0000\u0000\u00c2\u00c3"+
		"\u0005\u001a\u0000\u0000\u00c3\u00c4\u0005\u000f\u0000\u0000\u00c4\u00c5"+
		"\u0005\u001f\u0000\u0000\u00c5\u00c6\u0006\u000b\uffff\uffff\u0000\u00c6"+
		"\u00c7\u0005\u001e\u0000\u0000\u00c7\u00c8\u0006\u000b\uffff\uffff\u0000"+
		"\u00c8\u00c9\u0003\u001c\u000e\u0000\u00c9\u00ca\u0006\u000b\uffff\uffff"+
		"\u0000\u00ca\u00cb\u0005\u0010\u0000\u0000\u00cb\u00cc\u0005\u0011\u0000"+
		"\u0000\u00cc\u00cd\u0006\u000b\uffff\uffff\u0000\u00cd\u0017\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0005\u0019\u0000\u0000\u00cf\u00d0\u0005\u000f"+
		"\u0000\u0000\u00d0\u00d1\u0005\u001f\u0000\u0000\u00d1\u00d2\u0006\f\uffff"+
		"\uffff\u0000\u00d2\u00d3\u0005\u0015\u0000\u0000\u00d3\u00d4\u0006\f\uffff"+
		"\uffff\u0000\u00d4\u00d5\u0003\u001c\u000e\u0000\u00d5\u00d6\u0005\u0011"+
		"\u0000\u0000\u00d6\u00d7\u0006\f\uffff\uffff\u0000\u00d7\u00d8\u0005\u001f"+
		"\u0000\u0000\u00d8\u00d9\u0006\f\uffff\uffff\u0000\u00d9\u00da\u0005\u001e"+
		"\u0000\u0000\u00da\u00db\u0006\f\uffff\uffff\u0000\u00db\u00dc\u0003\u001c"+
		"\u000e\u0000\u00dc\u00dd\u0006\f\uffff\uffff\u0000\u00dd\u00de\u0005\u0011"+
		"\u0000\u0000\u00de\u00df\u0006\f\uffff\uffff\u0000\u00df\u00e0\u0005\u001f"+
		"\u0000\u0000\u00e0\u00e1\u0006\f\uffff\uffff\u0000\u00e1\u00e2\u0005\u0014"+
		"\u0000\u0000\u00e2\u00e3\u0006\f\uffff\uffff\u0000\u00e3\u00e4\u0005\u0010"+
		"\u0000\u0000\u00e4\u00e5\u0005\u001c\u0000\u0000\u00e5\u00e8\u0006\f\uffff"+
		"\uffff\u0000\u00e6\u00e9\u0003\n\u0005\u0000\u00e7\u00e9\u0003\u001a\r"+
		"\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0005\u001d\u0000\u0000\u00ed\u00ee\u0006\f\uffff\uffff"+
		"\u0000\u00ee\u0019\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u001f\u0000"+
		"\u0000\u00f0\u00f1\u0006\r\uffff\uffff\u0000\u00f1\u00f2\u0005\u0014\u0000"+
		"\u0000\u00f2\u00f3\u0006\r\uffff\uffff\u0000\u00f3\u00f4\u0005\u0011\u0000"+
		"\u0000\u00f4\u001b\u0001\u0000\u0000\u0000\u00f5\u00fb\u0003\u001e\u000f"+
		"\u0000\u00f6\u00f7\u0005\u0012\u0000\u0000\u00f7\u00f8\u0006\u000e\uffff"+
		"\uffff\u0000\u00f8\u00fa\u0003\u001e\u000f\u0000\u00f9\u00f6\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u001d\u0001\u0000"+
		"\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u0104\u0003 \u0010"+
		"\u0000\u00ff\u0100\u0005\u0013\u0000\u0000\u0100\u0101\u0006\u000f\uffff"+
		"\uffff\u0000\u0101\u0103\u0003 \u0010\u0000\u0102\u00ff\u0001\u0000\u0000"+
		"\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u001f\u0001\u0000\u0000"+
		"\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u0108\u0005\u001f\u0000"+
		"\u0000\u0108\u0119\u0006\u0010\uffff\uffff\u0000\u0109\u010a\u0005\u0006"+
		"\u0000\u0000\u010a\u0119\u0006\u0010\uffff\uffff\u0000\u010b\u010c\u0005"+
		"\b\u0000\u0000\u010c\u0119\u0006\u0010\uffff\uffff\u0000\u010d\u010e\u0005"+
		"\n\u0000\u0000\u010e\u0119\u0006\u0010\uffff\uffff\u0000\u010f\u0110\u0005"+
		"\f\u0000\u0000\u0110\u0119\u0006\u0010\uffff\uffff\u0000\u0111\u0112\u0005"+
		"\u000e\u0000\u0000\u0112\u0119\u0006\u0010\uffff\uffff\u0000\u0113\u0114"+
		"\u0005\u000f\u0000\u0000\u0114\u0115\u0006\u0010\uffff\uffff\u0000\u0115"+
		"\u0116\u0003\u001c\u000e\u0000\u0116\u0117\u0005\u0010\u0000\u0000\u0117"+
		"\u0119\u0001\u0000\u0000\u0000\u0118\u0107\u0001\u0000\u0000\u0000\u0118"+
		"\u0109\u0001\u0000\u0000\u0000\u0118\u010b\u0001\u0000\u0000\u0000\u0118"+
		"\u010d\u0001\u0000\u0000\u0000\u0118\u010f\u0001\u0000\u0000\u0000\u0118"+
		"\u0111\u0001\u0000\u0000\u0000\u0118\u0113\u0001\u0000\u0000\u0000\u0119"+
		"\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0006\u0010\uffff\uffff\u0000"+
		"\u011b!\u0001\u0000\u0000\u0000\u0015*4>BQVXaz\u0091\u009b\u00a0\u00b1"+
		"\u00b3\u00bd\u00bf\u00e8\u00ea\u00fb\u0104\u0118";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}