package main.java.uncertain_agentspeak.agentspeak.logical_expressions;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;

public abstract class RelationalExpression extends LogicalExpression {

    private LogicalExpression left;
    private LogicalExpression right;

    public RelationalExpression(LogicalExpression left, LogicalExpression right) {
        this.left = left;
        this.right = right;
    }

    public LogicalExpression getRight() {
        return right;
    }

    public LogicalExpression getLeft() {
        return left;
    }

    @Override
    public boolean isGround() {
        return this.getLeft().isGround() && this.getRight().isGround();
    }

    @Override
    public boolean isConjunctive() {
        return true;
    }

    @Override
    public boolean isDisjunctive() {
        return true;
    }

    @Override
    public boolean isClassical() {
        return true;
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        return new HashSet<BeliefAtom>();
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() {
        return new HashSet<BeliefLiteral>();
    }

    @Override
    public boolean inNNF() {
        return true;
    }

    @Override
    public HashSet<HashSet<Terminal>> getSetClauses() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Formula needs to be pared");
    }

    @Override
    public HashSet<Terminal> getTerminals() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Formula needs to be pared");
    }

}
