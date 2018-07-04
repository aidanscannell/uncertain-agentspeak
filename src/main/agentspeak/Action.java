package main.agentspeak;

import main.uncertainty.GlobalUncertainBelief;

public abstract class Action {
    public abstract boolean executeAction(Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet) throws Exception;
}
