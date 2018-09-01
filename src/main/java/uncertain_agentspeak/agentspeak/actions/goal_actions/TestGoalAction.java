package main.java.uncertain_agentspeak.agentspeak.actions.goal_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.GoalAction;
import main.java.uncertain_agentspeak.agentspeak.goals.TestGoal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public class TestGoalAction extends GoalAction {

    private TestGoal testGoal;

    public TestGoalAction(TestGoal testGoal) {
        this.testGoal = testGoal;
    }

    @Override
    public TestGoal getGoal() {
        return testGoal;
    }

    @Override
    public boolean executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        return false;
    }

    public Unifier executeTestGoalAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        Unifier unifierBB;
        if (testGoal.getFormula() != null) {
            return beliefBase.entails(testGoal.getFormula(), unifier);
        } else if (testGoal.getTerm() != null) {
            unifierBB = beliefBase.entails(new PositiveLiteral(new BeliefAtom(testGoal.getTerm())), unifier);
            return unifierBB;
        }
        return null;
    }

    @Override
    public String toString() {
        return testGoal.toString();
    }

}
