package test.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.*;
import main.java.actions.belief_actions.AddBeliefAction;
import main.java.actions.belief_actions.DeleteBeliefAction;
import main.java.actions.goal_actions.AchievementGoalAction;
import main.java.actions.goal_actions.TestGoalAction;
import main.java.event_triggers.AddEvent;
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

        interpreter();

    }

    public static void goals() {

    }

    public static void interpreter() {

        try {

            // initialise parser
            Parser parser = new Parser();

            // initialise interpreter
            Interpreter interpreter = new Interpreter();
            System.out.println("Successfully initialised interpreter and parser.");

            // create plans
            LinkedList<Plan> plans = new LinkedList<>();
            plans.add(parser.parsePlan("+!travel(a, d) : true <- !travel_taxi(a, X2); !travel_flight(X2, Y2); !travel_bus(Y2, d); print('arrived')."));
            plans.add(parser.parsePlan("+!travel_taxi(X3, Y3) : location(X3) <- ?airport(Y3); taxi(X3, Y3); -location(X3); +location(Y3)."));
            plans.add(parser.parsePlan("+?airport(X4) : location(Y4) & closest(Y4,X4) <- true."));
            plans.add(parser.parsePlan("+!travel_flight(X5, Y5) : location(X5) & flight(X5, Y5) <- ?location(A); -location(B); +location(Y5)."));
            plans.add(parser.parsePlan("+!travel_bus(Y6, d) : location(Y6) <- ?location(C); -location(D); +location(d)."));

            // populate plan library
            while (!plans.isEmpty()) {
                Plan plan = plans.pop();
//            System.out.println("\nAdding to plan library: \n" + plan.toString());
                if (plan != null) {
                    interpreter.getPlanLibrary().add(plan);
                }
            }
            System.out.println("\nSuccessfully created plan library:\n" + interpreter.getPlanLibrary().toString());

            // populate belief base
            interpreter.getBeliefBase().add(parser.parseBelief("flight(b,c)."));
            interpreter.getBeliefBase().add(parser.parseBelief("closest(c,d)."));
            interpreter.getBeliefBase().add(parser.parseBelief("closest(a,b)."));
            interpreter.getBeliefBase().add(parser.parseBelief("location(c)."));
            System.out.println("\nSuccessfully created belief base:\n" + interpreter.getBeliefBase().toString());

            // add event set
            interpreter.getEventSet().add(new ExternalEvent(new AddEvent(parser.parseGoal("!travel(a, d)."))));
            System.out.println("\nSuccessfully created event set:");
            System.out.println(interpreter.getEventSet().toString() + "\n");

            // run interpreter
            interpreter.run();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}