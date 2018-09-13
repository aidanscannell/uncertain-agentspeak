package main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers;

import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.BeliefEventTrigger;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.AddGoalET;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.goal_event_triggers.DeleteGoalET;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;

public class ReviseBeliefET extends BeliefEventTrigger {

    private Term weight;

    public ReviseBeliefET(BeliefLiteral beliefLiteral, Term weight) {
        super(beliefLiteral);
        this.weight = weight;
    }

    public void setWeight(Term weight) {
        this.weight = weight;
    }

    public Term getWeight() {
        return weight;
    }

    public Unifier unify(AddGoalET addGoalET) {
        return null;
    }

    public Unifier unify(DeleteGoalET deleteGoalET) {
        return null;
    }

    public Unifier unify(ReviseBeliefET reviseBeliefET) {
        Unifier unifierLiteral = super.getBeliefLiteral().unify(reviseBeliefET.getBeliefLiteral());
        if (unifierLiteral != null) {
            Unifier unifierWeight = weight.substitute(unifierLiteral).unify(reviseBeliefET.getWeight().substitute(unifierLiteral));
            if (unifierWeight != null) {
                unifierLiteral.putAll(unifierWeight);
                return unifierLiteral;
            }
        }
        return null;
    }

    @Override
    public ReviseBeliefET substitute(Unifier unifier) {
        return new ReviseBeliefET(getBeliefLiteral().substitute(unifier),weight.substitute(unifier));
    }

    @Override
    public String toString() {
        return "*(" + super.getBeliefLiteral().toString() + ", " + weight.toString() + ")";
    }
}
