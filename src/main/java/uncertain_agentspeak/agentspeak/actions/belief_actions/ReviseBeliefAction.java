package main.java.uncertain_agentspeak.agentspeak.actions.belief_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.BeliefAction;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;
import main.java.uncertain_agentspeak.agentspeak.events.ExternalEvent;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.DoubleNum;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public class ReviseBeliefAction extends BeliefAction {

    private Term weight;

    public ReviseBeliefAction(BeliefLiteral beliefLiteral, Term weight) {
        super(beliefLiteral);
        this.weight = weight;
    }


    @Override
    public boolean executeAction(Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet) throws Exception {
        BeliefLiteral beliefLiteral = this.getBeliefLiteral().substitute(unifier);
        DoubleNum weight = (DoubleNum) this.weight.substitute(unifier);
        beliefBase.revise(beliefLiteral, weight.getDoubleVal());
//        System.out.println("Belief revised: " + this.toString());
        eventSet.add(new ExternalEvent(new ReviseBeliefET(beliefLiteral,this.weight)));
        return false;
    }

    @Override
    public String toString() {
        return "*(" + super.getBeliefLiteral().toString() + ", " + this.weight.toString() + ")";
    }
}
