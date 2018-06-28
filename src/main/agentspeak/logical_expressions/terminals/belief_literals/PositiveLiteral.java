package main.agentspeak.logical_expressions.terminals.belief_literals;

import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

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
}
