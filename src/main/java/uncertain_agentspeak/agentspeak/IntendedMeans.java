package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.actions.goal_actions.TestGoalAction;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

import java.util.ArrayList;

public class IntendedMeans {

    private Plan plan;
    private Unifier unifier;
    private int index;

    public IntendedMeans(Plan plan, Unifier unifier) {
        this.plan = plan;
        this.unifier = unifier;
        this.index = 0;
    }

    public Plan getPlan() {
        return plan;
    }

    public Unifier getUnifier() {
        return unifier;
    }

    public int getIndex() {
        return index;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setUnifier(Unifier unifier) {
        this.unifier = unifier;
    }

    public boolean actionsRemaining() {
        return this.index < plan.getActions().size();
    }

    /** Executes the next action
     *  Returns - true, if subgoal is created, otherwise
     *          - false */
    public boolean executeAction(String name, Intention intention, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        boolean subGoalFlag = false;
        ArrayList<Action> actions = this.plan.getActions();
        if (actionsRemaining()) {
            Action action = actions.get(this.index);
            if (action instanceof TestGoalAction)  {
                TestGoalAction testGoalAction = (TestGoalAction) action;
                Unifier unifierNew = testGoalAction.executeTestGoalAction(name, intention, this.unifier, beliefBase, eventSet, environment);
                setUnifier(unifierNew);
            } else {
                subGoalFlag = action.executeAction(name, intention, this.unifier, beliefBase, eventSet, environment);
            }
            this.index++;
        }
        return subGoalFlag;
    }
}
