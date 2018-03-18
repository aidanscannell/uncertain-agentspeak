package main.java.actions;

import main.java.Action;
import main.java.Goal;

public abstract class GoalAction extends Action {

    public abstract Goal getGoal();

    @Override
    public String toString() {
        return getGoal().toString();
    }

}
