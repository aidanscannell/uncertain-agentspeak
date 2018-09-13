package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.actions.belief_actions.ReviseBeliefAction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.environment.EnvironmentEvent;
import main.java.uncertain_agentspeak.environment.EnvironmentEventListener;
import main.java.uncertain_agentspeak.ui.agent_console.AgentEvent;
import main.java.uncertain_agentspeak.ui.agent_console.AgentEventListener;
import main.java.uncertain_agentspeak.environment.ViewEventListener;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.resources.antlr.as_parser.AgentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.*;
import java.sql.Timestamp;

public class Agent implements EnvironmentEventListener, ViewEventListener {

    private Logger LOGGER = LogManager.getLogger("Agent");

    private final AgentParser parser = new AgentParser();

    private GlobalUncertainBelief beliefBase;
    private EventSet eventSet;
    private PlanLibrary planLibrary;
    private IntentionSet intentionSet;
    private Environment environment;
    private String name;
    private int id;
    private boolean isRunning;

    private AgentEventListener listener;

    public Agent(){
        this.beliefBase = new BeliefBase();
        this.eventSet = new EventSet();
        this.planLibrary = new PlanLibrary();
        this.intentionSet = new IntentionSet();
        isRunning = true;
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
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRunning(boolean running) {
        isRunning = running;
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

    /** Revise agents belief base based on environmental perceptions */
    public void reviseBelief(String input) {
        ReviseBeliefAction reviseBeliefAction = parser.parseAction(input);
        try {
            reviseBeliefAction.executeAction(name, new Intention(), new Unifier(), beliefBase, eventSet, environment);
            LOGGER.info("Successfully revised GUB for ReviseBeliefAction with input: " + input);
        } catch (Exception e) {
            LOGGER.warn("Error revising GUB for ReviseBeliefAction with input: " + input);

            try {
                HashSet<BeliefAtom> domain = new HashSet<>();
                domain.add(reviseBeliefAction.getBeliefLiteral().getBeliefAtom());
                CompactEpistemicState epistemicState = new CompactEpistemicState(domain);
                beliefBase.addEpistemicState(epistemicState);
                reviseBeliefAction.executeAction(name, new Intention(), new Unifier(), beliefBase, eventSet, environment);
                LOGGER.info("Successfully added new epistemic state and revised GUB with input: " + input);
            } catch (Exception e1) {
                LOGGER.warn("Error adding/revising GUB with input: " + input);
            }
        }

    }

    /** Agents main method - acting as it's interpreter */
    public void run() {

        ThreadContext.put("logFilename",name);
//        System.out.println(beliefBase.toString());

        while ((!eventSet.isEmpty() || !intentionSet.isEmpty()) && isRunning == true) {

            System.out.println(beliefBase.toString());

            try { Thread.sleep(1000); } catch (Exception e) {}

            if (!eventSet.isEmpty()) {

                Event event = selectEvent();
                LOGGER.info("Event selected: \n\t" + event.toString());
                notifyListener("Event selected: \n\t" + event.toString());

                if (event != null) {
                    try {
                        IntendedMeans intendedMeans = selectPlan(event);
                        if (intendedMeans != null) {
                            LOGGER.info("Plan selected: \n\t" + intendedMeans.getPlan().toString() + "     " + intendedMeans.getUnifier().toString());
                            notifyListener("Plan selected: \n\t" + intendedMeans.getPlan().substitute(intendedMeans.getUnifier()).toString());
                            intentionSet.addIntention(event, intendedMeans);
                            LOGGER.info("Intention added: \n\t" + intentionSet.peekLast().toString());
                            //TODO: peeking at correct intention??
                            notifyListener("Intention added: \n\t" + intentionSet.peekLast().toString());
                        }
                    } catch (Exception e) {
                        LOGGER.error("Error selecting plan: " + e);
                    }


                }
            }

            if (!intentionSet.isEmpty()) {

                notifyListener("Intention set: " + intentionSet.toString());
                LOGGER.info("Intention set: " + intentionSet.toString());
                Intention intention = selectIntention();
                LOGGER.info("Intention selected: \n\t" + intention.toString());
                notifyListener("Intention selected: \n\t" + intention.toString());

                if (intention != null) {
                    try {
                        intention.executeIntention(name, intentionSet, beliefBase, eventSet, environment);
                        LOGGER.info("Intention executed");
                        notifyListener("Intention executed");
                    } catch (Exception e) {
                            LOGGER.error("Error executing intention: " + e);
                    }

                }
            }
        }
    }

    /** AgentSpeak(L) selection functions */
    protected Event selectEvent(){
        return eventSet.poll();
    }

    private IntendedMeans selectOption(Deque<IntendedMeans> applicablePlans) {
        return applicablePlans.peekFirst();
    }

    public Intention selectIntention(){
        return intentionSet.pollLast();
    }

    /** Methos for selecting relevant and applicable plans */
    private IntendedMeans selectPlan(Event event) throws Exception {
        Deque<IntendedMeans> relevantPlans = selectRelevantPlans(event);
        if (!relevantPlans.isEmpty()) {
            LOGGER.info(relevantPlansToString(relevantPlans));
            notifyListener(relevantPlansToString(relevantPlans));
            Deque<IntendedMeans> applicablePlans = selectApplicablePlans(relevantPlans);
            if (!applicablePlans.isEmpty()) {
                LOGGER.info(appliablePlansToString(applicablePlans));
                notifyListener(appliablePlansToString(applicablePlans));
                return selectOption(applicablePlans);
            }
        }
        return null;
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
//                Unifier applicableUnifier = this.getBeliefBase().entails(context.substitute(relevantPlan.getUnifier()));
//                System.out.println("Unifier: " + applicableUnifier.toString());
                if (applicableUnifier != null) {
                    applicablePlans.add(new IntendedMeans(relevantPlan.getPlan(),applicableUnifier));
                }
            }
        }
        return applicablePlans;
    }

