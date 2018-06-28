package main.agentspeak.actions;

import main.agentspeak.Action;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

public abstract class BeliefAction extends Action {

    private BeliefLiteral beliefLiteral;

    public BeliefAction(BeliefLiteral beliefLiteral) {
        this.beliefLiteral = beliefLiteral;
    }

    public BeliefLiteral getBeliefLiteral() {
        return beliefLiteral;
    }

    public void setBeliefLiteral(BeliefLiteral beliefLiteral) {
        this.beliefLiteral = beliefLiteral;
    }
}
