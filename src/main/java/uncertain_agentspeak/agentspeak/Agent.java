package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.Deque;
import java.util.LinkedList;

public class Agent {

    private Logger LOGGER = Logger.getLogger("Agent");

    private GlobalUncertainBelief beliefBase;
    private EventSet eventSet;
    private PlanLibrary planLibrary;
    private IntentionSet intentionSet;
    private Environment environment;
    private String name;
    private int id;

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

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setName(String name) {
        this.name = name;
//        LOGGER = LogManager.getLogger(name);
//        ThreadContext.put("logFilename",name);
//        Thread.currentThread().setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public GlobalUncertainBelief getBeliefBase() {
        return beliefBase;
    }

    public EventSet getEventSet() {
        return eventSet;
    }

    public PlanLibrary getPlanLibrary() {
        return planLibrary;
    }

    public IntentionSet getIntentionSet() {
        return intentionSet;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void run() throws Exception {

        ThreadContext.put("logFilename",name);

        while (!eventSet.isEmpty() || !intentionSet.isEmpty()) {

            try { Thread.sleep(1000); } catch (Exception e) {}

            if (!eventSet.isEmpty()) {

                Event event = eventSet.selectEvent();
                LOGGER.info("Event selected: " + event.toString());

                if (event != null) {
                    IntendedMeans intendedMeans = selectPlan(event);
                    if (intendedMeans != null) {
                        LOGGER.info("Plan selected: " + intendedMeans.getPlan().toString() + "     " + intendedMeans.getUnifier().toString());
                        intentionSet.addIntention(event, intendedMeans);
                        LOGGER.info("Intention added: " + intentionSet.toString());
                    }
                }
            }

            if (!intentionSet.isEmpty()) {

                Intention intention = intentionSet.selectIntention();
                LOGGER.info("Intention selected: " + intention.toString());

                if (intention != null) {
                    intention.executeIntention(name, intentionSet, beliefBase, eventSet, environment);
                    LOGGER.info("Intention executed");
                }
            }
        }
    }

    private IntendedMeans selectPlan(Event event) throws Exception {
        Deque<IntendedMeans> relevantPlans = selectRelevantPlans(event);
        if (!relevantPlans.isEmpty()) {
            LOGGER.info("First Relevant Plan: " + relevantPlans.getFirst().getPlan().toString());
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
            Unifier unifier = event.getEventTrigger().unify(plan.getEventTrigger());
            if (unifier != null) {
                relevantPlans.add(new IntendedMeans(plan, unifier));
            }
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
                }
            }
        }
        return applicablePlans;
    }

}