    /** toString methods */
    private String appliablePlansToString(Deque<IntendedMeans> applicablePlans) {
        String applicablePlansString = "Applicable Plans:";
        for (IntendedMeans plan : applicablePlans) {
            Unifier unifier = plan.getUnifier();
            try {
                applicablePlansString += "\n\t" + plan.getPlan().substitute(unifier).toString();
            } catch (Exception e) {
                LOGGER.warn("Error substituting unifier into plan context whilst creating applicable plan string: " + e);
            }
        }
        return applicablePlansString;
    }

    private String relevantPlansToString(Deque<IntendedMeans> relevantPlans) {
        String applicablePlansString = "Relevant Plans:";
        for (IntendedMeans plan : relevantPlans) {
            Unifier unifier = plan.getUnifier();
            try {
                applicablePlansString += "\n\t" + plan.getPlan().substitute(unifier).toString();
            } catch (Exception e) {
                LOGGER.warn("Error substituting unifier into plan context whilst creating relevant plan string: " + e);
            }
        }
        return applicablePlansString;
    }

    /** Handle event from environment (percepts) */
    @Override
    public void handleEnvEvent(EnvironmentEvent environmentEvent) {
        LOGGER.info("Agent perceived: " + environmentEvent.getAgentPercepts().toString());
        if (environmentEvent.getAgentPercepts() != null) {
            for (String belief : environmentEvent.getAgentPercepts()) {
                reviseBelief(belief);
            }
        }
    }

    /** Handle event from GUI (GridWorldView) when user wants to stop running */
    @Override
    public void handleEvent(EventObject event) {
        isRunning = false;
    }

    public void notifyListener(String text) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        AgentEvent event = new AgentEvent(this, text, timestamp);
        AgentEventListener interested = listener;
        interested.handleEvent(event);
    }

    public void addAgentEventListener(AgentEventListener listener) {
        this.listener = listener;
    }

}