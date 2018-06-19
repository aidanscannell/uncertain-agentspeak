package main.agentspeak;

import main.agentspeak.parser.Visitor;
import main.resources.antlr.AgentspeakLexer;
import main.resources.antlr.AgentspeakParser;
import main.resources.antlr.AgentspeakVisitor;
import org.antlr.v4.runtime.*;


public class Parser {

    public Plan parsePlan(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        AgentspeakLexer agentspeakLexer = new AgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        AgentspeakParser agentspeakParser= new AgentspeakParser(commonTokenStream);

        AgentspeakVisitor visitor = new Visitor();

        AgentspeakParser.PlanContext planContext = agentspeakParser.plan();
        //        System.out.println(planContext);
//        System.out.println(plan.getEventTrigger().getBeliefGoal().getTerm().toString());
//        System.out.println(plan.getContext().get(0).getBelief().getTerm().toString());
//        System.out.println(plan.getActions().toString());

        return (Plan) visitor.visitPlan(planContext);
    }

    public Belief parseBelief(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        AgentspeakLexer agentspeakLexer = new AgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        AgentspeakParser agentspeakParser= new AgentspeakParser(commonTokenStream);

        AgentspeakVisitor visitor = new Visitor();

        AgentspeakParser.BeliefContext beliefContext = agentspeakParser.belief();
        //        System.out.println(belief.getTerm().toString());
        return (Belief) visitor.visitBelief(beliefContext);
    }

    public Goal parseGoal(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        AgentspeakLexer agentspeakLexer = new AgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        AgentspeakParser agentspeakParser= new AgentspeakParser(commonTokenStream);

        AgentspeakVisitor visitor = new Visitor();

        AgentspeakParser.GoalContext goalContext = agentspeakParser.goal();
        //        System.out.println(goal.getTerm().toString());

        return (Goal) visitor.visitGoal(goalContext);
    }

    public Term parseTerm(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        AgentspeakLexer agentspeakLexer = new AgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        AgentspeakParser agentspeakParser= new AgentspeakParser(commonTokenStream);

        AgentspeakVisitor visitor = new Visitor();

        AgentspeakParser.TermContext termContext = agentspeakParser.term();
        return (Term) visitor.visitTerm(termContext);
    }

}
