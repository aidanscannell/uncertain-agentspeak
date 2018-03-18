package main.java.actions;

import main.java.*;

public class EnvironmentAction extends Action {

    private Term term;

    public EnvironmentAction(Term term) {
        this.term = term;
    }

    public EnvironmentAction substitute(Unifier unifier) {
        return new EnvironmentAction(this.term.substitute(unifier));
    }

    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet) {
        System.out.println("Environment action executed: " + this.substitute(unifier));
        return false;
    }

    @Override
    public String toString() {
        return term.toString();
    }

}
