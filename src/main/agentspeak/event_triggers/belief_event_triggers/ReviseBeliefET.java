package main.agentspeak.event_triggers.belief_event_triggers;

import main.agentspeak.Term;
import main.agentspeak.Unifier;
import main.agentspeak.event_triggers.BeliefEventTrigger;
import main.agentspeak.event_triggers.goal_event_triggers.AddGoalET;
import main.agentspeak.event_triggers.goal_event_triggers.DeleteGoalET;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

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
    public String toString() {
        return "*(" + super.getBeliefLiteral().toString() + ", " + weight.toString() + ")";
    }
}
