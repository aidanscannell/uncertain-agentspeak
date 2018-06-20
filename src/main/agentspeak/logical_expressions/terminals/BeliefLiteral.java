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

    @Override
    public String toString() {
        return beliefAtom.getTerm().toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (beliefAtom == null) ? 0 : beliefAtom.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        BeliefLiteral other = (BeliefLiteral) obj;
        if (beliefAtom == null && other.beliefAtom == null) {
            return false;
        } else if (!beliefAtom.equals(other.beliefAtom)) {
            return false;
        }
        return true;
    }
}
