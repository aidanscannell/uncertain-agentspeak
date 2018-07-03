package main.agentspeak.logical_expressions.relational_expressions;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.RelationalExpression;

public class Equal extends RelationalExpression {

    public Equal(LogicalExpression left, LogicalExpression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return super.getLeft().toString() + " == " + super.getRight().toString();
    }
}
