package main.agentspeak.goals;

import main.agentspeak.Goal;
import main.agentspeak.Term;
import main.agentspeak.Unifier;

public class AchievementGoal extends Goal {

    public AchievementGoal(Term term) {
        super(term);
    }

    public AchievementGoal substitute(Unifier unifier) {
        return new AchievementGoal(super.getTerm().substitute(unifier));
    }

    @Override
    public String toString() {
        return "!" + super.getTerm().toString();
    }

}
