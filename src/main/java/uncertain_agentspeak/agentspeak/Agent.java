package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

import java.util.Deque;
import java.util.LinkedList;

public class Agent {

    private GlobalUncertainBelief beliefBase;
    private EventSet eventSet;
    private PlanLibrary planLibrary;
    private IntentionSet intentionSet;

    public Agent(){
        this.beliefBase = new BeliefBase();
        this.eventSet = new EventSet();
        this.planLibrary = new PlanLibrary();
        this.intentionSet = new IntentionSet();
    }

    public void setBeliefBase(GlobalUncertainBelief beliefBase) {
        this.beliefBase = beliefBase;
    }

    public void setEventSet(EventSet eventSet) {
        this.eventSet = eventSet;
    }

    public void setPlanLibrary(PlanLibrary planLibrary) {
        this.planLibrary = planLibrary;
    }

    public void setIntentionSet(IntentionSet intentionSet) {
        this.intentionSet = intentionSet;
    }

    public GlobalUncertainBelief getBeliefBase() {
        return beliefBase;
    }

    public EventSet getEventSet() {
        return eventSet;
    }

    public IntentionSet getIntentionSet() {
        return intentionSet;
    }

    public PlanLibrary getPlanLibrary() {
        return planLibrary;
    }

    public void run() throws Exception {


        while (!eventSet.isEmpty() || !intentionSet.isEmpty()) {

            if (!eventSet.isEmpty()) {

                Event event = eventSet.selectEvent();
                System.out.println("\nEvent selected:\n\t" + event.toString());

                if (event != null) {
                    IntendedMeans intendedMeans = selectPlan(event);
                    if (intendedMeans != null) {
                        System.out.println("\nPlan selected:\n\t" + intendedMeans.getPlan().toString());
                        System.out.println("\t" + intendedMeans.getUnifier().toString());
                        intentionSet.addIntention(event, intendedMeans);
                        System.out.println("\nIntention added\n\t" + intentionSet.toString());
                    }
                }
            }

            if (!intentionSet.isEmpty()) {

                Intention intention = intentionSet.selectIntention();
                System.out.println("\nIntention selected:\n\t" + intention.toString() + "\n");

                if (intention != null) {
                    intention.executeIntention(intentionSet, beliefBase, eventSet);
                    System.out.println("\nIntention executed");
                }
            }
        }
    }

    private IntendedMeans selectPlan(Event event) throws Exception {
        Deque<IntendedMeans> relevantPlans = selectRelevantPlans(event);
        if (!relevantPlans.isEmpty()) {
            System.out.println("\nFirst Relevant Plan:");
            System.out.println(relevantPlans.getFirst().getPlan().toString());
            Deque<IntendedMeans> applicablePlans = selectApplicablePlans(relevantPlans);
            if (!applicablePlans.isEmpty()) {
                return selectPlan(applicablePlans);
            }
        }
        return null;
    }

    private IntendedMeans selectPlan(Deque<IntendedMeans> applicablePlans) {
        return applicablePlans.peekFirst();
    }

    private Deque<IntendedMeans> selectRelevantPlans(Event event) {
        Deque<IntendedMeans> relevantPlans = new LinkedList<>();
        for (Plan plan : planLibrary) {
//            if (event.getEventTrigger().getBeliefGoal().getBelief() != null) {
//                if (event.getEventTrigger().getBeliefGoal().getBelief().isPositive() == plan.getEventTrigger().getEventTrigger().getBeliefGoal().getBelief().isPositive()) {
                    Unifier unifier = event.getEventTrigger().unify(plan.getEventTrigger());
                    if (unifier != null) {
                        relevantPlans.add(new IntendedMeans(plan, unifier));
                    }
//                }
//            }
        }
        return relevantPlans;
    }

    private Deque<IntendedMeans> selectApplicablePlans(Deque<IntendedMeans> relevantPlans) throws Exception {
        Deque<IntendedMeans> applicablePlans = new LinkedList<>();
        Deque<IntendedMeans> relevantPlansCopy = new LinkedList<>(relevantPlans); // copy relevant plans
        while(!relevantPlansCopy.isEmpty()) {
            IntendedMeans relevantPlan = relevantPlansCopy.pop();
            LogicalExpression context = relevantPlan.getPlan().getContext(); // get context of current plan
            if (context != null) {
                Unifier applicableUnifier = this.getBeliefBase().entails(context, relevantPlan.getUnifier());
                if (applicableUnifier != null) {
                    applicablePlans.add(new IntendedMeans(relevantPlan.getPlan(),applicableUnifier));
//                    System.out.println("Applicable plan");
//                    System.out.println(applicablePlans.getFirst().getPlan().toString());
                }
            }
        }
        return applicablePlans;
    }

}