package main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.negations;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Terminal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.GreaterEqualsPlausibility;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Negation;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;

public class StrongNegation extends Negation {

    public StrongNegation(LogicalExpression logicalExpression) {
        super(logicalExpression);
    }

    public StrongNegation substitute(Unifier unifier) throws Exception {
        return new StrongNegation(this.getTerm().substitute(unifier));
    }

    @Override
    public boolean isClassical() {
        return this.getTerm().isClassical();
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        throw new Exception("Unsupported operation");
    }

    @Override
    public LogicalExpression convertToNNF(boolean propagateStrongNegation) throws Exception {
        if (propagateStrongNegation) {
            return this.getTerm().convertToNNF(false);
        } else {
            return this.getTerm().convertToNNF(true);
        }
    }

    @Override
    public boolean inNNF() {
        return false;
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula not in NNF");
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula not in NNF");
    }

    @Override
    public GreaterEqualsPlausibility convertToCNF() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula must be in NNF");
    }

    @Override
    public String toString() {
        return "~" + super.getTerm().toString();
    }
}
