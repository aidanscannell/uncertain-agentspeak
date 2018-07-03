package main.agentspeak.logical_expressions.operators;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Operator;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class GreaterEqualsPlausibility extends Operator {

    private LogicalExpression left;
    private LogicalExpression right;

    public GreaterEqualsPlausibility(LogicalExpression left, LogicalExpression right) {
        this.left = left;
        this.right = right;
    }

    public LogicalExpression getLeft() {
        return left;
    }

    public LogicalExpression getRight() {
        return right;
    }

    public boolean isConjunctive() {
        return true;
    }

    public boolean isDisjunctive() {
        return true;
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        HashSet<BeliefAtom> beliefAtoms = new HashSet<BeliefAtom>();
        beliefAtoms.add((BeliefAtom) left.getBeliefAtoms().clone());
        beliefAtoms.add((BeliefAtom) right.getBeliefAtoms().clone());
        return beliefAtoms;
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() throws Exception {
        HashSet<BeliefLiteral> beliefLiterals = new HashSet<BeliefLiteral>();
        beliefLiterals.add((BeliefLiteral) left.getBeliefLiterals().clone());
        beliefLiterals.add((BeliefLiteral) right.getBeliefLiterals().clone());
        return beliefLiterals;
    }

    @Override
    public String toString() {
        return left.toString() + " >= " + right.toString();
    }

}
