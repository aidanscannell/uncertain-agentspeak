package main.java.event_triggers;

import main.java.BeliefGoal;
import main.java.EventTrigger;

public class AddEvent extends EventTrigger {

    public AddEvent(BeliefGoal beliefGoal) {
        super.setBeliefGoal(beliefGoal);
    }

    @Override
    public String toString() {
        return "+" + super.getBeliefGoal().toString();
    }
}
