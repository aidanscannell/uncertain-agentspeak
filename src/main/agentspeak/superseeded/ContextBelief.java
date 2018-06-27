package main.agentspeak.superseeded;

import main.agentspeak.Belief;

public class ContextBelief {

    private Belief belief;

    public ContextBelief(Belief belief) {
        this.belief = belief;
    }

    public void setBelief(Belief belief) {
        this.belief = belief;
    }

    public Belief getBelief() {
        return belief;
    }
}
