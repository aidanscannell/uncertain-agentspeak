package main.agentspeak.logical_expressions.terminals;

import main.agentspeak.logical_expressions.Terminal;

public class Primitive extends Terminal {

    @Override
    public boolean isGround() {
        return true;
    }
}
