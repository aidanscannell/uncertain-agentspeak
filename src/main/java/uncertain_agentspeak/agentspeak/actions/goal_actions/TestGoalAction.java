package main.java.uncertain_agentspeak.agentspeak.actions.goal_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.GoalAction;
import main.java.uncertain_agentspeak.agentspeak.goals.TestGoal;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

public class TestGoalAction extends GoalAction {

    public TestGoalAction(TestGoal testGoal) {
        super(testGoal);
    }

    @Override
    public Unifier executeAction(String name, Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        if (getGoal().getFormula() != null) {
            return beliefBase.entails(getGoal().getFormula(), unifier);
        } else if (getGoal().getTerm() != null) {
            return beliefBase.entails(new PositiveLiteral(new BeliefAtom(getGoal().getTerm())), unifier);
        }
        return unifier;
    }

    @Override
    public TestGoalAction substitute(Unifier unifier) {
        return new TestGoalAction(new TestGoal(this.getGoal().getTerm().substitute(unifier)));
    }
}
