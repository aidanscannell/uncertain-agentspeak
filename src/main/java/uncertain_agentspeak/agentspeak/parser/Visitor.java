package main.java.uncertain_agentspeak.agentspeak.parser;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.BeliefAction;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.agentspeak.actions.belief_actions.ReviseBeliefAction;
import main.java.uncertain_agentspeak.agentspeak.actions.goal_actions.AchievementGoalAction;
import main.java.uncertain_agentspeak.agentspeak.actions.goal_actions.TestGoalAction;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.BeliefEventTrigger;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.GoalEventTrigger;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.AddGoalET;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.DeleteGoalET;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Conjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Disjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.GreaterEqualsPlausibility;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.GreaterThanPlausibility;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.negations.NegationAsFailure;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.relational_expressions.Equal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.relational_expressions.NotEqual;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.primitives.Tautology;
import main.java.uncertain_agentspeak.agentspeak.events.ExternalEvent;
import main.java.uncertain_agentspeak.agentspeak.goals.AchievementGoal;
import main.java.uncertain_agentspeak.agentspeak.goals.TestGoal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.NegativeLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.java.uncertain_agentspeak.agentspeak.terms.Constant;
import main.java.uncertain_agentspeak.agentspeak.terms.Structure;
import main.java.uncertain_agentspeak.agentspeak.terms.Variable;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.Atom;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.Number;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.DoubleNum;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.IntNum;
import main.resources.antlr.uncertain_agentspeak.UncertainAgentspeakBaseVisitor;
import main.resources.antlr.uncertain_agentspeak.UncertainAgentspeakParser;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactPossibilisticEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Visitor extends UncertainAgentspeakBaseVisitor<Object> {

    @Override
    public Agent visitUncertainAgentspeak(UncertainAgentspeakParser.UncertainAgentspeakContext ctx) {
        Agent agent = new Agent();

        // Global uncertain belief (belief base)
        agent.setBeliefBase(visitInit_bels(ctx.init_bels()));

        // Initial goals
        agent.setEventSet(visitInit_goals(ctx.init_goals()));

        // Plan library
        agent.setPlanLibrary(visitPlans(ctx.plans()));

        return agent;
    }

    @Override
    public EventSet visitInit_goals(UncertainAgentspeakParser.Init_goalsContext ctx) {
        EventSet initGoals = new EventSet();
        for (int i=0; i<ctx.achievement_goal().size(); i++) {
            initGoals.add(new ExternalEvent(new AddGoalET(visitAchievement_goal(ctx.achievement_goal(i)))));
        }
        return initGoals;
    }

    @Override
    public PlanLibrary visitPlans(UncertainAgentspeakParser.PlansContext ctx) {
        PlanLibrary planLibrary = new PlanLibrary();
        for (UncertainAgentspeakParser.PlanContext planContext : ctx.plan()) {
            planLibrary.add(visitPlan(planContext));
        }
        return planLibrary;
    }

    @Override
    public Plan visitPlan(UncertainAgentspeakParser.PlanContext ctx) {
        if (ctx.context() != null && ctx.body() != null && ctx.event() != null) {
//            Event event = visitEvent(ctx.event());
//            LogicalExpression context = visitContext(ctx.context());
//            ArrayList<Action> body = visitBody(ctx.body());
            return new Plan(visitEvent(ctx.event()), visitContext(ctx.context()), visitBody(ctx.body()));
        } else {
            //TODO: add exception
            return null;
        }
    }

    @Override
    public LogicalExpression visitContext(UncertainAgentspeakParser.ContextContext ctx) {
        if (ctx.and_expr() != null) {
            return visitAnd_expr(ctx.and_expr());
        } else if (ctx.tautology() != null) {
            return new Tautology();
        } else {
            // TODO: Add exception
            return null;
        }
    }

    @Override
    public LogicalExpression visitAnd_expr(UncertainAgentspeakParser.And_exprContext ctx) {
        ArrayList<UncertainAgentspeakParser.Or_exprContext> copy = new ArrayList<>(ctx.or_expr());
        if (ctx.or_expr().size() < 2) {
            return visitOr_expr(ctx.or_expr(0));
        } else {
            ArrayList<UncertainAgentspeakParser.Or_exprContext> subList = new ArrayList<>(copy.subList(1,copy.size()));
            try {
                return new Conjunction(visitOr_expr(ctx.or_expr(0)), visitAnd_expr(subList));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public LogicalExpression visitAnd_expr(ArrayList<UncertainAgentspeakParser.Or_exprContext> ctx) throws Exception {
        ArrayList<UncertainAgentspeakParser.Or_exprContext> copy = new ArrayList<>(ctx);
        if (ctx.size() < 2) {
            return visitOr_expr(ctx.get(0));
        } else {
            ArrayList<UncertainAgentspeakParser.Or_exprContext> subList = new ArrayList<>(copy.subList(1,copy.size()));
            return new Conjunction(visitOr_expr(ctx.get(0)),visitAnd_expr(subList));
        }
    }

    @Override
    public LogicalExpression visitOr_expr(UncertainAgentspeakParser.Or_exprContext ctx) {
        ArrayList<UncertainAgentspeakParser.Less_than_exprContext> copy = new ArrayList<>(ctx.less_than_expr());
        if (ctx.less_than_expr().size() < 2) {
            return visitLess_than_expr(ctx.less_than_expr(0));
        } else {
            ArrayList<UncertainAgentspeakParser.Less_than_exprContext> subList = new ArrayList<>(copy.subList(1,copy.size()));
            try {
                return new Disjunction(visitLess_than_expr(ctx.less_than_expr(0)), visitOr_expr(subList));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public LogicalExpression visitOr_expr(ArrayList<UncertainAgentspeakParser.Less_than_exprContext> ctx) throws Exception {
        ArrayList<UncertainAgentspeakParser.Less_than_exprContext> copy = new ArrayList<>(ctx);
        if (ctx.size() < 2) {
            return visitLess_than_expr(ctx.get(0));
        } else {
            ArrayList<UncertainAgentspeakParser.Less_than_exprContext> subList = new ArrayList<>(copy.subList(1,copy.size()));
            return new Disjunction(visitLess_than_expr(ctx.get(0)),visitOr_expr(subList));
        }
    }

//    @Override
//    public LogicalExpression visitOr_expr(UncertainAgentspeakParser.Or_exprContext ctx) {
//        if (ctx.less_than_expr().size() > 1) {
//            for (int i =0; i < ctx.less_than_expr().size(); i++) {
//                Disjunction disjunction = new Disjunction(visitLess_than_expr(ctx.less_than_expr(i)),visitLess_than_expr(ctx.less_than_expr(i+1)));
//            }
//        } else {
//            return visitLess_than_expr(ctx.less_than_expr(0));
//        }
//    }


    @Override
    public LogicalExpression visitLess_than_expr(UncertainAgentspeakParser.Less_than_exprContext ctx) {
        if (ctx.less_equals_expr().size() > 1) {
            try {
                return new GreaterEqualsPlausibility(visitLess_equals_expr(ctx.less_equals_expr(1)),visitLess_equals_expr(ctx.less_equals_expr(0)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitLess_equals_expr(ctx.less_equals_expr(0));
        }
    }

    @Override
    public LogicalExpression visitLess_equals_expr(UncertainAgentspeakParser.Less_equals_exprContext ctx) {
        if (ctx.greater_than_expr().size() > 1) {
            try {
                return new GreaterThanPlausibility(visitGreater_than_expr(ctx.greater_than_expr(1)),visitGreater_than_expr(ctx.greater_than_expr(0)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitGreater_than_expr(ctx.greater_than_expr(0));
        }
    }

    @Override
    public LogicalExpression visitGreater_than_expr(UncertainAgentspeakParser.Greater_than_exprContext ctx) {
        if (ctx.greater_equals_expr().size() > 1) {
            try {
                return new GreaterThanPlausibility(visitGreater_equals_expr(ctx.greater_equals_expr(0)),visitGreater_equals_expr(ctx.greater_equals_expr(1)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitGreater_equals_expr(ctx.greater_equals_expr(0));
        }
    }

//    @Override
//    public LogicalExpression visitGreater_equals_expr(UncertainAgentspeakParser.Greater_equals_exprContext ctx) throws Exception {
////        if (ctx.negation_expr().size() > 1) {
//        if (ctx.equals_expr().size() > 1) {
//            return new GreaterEqualsPlausibility(visitNegation_expr(ctx.negation_expr(0)),visitNegation_expr(ctx.negation_expr(1)));
//        } else {
//            return visitNegation_expr(ctx.negation_expr(0));
//        }
//    }
    @Override
    public LogicalExpression visitGreater_equals_expr(UncertainAgentspeakParser.Greater_equals_exprContext ctx) {
        if (ctx.equals_expr().size() > 1) {
            try {
                return new GreaterEqualsPlausibility(visitEquals_expr(ctx.equals_expr(0)),visitEquals_expr(ctx.equals_expr(1)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitEquals_expr(ctx.equals_expr(0));
        }
    }

    @Override
    public LogicalExpression visitEquals_expr(UncertainAgentspeakParser.Equals_exprContext ctx) {
        if (ctx.not_equals_expr().size() > 1) {
            return new Equal(visitNot_equals_expr(ctx.not_equals_expr(0)),visitNot_equals_expr(ctx.not_equals_expr(1)));
        } else {
            return visitNot_equals_expr(ctx.not_equals_expr(0));
        }
    }

    @Override
    public LogicalExpression visitNot_equals_expr(UncertainAgentspeakParser.Not_equals_exprContext ctx) {
        if (ctx.negation_expr().size() > 1) {
            return new NotEqual(visitNegation_expr(ctx.negation_expr(0)),visitNegation_expr(ctx.negation_expr(1)));
        } else {
            return visitNegation_expr(ctx.negation_expr(0));
        }
    }

    @Override
    public LogicalExpression visitNegation_expr(UncertainAgentspeakParser.Negation_exprContext ctx) {
        if (ctx.STRONG_NEGATION() != null) {
            return new StrongNegation(visitBelief_atom_expr(ctx.belief_atom_expr()));
        } else if (ctx.NEGATION_AS_FAILURE() != null) {
            try {
                return new NegationAsFailure(visitBelief_atom_expr(ctx.belief_atom_expr()));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitBelief_atom_expr(ctx.belief_atom_expr());
        }
    }

    @Override
    public LogicalExpression visitBelief_atom_expr(UncertainAgentspeakParser.Belief_atom_exprContext ctx) {
        if (ctx.and_expr() != null) {
            try {
                return visitAnd_expr(ctx.and_expr());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return visitBelief_atom(ctx.belief_atom());
        }
    }

//    @Override
//    public LogicalExpression visitLog_expr(UncertainAgentspeakParser.Log_exprContext ctx) {
//        if (ctx.belief_literal() != null) {
//            visitBelief_literal(ctx.belief_literal());
//        } else if (ctx.conjunction() != null)
////        if (ctx. != null) {
////            return visitSimple_log_expr(ctx.simple_log_expr());
////        } else if (ctx.negation_as_failure() != null) {
////            return visitNegation_as_failure(ctx.negation_as_failure());
////        } else if (ctx.)
//    }

//    @Override
//    public StrongNegation visitStrong_negation(UncertainAgentspeakParser.Strong_negationContext ctx) {
//        return new StrongNegation(visitLog_expr(ctx.log_expr()));
//    }
//
//    @Override
//    public Conjunction visitConjunction(UncertainAgentspeakParser.ConjunctionContext ctx) {
//        return new Conjunction(visitLog_expr(ctx.log_expr(0)),visitLog_expr(ctx.log_expr(1)));
//    }
//
//    @Override
//    public LogicalExpression visitBraced_term(UncertainAgentspeakParser.Braced_termContext ctx) {
//        return visitLog_expr(ctx.log_expr());
//    }
//
//    @Override
//    public Disjunction visitDisjunction(UncertainAgentspeakParser.DisjunctionContext ctx) {
//        return new Disjunction(visitLog_expr(ctx.log_expr(0)),visitLog_expr(ctx.log_expr(1)));
//    }
//
//    @Override
//    public NegationAsFailure visitNegation_as_failure(UncertainAgentspeakParser.Negation_as_failureContext ctx) {
//        return new NegationAsFailure(visitLog_expr(ctx.log_expr()));
//    }

//    @Override
//    public LogicalExpression visitSimple_log_expr(UncertainAgentspeakParser.Simple_log_exprContext ctx) {
//        if (ctx.belief_literal() != null) {
//            return visitBelief_literal(ctx.belief_literal());
//        } else if (ctx.variable() != null) {
//            return visitVariable(ctx.variable());
//        } else if (ctx.rel_expr() != null) {
//            return visitRel_expr(ctx.rel_expr());
//        }
//    }

//    @Override
//    public RelationalExpression visitRel_expr(UncertainAgentspeakParser.Rel_exprContext ctx) {
//        if (ctx.)
//    }
//
//    @Override
//    public T visitRel_term(UncertainAgentspeakParser.Rel_termContext ctx) {
//
//    }


    @Override
    public EventTrigger visitEvent(UncertainAgentspeakParser.EventContext ctx) {
        if (ctx.belief_event_trigger() != null) {
            return visitBelief_event_trigger(ctx.belief_event_trigger());
        } else if (ctx.goal_event_trigger() != null) {
            return visitGoal_event_trigger(ctx.goal_event_trigger());
        } else {
            return null; // TODO: add case when event is "true"
        }
    }

    @Override
    public BeliefEventTrigger visitBelief_event_trigger(UncertainAgentspeakParser.Belief_event_triggerContext ctx) {
        return new ReviseBeliefET(visitBelief_literal(ctx.belief_literal()), visitTerm(ctx.term()));
    }

    @Override
    public GoalEventTrigger visitGoal_event_trigger(UncertainAgentspeakParser.Goal_event_triggerContext ctx) {
        if (ctx.add_goal_event_trigger() != null) {
            return visitAdd_goal_event_trigger(ctx.add_goal_event_trigger());
        } else {
            return visitDelete_goal_event_trigger(ctx.delete_goal_event_trigger());
        }
    }

    @Override
    public AddGoalET visitAdd_goal_event_trigger(UncertainAgentspeakParser.Add_goal_event_triggerContext ctx) {
        return new AddGoalET(visitGoal(ctx.goal()));
    }

    @Override
    public DeleteGoalET visitDelete_goal_event_trigger(UncertainAgentspeakParser.Delete_goal_event_triggerContext ctx) {
        return new DeleteGoalET(visitGoal(ctx.goal()));
    }

    @Override
    public Goal visitGoal(UncertainAgentspeakParser.GoalContext ctx) {
        if (ctx.achievement_goal() != null) {
            return visitAchievement_goal(ctx.achievement_goal());
        } else {
            return visitTest_goal(ctx.test_goal());
        }
    }

    @Override
    public AchievementGoal visitAchievement_goal(UncertainAgentspeakParser.Achievement_goalContext ctx) {
        return new AchievementGoal(visitTerm(ctx.term()));
    }

    @Override
    public TestGoal visitTest_goal(UncertainAgentspeakParser.Test_goalContext ctx) {
        return new TestGoal(visitTerm(ctx.term()));
    }

    @Override
    public ArrayList<Action> visitBody(UncertainAgentspeakParser.BodyContext ctx) {
        ArrayList<Action> actions = new ArrayList<>();
        for (int ii=0; ii<ctx.body_statement().size(); ii++) {
            if (ctx.tautology() == null) {
                Action action = visitBody_statement(ctx.body_statement(ii));
                actions.add(action);
            }
        }
        return actions;
    }

    @Override
    public Action visitBody_statement(UncertainAgentspeakParser.Body_statementContext ctx) {
        if (ctx.belief_action() != null) {
            return visitBelief_action(ctx.belief_action());
        } else if (ctx.environment_action() != null) {
            return visitEnvironment_action(ctx.environment_action());
        } else if (ctx.goal() != null) {
            if (ctx.goal().achievement_goal() != null) {
                return new AchievementGoalAction(visitAchievement_goal(ctx.goal().achievement_goal()));
            } else if (ctx.goal().test_goal() != null) {
                return new TestGoalAction(visitTest_goal(ctx.goal().test_goal()));
            }
        } else {
            // TODO: Add exceptions for invalid input in parser/visitor
            System.out.println("Invalid action in plan body");
        }
        return null;
    }

    @Override
    public BeliefAction visitBelief_action(UncertainAgentspeakParser.Belief_actionContext ctx) {
        return new ReviseBeliefAction(visitBelief_literal(ctx.belief_literal()), visitTerm(ctx.term()));
    }

    @Override
    public EnvironmentAction visitEnvironment_action(UncertainAgentspeakParser.Environment_actionContext ctx) {
        return new EnvironmentAction(visitTerm(ctx.term()));
    }

    @Override
    public GlobalUncertainBelief visitInit_bels(UncertainAgentspeakParser.Init_belsContext ctx) {
        GlobalUncertainBelief globalUncertainBelief = new GlobalUncertainBelief();

        for (UncertainAgentspeakParser.Probabilistic_belContext probabilistic_belContext : ctx.probabilistic_bel()) {
            CompactProbabilisticEpistemicState probBelief = visitProbabilistic_bel(probabilistic_belContext);
            try {
                globalUncertainBelief.addEpistemicState(probBelief);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (UncertainAgentspeakParser.Possibilistic_belContext possibilistic_belContext : ctx.possibilistic_bel()) {
            CompactPossibilisticEpistemicState possBelief = visitPossibilistic_bel(possibilistic_belContext);
            try {
                globalUncertainBelief.addEpistemicState(possBelief);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return globalUncertainBelief;
    }

    @Override
    public CompactPossibilisticEpistemicState visitPossibilistic_bel(UncertainAgentspeakParser.Possibilistic_belContext ctx) {
        HashSet<BeliefAtom> domain = new HashSet<BeliefAtom>();
        HashMap<BeliefAtom, Double> weightedBeliefBase = new HashMap<BeliefAtom, Double>();

        // Instantiate probabilistic epistemic state with given domain
        for (int ii=0; ii<ctx.belief_literal().size(); ii++) {
            BeliefAtom beliefAtom;
            if (ctx.belief_literal(ii).negative_literal() != null) {
                beliefAtom = visitBelief_atom(ctx.belief_literal(ii).negative_literal().belief_atom());
            } else {
                beliefAtom = visitBelief_atom(ctx.belief_literal(ii).positive_literal().belief_atom());
            }
            domain.add(beliefAtom);
        }
        CompactPossibilisticEpistemicState possBelief = null;
        try {
            possBelief = new CompactPossibilisticEpistemicState(domain);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Revise epistemic state with associated weights
        for (int ii=0; ii<ctx.belief_literal().size(); ii++) {
            Number weight = visitNumber(ctx.number(ii));
            double weightDouble = weight.getDoubleVal();
            BeliefLiteral beliefLiteral = visitBelief_literal(ctx.belief_literal(ii));
            try {
                possBelief.revise(beliefLiteral, weightDouble);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return possBelief;
    }

    @Override
    public CompactProbabilisticEpistemicState visitProbabilistic_bel(UncertainAgentspeakParser.Probabilistic_belContext ctx) {
        HashSet<BeliefAtom> domain = new HashSet<BeliefAtom>();
        HashMap<BeliefAtom, Double> weightedBeliefBase = new HashMap<BeliefAtom, Double>();

        // Instantiate probabilistic epistemic state with given domain
        for (int ii=0; ii<ctx.belief_literal().size(); ii++) {
            BeliefAtom beliefAtom;
            if (ctx.belief_literal(ii).negative_literal() != null) {
                beliefAtom = visitBelief_atom(ctx.belief_literal(ii).negative_literal().belief_atom());
            } else {
                beliefAtom = visitBelief_atom(ctx.belief_literal(ii).positive_literal().belief_atom());
            }
            domain.add(beliefAtom);
        }
        CompactProbabilisticEpistemicState probBelief = null;
        try {
            probBelief = new CompactProbabilisticEpistemicState(domain);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Revise epistemic state with associated weights
        for (int ii=0; ii<ctx.belief_literal().size(); ii++) {
            Number weight = visitNumber(ctx.number(ii));
            double weightDouble = weight.getDoubleVal();
            BeliefLiteral beliefLiteral = visitBelief_literal(ctx.belief_literal(ii));
            try {
                probBelief.revise(beliefLiteral, weightDouble);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return probBelief;
    }

    @Override
    public BeliefLiteral visitBelief_literal(UncertainAgentspeakParser.Belief_literalContext ctx) {
        if (ctx.negative_literal() != null) {
            return visitNegative_literal(ctx.negative_literal());
        } else {
            return visitPositive_literal(ctx.positive_literal());
        }
    }

    @Override
    public PositiveLiteral visitPositive_literal(UncertainAgentspeakParser.Positive_literalContext ctx) {
        return new PositiveLiteral(visitBelief_atom(ctx.belief_atom()));
    }

    @Override
    public NegativeLiteral visitNegative_literal(UncertainAgentspeakParser.Negative_literalContext ctx) {
        return new NegativeLiteral(visitBelief_atom(ctx.belief_atom()));
    }

    @Override
    public BeliefAtom visitBelief_atom(UncertainAgentspeakParser.Belief_atomContext context) {
        Term term = visitTerm(context.term());
        return new BeliefAtom(term);
    }

//    @Override
//    public BeliefAtom visitBelief(UncertainAgentspeakParser.BeliefContext context) {
//        if (context.arguments_list().children.size() == 1) {
//            Term term = visitTerm(context.arguments_list().term(0));
//            //            belief.setBelief(term);
//            return new BeliefAtom(term);
//        }
//        return null;
//    }

//    @Override
//    public Weight visitWeight(UncertainAgentspeakParser.WeightContext ctx) {
//
//    }

//    @Override
//    public BeliefAtom visitBelief(UncertainAgentspeakParser.BeliefContext context) {
////        Belief belief = null;
//
////        System.out.println(context.arguments_list().children.size());
//        if (context.arguments_list().children.size() == 1) {
//            Term term = visitTerm(context.arguments_list().term(0));
//            //            belief.setBelief(term);
//            return new BeliefAtom(term);
//        }
//        return null;
//    }

//    @Override
//    public void visitUncertainAgentspeak(UncertainAgentspeakParser.UncertainAgentspeakContext ctx) {
//
//    }

//    @Override
//    public Goal visitGoal(UncertainAgentspeakParser.GoalContext context){ //throws ParseException {
//        Goal goal = null;
//        if (context.children.size() == 2) {
//            if (context.children.get(0).getText().equals("!")) {
//                goal = new AchievementGoal(new Belief(visitTerm(context.term())));
//            } else if (context.children.get(0).getText().equals("?")) {
//                goal = new TestGoal(new Belief(visitTerm(context.term())));
//            }
////            } else {
////                throw new ParseException("Goal must be either achievement \"!\" or test \"?\"",1);
////            }
//        }
//        return goal;
//    }

    @Override
    public Term visitTerm(UncertainAgentspeakParser.TermContext context) {
        Term term = null;
        if (context.constant() != null) {
            term = visitConstant(context.constant());
        } else if (context.variable() != null) {
            term = visitVariable(context.variable());
        } else if (context.structure() != null) {
            term = visitStructure(context.structure());
        }
        return term;
    }

    @Override
    public Structure visitStructure(UncertainAgentspeakParser.StructureContext context) {
        if (context.ATOM() != null && context.arguments_list() != null) {
            Atom atom = new Atom(context.ATOM().getText());
            List<Term> argsList = new ArrayList<>();

            for (int ii = 0; ii < context.arguments_list().children.size(); ii++) {
                Term arg = null;
                if (context.arguments_list().term(ii) != null) {
                    if (context.arguments_list().term(ii).variable() != null) {
                        arg = visitVariable(context.arguments_list().term(ii).variable());
                    } else if (context.arguments_list().term(ii).constant() != null) {
                        arg = visitConstant(context.arguments_list().term(ii).constant());
                    } else if (context.arguments_list().term(ii).structure() != null) {
                        arg = visitStructure(context.arguments_list().term(ii).structure());
                    }
                }
                if (arg != null) {
                    argsList.add(arg);
                }
            }
            return new Structure(atom, argsList);
        }
        return null;
    }

    @Override
    public Variable visitVariable(UncertainAgentspeakParser.VariableContext context) {
        return new Variable(context.getText());
    }

    @Override
    public Constant visitConstant(UncertainAgentspeakParser.ConstantContext context) {
        if (context.atom() != null) {
            return visitAtom(context.atom());
        } else {
            return visitNumber(context.number());
        }
    }

    @Override
    public Atom visitAtom(UncertainAgentspeakParser.AtomContext ctx) {
        return new Atom(ctx.ATOM().toString());
    }

    @Override
    public Number visitNumber(UncertainAgentspeakParser.NumberContext ctx) {
        if (ctx.doubleNum() != null) {
            return visitDoubleNum(ctx.doubleNum());
        } else {
            return visitIntNum(ctx.intNum());
        }
    }

    @Override
    public IntNum visitIntNum(UncertainAgentspeakParser.IntNumContext ctx) {
        return new IntNum(Integer.parseInt(ctx.NUMBER().toString()));
    }

    @Override
    public DoubleNum visitDoubleNum(UncertainAgentspeakParser.DoubleNumContext ctx) {
        return new DoubleNum(parseDouble(ctx.DECIMAL().toString()));
    }

}
