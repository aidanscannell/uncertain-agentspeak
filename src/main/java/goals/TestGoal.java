package main.java.goals;

import main.java.Belief;
import main.java.Goal;
import main.java.Unifier;

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
