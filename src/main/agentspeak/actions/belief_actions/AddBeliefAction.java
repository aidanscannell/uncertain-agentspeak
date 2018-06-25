package main.agentspeak.actions.belief_actions;

import main.agentspeak.*;
import main.agentspeak.actions.BeliefAction;
import main.agentspeak.event_triggers.AddEvent;
import main.agentspeak.events.ExternalEvent;

public class AddBeliefAction extends BeliefAction {

    public AddBeliefAction(Belief belief) {
        super.setBelief(belief);
    }

    @Override
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet){
        Belief belief = new Belief(this.getBelief().getTerm().substitute(unifier));
//        beliefBase.add(belief);
        System.out.println("Belief added: " + belief);
        ExternalEvent externalEvent = new ExternalEvent(new AddEvent(belief));
        eventSet.add(externalEvent);
        return false;
    }

    @Override
    public String toString() {
        return "+" + super.getBelief().getTerm().toString();
    }
}
