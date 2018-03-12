package main.java.actions.goal_actions;

import main.java.*;
import main.java.actions.GoalAction;
import main.java.event_triggers.AddEvent;
import main.java.events.InternalEvent;
import main.java.goals.AchievementGoal;

public class AchievementGoalAction extends GoalAction {

    private AchievementGoal achievementGoal;

    public AchievementGoalAction(AchievementGoal achievementGoal) {
        this.achievementGoal = achievementGoal;
    }

    @Override
    public AchievementGoal getGoal() {
        return achievementGoal;
    }

    @Override
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet) {
        AchievementGoal achievementGoalSub = this.achievementGoal.substitute(unifier);
        eventSet.add(new InternalEvent(new AddEvent(achievementGoalSub),intention));
        System.out.println("Subgoal added: " + achievementGoalSub);
        return true;
    }
}
