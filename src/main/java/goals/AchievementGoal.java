package main.java.goals;

import main.java.Belief;
import main.java.Goal;
import main.java.Unifier;

public class AchievementGoal extends Goal {

    public AchievementGoal(Belief belief) {
        super.setBelief(belief);
    }

    public AchievementGoal substitute(Unifier unifier) {
        return new AchievementGoal(new Belief(this.getBelief().getTerm().substitute(unifier)));
    }

}
