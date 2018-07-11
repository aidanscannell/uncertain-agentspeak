package main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals;

import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.Terminal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.NegativeLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;

import java.util.HashSet;

public abstract class BeliefLiteral extends Terminal {

    private BeliefAtom beliefAtom;

    public BeliefLiteral(BeliefAtom beliefAtom) {
        this.beliefAtom = beliefAtom;
    }

    public BeliefAtom getBeliefAtom() {
        return beliefAtom;
    }

    public abstract BeliefLiteral negation();

    @Override
    public boolean isGround() {
        return beliefAtom.isGround();
    }

    public abstract boolean isPositive();

    @Override
    public HashSet<BeliefAtom> getBeliefAtoms() {
        HashSet<BeliefAtom> beliefAtoms = new HashSet<BeliefAtom>();
        beliefAtoms.add(beliefAtom);
        return beliefAtoms;
    }

    @Override
    public HashSet<BeliefLiteral> getBeliefLiterals() {
        HashSet<BeliefLiteral> beliefLiterals = new HashSet<BeliefLiteral>();
        beliefLiterals.add(this);
        return beliefLiterals;
    }

    public abstract BeliefLiteral substitute(Unifier unifier);

    public Unifier unify(BeliefLiteral beliefLiteral) {
        if (beliefLiteral instanceof PositiveLiteral) {
            return this.unify((PositiveLiteral) beliefLiteral);
        } else if (beliefLiteral instanceof NegativeLiteral) {
            return this.unify((NegativeLiteral) beliefLiteral);
        } else {
            return null;
        }
    }

    @Override
    public BeliefLiteral convertToNNF(boolean propagateStrongNegation) {
        if (propagateStrongNegation) {
            return this.negation();
        } else {
            return this;
        }
    }

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
