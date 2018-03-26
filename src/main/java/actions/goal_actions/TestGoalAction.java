package main.java.actions.goal_actions;

import main.java.*;
import main.java.actions.GoalAction;
import main.java.event_triggers.AddEvent;
import main.java.events.InternalEvent;
import main.java.goals.TestGoal;

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
    public boolean executeAction(Intention intention, Unifier unifier, BeliefBase beliefBase, EventSet eventSet) {
        boolean flag = false;
        for (Belief belief : beliefBase) {
            if (belief.isPositive() == this.testGoal.getBelief().isPositive()) {
                Unifier unifierNew = this.testGoal.getBelief().getTerm().unify(belief.getTerm(), unifier);
                if (unifierNew != null) {
                    flag = true;
                    unifier.putAll(unifierNew);
                }
            }
        }

        if (!flag) {
            Goal achievementGoalSub = this.testGoal.substitute(unifier);
            eventSet.add(new InternalEvent(new AddEvent(achievementGoalSub), intention));
            System.out.println("New event created to resolve test goal");
            return true;
        } else {
            System.out.println("Test goal immediately resolved");
            return false;
        }
    }

    @Override
    public String toString() {
        return "?" + testGoal.getBelief().getTerm().toString();
    }

}
