package main.agentspeak.goals;

import main.agentspeak.Belief;
import main.agentspeak.Goal;
import main.agentspeak.Unifier;

public class TestGoal extends Goal {

    public TestGoal(Belief belief) {
        super.setBelief(belief);
    }

    public TestGoal substitute(Unifier unifier) {
        return new TestGoal(new Belief(this.getBelief().getTerm().substitute(unifier)));
    }

    @Override
    public String toString() {
        return "?" + super.getBelief().getTerm().toString();
    }

}
