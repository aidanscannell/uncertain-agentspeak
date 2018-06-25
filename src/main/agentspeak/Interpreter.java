package main.agentspeak;

import java.util.Deque;
import java.util.LinkedList;

public class Interpreter {

    private BeliefBase beliefBase;
    private EventSet eventSet;
    private PlanLibrary planLibrary;
    private IntentionSet intentionSet;

    public Interpreter(){
        this.beliefBase = new BeliefBase();
        this.eventSet = new EventSet();
        this.planLibrary = new PlanLibrary();
        this.intentionSet = new IntentionSet();
    }

    public void setBeliefBase(BeliefBase beliefBase) {
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

    public BeliefBase getBeliefBase() {
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

    public void run() {


        while (!eventSet.isEmpty() || !intentionSet.isEmpty()) {

            if (!eventSet.isEmpty()) {

                Event event = eventSet.selectEvent();
                System.out.println("Event selected:\n\t" + event.toString());

                if (event != null) {
                    IntendedMeans intendedMeans = selectPlan(event);
                    if (intendedMeans != null) {
                        System.out.println("\nPlan selected:\n\t" + intendedMeans.getPlan().toString());
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

    private IntendedMeans selectPlan(Event event) {
        Deque<IntendedMeans> relevantPlans = selectRelevantPlans(event);
        if (!relevantPlans.isEmpty()) {
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
            if (event.getEventTrigger().getBeliefGoal().getBelief() != null) {
                if (event.getEventTrigger().getBeliefGoal().getBelief().isPositive() == plan.getEventTrigger().getEventTrigger().getBeliefGoal().getBelief().isPositive()) {
                    Unifier unifier = event.getTerm().unify(plan.getTerm());
                    if (unifier != null) {
                        relevantPlans.add(new IntendedMeans(plan, unifier));
                    }
                }
            }
        }
        return relevantPlans;
    }

    private Deque<IntendedMeans> selectApplicablePlans(Deque<IntendedMeans> relevantPlans) {
        Deque<IntendedMeans> applicablePlans = new LinkedList<>();
        Deque<IntendedMeans> relevantPlansCopy = new LinkedList<>(relevantPlans); // copy relevant plans
        while(!relevantPlansCopy.isEmpty()) {
            IntendedMeans relevantPlan = relevantPlansCopy.pop();
            Context context = relevantPlan.getPlan().getContext(); // get context of current plan
            if (!context.isEmpty()) {
                Unifier applicableUnifier = unifyPlanContext(context, context, relevantPlan.getUnifier());
                if (applicableUnifier != null) {
                    applicablePlans.add(new IntendedMeans(relevantPlan.getPlan(),applicableUnifier));
                }
            } else {
                applicablePlans.add(relevantPlan); // add relevant plans with context "true"
            }
        }
        return applicablePlans;
    }

    private Unifier unifyPlanContext(Context contextOriginal, Context contextRemaining, Unifier unifier) {

        // make a copy of the unifier
        Unifier unifierOriginal = unifier.copy();

        // make a copy of the remaining context beliefs
        Context remaining = contextRemaining.copy();

        if (remaining.isEmpty()){
            return unifierOriginal;
        } else {

            ContextBelief contextBelief = remaining.pop();

//            // loop through beliefs in belief base
//            for (Belief belief : beliefBase) {
//
//                // check that context belief and belief from belief base are either both positive or negative
//                if (contextBelief.getBelief().isPositive() == belief.isPositive()) {
//
//                    // unify context belief and belief from belief base given the relevant unifier
//                    Unifier unifierPossible = contextBelief.getBelief().getTerm().unify(belief.getTerm(), unifierOriginal);
//
//                    // if the context belief unifies with the belief from belief base
//                    if (unifierPossible != null) {
//
//                        // attempt to unify the rest of the context with this unifier
//                        unifierPossible = unifyPlanContext(contextOriginal, remaining, unifierPossible);
//
//                        // if it unifies then return it
//                        if (unifierPossible != null) {
//                            return unifierPossible;
//                        }
//                    }
//                }
//            }
        }
        return null;
    }
}