package main.agentspeak.logical_expressions;

import com.oracle.tools.packager.Log;
import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

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

}
