package main.java.uncertain_agentspeak.agentspeak.actions.goal_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.GoalAction;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.GoalEventTrigger;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.AddGoalET;
import main.java.uncertain_agentspeak.agentspeak.events.InternalEvent;
import main.java.uncertain_agentspeak.agentspeak.goals.AchievementGoal;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

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
    public boolean executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) {
        AchievementGoal achievementGoalSub = this.achievementGoal.substitute(unifier);
        eventSet.add(new InternalEvent(new AddGoalET(achievementGoalSub),intention));
        System.out.println("Subgoal added: " + achievementGoalSub);
        return true;
    }

    @Override
    public String toString() {
        return "!" + achievementGoal.getTerm().toString();
    }
}
