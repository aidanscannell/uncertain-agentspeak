package main.agentspeak.logical_expressions;

import main.agentspeak.LogicalExpression;

public abstract class Terminal extends LogicalExpression {

    public abstract boolean isGround();

    @Override
    public boolean isDisjunctive() {
        return true;
    }

    @Override
    public boolean isConjunctive() {
        return true;
    }

    @Override
    public boolean inNNF() {
        return true;
    }
}
