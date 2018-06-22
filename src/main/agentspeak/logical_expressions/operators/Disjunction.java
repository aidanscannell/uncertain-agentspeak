package main.agentspeak.logical_expressions.operators;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.Operator;

public class Disjunction extends Operator {

    private LogicalExpression left;
    private LogicalExpression right;

    public Disjunction(LogicalExpression left, LogicalExpression right) {
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
        return false;
    }

    public boolean isDisjunctive() {
        if (this.getLeft().isDisjunctive() && this.getRight().isDisjunctive()) {
            return true;
        } else {
            return false;
        }
    }
}
