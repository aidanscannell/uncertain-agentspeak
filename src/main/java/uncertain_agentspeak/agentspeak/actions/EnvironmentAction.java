package main.java.uncertain_agentspeak.agentspeak.actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public class EnvironmentAction extends Action {

    private Term term;

    public EnvironmentAction(Term term) {
        this.term = term;
    }

    public EnvironmentAction substitute(Unifier unifier) {
        return new EnvironmentAction(this.term.substitute(unifier));
    }

    public boolean executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) {
        environment.scheduleAction(name, this.substitute(unifier));
        System.out.println("Environment action executed: " + this.substitute(unifier));
        return false;
    }

    public Term getTerm() {
        return term;
    }

    public String getFunctor() {
        String term = this.term.toString();
        String[] parts = term.split("\\(");
        return parts[0];
    }

    @Override
    public String toString() {
        return term.toString();
    }

}
