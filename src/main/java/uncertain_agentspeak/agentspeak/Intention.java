package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

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

    public void executeIntention(String name, IntentionSet intentionSet, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        IntendedMeans intendedMeans = this.plansUnified.peek();
        boolean propagateFlag = false;
        boolean subGoalFlag = intendedMeans.executeAction(name,this, beliefBase, eventSet, environment);
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