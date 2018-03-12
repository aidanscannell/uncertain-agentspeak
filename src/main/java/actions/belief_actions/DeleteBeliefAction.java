package main.java.actions.belief_actions;

import main.java.*;
import main.java.actions.BeliefAction;
import main.java.event_triggers.DeleteEvent;
import main.java.events.ExternalEvent;

public class DeleteBeliefAction extends BeliefAction {

    public DeleteBeliefAction(Belief belief) {
        super.setBelief(belief);
    }

    @Override
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet){
        Belief belief = new Belief(this.getBelief().getTerm().substitute(unifier));
        beliefBase.remove(belief);
        System.out.println("Belief deleted: " + belief);
        ExternalEvent externalEvent = new ExternalEvent(new DeleteEvent(belief));
        eventSet.add(externalEvent);
        return false;
    }

}
