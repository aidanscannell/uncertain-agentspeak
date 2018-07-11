package main.java.uncertain_agentspeak.agentspeak.actions.goal_actions;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.GoalAction;
import main.java.uncertain_agentspeak.agentspeak.goals.TestGoal;
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
    public boolean executeAction(Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet) {
        // TODO: add GUB entails method and evaluate here
//        boolean flag = false;
//        for (Belief belief : beliefBase) {
//            if (belief.isPositive() == this.testGoal.getBelief().isPositive()) {
//                Unifier unifierNew = this.testGoal.getBelief().getTerm().unify(belief.getTerm(), unifier);
//                if (unifierNew != null) {
//                    flag = true;
//                    unifier.putAll(unifierNew);
//                }
//            }
//        }

//        if (!flag) {
//            Goal achievementGoalSub = this.testGoal.substitute(unifier);
//            eventSet.add(new InternalEvent(new AddGoalET(achievementGoalSub), intention));
//            System.out.println("New event created to resolve test goal");
//            return true;
//        } else {
//            System.out.println("Test goal immediately resolved");
//            return false;
//        }
        return false;
    }

    @Override
    public String toString() {
        return "?" + testGoal.getTerm().toString();
    }

}
