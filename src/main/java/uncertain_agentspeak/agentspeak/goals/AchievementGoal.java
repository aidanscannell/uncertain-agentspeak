package main.java.uncertain_agentspeak.agentspeak.goals;

import main.java.uncertain_agentspeak.agentspeak.Goal;
import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;

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
