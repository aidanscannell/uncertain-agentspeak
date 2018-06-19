package main.agentspeak.actions;

import main.agentspeak.Action;
import main.agentspeak.Belief;

public abstract class BeliefAction extends Action {

    private Belief belief;

    public Belief getBelief() {
        return belief;
    }

    public void setBelief(Belief belief) {
        this.belief = belief;
    }
}
