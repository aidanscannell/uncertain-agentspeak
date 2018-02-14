package main.java;

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

    public void run() {

        while (!eventSet.isEmpty()) {

            Event event = eventSet.selectEvent();

            if (event != null) {

                /**
                 * Relevant Plans
                 * Unify plan triggers with event triggers
                 * */
                PlanLibrary relevantPlans = new PlanLibrary();
                for (Plan plan : planLibrary) {
                    if (event.getEventTrigger().getBeliefLiteral().isPositive() == plan.getEventTrigger().getBeliefLiteral().isPositive()) {
                        Unifier unifier = event.getTerm().unify(plan.getTerm());
                        if (unifier != null) {
                            relevantPlans.add(plan);
                        }
                    }
                }
                /**
                 * Applicable Plans
                 * Unify relevant plan context with beliefs
                 * */
                PlanLibrary applicablePlans = new PlanLibrary();
                for (Plan relevantPlan : relevantPlans) {
                    Context context = relevantPlan.getContext();

                    for (BeliefLiteral contextBelief : context){
                        for (BeliefLiteral belief : beliefBase) {
                            Unifier unifierApplicable = contextBelief.getTerm().unify(belief.getTerm());
                        }
                    }


                }


            }
        }

    }
}
