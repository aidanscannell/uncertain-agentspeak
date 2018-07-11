package main.java.uncertain_agentspeak.agentspeak.goals;

import main.java.uncertain_agentspeak.agentspeak.Goal;
import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;

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
