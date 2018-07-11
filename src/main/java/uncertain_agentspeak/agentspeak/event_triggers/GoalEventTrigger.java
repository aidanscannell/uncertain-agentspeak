package main.java.uncertain_agentspeak.agentspeak.event_triggers;

import main.java.uncertain_agentspeak.agentspeak.EventTrigger;
import main.java.uncertain_agentspeak.agentspeak.Goal;

public abstract class GoalEventTrigger extends EventTrigger {

    private Goal goal;

    public GoalEventTrigger(Goal goal) {
        this.goal = goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }
}
