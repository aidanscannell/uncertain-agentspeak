package main.agentspeak.logical_expressions.relational_expressions;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.RelationalExpression;

public class NotEqual extends RelationalExpression {

    public NotEqual(LogicalExpression left, LogicalExpression right) {
        super(left, right);
    }

}
