package main.agentspeak.logical_expressions.terminals.belief_literals;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

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

}
