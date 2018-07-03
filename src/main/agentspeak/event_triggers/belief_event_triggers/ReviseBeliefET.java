package main.agentspeak.event_triggers.belief_event_triggers;

import main.agentspeak.Term;
import main.agentspeak.event_triggers.BeliefEventTrigger;
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

    @Override
    public String toString() {
        return "*(" + super.getBeliefLiteral().toString() + ", " + weight.toString() + ")";
    }
}
