package main.agentspeak.actions;

import main.agentspeak.Action;
import main.agentspeak.Goal;

public abstract class GoalAction extends Action {

    public abstract Goal getGoal();

    @Override
    public String toString() {
        return getGoal().toString();
    }

}
