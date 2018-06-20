package main.agentspeak.logical_expressions;

import main.agentspeak.Belief;
import main.agentspeak.LogicalExpression;
import main.agentspeak.Term;

public class BeliefAtom extends LogicalExpression {

    private Term belief;

    public BeliefAtom(Term belief) {
        this.belief = belief;
    }

    public Term getTerm() {
        return belief;
    }


    public boolean equals(BeliefAtom beliefAtom) {
        if (beliefAtom.getTerm().equals(belief)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGround() {
        return belief.isGround();
    }

    @Override
    public String toString() {
        return belief.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (belief == null) ? 0 : belief.hashCode() );
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
        BeliefAtom other = (BeliefAtom) obj;
        if (belief == null && other.belief == null) {
            return false;
        } else if (!belief.equals(other.belief)) {
            return false;
        }
        return true;
    }
}
