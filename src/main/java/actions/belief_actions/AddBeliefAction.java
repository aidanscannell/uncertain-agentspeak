package main.java.actions.belief_actions;

import main.java.*;
import main.java.actions.BeliefAction;
import main.java.event_triggers.AddEvent;
import main.java.events.ExternalEvent;

public class AddBeliefAction extends BeliefAction {

    public AddBeliefAction(Belief belief) {
        super.setBelief(belief);
    }

    @Override
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet){
        Belief belief = new Belief(this.getBelief().getTerm().substitute(unifier));
        beliefBase.add(belief);
        System.out.println("Belief added: " + belief);
        ExternalEvent externalEvent = new ExternalEvent(new AddEvent(belief));
        eventSet.add(externalEvent);
        return false;
    }
}
