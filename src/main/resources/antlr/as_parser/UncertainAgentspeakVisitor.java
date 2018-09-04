package main.resources.antlr.as_parser;

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
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.*;
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
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactPossibilisticEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;
import main.resources.antlr.UncertainAgentspeakBaseVisitor;
import main.resources.antlr.UncertainAgentspeakParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.lang.Double.parseDouble;

public class UncertainAgentspeakVisitor extends UncertainAgentspeakBaseVisitor<Object> {

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
        return new TestGoal(visitAnd_expr(ctx.and_expr()));
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
            // TODO: Add exceptions for invalid input in as_parser/visitor
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
        HashSet<CompactEpistemicState> epistemicStateHashSet = new HashSet<>();

//        HashSet<EpistemicState> epistemicStates = new HashSet<>();

        for (UncertainAgentspeakParser.Probabilistic_esContext probabilistic_esContext : ctx.probabilistic_es()) {
            HashSet<HashMap<String, BeliefLiteral>> epistemicStates = new HashSet<>();
            HashSet<String> functors = new HashSet<>();

            for (UncertainAgentspeakParser.Probabilistic_belContext probabilistic_belContext : probabilistic_esContext.probabilistic_bel()) {

                BeliefLiteral beliefLiteral;
                String functor;
                HashMap<String, BeliefLiteral> beliefMap = new HashMap<>();

                beliefLiteral = visitBelief_literal(probabilistic_belContext.belief_literal());
                if (probabilistic_belContext.belief_literal().negative_literal() != null) {
                    functor = probabilistic_belContext.belief_literal().negative_literal().belief_atom().term().structure().ATOM().toString();
                } else {
                    functor = probabilistic_belContext.belief_literal().positive_literal().belief_atom().term().structure().ATOM().toString();
                }

                beliefMap.put(functor, beliefLiteral);
                functors.add(functor);
                epistemicStates.add(beliefMap);
            }

            for (String functor : functors) {
                HashSet<BeliefAtom> domain = new HashSet<>();
                CompactProbabilisticEpistemicState compactProbabilisticEpistemicState = null;
                for (HashMap<String, BeliefLiteral> beliefMap : epistemicStates) {
                    if (beliefMap.containsKey(functor)) {
                        domain.add(beliefMap.get(functor).getBeliefAtom());
                    }
                }
                try {
                    compactProbabilisticEpistemicState = new CompactProbabilisticEpistemicState(domain);
                    for (UncertainAgentspeakParser.Probabilistic_belContext probabilistic_belContext : probabilistic_esContext.probabilistic_bel()) {
                        Number weight = visitNumber(probabilistic_belContext.number());
                        double weightDouble = weight.getDoubleVal();
                        BeliefLiteral beliefLiteral = visitBelief_literal(probabilistic_belContext.belief_literal());
                        String[] string = beliefLiteral.getBeliefAtom().toString().split("\\(");
                        if (functor.equals(string[0])) {
                            compactProbabilisticEpistemicState.revise(beliefLiteral, weightDouble);
                        }
                    }
                    epistemicStateHashSet.add(compactProbabilisticEpistemicState);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

        for (UncertainAgentspeakParser.Possibilistic_esContext possibilistic_esContext : ctx.possibilistic_es()) {
            HashSet<HashMap<String, BeliefAtom>> epistemicStates = new HashSet<>();
            HashSet<String> functors = new HashSet<>();

            for (UncertainAgentspeakParser.Possibilistic_belContext possibilistic_belContext : possibilistic_esContext.possibilistic_bel()) {

                BeliefAtom beliefAtom;
                String functor;
                HashMap<String, BeliefAtom> beliefMap = new HashMap<>();
                if (possibilistic_belContext.belief_literal().negative_literal() != null) {
                    beliefAtom = visitBelief_atom(possibilistic_belContext.belief_literal().negative_literal().belief_atom());
                    functor = possibilistic_belContext.belief_literal().negative_literal().belief_atom().term().structure().ATOM().toString();
                } else {
                    beliefAtom = visitBelief_atom(possibilistic_belContext.belief_literal().positive_literal().belief_atom());
                    functor = possibilistic_belContext.belief_literal().positive_literal().belief_atom().term().structure().ATOM().toString();
                }
                beliefMap.put(functor, beliefAtom);
                functors.add(functor);
                epistemicStates.add(beliefMap);
            }

            for (String functor : functors) {
                HashSet<BeliefAtom> domain = new HashSet<>();
                CompactPossibilisticEpistemicState compactPossibilisticEpistemicState = null;
                for (HashMap<String, BeliefAtom> beliefMap : epistemicStates) {
                    if (beliefMap.containsKey(functor)) {
                        domain.add(beliefMap.get(functor));
                    }
                }
                try {
                    compactPossibilisticEpistemicState= new CompactPossibilisticEpistemicState(domain);
                    for (UncertainAgentspeakParser.Possibilistic_belContext possibilistic_belContext : possibilistic_esContext.possibilistic_bel()) {
                        Number weight = visitNumber(possibilistic_belContext.number());
                        double weightDouble = weight.getDoubleVal();
                        BeliefLiteral beliefLiteral = visitBelief_literal(possibilistic_belContext.belief_literal());
                        String[] string = beliefLiteral.getBeliefAtom().toString().split("\\(");
                        if (functor.equals(string[0])) {
                            compactPossibilisticEpistemicState.revise(beliefLiteral, weightDouble);
                        }
                    }
                    epistemicStateHashSet.add(compactPossibilisticEpistemicState);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

        for (CompactEpistemicState epistemicState : epistemicStateHashSet) {

            try {
                globalUncertainBelief.addEpistemicState(epistemicState);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return globalUncertainBelief;
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
