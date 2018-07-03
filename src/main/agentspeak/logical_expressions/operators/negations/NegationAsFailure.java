package main.agentspeak.logical_expressions.operators.negations;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.operators.Negation;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class NegationAsFailure extends Negation {

    public NegationAsFailure(LogicalExpression logicalExpression) {
        super(logicalExpression);
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        return this.getTerm().getBeliefLiterals();
    }

    @Override
    public String toString() {
        return "not" + super.getTerm().toString();
    }
}
