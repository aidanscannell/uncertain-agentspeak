package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.AddGoalET;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.DeleteGoalET;

public abstract class EventTrigger {

    public Unifier unify(EventTrigger eventTrigger) {
        if (eventTrigger instanceof AddGoalET) {
            return this.unify((AddGoalET) eventTrigger);
        } else if (eventTrigger instanceof DeleteGoalET) {
            return this.unify((DeleteGoalET) eventTrigger);
        } else if (eventTrigger instanceof ReviseBeliefET) {
            return this.unify((ReviseBeliefET) eventTrigger);
        } else {
            return null;
        }
    }

    public abstract Unifier unify(AddGoalET addGoalET);

    public abstract Unifier unify(DeleteGoalET deleteGoalET);

    public abstract Unifier unify(ReviseBeliefET reviseBeliefET);

    public abstract EventTrigger substitute(Unifier unifier) throws Exception;
}
