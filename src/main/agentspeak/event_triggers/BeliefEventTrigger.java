package main.agentspeak.event_triggers;

import main.agentspeak.EventTrigger;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

public class BeliefEventTrigger extends EventTrigger {

    private BeliefLiteral beliefLiteral;

    public BeliefEventTrigger(BeliefLiteral beliefLiteral) {
        this.beliefLiteral = beliefLiteral;
    }

    public void setBeliefLiteral(BeliefLiteral beliefLiteral) {
        this.beliefLiteral = beliefLiteral;
    }

}
