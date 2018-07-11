// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/UncertainAgentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UncertainAgentspeakParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UncertainAgentspeakVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#uncertainAgentspeak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUncertainAgentspeak(UncertainAgentspeakParser.UncertainAgentspeakContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#init_bels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_bels(UncertainAgentspeakParser.Init_belsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#probabilistic_bel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbabilistic_bel(UncertainAgentspeakParser.Probabilistic_belContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#possibilistic_bel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibilistic_bel(UncertainAgentspeakParser.Possibilistic_belContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#init_goals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_goals(UncertainAgentspeakParser.Init_goalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#plans}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlans(UncertainAgentspeakParser.PlansContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(UncertainAgentspeakParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(UncertainAgentspeakParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#belief_event_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_event_trigger(UncertainAgentspeakParser.Belief_event_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#goal_event_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal_event_trigger(UncertainAgentspeakParser.Goal_event_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#add_goal_event_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_goal_event_trigger(UncertainAgentspeakParser.Add_goal_event_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#delete_goal_event_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_goal_event_trigger(UncertainAgentspeakParser.Delete_goal_event_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(UncertainAgentspeakParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#achievement_goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAchievement_goal(UncertainAgentspeakParser.Achievement_goalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#test_goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_goal(UncertainAgentspeakParser.Test_goalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#tautology}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTautology(UncertainAgentspeakParser.TautologyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#context}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext(UncertainAgentspeakParser.ContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#log_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog_expr(UncertainAgentspeakParser.Log_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(UncertainAgentspeakParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(UncertainAgentspeakParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#less_than_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess_than_expr(UncertainAgentspeakParser.Less_than_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#less_equals_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess_equals_expr(UncertainAgentspeakParser.Less_equals_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#greater_than_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater_than_expr(UncertainAgentspeakParser.Greater_than_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#greater_equals_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater_equals_expr(UncertainAgentspeakParser.Greater_equals_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#equals_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals_expr(UncertainAgentspeakParser.Equals_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#not_equals_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_equals_expr(UncertainAgentspeakParser.Not_equals_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#negation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation_expr(UncertainAgentspeakParser.Negation_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#belief_atom_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_atom_expr(UncertainAgentspeakParser.Belief_atom_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(UncertainAgentspeakParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_statement(UncertainAgentspeakParser.Body_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#belief_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_action(UncertainAgentspeakParser.Belief_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#environment_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment_action(UncertainAgentspeakParser.Environment_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#belief_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_literal(UncertainAgentspeakParser.Belief_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#positive_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositive_literal(UncertainAgentspeakParser.Positive_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#negative_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative_literal(UncertainAgentspeakParser.Negative_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#belief_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBelief_atom(UncertainAgentspeakParser.Belief_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(UncertainAgentspeakParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(UncertainAgentspeakParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(UncertainAgentspeakParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(UncertainAgentspeakParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#intNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(UncertainAgentspeakParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#doubleNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleNum(UncertainAgentspeakParser.DoubleNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(UncertainAgentspeakParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments_list(UncertainAgentspeakParser.Arguments_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UncertainAgentspeakParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(UncertainAgentspeakParser.StructureContext ctx);
}