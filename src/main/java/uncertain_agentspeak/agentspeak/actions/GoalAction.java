package main.java.uncertain_agentspeak.agentspeak.actions;

import main.java.uncertain_agentspeak.agentspeak.Action;
import main.java.uncertain_agentspeak.agentspeak.Goal;

public abstract class GoalAction extends Action {

    private Goal goal;

    public GoalAction(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }

    @Override
    public String toString() {
        return getGoal().toString();
    }

}
