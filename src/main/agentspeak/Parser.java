package main.agentspeak;

import main.agentspeak.parser.Visitor;
import main.resources.antlr.*;
import org.antlr.v4.runtime.*;

import java.io.FileInputStream;


public class Parser {

    public Interpreter parseUncertainAgentSpeak(FileInputStream input) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.UncertainAgentspeakContext agentspeakContext = agentspeakParser.uncertainAgentspeak();

        return (Interpreter) visitor.visitUncertainAgentspeak(agentspeakContext);
    }

    public Plan parsePlan(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        UncertainAgentspeakLexer agentspeakLexer = new UncertainAgentspeakLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(agentspeakLexer);
        UncertainAgentspeakParser agentspeakParser= new UncertainAgentspeakParser(commonTokenStream);

        UncertainAgentspeakVisitor visitor = new Visitor();

        UncertainAgentspeakParser.PlanContext planContext = agentspeakParser.plan();

        return (Plan) visitor.visitPlan(planContext);
    }

    public LogicalExpression parseContext(String input) {
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

}
