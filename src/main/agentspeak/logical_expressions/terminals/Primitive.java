package main.agentspeak.logical_expressions.terminals;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Terminal;

import java.util.HashSet;

public abstract class Primitive extends Terminal {

    public abstract Primitive negation();

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

    @Override
    public Primitive convertToNNF(boolean propagateStrongNegation) {
        if (propagateStrongNegation) {
            return this.negation();
        } else {
            return this;
        }
    }
}
