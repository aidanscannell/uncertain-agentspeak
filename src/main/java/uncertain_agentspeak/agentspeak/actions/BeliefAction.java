package main.java.uncertain_agentspeak.agentspeak.actions;

import main.java.uncertain_agentspeak.agentspeak.Action;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

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
