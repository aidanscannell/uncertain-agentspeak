package main.java.uncertain_agentspeak.agentspeak.goals;

import main.java.uncertain_agentspeak.agentspeak.Goal;
import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import org.apache.commons.logging.Log;

public class TestGoal extends Goal {

    public TestGoal(Term term) {
        super(term);
    }

    public TestGoal(LogicalExpression formula) {
        super(formula);
    }

    public TestGoal substitute(Unifier unifier) throws Exception {
        if (getFormula()!= null) {
            return new TestGoal(this.getFormula().substitute(unifier));
        } else if (super.getTerm() != null) {
            return new TestGoal(this.getTerm().substitute(unifier));
        }
        throw new Exception("Test goal has no formula or term associated with it.");
    }

    @Override
    public String toString() {
        if (getFormula() != null) {
            return "?" + getFormula().toString();
        } else if ( super.getTerm() != null) {
            return "?" + super.getTerm().toString();
        }
        return "Test goal has no formula or term associated with it.";
    }

}
