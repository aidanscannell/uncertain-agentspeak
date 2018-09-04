// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/UncertainAgentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UncertainAgentspeakParser}.
 */
public interface UncertainAgentspeakListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#uncertainAgentspeak}.
	 * @param ctx the parse tree
	 */
	void enterUncertainAgentspeak(UncertainAgentspeakParser.UncertainAgentspeakContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#uncertainAgentspeak}.
	 * @param ctx the parse tree
	 */
	void exitUncertainAgentspeak(UncertainAgentspeakParser.UncertainAgentspeakContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#init_bels}.
	 * @param ctx the parse tree
	 */
	void enterInit_bels(UncertainAgentspeakParser.Init_belsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#init_bels}.
	 * @param ctx the parse tree
	 */
	void exitInit_bels(UncertainAgentspeakParser.Init_belsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#probabilistic_es}.
	 * @param ctx the parse tree
	 */
	void enterProbabilistic_es(UncertainAgentspeakParser.Probabilistic_esContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#probabilistic_es}.
	 * @param ctx the parse tree
	 */
	void exitProbabilistic_es(UncertainAgentspeakParser.Probabilistic_esContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#possibilistic_es}.
	 * @param ctx the parse tree
	 */
	void enterPossibilistic_es(UncertainAgentspeakParser.Possibilistic_esContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#possibilistic_es}.
	 * @param ctx the parse tree
	 */
	void exitPossibilistic_es(UncertainAgentspeakParser.Possibilistic_esContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#probabilistic_bel}.
	 * @param ctx the parse tree
	 */
	void enterProbabilistic_bel(UncertainAgentspeakParser.Probabilistic_belContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#probabilistic_bel}.
	 * @param ctx the parse tree
	 */
	void exitProbabilistic_bel(UncertainAgentspeakParser.Probabilistic_belContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#possibilistic_bel}.
	 * @param ctx the parse tree
	 */
	void enterPossibilistic_bel(UncertainAgentspeakParser.Possibilistic_belContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#possibilistic_bel}.
	 * @param ctx the parse tree
	 */
	void exitPossibilistic_bel(UncertainAgentspeakParser.Possibilistic_belContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#init_goals}.
	 * @param ctx the parse tree
	 */
	void enterInit_goals(UncertainAgentspeakParser.Init_goalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#init_goals}.
	 * @param ctx the parse tree
	 */
	void exitInit_goals(UncertainAgentspeakParser.Init_goalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#plans}.
	 * @param ctx the parse tree
	 */
	void enterPlans(UncertainAgentspeakParser.PlansContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#plans}.
	 * @param ctx the parse tree
	 */
	void exitPlans(UncertainAgentspeakParser.PlansContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#plan}.
	 * @param ctx the parse tree
	 */
	void enterPlan(UncertainAgentspeakParser.PlanContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#plan}.
	 * @param ctx the parse tree
	 */
	void exitPlan(UncertainAgentspeakParser.PlanContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(UncertainAgentspeakParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(UncertainAgentspeakParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#belief_event_trigger}.
	 * @param ctx the parse tree
	 */
	void enterBelief_event_trigger(UncertainAgentspeakParser.Belief_event_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#belief_event_trigger}.
	 * @param ctx the parse tree
	 */
	void exitBelief_event_trigger(UncertainAgentspeakParser.Belief_event_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void enterGoal_event_trigger(UncertainAgentspeakParser.Goal_event_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void exitGoal_event_trigger(UncertainAgentspeakParser.Goal_event_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#add_goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void enterAdd_goal_event_trigger(UncertainAgentspeakParser.Add_goal_event_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#add_goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void exitAdd_goal_event_trigger(UncertainAgentspeakParser.Add_goal_event_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#delete_goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDelete_goal_event_trigger(UncertainAgentspeakParser.Delete_goal_event_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#delete_goal_event_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDelete_goal_event_trigger(UncertainAgentspeakParser.Delete_goal_event_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(UncertainAgentspeakParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(UncertainAgentspeakParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#achievement_goal}.
	 * @param ctx the parse tree
	 */
	void enterAchievement_goal(UncertainAgentspeakParser.Achievement_goalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#achievement_goal}.
	 * @param ctx the parse tree
	 */
	void exitAchievement_goal(UncertainAgentspeakParser.Achievement_goalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#test_goal}.
	 * @param ctx the parse tree
	 */
	void enterTest_goal(UncertainAgentspeakParser.Test_goalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#test_goal}.
	 * @param ctx the parse tree
	 */
	void exitTest_goal(UncertainAgentspeakParser.Test_goalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#tautology}.
	 * @param ctx the parse tree
	 */
	void enterTautology(UncertainAgentspeakParser.TautologyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#tautology}.
	 * @param ctx the parse tree
	 */
	void exitTautology(UncertainAgentspeakParser.TautologyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(UncertainAgentspeakParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(UncertainAgentspeakParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#log_expr}.
	 * @param ctx the parse tree
	 */
	void enterLog_expr(UncertainAgentspeakParser.Log_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#log_expr}.
	 * @param ctx the parse tree
	 */
	void exitLog_expr(UncertainAgentspeakParser.Log_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(UncertainAgentspeakParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(UncertainAgentspeakParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(UncertainAgentspeakParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(UncertainAgentspeakParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#less_than_expr}.
	 * @param ctx the parse tree
	 */
	void enterLess_than_expr(UncertainAgentspeakParser.Less_than_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#less_than_expr}.
	 * @param ctx the parse tree
	 */
	void exitLess_than_expr(UncertainAgentspeakParser.Less_than_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#less_equals_expr}.
	 * @param ctx the parse tree
	 */
	void enterLess_equals_expr(UncertainAgentspeakParser.Less_equals_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#less_equals_expr}.
	 * @param ctx the parse tree
	 */
	void exitLess_equals_expr(UncertainAgentspeakParser.Less_equals_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#greater_than_expr}.
	 * @param ctx the parse tree
	 */
	void enterGreater_than_expr(UncertainAgentspeakParser.Greater_than_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#greater_than_expr}.
	 * @param ctx the parse tree
	 */
	void exitGreater_than_expr(UncertainAgentspeakParser.Greater_than_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#greater_equals_expr}.
	 * @param ctx the parse tree
	 */
	void enterGreater_equals_expr(UncertainAgentspeakParser.Greater_equals_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#greater_equals_expr}.
	 * @param ctx the parse tree
	 */
	void exitGreater_equals_expr(UncertainAgentspeakParser.Greater_equals_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#equals_expr}.
	 * @param ctx the parse tree
	 */
	void enterEquals_expr(UncertainAgentspeakParser.Equals_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#equals_expr}.
	 * @param ctx the parse tree
	 */
	void exitEquals_expr(UncertainAgentspeakParser.Equals_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#not_equals_expr}.
	 * @param ctx the parse tree
	 */
	void enterNot_equals_expr(UncertainAgentspeakParser.Not_equals_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#not_equals_expr}.
	 * @param ctx the parse tree
	 */
	void exitNot_equals_expr(UncertainAgentspeakParser.Not_equals_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#negation_expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation_expr(UncertainAgentspeakParser.Negation_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#negation_expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation_expr(UncertainAgentspeakParser.Negation_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#belief_atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterBelief_atom_expr(UncertainAgentspeakParser.Belief_atom_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#belief_atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitBelief_atom_expr(UncertainAgentspeakParser.Belief_atom_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(UncertainAgentspeakParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(UncertainAgentspeakParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 */
	void enterBody_statement(UncertainAgentspeakParser.Body_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#body_statement}.
	 * @param ctx the parse tree
	 */
	void exitBody_statement(UncertainAgentspeakParser.Body_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#belief_action}.
	 * @param ctx the parse tree
	 */
	void enterBelief_action(UncertainAgentspeakParser.Belief_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#belief_action}.
	 * @param ctx the parse tree
	 */
	void exitBelief_action(UncertainAgentspeakParser.Belief_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#environment_action}.
	 * @param ctx the parse tree
	 */
	void enterEnvironment_action(UncertainAgentspeakParser.Environment_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#environment_action}.
	 * @param ctx the parse tree
	 */
	void exitEnvironment_action(UncertainAgentspeakParser.Environment_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#belief_literal}.
	 * @param ctx the parse tree
	 */
	void enterBelief_literal(UncertainAgentspeakParser.Belief_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#belief_literal}.
	 * @param ctx the parse tree
	 */
	void exitBelief_literal(UncertainAgentspeakParser.Belief_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#positive_literal}.
	 * @param ctx the parse tree
	 */
	void enterPositive_literal(UncertainAgentspeakParser.Positive_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#positive_literal}.
	 * @param ctx the parse tree
	 */
	void exitPositive_literal(UncertainAgentspeakParser.Positive_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#negative_literal}.
	 * @param ctx the parse tree
	 */
	void enterNegative_literal(UncertainAgentspeakParser.Negative_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#negative_literal}.
	 * @param ctx the parse tree
	 */
	void exitNegative_literal(UncertainAgentspeakParser.Negative_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#belief_atom}.
	 * @param ctx the parse tree
	 */
	void enterBelief_atom(UncertainAgentspeakParser.Belief_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#belief_atom}.
	 * @param ctx the parse tree
	 */
	void exitBelief_atom(UncertainAgentspeakParser.Belief_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(UncertainAgentspeakParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(UncertainAgentspeakParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(UncertainAgentspeakParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(UncertainAgentspeakParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(UncertainAgentspeakParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(UncertainAgentspeakParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(UncertainAgentspeakParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(UncertainAgentspeakParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#intNum}.
	 * @param ctx the parse tree
	 */
	void enterIntNum(UncertainAgentspeakParser.IntNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#intNum}.
	 * @param ctx the parse tree
	 */
	void exitIntNum(UncertainAgentspeakParser.IntNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#doubleNum}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNum(UncertainAgentspeakParser.DoubleNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#doubleNum}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNum(UncertainAgentspeakParser.DoubleNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(UncertainAgentspeakParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(UncertainAgentspeakParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArguments_list(UncertainAgentspeakParser.Arguments_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArguments_list(UncertainAgentspeakParser.Arguments_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UncertainAgentspeakParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(UncertainAgentspeakParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link UncertainAgentspeakParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(UncertainAgentspeakParser.StructureContext ctx);
}