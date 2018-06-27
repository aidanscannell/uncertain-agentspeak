package main.agentspeak.parser;

import main.agentspeak.*;
import main.agentspeak.actions.EnvironmentAction;
import main.agentspeak.actions.belief_actions.AddBeliefAction;
import main.agentspeak.actions.belief_actions.DeleteBeliefAction;
import main.agentspeak.actions.goal_actions.AchievementGoalAction;
import main.agentspeak.actions.goal_actions.TestGoalAction;
import main.agentspeak.event_triggers.AddEvent;
import main.agentspeak.event_triggers.DeleteEvent;
import main.agentspeak.events.ExternalEvent;
import main.agentspeak.goals.AchievementGoal;
import main.agentspeak.goals.TestGoal;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.terms.Constant;
import main.agentspeak.terms.Structure;
import main.agentspeak.terms.Variable;
import main.agentspeak.terms.constants.Atom;
import main.agentspeak.terms.constants.Number;
import main.resources.antlr.AgentspeakBaseVisitor;
import main.resources.antlr.AgentspeakParser;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends AgentspeakBaseVisitor<Object> {

    @Override
    public Plan visitPlan(AgentspeakParser.PlanContext context) {

        /* Initialise the plans triggering event */
        // TODO: add case when event is "true"
        Event event = null;
        if (context.event() != null) {
            switch (context.event().getChild(0).getText()) {
                case "+":
                    event = new ExternalEvent(new AddEvent(new Belief(visitTerm(context.event().term()))));
                    break;
                case "-":
                    event = new ExternalEvent(new DeleteEvent(new Belief(visitTerm(context.event().term()))));
                    break;
                case "+!":
                    event = new ExternalEvent(new AddEvent(new AchievementGoal(new Belief(visitTerm(context.event().term())))));
                    break;
                case "+?":
                    event = new ExternalEvent(new AddEvent(new TestGoal(new Belief(visitTerm(context.event().term())))));
                    break;
                case "-!":
                    event = new ExternalEvent(new DeleteEvent(new AchievementGoal(new Belief(visitTerm(context.event().term())))));
                    break;
                case "-?":
                    event = new ExternalEvent(new DeleteEvent(new TestGoal(new Belief(visitTerm(context.event().term())))));
                    break;
            }
        }

        /* Initialise the plans context */
        // TODO: Check context "true" is an atom
        Context contextPlan = new Context();
        if (context.context() != null) {
//            if (context.context().getText().equals("true")) {
//                contextPlan.add(new ContextBelief(new Belief(new Atom("true"))));
//            } else if (context.context().context_list() != null) {
//                for (int i = 0; i < context.context().context_list().children.size(); i++) {
//                    if (context.context().context_list().term(i) != null) {
//                        context.context().context_list();
//                        contextPlan.add(new ContextBelief(new Belief(visitTerm(context.context().context_list().term(i)))));
//                    }
//                }
//            }
            if (context.context().context_list() != null) {
                for (int i = 0; i < context.context().context_list().children.size(); i++) {
                    if (context.context().context_list().term(i) != null) {
                        context.context().context_list();
                        contextPlan.add(new ContextBelief(new Belief(visitTerm(context.context().context_list().term(i)))));
                    }
                }
            }
        }

        /* Initialise the plans actions */
        // TODO: check all actions included (term)
        ArrayList<Action> actions = new ArrayList<>();
        if (context.body() != null && !context.body().getText().equals("true")) {
            for (int i = 0; i < context.body().body_list().children.size(); i++) {
                Action action = null;
                if (context.body().body_list().body_statement(i) != null)
                    if (context.body().body_list().body_statement(i).children.size() == 2) {
                        switch (context.body().body_list().body_statement(i).children.get(0).getText()) {
                            case "+":
                                action = new AddBeliefAction(new Belief(visitTerm(context.body().body_list().body_statement(i).term())));
                                break;
                            case "-":
                                action = new DeleteBeliefAction(new Belief(visitTerm(context.body().body_list().body_statement(i).term())));
                                break;
                            case "!":
                                action = new AchievementGoalAction(new AchievementGoal(new Belief(visitTerm(context.body().body_list().body_statement(i).term()))));
                                break;
                            case "?":
                                action = new TestGoalAction(new TestGoal(new Belief(visitTerm(context.body().body_list().body_statement(i).term()))));
                                break;
                        }
                    } else if (context.body().body_list().body_statement(i).children.size() == 1) {
                        action = new EnvironmentAction(visitTerm(context.body().body_list().body_statement(i).term()));
                    }
                if (action != null) {
                    actions.add(action);
                }
            }
        }

//        if (eventTrigger != null && contextPlan != null && actions != null) {
        return new Plan(event, contextPlan, actions);
//        }

//        System.out.println(eventTrigger.getBeliefGoal().getTerm().toString());
//        System.out.println(contextPlan.getFirst().getBelief().getTerm().toString());
//        System.out.println(actions.toString());
//        Plan plan = new Plan(eventTrigger, contextPlan, actions);
//        return null;
    }

    @Override
    public BeliefAtom visitBelief(AgentspeakParser.BeliefContext context) {
//        Belief belief = null;

//        System.out.println(context.arguments_list().children.size());
        if (context.arguments_list().children.size() == 1) {
            Term term = visitTerm(context.arguments_list().term(0));
            //            belief.setBelief(term);
            return new BeliefAtom(term);
        }
        return null;
    }

    @Override
    public Goal visitGoal(AgentspeakParser.GoalContext context){ //throws ParseException {
        Goal goal = null;
        if (context.children.size() == 2) {
            if (context.children.get(0).getText().equals("!")) {
                goal = new AchievementGoal(new Belief(visitTerm(context.term())));
            } else if (context.children.get(0).getText().equals("?")) {
                goal = new TestGoal(new Belief(visitTerm(context.term())));
            }
//            } else {
//                throw new ParseException("Goal must be either achievement \"!\" or test \"?\"",1);
//            }
        }
        return goal;
    }

    @Override
    public Term visitTerm(AgentspeakParser.TermContext context) {
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
    public Structure visitStructure(AgentspeakParser.StructureContext context) {
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
    public Variable visitVariable(AgentspeakParser.VariableContext context) {
        return new Variable(context.getText());
    }

    @Override
    public Constant visitConstant(AgentspeakParser.ConstantContext context) {
        Constant constant = null;
        if (context.NUMBER() != null) {
            constant = new Number(Integer.parseInt(context.NUMBER().toString()));
        } else if (context.ATOM() != null) {
            constant = new Atom(context.ATOM().toString());
        }
        return constant;
    }

}
