// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/Agentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AgentspeakParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AgentspeakVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#agentspeak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentspeak(AgentspeakParser.AgentspeakContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(AgentspeakParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#belief}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief(AgentspeakParser.BeliefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(AgentspeakParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#context}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext(AgentspeakParser.ContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#context_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext_list(AgentspeakParser.Context_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AgentspeakParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#body_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_list(AgentspeakParser.Body_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_statement(AgentspeakParser.Body_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments_list(AgentspeakParser.Arguments_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(AgentspeakParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(AgentspeakParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(AgentspeakParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(AgentspeakParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentspeakParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AgentspeakParser.VariableContext ctx);
}