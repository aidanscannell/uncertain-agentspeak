package main.agentspeak.event_triggers;

import main.agentspeak.BeliefGoal;
import main.agentspeak.EventTrigger;

public class DeleteEvent extends EventTrigger {

    public DeleteEvent(BeliefGoal beliefGoal) {
        super.setBeliefGoal(beliefGoal);
    }

    @Override
    public String toString() {
        return "-" + super.getBeliefGoal().toString();
    }

}
