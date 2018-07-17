package test.java;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.NegativeLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.Atom;
import main.java.uncertain_agentspeak.mas.MASProject;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;
import main.resources.antlr.as_parser.AgentParser;
import main.resources.antlr.mas_parser.ProjectParser;

public class Test {

    public static void main(String args[]) throws Exception {

//        parseBeliefAtoms();
//        parseLogicalExpression();
//        compactEpistemicState();
//        parsePlan();
//        parseLogicalExpression();
//        parsePlanLibrary();

//        parse();
        marsExplorationScenario();
//        unification();
//        example();
//        parse();

//        compactEpistemicState();
//        gub();
    }

    public static void marsExplorationScenario() throws Exception {
        ProjectParser projectParser = new ProjectParser();

        File file = new File("/Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/test/java/marsExplorationScenario/marsExplorationScenario.mas");
        FileInputStream fis = null;
        fis = new FileInputStream(file);
        try {
            MASProject project = projectParser.parseMASProject(fis);
            System.out.println("Successfully opened and parsed file");
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (Exception e) {
            System.err.println("Error parsing file");
        }




    }

    public static void marsExplorationScenarioAgent() throws Exception {
        AgentParser agentParser = new AgentParser();

        File file = new File("/Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/test/java/marsExplorationScenario/agents/sampleAgent.agent");
        FileInputStream fis = null;
        fis = new FileInputStream(file);

        Agent agent = agentParser.parseUncertainAgentSpeak(fis);


        System.out.println(agent.getBeliefBase());

        System.out.println("\nInitial Goals");
        System.out.println(agent.getEventSet());

        System.out.println("\nPlan Library");
        System.out.println(agent.getPlanLibrary());

        Font font = new Font("Arial",Font.BOLD,10);
        System.out.println(font.getAvailableAttributes());


        agent.run();
    }

    public static void parseBeliefAtoms() {

        try {
            AgentParser agentParser = new AgentParser();

            HashSet<BeliefAtom> beliefAtoms = new HashSet<>();

            beliefAtoms.add(agentParser.parseBeliefAtom("atom."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(a)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(a,b)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(a,b,c)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(Var)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(Var1,Var2)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(a,Var)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(Var,a)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(struct(a))."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(struct(Var))."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(struct(a,b),c)."));
            beliefAtoms.add(agentParser.parseBeliefAtom("atom(struct(Var1,Var2),Var3)."));

            for (BeliefAtom beliefAtom : beliefAtoms) {
                System.out.println("Belief Atom: " + beliefAtom.toString());
//                System.out.println("Class: " + beliefAtom.getTerm().getClass());
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parseLogicalExpression() {

        try {
            AgentParser agentParser = new AgentParser();

            LinkedList<String> formulas = new LinkedList<>();

            formulas.add("belief(c)");
            formulas.add("belief(d)");
            formulas.add("10");
            formulas.add("0.001");
            formulas.add("~belief(c)");
            formulas.add("~belief(d)");
            //TODO: parse negation as failure
            formulas.add("not belief(c)");
            formulas.add("not belief(d)");
            formulas.add("belief(c) && belief(d)");
            formulas.add("belief(c) && ~belief(d)");
            formulas.add("~belief(c) && belief(d)");
            formulas.add("~belief(c) && ~belief(d)");
            formulas.add("belief(c) || belief(d)");
            formulas.add("belief(c) || ~belief(d)");
            formulas.add("~belief(c) || belief(d)");
            formulas.add("~belief(c) || ~belief(d)");
            formulas.add("belief(c) > belief(d)");
            formulas.add("belief(c) > ~belief(d)");
            formulas.add("~belief(c) > belief(d)");
            formulas.add("~belief(c) > ~belief(d)");
            formulas.add("belief(c) >= belief(d)");
            formulas.add("belief(c) >= ~belief(d)");
            formulas.add("~belief(c) >= belief(d)");
            formulas.add("~belief(c) >= ~belief(d)");

            for (String formula : formulas) {
                LogicalExpression logicalExpression = agentParser.parseLogicalExpression(formula);
                System.out.println(logicalExpression.toString());
                System.out.println(logicalExpression.getClass());
            }

//            System.out.println(as_parser.parseContext("true").getClass());
//            System.out.println(as_parser.parseContext("atom1 && atom2").getClass());
//            System.out.println(as_parser.parseContext("atom1 || atom2").getClass());
//            System.out.println(as_parser.parseContext("atom1 > atom2").getClass());
//            System.out.println(as_parser.parseContext("atom1 >= atom2").getClass());
//            System.out.println(as_parser.parseContext("atom1 < atom2").getClass());
//            System.out.println(as_parser.parseContext("atom1 =< atom2").getClass());
//
//            System.out.println(as_parser.parseContext("true"));
//            System.out.println(as_parser.parseContext("atom1 && atom2"));
//            System.out.println(as_parser.parseContext("atom1 || atom2"));
//            System.out.println(as_parser.parseContext("atom1 > atom2"));
//            System.out.println(as_parser.parseContext("atom1 >= atom2"));
//            System.out.println(as_parser.parseContext("atom1 < atom2"));
//            System.out.println(as_parser.parseContext("atom1 =< atom2"));
//            System.out.println(as_parser.parseContext("atom1 && atom2 > atom3 && atom4"));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void compactEpistemicState() {

        try {

            // initialise as_parser
            AgentParser agentParser = new AgentParser();

            BeliefAtom beliefAtom1 = agentParser.parseBeliefAtom("belief(a).");
            BeliefAtom beliefAtom2 = agentParser.parseBeliefAtom("belief(b).");
            BeliefAtom beliefAtom3 = agentParser.parseBeliefAtom("belief(c).");

            HashSet<BeliefAtom> domain = new HashSet<BeliefAtom>();
            domain.add(beliefAtom1);
            domain.add(beliefAtom2);
            domain.add(beliefAtom3);

            CompactEpistemicState compactEpistemicState = new CompactEpistemicState(domain);

            PositiveLiteral positiveLiteral = new PositiveLiteral(beliefAtom1);
            NegativeLiteral negativeLiteral = new NegativeLiteral(beliefAtom1);
            compactEpistemicState.revise(positiveLiteral, -1);
            compactEpistemicState.revise(negativeLiteral, 2);

            PositiveLiteral positiveLiteral2 = new PositiveLiteral(beliefAtom2);
            NegativeLiteral negativeLiteral2 = new NegativeLiteral(beliefAtom2);
            compactEpistemicState.revise(positiveLiteral2, 5);
            compactEpistemicState.revise(negativeLiteral2, 2);

            PositiveLiteral positiveLiteral3 = new PositiveLiteral(beliefAtom3);
            NegativeLiteral negativeLiteral3 = new NegativeLiteral(beliefAtom3);
            compactEpistemicState.revise(positiveLiteral3, 10);
            compactEpistemicState.revise(negativeLiteral3, 5);


            System.out.println("Domain: " + compactEpistemicState.getDomain().toString());
            System.out.println(compactEpistemicState.toString());

            LinkedList<String> formulas = new LinkedList<>();

            formulas.add("belief(a)");
            formulas.add("belief(b)");
            formulas.add("~belief(a)");
            formulas.add("~belief(b)");
            formulas.add("belief(a) && belief(b)");
            formulas.add("belief(a) && ~belief(b)");
            formulas.add("~belief(a) && belief(b)");
            formulas.add("~belief(a) && ~belief(b)");
            formulas.add("belief(a) || belief(b)");
            formulas.add("belief(a) || ~belief(b)");
            formulas.add("~belief(a) || belief(b)");
            formulas.add("~belief(a) || ~belief(b)");
            formulas.add("belief(a) > belief(b)");
            formulas.add("belief(a) > ~belief(b)");
            formulas.add("~belief(a) > belief(b)");
            formulas.add("~belief(a) > ~belief(b)");
            formulas.add("belief(a) >= belief(b)");
            formulas.add("belief(a) >= ~belief(b)");
            formulas.add("~belief(a) >= belief(b)");
            formulas.add("~belief(a) >= ~belief(b)");

            for(String formula : formulas) {
                LogicalExpression f = agentParser.parseLogicalExpression(formula);
                System.out.print("val(" + f.toString() + ") = " + compactEpistemicState.entails(f));
                System.out.println();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void probabalisticCompactEpistemicState() {

        try {

            // initialise as_parser
            AgentParser agentParser = new AgentParser();

            BeliefAtom beliefAtom1 = agentParser.parseBeliefAtom("belief(a).");
            BeliefAtom beliefAtom2 = agentParser.parseBeliefAtom("belief(b).");
            BeliefAtom beliefAtom3 = agentParser.parseBeliefAtom("belief(c).");

            HashSet<BeliefAtom> domain = new HashSet<BeliefAtom>();
            domain.add(beliefAtom1);
            domain.add(beliefAtom2);
            domain.add(beliefAtom3);

            CompactEpistemicState compactEpistemicState = new CompactEpistemicState(domain);

            PositiveLiteral positiveLiteral = new PositiveLiteral(beliefAtom1);
            NegativeLiteral negativeLiteral = new NegativeLiteral(beliefAtom1);
            compactEpistemicState.revise(positiveLiteral, -1);
            compactEpistemicState.revise(negativeLiteral, 2);

            PositiveLiteral positiveLiteral2 = new PositiveLiteral(beliefAtom2);
            NegativeLiteral negativeLiteral2 = new NegativeLiteral(beliefAtom2);
            compactEpistemicState.revise(positiveLiteral2, 5);
            compactEpistemicState.revise(negativeLiteral2, 2);

            PositiveLiteral positiveLiteral3 = new PositiveLiteral(beliefAtom3);
            NegativeLiteral negativeLiteral3 = new NegativeLiteral(beliefAtom3);
            compactEpistemicState.revise(positiveLiteral3, 10);
            compactEpistemicState.revise(negativeLiteral3, 5);


            System.out.println("Domain: " + compactEpistemicState.getDomain().toString());
            System.out.println(compactEpistemicState.toString());

            LinkedList<String> formulas = new LinkedList<>();

            formulas.add("belief(a)");
            formulas.add("belief(b)");
            formulas.add("~belief(a)");
            formulas.add("~belief(b)");
            formulas.add("belief(a) && belief(b)");
            formulas.add("belief(a) && ~belief(b)");
            formulas.add("~belief(a) && belief(b)");
            formulas.add("~belief(a) && ~belief(b)");
            formulas.add("belief(a) || belief(b)");
            formulas.add("belief(a) || ~belief(b)");
            formulas.add("~belief(a) || belief(b)");
            formulas.add("~belief(a) || ~belief(b)");
            formulas.add("belief(a) > belief(b)");
            formulas.add("belief(a) > ~belief(b)");
            formulas.add("~belief(a) > belief(b)");
            formulas.add("~belief(a) > ~belief(b)");
            formulas.add("belief(a) >= belief(b)");
            formulas.add("belief(a) >= ~belief(b)");
            formulas.add("~belief(a) >= belief(b)");
            formulas.add("~belief(a) >= ~belief(b)");

            for(String formula : formulas) {
                LogicalExpression f = agentParser.parseLogicalExpression(formula);
                System.out.print("val(" + f.toString() + ") = " + compactEpistemicState.entails(f));
                System.out.println();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static void example() {

        try {

            // initialise as_parser
            AgentParser agentParser = new AgentParser();

            // initialise agent
            Agent agent = new Agent();
            System.out.println("Successfully initialised agent and as_parser.");

            // create plans
            LinkedList<Plan> plans = new LinkedList<>();
            plans.add(agentParser.parsePlan("+!find_water : at(location(X)) & water(location(Y)) <- ?travel(X,Y) print('Found water')."));
            plans.add(agentParser.parsePlan("+?travel(X,Y) : at(location(X)) & safe(location(X),location(Y)) <- ?travel(X,Y) print('Found water')."));

            // populate plan library
            while (!plans.isEmpty()) {
                Plan plan = plans.pop();
//            System.out.println("\nAdding to plan library: \n" + plan.toString());
                if (plan != null) {
                    agent.getPlanLibrary().add(plan);
                }
            }
            System.out.println("\nSuccessfully created plan library:\n" + agent.getPlanLibrary().toString());

            // populate belief base
            HashSet<BeliefAtom> atoms = new HashSet<>();
            atoms.add((new BeliefAtom(new Atom("find_water"))));
            atoms.add((new BeliefAtom(new Atom("find_life"))));
            agent.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms));
//            agent.getBeliefBase().revise(new PositiveLiteral(new BeliefAtom(new Atom("find_water"))), 0.8);

            HashSet<BeliefAtom> atoms2 = new HashSet<BeliefAtom>();
            atoms2.add((new BeliefAtom(new Atom("find_water2"))));
            atoms2.add((new BeliefAtom(new Atom("find_life2"))));
            agent.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms2));

            HashSet<BeliefAtom> atoms3 = new HashSet<>();
            atoms3.add((new BeliefAtom(new Atom("find_water"))));
            atoms3.add((new BeliefAtom(new Atom("find_life"))));
            agent.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(atoms3));

            System.out.println("\nSuccessfully created belief base:\n" + agent.getBeliefBase().toString());

//            agent.getBeliefBase().add(as_parser.parseBelief("water(location(2))."));
//            agent.getBeliefBase().add(as_parser.parseBelief("at(location(1))."));
//            agent.getBeliefBase().add(as_parser.parseBelief("safe(location(1),location(2))."));
//            agent.getBeliefBase().add(as_parser.parseBelief("location(c)."));
//            System.out.println("\nSuccessfully created belief base:\n" + agent.getBeliefBase().toString());

            // add event set
//            agent.getEventSet().add(new ExternalEvent(new AddEvent(as_parser.parseGoal("!find_water."))));
//            System.out.println("\nSuccessfully created event set:");
//            System.out.println(agent.getEventSet().toString() + "\n");

            // run agent
//            agent.run();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void interpreter() {

        try {
//
//            // initialise as_parser
//            AgentParser as_parser = new AgentParser();
//
//            // initialise interpreter
//            Agent interpreter = new Agent();
//            System.out.println("Successfully initialised interpreter and as_parser.");
//
//            // create plans
//            LinkedList<Plan> plans = new LinkedList<>();
//            plans.add(as_parser.parsePlan("+!travel(a, d) : true <- !travel_taxi(a, X2); !travel_flight(X2, Y2); !travel_bus(Y2, d); print('arrived')."));
//            plans.add(as_parser.parsePlan("+!travel_taxi(X3, Y3) : location(X3) <- ?airport(Y3); taxi(X3, Y3); -location(X3); +location(Y3)."));
//            plans.add(as_parser.parsePlan("+?airport(X4) : location(Y4) & closest(Y4,X4) <- true."));
//            plans.add(as_parser.parsePlan("+!travel_flight(X5, Y5) : location(X5) & flight(X5, Y5) <- ?location(A); -location(B); +location(Y5)."));
//            plans.add(as_parser.parsePlan("+!travel_bus(Y6, d) : location(Y6) <- ?location(C); -location(D); +location(d)."));
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
////            interpreter.getBeliefBase().add(as_parser.parseBelief("flight(b,c)."));
////            interpreter.getBeliefBase().add(as_parser.parseBelief("closest(c,d)."));
////            interpreter.getBeliefBase().add(as_parser.parseBelief("closest(a,b)."));
////            interpreter.getBeliefBase().add(as_parser.parseBelief("location(c)."));
//            System.out.println("\nSuccessfully created belief base:\n" + interpreter.getBeliefBase().toString());
//
//            // add event set
//            interpreter.getEventSet().add(new ExternalEvent(new AddEvent(as_parser.parseGoal("!travel(a, d)."))));
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

        AgentParser agentParser = new AgentParser();

        Term atom = agentParser.parseTerm("atom.");
        Term variable = agentParser.parseTerm("X.");
        Term structure = agentParser.parseTerm("struct(X,Y).");

        Term term1 = agentParser.parseTerm("atom.");
        Term term2 = agentParser.parseTerm("atom.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("atom1.");
        term2 = agentParser.parseTerm("atom2.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("X.");
        term2 = agentParser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("X.");
        term2 = agentParser.parseTerm("Y.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("Y.");
        term2 = agentParser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("X.");
        term2 = agentParser.parseTerm("atom.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("atom.");
        term2 = agentParser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(X).");
        term2 = agentParser.parseTerm("X.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("strut(X).");
        term2 = agentParser.parseTerm("Y.");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(X).");
        term2 = agentParser.parseTerm("struct(Y).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(atom).");
        term2 = agentParser.parseTerm("struct(atom).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(atom,X).");
        term2 = agentParser.parseTerm("struct(atom,atom1).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(a).");
        term2 = agentParser.parseTerm("struct2(a).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(struct2(a,X),b).");
        term2 = agentParser.parseTerm("struct(struct2(Y,c),Z).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));

        term1 = agentParser.parseTerm("struct(atom1, atom2).");
        term2 = agentParser.parseTerm("struct(X,Y).");
        System.out.println("unify(" + term1 + ", " + term2 + ") = "  + term1.unify(term2));
    }

    public static void parsePlan() {

        try {
            AgentParser agentParser = new AgentParser();

            System.out.println(agentParser.parsePlan("+!trigEvent : true <- envAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("-!trigEvent : context(A) > context(B) <- !achievementAction(B); action(A)."));
            System.out.println(agentParser.parsePlan("+!trigEvent : context(A) && context(B) <- envAction(A); -deleteBelief(B)."));
            System.out.println(agentParser.parsePlan("-!trigEvent : context(A) && context(B) <- ?testAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("+?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("-?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



    public static void parsePlanLibrary() {

        try {
            AgentParser agentParser = new AgentParser();

            System.out.println(agentParser.parsePlan("+!trigEvent : true <- envAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("-!trigEvent : context(A) > context(B) <- !achievementAction(B); action(A)."));
            System.out.println(agentParser.parsePlan("+!trigEvent : context(A) && context(B) <- envAction(A); -deleteBelief(B)."));
            System.out.println(agentParser.parsePlan("-!trigEvent : context(A) && context(B) <- ?testAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("+?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));
            System.out.println(agentParser.parsePlan("-?trigEvent : context(A) && context(B) <- envAction(A); +addBelief(B)."));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void parse() throws Exception {
        AgentParser agentParser = new AgentParser();

        File file = new File("/Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/test/java/test.agent");
        FileInputStream fis = null;
        fis = new FileInputStream(file);

        Agent agent = agentParser.parseUncertainAgentSpeak(fis);


        System.out.println(agent.getBeliefBase());

        System.out.println("\nInitial Goals");
        System.out.println(agent.getEventSet());

        System.out.println("\nPlan Library");
        System.out.println(agent.getPlanLibrary());


        agent.run();
    }

}