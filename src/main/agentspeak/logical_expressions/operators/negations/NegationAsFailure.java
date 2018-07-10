package main.agentspeak.logical_expressions.operators.negations;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.Terminal;
import main.agentspeak.logical_expressions.operators.Negation;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;

public class NegationAsFailure extends Negation {

    public NegationAsFailure(LogicalExpression logicalExpression) throws Exception {
        super(logicalExpression);
        if (!this.getTerm().isClassical()) {
            throw new Exception("Formula must be classical to use this operator");
        }
    }

    public NegationAsFailure substitute(Unifier unifier) throws Exception {
        return new NegationAsFailure(this.getTerm().substitute(unifier));
    }

    @Override
    public boolean isClassical() {
        return false;
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        return this.getTerm().getBeliefLiterals();
    }

    @Override
    public LogicalExpression convertToNNF(boolean propogateStrongNegation) throws Exception {
        if (propogateStrongNegation) {
            System.out.println("Negation as failure does not support strong negation");
            return null;
            //TODO: throw exception
        } else {
            return new NegationAsFailure(this.getTerm().convertToNNF(false));
        }
    }

    @Override
    public boolean inNNF() {
        return this.getTerm().inNNF();
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula needs to be pared");
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        return this.getTerm().getTerminals();
    }

    @Override
    public NegationAsFailure convertToCNF() throws Exception {
        return new NegationAsFailure(this.getTerm().convertToCNF());
    }

    @Override
    public String toString() {
        return "not" + super.getTerm().toString();
    }
}
