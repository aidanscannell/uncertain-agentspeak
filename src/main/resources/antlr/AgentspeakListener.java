// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/Agentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AgentspeakParser}.
 */
public interface AgentspeakListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#agentspeak}.
	 * @param ctx the parse tree
	 */
	void enterAgentspeak(AgentspeakParser.AgentspeakContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#agentspeak}.
	 * @param ctx the parse tree
	 */
	void exitAgentspeak(AgentspeakParser.AgentspeakContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#plan}.
	 * @param ctx the parse tree
	 */
	void enterPlan(AgentspeakParser.PlanContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#plan}.
	 * @param ctx the parse tree
	 */
	void exitPlan(AgentspeakParser.PlanContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#belief}.
	 * @param ctx the parse tree
	 */
	void enterBelief(AgentspeakParser.BeliefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#belief}.
	 * @param ctx the parse tree
	 */
	void exitBelief(AgentspeakParser.BeliefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(AgentspeakParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(AgentspeakParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(AgentspeakParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(AgentspeakParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#context_list}.
	 * @param ctx the parse tree
	 */
	void enterContext_list(AgentspeakParser.Context_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#context_list}.
	 * @param ctx the parse tree
	 */
	void exitContext_list(AgentspeakParser.Context_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(AgentspeakParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(AgentspeakParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#body_list}.
	 * @param ctx the parse tree
	 */
	void enterBody_list(AgentspeakParser.Body_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#body_list}.
	 * @param ctx the parse tree
	 */
	void exitBody_list(AgentspeakParser.Body_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 */
	void enterBody_statement(AgentspeakParser.Body_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 */
	void exitBody_statement(AgentspeakParser.Body_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArguments_list(AgentspeakParser.Arguments_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArguments_list(AgentspeakParser.Arguments_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(AgentspeakParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(AgentspeakParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(AgentspeakParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(AgentspeakParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(AgentspeakParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(AgentspeakParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(AgentspeakParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(AgentspeakParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentspeakParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AgentspeakParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentspeakParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AgentspeakParser.VariableContext ctx);
}