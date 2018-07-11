package main.java.uncertain_agentspeak.agentspeak.actions;

import main.java.uncertain_agentspeak.agentspeak.Action;
import main.java.uncertain_agentspeak.agentspeak.Goal;

public abstract class GoalAction extends Action {

    public abstract Goal getGoal();

    @Override
    public String toString() {
        return getGoal().toString();
    }

}
