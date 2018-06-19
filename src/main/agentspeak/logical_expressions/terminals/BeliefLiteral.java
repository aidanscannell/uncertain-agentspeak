package main.agentspeak.logical_expressions.terminals;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Terminal;

public abstract class BeliefLiteral extends Terminal {

    private BeliefAtom beliefAtom;

    public BeliefLiteral(BeliefAtom beliefAtom) {
        this.beliefAtom = beliefAtom;
    }

    public BeliefAtom getBeliefAtom() {
        return beliefAtom;
    }

    @Override
    public boolean isGround() {
        return beliefAtom.isGround();
    }

    public abstract boolean isPositive();
}
