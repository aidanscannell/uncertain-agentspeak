package main.agentspeak.logical_expressions.operators.negations;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.operators.Negation;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class NegationAsFailure extends Negation {

    public NegationAsFailure(LogicalExpression logicalExpression) {
        super(logicalExpression);
    }

    public NegationAsFailure substitute(Unifier unifier) {
        return new NegationAsFailure(this.getTerm().substitute(unifier));
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        return this.getTerm().getBeliefLiterals();
    }

    @Override
    public LogicalExpression convertToNNF(boolean propogateStrongNegation) {
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
    public String toString() {
        return "not" + super.getTerm().toString();
    }
}
