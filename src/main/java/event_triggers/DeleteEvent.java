package main.java.event_triggers;

import main.java.BeliefGoal;
import main.java.EventTrigger;

public class DeleteEvent extends EventTrigger {

    public DeleteEvent(BeliefGoal beliefGoal) {
        super.setBeliefGoal(beliefGoal);
    }

}
