package main.agentspeak.event_triggers.goal_event_triggers;

import main.agentspeak.Goal;
import main.agentspeak.Unifier;
import main.agentspeak.event_triggers.GoalEventTrigger;
import main.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;

public class AddGoalET extends GoalEventTrigger {

    public AddGoalET(Goal goal) {
        super(goal);
    }

    public Unifier unify(AddGoalET addGoalET) {
        return super.getGoal().getTerm().unify(addGoalET.getGoal().getTerm());
    }

    public Unifier unify(DeleteGoalET deleteGoalET) {
        return null;
    }

    public Unifier unify(ReviseBeliefET reviseBeliefET) {
        return null;
    }

    @Override
    public String toString() {
        return "+" + super.getGoal().toString();
    }
}
