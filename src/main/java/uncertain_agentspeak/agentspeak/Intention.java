package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

import java.util.LinkedList;

public class Intention {

    private LinkedList<IntendedMeans> plansUnified;

    public Intention(){
        this.plansUnified = new LinkedList<>();
    }

    private IntendedMeans pollLast(){
        return plansUnified.pollLast();
    }

    public void push(IntendedMeans intendedMeans){
        this.plansUnified.add(intendedMeans);
    }

    public void executeIntention(String name, IntentionSet intentionSet, GlobalUncertainBelief beliefBase, EventSet eventSet, Environment environment) throws Exception {
        IntendedMeans intendedMeans = this.plansUnified.peekLast();
        boolean complete = false;
        boolean subGoalFlag = intendedMeans.executeAction(name,this, beliefBase, eventSet, environment);
        if (!subGoalFlag) {
            while(!this.plansUnified.getLast().actionsRemaining()) {
                if (this.plansUnified.size() == 1) {
                    complete = true;
                } else {
                    IntendedMeans top = this.pollLast();
//                    this.plansUnified.peekLast().getUnifier().putAll(top.getUnifier());
                }
                if (!this.plansUnified.peekLast().actionsRemaining()) {
                    System.out.println("Break out of intention while loop");
                    break;
                }
            }
            if (!complete) {
                intentionSet.add(this);
            }
        }
    }

    @Override
    public String toString() {
        LinkedList<IntendedMeans> intention = (LinkedList<IntendedMeans>) plansUnified.clone();
        StringBuilder string = new StringBuilder();
        for (int i=intention.size()-1; i>=0; i--) {
            if (intention.get(i) != plansUnified.getLast()) {
                string.append("\n\t");
            }
            Unifier unifier = intention.get(i).getUnifier();
            try {
                string.append(intention.get(i).getPlan().substitute(unifier).toString());
            } catch (Exception e) {
                //TODO: catch exception
            }
        }
//        for (IntendedMeans intendedMean : plansUnified) {
//            if (intendedMean != plansUnified.getFirst()) {
//                string.append("\n\t");
//            }
//            string.append("" + intendedMean.getPlan().toString());
//        }
        return string.toString();
    }

    public String toString(String prefix) {
        LinkedList<IntendedMeans> intention = (LinkedList<IntendedMeans>) plansUnified.clone();
        StringBuilder string = new StringBuilder();
        for (int i=intention.size()-1; i>=0; i--) {
            string.append(prefix);
            Unifier unifier = intention.get(i).getUnifier();
            try {
                string.append(intention.get(i).getPlan().substitute(unifier).toString());
            } catch (Exception e) {
                //TODO: catch exception
            }

        }
//        for (IntendedMeans intendedMean : plansUnified) {
//            if (intendedMean != plansUnified.getFirst()) {
//                string.append("\n\t");
//            }
//            string.append("" + intendedMean.getPlan().toString());
//        }
        return string.toString();
    }
}