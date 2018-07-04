package main.agentspeak.logical_expressions.relational_expressions;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.RelationalExpression;

public class NotEqual extends RelationalExpression {

    public NotEqual(LogicalExpression left, LogicalExpression right) {
        super(left, right);
    }

    public NotEqual substitute(Unifier unifier) {
        return new NotEqual(super.getLeft().substitute(unifier), super.getRight().substitute(unifier));
    }

    @Override
    public String toString() {
        return super.getLeft().toString() + " \\= " + super.getRight().toString();
    }
}
