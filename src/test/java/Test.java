package test.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import main.agentspeak.*;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.parser.Visitor;
import main.agentspeak.terms.constants.Atom;
import main.resources.antlr.UncertainAgentspeakLexer;
import main.resources.antlr.UncertainAgentspeakParser;
import main.resources.antlr.UncertainAgentspeakVisitor;
import main.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Test {

    public static void main(String args[]) throws Exception {

//        example();
//        parseBeliefs();
//        parsePlan();
//        parseLogicalExpression();
//        parsePlanLibrary();

        parse();
//        unification();
//        example();
//        parse();

//        compactEpistemicState();
//        gub();
    }


    public static void compactEpistemicState() {

        try {

//            // initialise parser
//            Parser parser = new Parser();
//
//            BeliefAtom beliefAtom1 = parser.parseBelief("belief1(a).");
//            BeliefAtom beliefAtom2 = parser.parseBelief("belief2(a).");
//            BeliefAtom beliefAtom3 = parser.parseBelief("belief3(a).");
//
//            HashSet<BeliefAtom> domain = new HashSet<BeliefAtom>();
//            domain.add(beliefAtom1);
//            domain.add(beliefAtom2);
//            domain.add(beliefAtom3);
//
//            System.out.println("Domain: ");
//            for (BeliefAtom beliefAtom : domain) {
//                System.out.println("\tBelief Atom: " + beliefAtom.toString());
//            }
//
//            CompactEpistemicState compactEpistemicState = new CompactEpistemicState(domain);
//
//            PositiveLiteral positiveLiteral = new PositiveLiteral(beliefAtom1);
//            NegativeLiteral negativeLiteral = new NegativeLiteral(beliefAtom1);
//            compactEpistemicState.revise(positiveLiteral, 10);
//            compactEpistemicState.revise(negativeLiteral, 20);
//
//            System.out.println(compactEpistemicState);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void gub() {

        try {

//            // initialise parser
//            Parser parser = new Parser();
//
//            // initialise interpreter
//            Interpreter interpreter = new Interpreter();
//            System.out.println("Successfully initialised interpreter and parser.");
//
//            // populate belief base
//            HashSet<BeliefAtom> atoms1 = new HashSet<BeliefAtom>();
//            atoms1.add(parser.parseBelief("atom1(a)."));
//            atoms1.add(parser.parseBelief("atom1(b)."));
//            interpreter.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms1));
//
//            HashSet<BeliefAtom> atoms2 = new HashSet<BeliefAtom>();
//            atoms2.add(parser.parseBelief("atom2(a)."));
//            atoms2.add(parser.parseBelief("atom3(b)."));
//            interpreter.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms2));
//
//            BeliefLiteral reviseAtom2 = new PositiveLiteral(parser.parseBelief("atom2(a)."));
//            System.out.println("\nRevise belief");
//            interpreter.getBeliefBase().revise(reviseAtom2, 0.6);
//            System.out.println("\nRevised belief base:\n\t" + interpreter.getBeliefBase().toString());
//
//            BeliefLiteral reviseAtom3 = new PositiveLiteral(parser.parseBelief("atom3(b)."));
//            System.out.println("\nRevise belief");
//            interpreter.getBeliefBase().revise(reviseAtom3, 0.7);
//            System.out.println("\nRevised belief base:\n\t" + interpreter.getBeliefBase().toString());
//
//            BeliefLiteral reviseAtom = new PositiveLiteral(parser.parseBelief("atom1(a)."));
//            System.out.println("\nRevise belief");
//            interpreter.getBeliefBase().revise(reviseAtom, 0.8);
//            System.out.println("\nRevised belief base:\n\t" + interpreter.getBeliefBase().toString());
//
//            System.out.println("\nSuccessfully created belief base:\n\t" + interpreter.getBeliefBase().toString());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void example() {

        try {

            // initialise parser
            Parser parser = new Parser();

            // initialise interpreter
            Interpreter interpreter = new Interpreter();
            System.out.println("Successfully initialised interpreter and parser.");

            // create plans
            LinkedList<Plan> plans = new LinkedList<>();
            plans.add(parser.parsePlan("+!find_water : at(location(X)) & water(location(Y)) <- ?travel(X,Y) print('Found water')."));
            plans.add(parser.parsePlan("+?travel(X,Y) : at(location(X)) & safe(location(X),location(Y)) <- ?travel(X,Y) print('Found water')."));

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
            HashSet<BeliefAtom> atoms = new HashSet<>();
            atoms.add((new BeliefAtom(new Atom("find_water"))));
            atoms.add((new BeliefAtom(new Atom("find_life"))));
            interpreter.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms));
//            interpreter.getBeliefBase().revise(new PositiveLiteral(new BeliefAtom(new Atom("find_water"))), 0.8);

            HashSet<BeliefAtom> atoms2 = new HashSet<BeliefAtom>();
            atoms2.add((new BeliefAtom(new Atom("find_water2"))));
            atoms2.add((new BeliefAtom(new Atom("find_life2"))));
            interpreter.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms2));

            HashSet<BeliefAtom> atoms3 = new HashSet<>();
            atoms3.add((new BeliefAtom(new Atom("find_water"))));
            atoms3.add((new BeliefAtom(new Atom("find_life"))));
            interpreter.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms3));

            System.out.println("\nSuccessfully created belief base:\n" + interpreter.getBeliefBase().toString());

