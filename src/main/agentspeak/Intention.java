package main.agentspeak;

import main.uncertainty.GlobalUncertainBelief;

import java.util.ArrayDeque;
import java.util.Deque;

public class Intention {

    private Deque<IntendedMeans> plansUnified;

    public Intention(){
        this.plansUnified = new ArrayDeque<>();
    }

    private IntendedMeans pop(){
        return plansUnified.pop();
    }

    public void push(IntendedMeans intendedMeans){
        this.plansUnified.push(intendedMeans);
    }

    public void executeIntention(IntentionSet intentionSet, GlobalUncertainBelief beliefBase, EventSet eventSet) throws Exception{
        IntendedMeans intendedMeans = this.plansUnified.peek();
        boolean propagateFlag = false;
        boolean subGoalFlag = intendedMeans.executeAction(this, beliefBase, eventSet);
        if (!subGoalFlag) {
            while(!this.plansUnified.getFirst().actionsRemaining()) {
                if (this.plansUnified.size() == 1) {
                    propagateFlag = true;
                } else {
                    IntendedMeans top = this.pop();
                    this.plansUnified.peekFirst().getUnifier().putAll(top.getUnifier());
                }
                if (!this.plansUnified.peekFirst().actionsRemaining()) {
                    System.out.println("Break out of intention while loop");
                    break;
                }
            }
            if (!propagateFlag) {
                intentionSet.add(this);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (IntendedMeans intendedMean : plansUnified) {
            string.append(intendedMean.getPlan().toString());
            if (intendedMean != plansUnified.getLast()) {
                string.append("\n");
            }
        }
        return string.toString();
    }
}