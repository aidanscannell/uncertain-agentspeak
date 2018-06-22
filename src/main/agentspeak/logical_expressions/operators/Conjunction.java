package main.agentspeak.logical_expressions.operators;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Operator;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class Conjunction extends Operator {

    private LogicalExpression left;
    private LogicalExpression right;

    public Conjunction(LogicalExpression left, LogicalExpression right) {
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
        if (this.getLeft().isConjunctive() && this.getRight().isConjunctive()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDisjunctive() {
        return false;
    }

}