//            interpreter.getBeliefBase().add(parser.parseBelief("water(location(2))."));
//            interpreter.getBeliefBase().add(parser.parseBelief("at(location(1))."));
//            interpreter.getBeliefBase().add(parser.parseBelief("safe(location(1),location(2))."));
//            interpreter.getBeliefBase().add(parser.parseBelief("location(c)."));
//            System.out.println("\nSuccessfully created belief base:\n" + interpreter.getBeliefBase().toString());

            // add event set
//            interpreter.getEventSet().add(new ExternalEvent(new AddEvent(parser.parseGoal("!find_water."))));
//            System.out.println("\nSuccessfully created event set:");
//            System.out.println(interpreter.getEventSet().toString() + "\n");

            // run interpreter
//            interpreter.run();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void interpreter() {

        try {
//
//            // initialise parser
//            Parser parser = new Parser();
//
//            // initialise interpreter
//            Interpreter interpreter = new Interpreter();
//            System.out.println("Successfully initialised interpreter and parser.");
//
//            // create plans
//            LinkedList<Plan> plans = new LinkedList<>();
//            plans.add(parser.parsePlan("+!travel(a, d) : true <- !travel_taxi(a, X2); !travel_flight(X2, Y2); !travel_bus(Y2, d); print('arrived')."));
//            plans.add(parser.parsePlan("+!travel_taxi(X3, Y3) : location(X3) <- ?airport(Y3); taxi(X3, Y3); -location(X3); +location(Y3)."));
//            plans.add(parser.parsePlan("+?airport(X4) : location(Y4) & closest(Y4,X4) <- true."));
//            plans.add(parser.parsePlan("+!travel_flight(X5, Y5) : location(X5) & flight(X5, Y5) <- ?location(A); -location(B); +location(Y5)."));
//            plans.add(parser.parsePlan("+!travel_bus(Y6, d) : location(Y6) <- ?location(C); -location(D); +location(d)."));
//
//            // populate plan library
//            while (!plans.isEmpty()) {
//                Plan plan = plans.pop();
////            System.out.println("\nAdding to plan library: \n" + plan.toString());
//                if (plan != null) {
//                    interpreter.getPlanLibrary().add(plan);
//                }
//            }
//            System.out.println("\nSuccessfully created plan library:\n" + interpreter.getPlanLibrary().toString());
//
//            // populate belief base
////            interpreter.getBeliefBase().add(parser.parseBelief("flight(b,c)."));
////            interpreter.getBeliefBase().add(parser.parseBelief("closest(c,d)."));
////            interpreter.getBeliefBase().add(parser.parseBelief("closest(a,b)."));
////            interpreter.getBeliefBase().add(parser.parseBelief("location(c)."));
//            System.out.println("\nSuccessfully created belief base:\n" + interpreter.getBeliefBase().toString());
//
//            // add event set
//            interpreter.getEventSet().add(new ExternalEvent(new AddEvent(parser.parseGoal("!travel(a, d)."))));
//            System.out.println("\nSuccessfully created event set:");
//            System.out.println(interpreter.getEventSet().toString() + "\n");
//
//            // run interpreter
//            interpreter.run();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void unification() {

        Parser parser = new Parser();

        Term atom = parser.parseTerm("atom.");
        Term variable = parser.parseTerm("X.");
        Term structure = parser.parseTerm("struct(X,Y).");

        Term term1 = parser.parseTerm("atom.");
        Term term2 = parser.parseTerm("atom.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("atom1.");
        term2 = parser.parseTerm("atom2.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("X.");
        term2 = parser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("X.");
        term2 = parser.parseTerm("Y.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("Y.");
        term2 = parser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("X.");
        term2 = parser.parseTerm("atom.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("atom.");
        term2 = parser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(X).");
        term2 = parser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("strut(X).");
        term2 = parser.parseTerm("Y.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(X).");
        term2 = parser.parseTerm("struct(Y).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(atom).");
        term2 = parser.parseTerm("struct(atom).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(atom,X).");
        term2 = parser.parseTerm("struct(atom,atom1).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(a).");
        term2 = parser.parseTerm("struct2(a).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(struct2(a,X),b).");
        term2 = parser.parseTerm("struct(struct2(Y,c),Z).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = parser.parseTerm("struct(atom1, atom2).");
        term2 = parser.parseTerm("struct(X,Y).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));
    }

    public static void parseBeliefs() {

        try {
            Parser parser = new Parser();

//            System.out.println(parser.parseBelief("atom."));
//            System.out.println(parser.parseBelief("atom(a)."));
//            System.out.println(parser.parseBelief("atom(a,b)."));
//            System.out.println(parser.parseBelief("atom(a,b,c)."));
//            System.out.println(parser.parseBelief("atom(Var)."));
//            System.out.println(parser.parseBelief("atom(Var1,Var2)."));
//            System.out.println(parser.parseBelief("atom(a,Var)."));
//            System.out.println(parser.parseBelief("atom(Var,a)."));
//            System.out.println(parser.parseBelief("atom(struct(a))."));
//            System.out.println(parser.parseBelief("atom(struct(Var))."));
//            System.out.println(parser.parseBelief("atom(struct(a,b),c)."));
//            System.out.println(parser.parseBelief("atom(struct(Var1,Var2),Var3)."));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parsePlan() {

        try {
            Parser parser = new Parser();

            System.out.println(parser.parsePlan("+!trigEvent : true <- envAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("-!trigEvent : context(A) > context(B) <- !achievementAction(B); action(A)."));
            System.out.println(parser.parsePlan("+!trigEvent : context(A) && context(B) <- envAction(A); -deleteBelief(B)."));
            System.out.println(parser.parsePlan("-!trigEvent : context(A) && context(B) <- ?testAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("+?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("-?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parseLogicalExpression() {

        try {
            Parser parser = new Parser();

            System.out.println(parser.parseContext("true").getClass());
            System.out.println(parser.parseContext("atom1 && atom2").getClass());
            System.out.println(parser.parseContext("atom1 || atom2").getClass());
            System.out.println(parser.parseContext("atom1 > atom2").getClass());
            System.out.println(parser.parseContext("atom1 >= atom2").getClass());
            System.out.println(parser.parseContext("atom1 < atom2").getClass());
            System.out.println(parser.parseContext("atom1 =< atom2").getClass());

            System.out.println(parser.parseContext("true"));
            System.out.println(parser.parseContext("atom1 && atom2"));
            System.out.println(parser.parseContext("atom1 || atom2"));
            System.out.println(parser.parseContext("atom1 > atom2"));
            System.out.println(parser.parseContext("atom1 >= atom2"));
            System.out.println(parser.parseContext("atom1 < atom2"));
            System.out.println(parser.parseContext("atom1 =< atom2"));
            System.out.println(parser.parseContext("atom1 && atom2 > atom3 && atom4"));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parsePlanLibrary() {

        try {
            Parser parser = new Parser();

            System.out.println(parser.parsePlan("+!trigEvent : true <- envAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("-!trigEvent : context(A) > context(B) <- !achievementAction(B); action(A)."));
            System.out.println(parser.parsePlan("+!trigEvent : context(A) && context(B) <- envAction(A); -deleteBelief(B)."));
            System.out.println(parser.parsePlan("-!trigEvent : context(A) && context(B) <- ?testAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("+?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));
            System.out.println(parser.parsePlan("-?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parse() throws Exception {
        Parser parser = new Parser();

        File file = new File("/Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/test/java/input.txt");
        FileInputStream fis = null;
        fis = new FileInputStream(file);

        Interpreter interpreter = parser.parseUncertainAgentSpeak(fis);


        System.out.println(interpreter.getBeliefBase());

        System.out.println("\nInitial Goals");
        System.out.println(interpreter.getEventSet());

        System.out.println("\nPlan Library");
        System.out.println(interpreter.getPlanLibrary());


        interpreter.run();
    }

}