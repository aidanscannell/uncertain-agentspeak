package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public abstract class Action {
    public abstract Unifier executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception;
}
