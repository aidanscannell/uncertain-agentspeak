package test.java;

import java.util.ArrayList;
import java.util.List;

import main.java.*;
import main.java.actions.belief_actions.AddBeliefAction;
import main.java.actions.belief_actions.DeleteBeliefAction;
import main.java.actions.goal_actions.AchievementGoalAction;
import main.java.actions.goal_actions.TestGoalAction;
import main.java.events.ExternalEvent;
import main.java.goals.AchievementGoal;
import main.java.goals.TestGoal;
import main.java.terms.Structure;
import main.java.terms.Variable;
import main.java.terms.constants.Number;
import main.java.terms.constants.Text;
import main.java.terms.constants.Atom;

public class Test {

    public static void main(String args[]) {

        beliefBase();
//        interpreter();

    }

//    public static void interpreter() {
//
//        try {
//            // initialise interpreter
//            Interpreter interpreter = new Interpreter();
//
//
//            // create beliefs
//            List<Term> args = new ArrayList<Term>();
//            args.add(new Variable("aidan"));
//            Term belief = new Structure(new Atom("human"), args);
//
//            // populate belief base
//            interpreter.getBeliefBase().add(new Belief(belief));
//
//
//            // create plan 1
//            Term beliefEvent = new Atom("saveHuman");
//            EventTrigger eventTrigger = new AddBeliefAction(new Belief(beliefEvent));
//            eventTrigger.setBeliefGoal(new Belief(beliefEvent));
//
//            Context context = new Context();
//            ContextBelief contextBelief = new ContextBelief();
//            List<Term> argsContext = new ArrayList<Term>();
//            argsContext.add(new Variable("X"));
//            contextBelief.setBelief(new Belief(new Structure(new Atom("human"), argsContext)));
//            context.add(contextBelief);
//
//            List<Term> argsAction = new ArrayList<Term>();
//            argsAction.add(new Atom("X"));
//            Term beliefAction = new Structure(new Atom("rescue"), argsAction);
//            Action action = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction)));
//            ArrayList<Action> actions = new ArrayList<Action>();
//            actions.add(action);
//
//            Plan plan = new Plan(eventTrigger, context, actions);
//
//
//            // create plan 2
//            Term beliefEvent1 = new Atom("saveHuman");
//            EventTrigger eventTrigger1 = new EventTrigger();
//            eventTrigger1.setBelief(new Belief(beliefEvent1));
//
//            Context context1 = new Context();
//            ContextBelief contextBelief1 = new ContextBelief();
//            List<Term> argsContext1 = new ArrayList<Term>();
//            argsContext1.add(new Variable("X"));
//            contextBelief1.setBelief(new Belief(new Structure(new Atom("human"), argsContext1)));
//            context1.add(contextBelief1);
//
//            List<Term> argsAction1 = new ArrayList<Term>();
//            argsAction1.add(new Atom("X"));
//            Term beliefAction1 = new Structure(new Atom("rescue"), argsAction1);
//            Action action1 = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction1)));
//            ArrayList<Action> actions1 = new ArrayList<Action>();
//            actions1.add(action1);
//
//            Plan plan1 = new Plan(eventTrigger1, context1, actions1);
//
//
//            // populate plan library
//            interpreter.getPlanLibrary().add(plan);
//            interpreter.getPlanLibrary().add(plan1);
//
//
//            // run
//            interpreter.getEventSet().add(new ExternalEvent(eventTrigger1));
//            interpreter.run();
//        } catch(Exception exception) {
//            exception.printStackTrace();
//        }

//        // create beliefs
//        List<Term> args1 = new ArrayList<Term>();
//        args1.add(new Variable("b"));
//        args1.add(new Variable("c"));
//        Term belief1 = new Structure(new Atom("flight"), args1);
//        List<Term> args2 = new ArrayList<Term>();
//        args2.add(new Variable("c"));
//        args2.add(new Variable("d"));
//        Term belief2 = new Structure(new Atom("closest"), args2);
//        List<Term> args3 = new ArrayList<Term>();
//        args3.add(new Variable("a"));
//        args3.add(new Variable("b"));
//        Term belief3 = new Structure(new Atom("closest"), args3);
//        List<Term> args4 = new ArrayList<Term>();
//        args4.add(new Variable("a"));
//        Term belief4 = new Structure(new Atom("location"), args4);

//        // populate belief base
//        interpreter.getBeliefBase().add(new Belief(belief1));
//        interpreter.getBeliefBase().add(new Belief(belief2));
//        interpreter.getBeliefBase().add(new Belief(belief3));
//        interpreter.getBeliefBase().add(new Belief(belief4));
//
//        // create plan 1
//        List<Term> argsBelief1 = new ArrayList<Term>();
//        argsBelief1.add(new Atom("a"));
//        argsBelief1.add(new Atom("d"));
//        Term beliefEvent1 = new Structure(new Atom("travel"), argsBelief1);
//        EventTrigger eventTrigger = new EventTrigger();
//        eventTrigger.setBelief(new Belief(beliefEvent1));
//        List<Term> argsAction1 = new ArrayList<Term>();
//        argsAction1.add(new Atom("a"));
//        argsAction1.add(new Variable("X2"));
//        Term beliefAction1 = new Structure(new Atom("travel_taxi"), argsAction1);
//        Action action1 = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction1)));
//        List<Term> argsAction2 = new ArrayList<Term>();
//        argsAction2.add(new Variable("X2"));
//        argsAction2.add(new Variable("Y2"));
//        Term beliefAction2 = new Structure(new Atom("travel_flight"), argsAction2);
//        Action action2 = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction2)));
//        List<Term> argsAction3 = new ArrayList<Term>();
//        argsAction3.add(new Variable("Y2"));
//        argsAction3.add(new Atom("d"));
//        Term beliefAction3 = new Structure(new Atom("travel_bus"), argsAction3);
//        Action action3 = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction3)));
//        ArrayList<Action> actions1 = new ArrayList<Action>();
//        actions1.add(action1);
//        actions1.add(action2);
//        actions1.add(action3);
//        Plan plan1 = new Plan(eventTrigger, new Context(),actions1);

//        // create plan 2
//        List<Term> argsBelief2 = new ArrayList<Term>();
//        argsBelief2.add(new Variable("X3"));
//        argsBelief2.add(new Variable("Y3"));
//        Term beliefEvent2 = new Structure(new Atom("travel_taxi"), argsBelief2);
//        EventTrigger eventTrigger2 = new EventTrigger();
//        eventTrigger2.setBelief(new Belief(beliefEvent2));
//
//        Context context = new Context();
//        ContextBelief contextBelief = new ContextBelief();
//        List<Term> argsContext2 = new ArrayList<Term>();
//        argsContext2.add(new Variable("X3"));
//        contextBelief.setBelief(new Belief(new Structure(new Atom("location"), argsContext2)));
//        context.add(contextBelief);
//
//        List<Term> argsAction21 = new ArrayList<Term>();
//        argsAction21.add(new Atom("Y3"));
//        Term beliefAction21 = new Structure(new Atom("airport"), argsAction21);
//        Action action21 = new TestGoalAction(new TestGoal(new Belief(beliefAction21)));
//        List<Term> argsAction22 = new ArrayList<Term>();
//        argsAction22.add(new Variable("X3"));
//        argsAction22.add(new Variable("Y3"));
//        Term beliefAction2 = new Structure(new Atom("taxi"), argsAction2);
////        Action action2 = new AchievementGoalAction(new AchievementGoal(new Belief(beliefAction2)));
//        List<Term> argsAction23 = new ArrayList<Term>();
//        argsAction23.add(new Variable("X3"));
//        Term beliefAction23 = new Structure(new Atom("location"), argsAction3);
//        Action action23 = new DeleteBeliefAction(new Belief(beliefAction23));
//        ArrayList<Action> actions2 = new ArrayList<Action>();
//        actions2.add(action21);
//        actions2.add(action22);
//        actions2.add(action23);
//
//        Plan plan2 = new Plan(eventTrigger2, new Context(), actions2);


//        // populate plan library
//        ArrayList<Action> actions = new ArrayList<>();
//        actions.add();
//        interpreter.getPlanLibrary().add(new Plan("travel(a, d)", "true", actions));
//        "+!travel(a, d) : true <- !travel_taxi(a, X2); !travel_flight(X2, Y2); !travel_bus(Y2, d); print('arrived')"
//        "+!c : location(X3) <- ?airport(Y3); taxi(X3, Y3); -location(X3); +location(Y3)"
//        "+?airport(X4) : location(Y4) & closest(Y4, X4) <- true"
//        "+!travel_flight(X5, Y5) : location(X5) & flight(X5, Y5) <- ?location(_); -location(_); +location(Y5)"
//        "+!travel_bus(Y6, d) : location(Y6) <- ?location(_); -location(_); +location(d)"
//    }
//    travel(a,d).travel_taxi(X3,Y3).
//    +!travel(a,d) : true <- !travel_taxi(a,X2); !travel_flight(X2,Y2); !travel_bus(Y2,d).

