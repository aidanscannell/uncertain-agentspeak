package main.agentspeak.actions.belief_actions;

import main.agentspeak.*;
import main.agentspeak.actions.BeliefAction;
import main.agentspeak.event_triggers.DeleteEvent;
import main.agentspeak.events.ExternalEvent;

public class DeleteBeliefAction extends BeliefAction {

    public DeleteBeliefAction(Belief belief) {
        super.setBelief(belief);
    }

    @Override
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet){
        Belief belief = new Belief(this.getBelief().getTerm().substitute(unifier));
//        beliefBase.remove(belief);
        System.out.println("Belief deleted: " + belief);
        ExternalEvent externalEvent = new ExternalEvent(new DeleteEvent(belief));
        eventSet.add(externalEvent);
        return false;
    }

    @Override
    public String toString() {
        return "-" + super.getBelief().getTerm().toString();
    }
}
