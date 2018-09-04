package main.java.uncertain_agentspeak.environment;

import javafx.application.Platform;
import javafx.stage.Stage;
import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.GridWorldView;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import test.java.marsExplorationScenario.environment.MarsModel;
import test.java.marsExplorationScenario.environment.MarsView;

import java.util.*;
import java.util.concurrent.*;

public class Environment {

    protected Logger LOGGER = Logger.getLogger("Environment");

    protected GridWorldModel model;
    protected GridWorldView stage;

    private List<LogicalExpression> percepts = Collections.synchronizedList(new ArrayList<>());
    private Map<String, List<LogicalExpression>> agentPercepts = new ConcurrentHashMap<>();

    protected int numAgents;
    protected List<Agent> agents;
    protected HashMap<String, Integer> agentList;

    private Set<String> upToDateAgents = Collections.synchronizedSet(new HashSet<>());

//    private Stage stage;

    public Environment() {
//        executor = Executors.newFixedThreadPool(4);
    }

    public Environment(List args, List<Agent> agents) {
//        executor = Executors.newFixedThreadPool(4);
        this.agents = agents;
        init(args);
    }

    /** Overwritten by user environment. */
    public void init(List args) {
    }

    public boolean scheduleAction(String agentName, EnvironmentAction action) {
        LOGGER.info("Agent " + agentName + ", scheduling action: " + action.toString());

        runAndWait( () -> {
            try {
                ThreadContext.put("logFilename",agentName);
                LOGGER.info("Agent " + agentName + ", executing " + action.toString() + " on MarsEnvironment.");
                executeAction(agentName, action);
                LOGGER.info("Environment action executed: " + action.toString());
            } catch (Exception e) {
                LOGGER.error("Error executing environment action: " + action.toString() + ". Error: " + e.toString());
//                e.printStackTrace();
            }
            ThreadContext.put("logFilename","Main");
        });
        return true;
        //TODO return true/false accordingly
    }

    public synchronized boolean executeAction(String agentName, EnvironmentAction action) {
        LOGGER.info("environment action from schedule action: " + action.toString());
        LOGGER.info("The action " + action + " done by " + agentName + " is not implemented in the default environment.");
        return false;
    }

    public static void runAndWait(Runnable action) {
        if (action == null) {
            throw new NullPointerException("action");
        }
        // run synchronously on JavaFX thread
        if (Platform.isFxApplicationThread()) {
            action.run();
            return;
        }
        // queue on JavaFX thread and wait for completion
        final CountDownLatch doneLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                action.run();
            } finally {
                doneLatch.countDown();
            }
        });
        try {
            doneLatch.await();
        } catch (InterruptedException e) {
            // ignore exception
        }
    }


//    public Collection<LogicalExpression> getPercepts(String agentName) {
//        if (upToDateAgents.contains(agentName)) {
//            return null;
//        }
//
//        upToDateAgents.add(agentName);
//
//        int size = percepts.size();
//        List<LogicalExpression> agl = agentPercepts.get(agentName);
//        if (agl != null) {
//            size += agl.size();
//        }
//        Collection<LogicalExpression> p = new ArrayList<>(size);
//
//        if (!percepts.isEmpty()) {
//            synchronized (percepts) {
//                p.addAll(percepts);
//            }
//        }
//        if (agl != null) {
//            synchronized (agl) {
//                p.addAll(agl);
//            }
//        }
//        return p;
//    }

//    public void addPercept(LogicalExpression... perceptions) {
//        if (perceptions != null) {
//            for (LogicalExpression per: perceptions) {
//                if (! percepts.contains(per)) {
//                    percepts.add(per);
//                }
//            }
//            upToDateAgents.clear();
//        }
//    }

//    public boolean removePercept(LogicalExpression per) {
//        if (per != null) {
//            upToDateAgents.clear();
//            return percepts.remove(per);
//        }
//        return false;
//    }
}
