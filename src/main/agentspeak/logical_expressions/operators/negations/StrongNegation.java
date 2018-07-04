package main.agentspeak.logical_expressions.operators.negations;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.operators.Negation;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class StrongNegation extends Negation {

    public StrongNegation(LogicalExpression logicalExpression) {
        super(logicalExpression);
    }

    public StrongNegation substitute(Unifier unifier) {
        return new StrongNegation(this.getTerm().substitute(unifier));
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        throw new Exception("Unsupported operation");
    }

    @Override
    public String toString() {
        return "~" + super.getTerm().toString();
    }
}
