package main.agentspeak.goals;

import main.agentspeak.Belief;
import main.agentspeak.Goal;
import main.agentspeak.Unifier;

public class AchievementGoal extends Goal {

    public AchievementGoal(Belief belief) {
        super.setBelief(belief);
    }

    public AchievementGoal substitute(Unifier unifier) {
        return new AchievementGoal(new Belief(this.getBelief().getTerm().substitute(unifier)));
    }

    @Override
    public String toString() {
        return "!" + super.getBelief().getTerm().toString();
    }

}
