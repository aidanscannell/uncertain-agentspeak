package main.agentspeak.event_triggers;

import main.agentspeak.EventTrigger;
import main.agentspeak.Goal;

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