    public static void beliefBase() {

        Interpreter interpreter = new Interpreter();

        Term number = new Number(10);
        Term text = new Text("text text");
        Term atom = new Atom("atom atom");
        Term variable = new Variable("var");

        // nested structure
        List structArgs = new ArrayList();
        structArgs.add(new Number(1));
        structArgs.add(new Variable("arg2"));
        Term structure = new Structure(new Atom("structFunctorNested"), structArgs);

        // structure
        List structArgs2 = new ArrayList();
        structArgs2.add(new Number(2));
        structArgs2.add(structure);
        Atom structAtom2 = new Atom("structFunctor");
        Term structure2 = new Structure(structAtom2, structArgs2);

        // create list of terms
        List<Term> termList = new ArrayList<Term>();
        termList.add(number);
        termList.add(text);
        termList.add(atom);
        termList.add(variable);
        termList.add(structure);
        termList.add(structure2);

        List<Belief> beliefList = new ArrayList<>();

        // test setting and getting belief base for each type of term
        for (Term term : termList) {

            // initialise belief for a given term
            Belief belief = new Belief(term);
            beliefList.add(belief);

            // create belief base
            BeliefBase beliefBase = new BeliefBase();
            beliefBase.add(belief);

            // set belief base
            interpreter.setBeliefBase(beliefBase);

            // print belief base
            System.out.println(interpreter.getBeliefBase().get(0).getTerm().toString());
        }

        // create belief base
        BeliefBase beliefBase = new BeliefBase();
        beliefBase.addAll(beliefList);

        // set belief base
        interpreter.setBeliefBase(beliefBase);

        for (int i = 0; i < interpreter.getBeliefBase().size(); i++) {
            // print belief base
            System.out.println(interpreter.getBeliefBase().get(i).getTerm().toString());
        }
    }
}

