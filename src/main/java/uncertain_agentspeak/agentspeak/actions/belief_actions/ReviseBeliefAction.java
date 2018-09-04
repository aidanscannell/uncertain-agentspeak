package main.java.uncertain_agentspeak.agentspeak.actions.belief_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.BeliefAction;
import main.java.uncertain_agentspeak.agentspeak.event_triggers.belief_event_triggers.ReviseBeliefET;
import main.java.uncertain_agentspeak.agentspeak.events.ExternalEvent;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.DoubleNum;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.IntNum;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public class ReviseBeliefAction extends BeliefAction {

    private Term weight;

    public ReviseBeliefAction(BeliefLiteral beliefLiteral, Term weight) {
        super(beliefLiteral);
        this.weight = weight;
    }

    @Override
    public Unifier executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        BeliefLiteral beliefLiteral = this.getBeliefLiteral().substitute(unifier);
        DoubleNum weight = null;
        if (this.weight.substitute(unifier) instanceof IntNum) {
            double doubleNum = ((IntNum) this.weight.substitute(unifier)).getIntVal();
            weight = new DoubleNum(doubleNum);
        } else if (this.weight.substitute(unifier) instanceof DoubleNum) {
            weight = (DoubleNum) this.weight.substitute(unifier);
        }
//        System.out.println("Attempting to revise GUB with: (" + beliefLiteral.toString() + ", " + weight + ")");
        beliefBase.revise(beliefLiteral, weight.getDoubleVal());
        eventSet.add(new ExternalEvent(new ReviseBeliefET(beliefLiteral,this.weight.substitute(unifier))));
        return unifier;
    }

    @Override
    public String toString() {
        return "*(" + super.getBeliefLiteral().toString() + ", " + this.weight.toString() + ")";
    }
}
