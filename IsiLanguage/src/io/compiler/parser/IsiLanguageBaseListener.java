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


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link IsiLanguageListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class IsiLanguageBaseListener implements IsiLanguageListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProg(IsiLanguageParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProg(IsiLanguageParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDecl(IsiLanguageParser.DeclContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDecl(IsiLanguageParser.DeclContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaravar(IsiLanguageParser.DeclaravarContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaravar(IsiLanguageParser.DeclaravarContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTipo(IsiLanguageParser.TipoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTipo(IsiLanguageParser.TipoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBloco(IsiLanguageParser.BlocoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBloco(IsiLanguageParser.BlocoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCmd(IsiLanguageParser.CmdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCmd(IsiLanguageParser.CmdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCmdleitura(IsiLanguageParser.CmdleituraContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCmdleitura(IsiLanguageParser.CmdleituraContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCmdescrita(IsiLanguageParser.CmdescritaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCmdescrita(IsiLanguageParser.CmdescritaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCmdattrib(IsiLanguageParser.CmdattribContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCmdattrib(IsiLanguageParser.CmdattribContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCmdselecao(IsiLanguageParser.CmdselecaoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCmdselecao(IsiLanguageParser.CmdselecaoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileC(IsiLanguageParser.WhileCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileC(IsiLanguageParser.WhileCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDoWhileC(IsiLanguageParser.DoWhileCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDoWhileC(IsiLanguageParser.DoWhileCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForC(IsiLanguageParser.ForCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForC(IsiLanguageParser.ForCContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIncDec(IsiLanguageParser.IncDecContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIncDec(IsiLanguageParser.IncDecContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr(IsiLanguageParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(IsiLanguageParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTerm(IsiLanguageParser.TermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTerm(IsiLanguageParser.TermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFactor(IsiLanguageParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFactor(IsiLanguageParser.FactorContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}