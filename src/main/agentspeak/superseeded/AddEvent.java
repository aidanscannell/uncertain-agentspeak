package main.agentspeak.superseeded;

import main.agentspeak.BeliefGoal;
import main.agentspeak.EventTrigger;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;

public class AddEvent extends EventTrigger {

    public AddEvent(BeliefLiteral beliefLiteral) {
        super.setBeliefGoal(beliefLiteral);
    }

    @Override
    public String toString() {
        return "+" + super.getBeliefGoal().toString();
    }
}


//public class AddEvent extends EventTrigger {
//
//    public AddEvent(BeliefGoal beliefGoal) {
//        super.setBeliefGoal(beliefGoal);
//    }
//
//    @Override
//    public String toString() {
//        return "+" + super.getBeliefGoal().toString();
//    }
//}
