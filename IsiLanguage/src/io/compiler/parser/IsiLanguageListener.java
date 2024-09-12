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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLanguageParser}.
 */
public interface IsiLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLanguageParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLanguageParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsiLanguageParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsiLanguageParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLanguageParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLanguageParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLanguageParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLanguageParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLanguageParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLanguageParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLanguageParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLanguageParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(IsiLanguageParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(IsiLanguageParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#whileC}.
	 * @param ctx the parse tree
	 */
	void enterWhileC(IsiLanguageParser.WhileCContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#whileC}.
	 * @param ctx the parse tree
	 */
	void exitWhileC(IsiLanguageParser.WhileCContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#doWhileC}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileC(IsiLanguageParser.DoWhileCContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#doWhileC}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileC(IsiLanguageParser.DoWhileCContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#forC}.
	 * @param ctx the parse tree
	 */
	void enterForC(IsiLanguageParser.ForCContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#forC}.
	 * @param ctx the parse tree
	 */
	void exitForC(IsiLanguageParser.ForCContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#incDec}.
	 * @param ctx the parse tree
	 */
	void enterIncDec(IsiLanguageParser.IncDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#incDec}.
	 * @param ctx the parse tree
	 */
	void exitIncDec(IsiLanguageParser.IncDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(IsiLanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(IsiLanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(IsiLanguageParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(IsiLanguageParser.FactorContext ctx);
}