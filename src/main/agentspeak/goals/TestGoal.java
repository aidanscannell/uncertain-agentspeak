package main.agentspeak.goals;

import main.agentspeak.Goal;
import main.agentspeak.Term;
import main.agentspeak.Unifier;

public class TestGoal extends Goal {

    public TestGoal(Term term) {
        super(term);
    }

    public TestGoal substitute(Unifier unifier) {
        return new TestGoal(this.getTerm().substitute(unifier));
    }

    @Override
    public String toString() {
        return "?" + super.getTerm().toString();
    }

}
