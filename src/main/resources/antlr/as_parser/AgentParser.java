package main.resources.antlr.as_parser;

//import main.resources.antlr.uncertain_agentspeak.UncertainAgentspeakLexer;
//import main.resources.antlr.uncertain_agentspeak.UncertainAgentspeakParser;
//import main.resources.antlr.uncertain_agentspeak.UncertainAgentspeakVisitor;
import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Plan;
import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.resources.antlr.UncertainAgentspeakLexer;
import main.resources.antlr.UncertainAgentspeakParser;
import main.resources.antlr.as_parser.UncertainAgentspeakVisitor;

import org.antlr.v4.runtime.*;

import java.io.FileInputStream;


public class AgentParser {

    public Agent parseUncertainAgentSpeak(FileInputStream input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.UncertainAgentspeakContext agentspeakContext = agentspeakParser.uncertainAgentspeak();

        return (Agent) uncertainAgentspeakVisitor.visitUncertainAgentspeak(agentspeakContext);
    }

    public Plan parsePlan(String input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.PlanContext planContext = agentspeakParser.plan();

        return (Plan) uncertainAgentspeakVisitor.visitPlan(planContext);
    }

    public LogicalExpression parseContext(String input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.ContextContext contextContext = agentspeakParser.context();

        return (LogicalExpression) uncertainAgentspeakVisitor.visitContext(contextContext);
    }

    public Term parseTerm(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.TermContext termContext = agentspeakParser.term();
        return (Term) uncertainAgentspeakVisitor.visitTerm(termContext);
    }

    public BeliefLiteral parseBeliefLiteral(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.Belief_literalContext belief_literalContext = agentspeakParser.belief_literal();
        return (BeliefLiteral) uncertainAgentspeakVisitor.visitBelief_literal(belief_literalContext);
    }

    public BeliefAtom parseBeliefAtom(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.Belief_atomContext belief_atomContext = agentspeakParser.belief_atom();
        return (BeliefAtom) uncertainAgentspeakVisitor.visitBelief_atom(belief_atomContext);
    }

    public LogicalExpression parseLogicalExpression(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.Log_exprContext log_exprContext = agentspeakParser.log_expr();
        return (LogicalExpression) uncertainAgentspeakVisitor.visitLog_expr(log_exprContext);
    }

}