//package main.java;
//
//import main.java.Unifier;
////import main.java.terms.*;
//import main.java.terms.constants.Atom;
//import main.java.terms.constants.Text;
//import main.java.terms.constants.Number;
//import main.java.terms.Constant;
//import main.java.terms.Structure;
//import main.java.terms.Variable;
//import main.java.Term;
//import java.util.HashMap;
//import java.util.List;
//import java.util.ArrayList;
//import java.lang.String;
//
//public class Main {
//
//    public static void main(String args[]){
//        Atom atom = new Atom("atom");
//        Text text = new Text("text");
//        Number number = new Number(10);
//
//        Constant c = new Constant();
//        c = atom;
////        c = text;
////        c = number;
//
//        Variable var = new Variable("var");
//
//        List<Term> listArgs = new ArrayList<Term>();
//        listArgs.add(number);
//        listArgs.add(text);
//        listArgs.add(var);
//
//        Structure struct = new Structure(atom,listArgs);
//
//        Unifier map = new Unifier();
//
//        List<Term> listTerms = new ArrayList<Term>();
//        listTerms.add(c);
//        listTerms.add(var);
//        listTerms.add(struct);
//
////        map = c.unify(c);
////        map = c.unify(var);
//        map = c.unify(struct);
//
////        map = var.unify(c);
////        map = var.unify(var);
////        map = var.unify(struct);
//
////        map = struct.unify(c);
////        map = struct.unify(var);
////        map = struct.unify(struct);
//
//        if (map.get(var) instanceof Number){
//            Number v = (Number) map.get(var);
//            System.out.println(v.getValue());
//        } else if (map.get(var) instanceof Text){
//            Text v = (Text) map.get(var);
//            System.out.println(v.getValue());
//        } else if (map.get(var) instanceof Atom){
//            Atom v = (Atom) map.get(var);
//            System.out.println(v.getLabel());
//        } else if (map.get(var) instanceof Structure){
//            Structure v = (Structure) map.get(var);
//            List<Term> vArgs = v.getArguments();
//            Atom functor = v.getFunctor();
//            System.out.println("Structure -> functor: " + functor.getLabel() + ", Arguments: " + vArgs);
//        }
//
//
//
//    }
//}
