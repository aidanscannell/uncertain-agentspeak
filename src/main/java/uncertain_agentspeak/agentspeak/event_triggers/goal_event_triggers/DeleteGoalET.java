package main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers;

import main.java.uncertain_agentspeak.agentspeak.Goal;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.GoalEventTrigger;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;

public class DeleteGoalET extends GoalEventTrigger {

    public DeleteGoalET(Goal goal) {
        super(goal);
    }

    public Unifier unify(AddGoalET addGoalET) {
        return null;
    }

    public Unifier unify(DeleteGoalET deleteGoalET) {
        return super.getGoal().getTerm().unify(deleteGoalET.getGoal().getTerm());
    }

    public Unifier unify(ReviseBeliefET reviseBeliefET) {
        return null;
    }

    @Override
    public DeleteGoalET substitute(Unifier unifier) throws Exception {
        return new DeleteGoalET(this.getGoal().substitute(unifier));
    }

    @Override
    public String toString() {
        return "-" + super.getGoal().toString();
    }

}
