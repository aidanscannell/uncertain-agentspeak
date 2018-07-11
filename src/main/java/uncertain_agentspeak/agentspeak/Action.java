package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public abstract class Action {
    public abstract boolean executeAction(Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet) throws Exception;
}
