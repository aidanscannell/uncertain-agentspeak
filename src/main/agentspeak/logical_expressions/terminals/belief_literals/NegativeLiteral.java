package main.agentspeak.logical_expressions.terminals.belief_literals;

import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

import java.util.HashSet;

public class NegativeLiteral extends BeliefLiteral {

    public NegativeLiteral(BeliefAtom atom) {
        super(atom);
    }

    public boolean isPositive() {
        return false;
    };

    public PositiveLiteral negation() {
        return new PositiveLiteral(this.getBeliefAtom());
    }

    public NegativeLiteral substitute(Unifier unifier) {
        return new NegativeLiteral(super.getBeliefAtom().substitute(unifier));
    }

    public Unifier unify(PositiveLiteral positiveLiteral) {
        return null;
    }

    public Unifier unify(NegativeLiteral negativeLiteral) {
        return super.getBeliefAtom().getTerm().unify(negativeLiteral.getBeliefAtom().getTerm());
    }

    @Override
    public String toString() {
        return "~" + super.getBeliefAtom().toString();
    }

}
