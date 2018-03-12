package main.java.actions;

import main.java.Action;
import main.java.Belief;

public abstract class BeliefAction extends Action {

    private Belief belief;

    public Belief getBelief() {
        return belief;
    }

    public void setBelief(Belief belief) {
        this.belief = belief;
    }
}
