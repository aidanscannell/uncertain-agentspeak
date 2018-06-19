package main.agentspeak.logical_expressions;

import main.agentspeak.LogicalExpression;

public abstract class Operator extends LogicalExpression {

    public boolean isGround() {
        return false;
    }

}
