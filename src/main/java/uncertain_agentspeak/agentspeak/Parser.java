package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.parser.Visitor;
import main.resources.antlr.*;
import org.antlr.v4.runtime.*;

import java.io.FileInputStream;


public class Parser {

    public Agent parseUncertainAgentSpeak(FileInputStream input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.UncertainAgentspeakContext agentspeakContext = agentspeakParser.uncertainAgentspeak();

        return (Agent) visitor.visitUncertainAgentspeak(agentspeakContext);
    }

    public Plan parsePlan(String input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.PlanContext planContext = agentspeakParser.plan();

        return (Plan) visitor.visitPlan(planContext);
    }

    public LogicalExpression parseContext(String input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.ContextContext contextContext = agentspeakParser.context();

        return (LogicalExpression) visitor.visitContext(contextContext);
    }

    public Term parseTerm(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.TermContext termContext = agentspeakParser.term();
        return (Term) visitor.visitTerm(termContext);
    }

    public BeliefLiteral parseBeliefLiteral(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.Belief_literalContext belief_literalContext = agentspeakParser.belief_literal();
        return (BeliefLiteral) visitor.visitBelief_literal(belief_literalContext);
    }

    public BeliefAtom parseBeliefAtom(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.Belief_atomContext belief_atomContext = agentspeakParser.belief_atom();
        return (BeliefAtom) visitor.visitBelief_atom(belief_atomContext);
    }

    public LogicalExpression parseLogicalExpression(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.Log_exprContext log_exprContext = agentspeakParser.log_expr();
        return (LogicalExpression) visitor.visitLog_expr(log_exprContext);
    }

}
