package main.resources.antlr.as_parser;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.BeliefAction;
import main.java.uncertain_agentspeak.agentspeak.actions.belief_actions.ReviseBeliefAction;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;
import main.java.uncertain_agentspeak.agentspeak.events.ExternalEvent;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.resources.antlr.UncertainAgentspeakLexer;
import main.resources.antlr.UncertainAgentspeakParser;

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

    public Event parseEvent(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.EventContext eventContext = agentspeakParser.event();
        ReviseBeliefET reviseBeliefET = (ReviseBeliefET) uncertainAgentspeakVisitor.visitEvent(eventContext);
        return new ExternalEvent(reviseBeliefET);
    }

    public ReviseBeliefAction parseAction(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor uncertainAgentspeakVisitor = new UncertainAgentspeakVisitor();

        UncertainAgentspeakParser.Belief_actionContext belief_actionContext = agentspeakParser.belief_action();
        ReviseBeliefAction beliefAction = (ReviseBeliefAction) uncertainAgentspeakVisitor.visitBelief_action(belief_actionContext);
        return beliefAction;
    }

}
