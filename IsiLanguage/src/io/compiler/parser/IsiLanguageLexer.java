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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiLanguageLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "INT_DECL", "INT_VAL", "DOUBLE_DECL", 
			"DOUBLE_VAL", "STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", "BOOLEAN_VAL", 
			"CHAR_DECL", "CHAR_VAL", "AP", "FP", "SC", "OP_S", "OP_M", "OP_INCREM", 
			"ATTR", "IF", "ELSE", "DO", "FOR", "WHILE", "VIR", "ACH", "FCH", "OPREL", 
			"EQUALS", "NOT_EQUALS", "LOGICAL_AND", "LOGICAL_OR", "LOGICAL_NOT", "ID", 
			"WS"
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


	public IsiLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000%\u0114\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0004\u0005m\b\u0005\u000b\u0005\f\u0005n\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007w\b"+
		"\u0007\u000b\u0007\f\u0007x\u0001\u0007\u0001\u0007\u0004\u0007}\b\u0007"+
		"\u000b\u0007\f\u0007~\u0003\u0007\u0081\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u008e\b\b\u0001\t\u0001\t\u0005\t\u0092\b\t\n\t\f\t\u0095\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b1\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00cf\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u00fa\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001#\u0001#\u0005#\u010c\b#\n#\f#\u010f\t#\u0001$"+
		"\u0001$\u0001$\u0001$\u0000\u0000%\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c"+
		"9\u001d;\u001e=\u001f? A!C\"E#G$I%\u0001\u0000\b\u0001\u000009\u0003\u0000"+
		"\n\n\r\r\"\"\u0002\u0000++--\u0002\u0000**//\u0002\u0000<<>>\u0001\u0000"+
		"az\u0003\u000009AZaz\u0003\u0000\t\n\r\r  \u011e\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000"+
		"\u0000\u0000I\u0001\u0000\u0000\u0000\u0001K\u0001\u0000\u0000\u0000\u0003"+
		"Q\u0001\u0000\u0000\u0000\u0005V\u0001\u0000\u0000\u0000\u0007[\u0001"+
		"\u0000\u0000\u0000\tc\u0001\u0000\u0000\u0000\u000bl\u0001\u0000\u0000"+
		"\u0000\rp\u0001\u0000\u0000\u0000\u000fv\u0001\u0000\u0000\u0000\u0011"+
		"\u008d\u0001\u0000\u0000\u0000\u0013\u008f\u0001\u0000\u0000\u0000\u0015"+
		"\u0098\u0001\u0000\u0000\u0000\u0017\u00b0\u0001\u0000\u0000\u0000\u0019"+
		"\u00b2\u0001\u0000\u0000\u0000\u001b\u00bc\u0001\u0000\u0000\u0000\u001d"+
		"\u00c0\u0001\u0000\u0000\u0000\u001f\u00c2\u0001\u0000\u0000\u0000!\u00c4"+
		"\u0001\u0000\u0000\u0000#\u00c6\u0001\u0000\u0000\u0000%\u00c8\u0001\u0000"+
		"\u0000\u0000\'\u00ce\u0001\u0000\u0000\u0000)\u00d0\u0001\u0000\u0000"+
		"\u0000+\u00d2\u0001\u0000\u0000\u0000-\u00d5\u0001\u0000\u0000\u0000/"+
		"\u00db\u0001\u0000\u0000\u00001\u00e0\u0001\u0000\u0000\u00003\u00e5\u0001"+
		"\u0000\u0000\u00005\u00ee\u0001\u0000\u0000\u00007\u00f0\u0001\u0000\u0000"+
		"\u00009\u00f2\u0001\u0000\u0000\u0000;\u00f9\u0001\u0000\u0000\u0000="+
		"\u00fb\u0001\u0000\u0000\u0000?\u00fe\u0001\u0000\u0000\u0000A\u0101\u0001"+
		"\u0000\u0000\u0000C\u0104\u0001\u0000\u0000\u0000E\u0107\u0001\u0000\u0000"+
		"\u0000G\u0109\u0001\u0000\u0000\u0000I\u0110\u0001\u0000\u0000\u0000K"+
		"L\u0005s\u0000\u0000LM\u0005t\u0000\u0000MN\u0005a\u0000\u0000NO\u0005"+
		"r\u0000\u0000OP\u0005t\u0000\u0000P\u0002\u0001\u0000\u0000\u0000QR\u0005"+
		"e\u0000\u0000RS\u0005n\u0000\u0000ST\u0005d\u0000\u0000TU\u0005;\u0000"+
		"\u0000U\u0004\u0001\u0000\u0000\u0000VW\u0005l\u0000\u0000WX\u0005e\u0000"+
		"\u0000XY\u0005i\u0000\u0000YZ\u0005a\u0000\u0000Z\u0006\u0001\u0000\u0000"+
		"\u0000[\\\u0005e\u0000\u0000\\]\u0005s\u0000\u0000]^\u0005c\u0000\u0000"+
		"^_\u0005r\u0000\u0000_`\u0005e\u0000\u0000`a\u0005v\u0000\u0000ab\u0005"+
		"a\u0000\u0000b\b\u0001\u0000\u0000\u0000cd\u0005i\u0000\u0000de\u0005"+
		"n\u0000\u0000ef\u0005t\u0000\u0000fg\u0005e\u0000\u0000gh\u0005i\u0000"+
		"\u0000hi\u0005r\u0000\u0000ij\u0005o\u0000\u0000j\n\u0001\u0000\u0000"+
		"\u0000km\u0007\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\f\u0001"+
		"\u0000\u0000\u0000pq\u0005r\u0000\u0000qr\u0005e\u0000\u0000rs\u0005a"+
		"\u0000\u0000st\u0005l\u0000\u0000t\u000e\u0001\u0000\u0000\u0000uw\u0007"+
		"\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0080\u0001\u0000"+
		"\u0000\u0000z|\u0005.\u0000\u0000{}\u0007\u0000\u0000\u0000|{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080z\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0010\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005t\u0000\u0000\u0083\u0084\u0005e\u0000"+
		"\u0000\u0084\u0085\u0005x\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086"+
		"\u008e\u0005o\u0000\u0000\u0087\u0088\u0005s\u0000\u0000\u0088\u0089\u0005"+
		"t\u0000\u0000\u0089\u008a\u0005r\u0000\u0000\u008a\u008b\u0005i\u0000"+
		"\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u008e\u0005g\u0000\u0000\u008d"+
		"\u0082\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000\u0000\u0000\u008e"+
		"\u0012\u0001\u0000\u0000\u0000\u008f\u0093\u0005\"\u0000\u0000\u0090\u0092"+
		"\b\u0001\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005\"\u0000\u0000\u0097\u0014\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0005b\u0000\u0000\u0099\u009a\u0005o\u0000\u0000"+
		"\u009a\u009b\u0005o\u0000\u0000\u009b\u009c\u0005l\u0000\u0000\u009c\u009d"+
		"\u0005e\u0000\u0000\u009d\u009e\u0005a\u0000\u0000\u009e\u009f\u0005n"+
		"\u0000\u0000\u009f\u00a0\u0005o\u0000\u0000\u00a0\u0016\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005v\u0000\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3"+
		"\u00a4\u0005r\u0000\u0000\u00a4\u00a5\u0005d\u0000\u0000\u00a5\u00a6\u0005"+
		"a\u0000\u0000\u00a6\u00a7\u0005d\u0000\u0000\u00a7\u00a8\u0005e\u0000"+
		"\u0000\u00a8\u00a9\u0005i\u0000\u0000\u00a9\u00aa\u0005r\u0000\u0000\u00aa"+
		"\u00b1\u0005o\u0000\u0000\u00ab\u00ac\u0005f\u0000\u0000\u00ac\u00ad\u0005"+
		"a\u0000\u0000\u00ad\u00ae\u0005l\u0000\u0000\u00ae\u00af\u0005s\u0000"+
		"\u0000\u00af\u00b1\u0005o\u0000\u0000\u00b0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ab\u0001\u0000\u0000\u0000\u00b1\u0018\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005c\u0000\u0000\u00b3\u00b4\u0005a\u0000\u0000\u00b4\u00b5"+
		"\u0005r\u0000\u0000\u00b5\u00b6\u0005a\u0000\u0000\u00b6\u00b7\u0005c"+
		"\u0000\u0000\u00b7\u00b8\u0005t\u0000\u0000\u00b8\u00b9\u0005e\u0000\u0000"+
		"\u00b9\u00ba\u0005r\u0000\u0000\u00ba\u00bb\u0005e\u0000\u0000\u00bb\u001a"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd\u00be\t"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005\'\u0000\u0000\u00bf\u001c\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005(\u0000\u0000\u00c1\u001e\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005)\u0000\u0000\u00c3 \u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005;\u0000\u0000\u00c5\"\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0007\u0002\u0000\u0000\u00c7$\u0001\u0000\u0000\u0000\u00c8\u00c9\u0007"+
		"\u0003\u0000\u0000\u00c9&\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005+\u0000"+
		"\u0000\u00cb\u00cf\u0005+\u0000\u0000\u00cc\u00cd\u0005-\u0000\u0000\u00cd"+
		"\u00cf\u0005-\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cf(\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"=\u0000\u0000\u00d1*\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005s\u0000"+
		"\u0000\u00d3\u00d4\u0005e\u0000\u0000\u00d4,\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0005s\u0000\u0000\u00d6\u00d7\u0005e\u0000\u0000\u00d7\u00d8\u0005"+
		"n\u0000\u0000\u00d8\u00d9\u0005a\u0000\u0000\u00d9\u00da\u0005o\u0000"+
		"\u0000\u00da.\u0001\u0000\u0000\u0000\u00db\u00dc\u0005f\u0000\u0000\u00dc"+
		"\u00dd\u0005a\u0000\u0000\u00dd\u00de\u0005c\u0000\u0000\u00de\u00df\u0005"+
		"a\u0000\u0000\u00df0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005p\u0000"+
		"\u0000\u00e1\u00e2\u0005a\u0000\u0000\u00e2\u00e3\u0005r\u0000\u0000\u00e3"+
		"\u00e4\u0005a\u0000\u0000\u00e42\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005"+
		"e\u0000\u0000\u00e6\u00e7\u0005n\u0000\u0000\u00e7\u00e8\u0005q\u0000"+
		"\u0000\u00e8\u00e9\u0005u\u0000\u0000\u00e9\u00ea\u0005a\u0000\u0000\u00ea"+
		"\u00eb\u0005n\u0000\u0000\u00eb\u00ec\u0005t\u0000\u0000\u00ec\u00ed\u0005"+
		"o\u0000\u0000\u00ed4\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005,\u0000"+
		"\u0000\u00ef6\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005{\u0000\u0000\u00f1"+
		"8\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005}\u0000\u0000\u00f3:\u0001"+
		"\u0000\u0000\u0000\u00f4\u00fa\u0007\u0004\u0000\u0000\u00f5\u00f6\u0005"+
		">\u0000\u0000\u00f6\u00fa\u0005=\u0000\u0000\u00f7\u00f8\u0005<\u0000"+
		"\u0000\u00f8\u00fa\u0005=\u0000\u0000\u00f9\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f5\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fa<\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005=\u0000\u0000\u00fc\u00fd"+
		"\u0005=\u0000\u0000\u00fd>\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005!"+
		"\u0000\u0000\u00ff\u0100\u0005=\u0000\u0000\u0100@\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0005&\u0000\u0000\u0102\u0103\u0005&\u0000\u0000\u0103B"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0005|\u0000\u0000\u0105\u0106\u0005"+
		"|\u0000\u0000\u0106D\u0001\u0000\u0000\u0000\u0107\u0108\u0005!\u0000"+
		"\u0000\u0108F\u0001\u0000\u0000\u0000\u0109\u010d\u0007\u0005\u0000\u0000"+
		"\u010a\u010c\u0007\u0006\u0000\u0000\u010b\u010a\u0001\u0000\u0000\u0000"+
		"\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0001\u0000\u0000\u0000\u010eH\u0001\u0000\u0000\u0000\u010f"+
		"\u010d\u0001\u0000\u0000\u0000\u0110\u0111\u0007\u0007\u0000\u0000\u0111"+
		"\u0112\u0001\u0000\u0000\u0000\u0112\u0113\u0006$\u0000\u0000\u0113J\u0001"+
		"\u0000\u0000\u0000\f\u0000nx~\u0080\u008d\u0093\u00b0\u00ce\u00f9\u010b"+
		"\u010d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}