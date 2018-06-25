package main.agentspeak.logical_expressions.terminals;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Terminal;

import java.util.HashSet;

public class Primitive extends Terminal {

    @Override
    public boolean isGround() {
        return true;
    }

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        return new HashSet<BeliefAtom>();
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() {
        return new HashSet<BeliefLiteral>();
    }
}
