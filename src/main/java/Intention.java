package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Intention {

    private Deque<IntendedMeans> intendedMeans;

    public Intention(){
        this.intendedMeans = new ArrayDeque<>();
    }

    private IntendedMeans pop(){
        return intendedMeans.pop();
    }

    public void push(IntendedMeans intendedMeans){
        this.intendedMeans.push(intendedMeans);
    }

    public void executeIntention(IntentionSet intentionSet, BeliefBase beliefBase, EventSet eventSet){
        IntendedMeans intendedMeans = this.intendedMeans.peekFirst();
        boolean propogateFlag = false;
        boolean subGoalFlag = intendedMeans.executeAction(this, beliefBase, eventSet);
        if (!subGoalFlag) {
            while(intendedMeans.getIndex() < intendedMeans.actionsRemaining()) {
                if (this.intendedMeans.size() == 1) {
                    propogateFlag = true;
                } else {
                    IntendedMeans top = this.pop();
                    this.intendedMeans.getFirst().getUnifier().putAll(top.getUnifier());
                }
            }
            if (!propogateFlag) {
                intentionSet.add(this);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (IntendedMeans intendedMean : intendedMeans) {
            string.append(intendedMean.getPlan().toString());
            if (intendedMean != intendedMeans.getLast()) {
                string.append("\n");
            }
        }
        return string.toString();
    }
}
