package main.agentspeak.actions.goal_actions;

import main.agentspeak.*;
import main.agentspeak.actions.GoalAction;
import main.agentspeak.event_triggers.AddEvent;
import main.agentspeak.events.InternalEvent;
import main.agentspeak.goals.AchievementGoal;

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

    @Override
    public String toString() {
        return "!" + achievementGoal.getBelief().getTerm().toString();
    }
}