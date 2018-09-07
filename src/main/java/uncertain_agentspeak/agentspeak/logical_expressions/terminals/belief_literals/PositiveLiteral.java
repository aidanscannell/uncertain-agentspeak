package main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals;

import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

public class PositiveLiteral extends BeliefLiteral {

    public PositiveLiteral(BeliefAtom atom) {
        super(atom);
    }

    public boolean isPositive() {
        return true;
    };

    public NegativeLiteral negation() {
        return new NegativeLiteral(this.getBeliefAtom());
    }

    public PositiveLiteral substitute(Unifier unifier) {
        return new PositiveLiteral(super.getBeliefAtom().substitute(unifier));
    }

    @Override
    public Unifier unify(PositiveLiteral positiveLiteral) {
        return super.getBeliefAtom().getTerm().unify(positiveLiteral.getBeliefAtom().getTerm());
    }

    @Override
    public Unifier unify(NegativeLiteral negativeLiteral) {
        return null;
    }

    @Override
    public String toString() {
        return super.getBeliefAtom().toString();
    }
}
