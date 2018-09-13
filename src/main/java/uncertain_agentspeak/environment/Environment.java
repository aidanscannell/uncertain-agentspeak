package main.java.uncertain_agentspeak.environment;

import javafx.application.Platform;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.*;
import java.util.concurrent.*;

public class Environment {

    protected Logger LOGGER = LogManager.getLogger("Environment");

//    private List<String> perceptsAllAgents = Collections.synchronizedList(new ArrayList<>());
    private Map<String, ArrayList<String>> agentPercepts = new ConcurrentHashMap<>();

//    protected int numAgents;
    protected List<Agent> agents;
    protected HashMap<String, Integer> agentList;

    private Set<String> upToDateAgents = Collections.synchronizedSet(new HashSet<>());

    private EnvironmentEventListener[] listeners;

    public Environment() {
    }

    public Environment(List args, List<Agent> agents) {
        this.agents = agents;
        init(args);
    }

    /** Overwritten by user environment. */
    public void init(List args) {
    }

    public Map<String, ArrayList<String>> getAgentPercepts() {
        return agentPercepts;
    }

    public boolean scheduleAction(String agentName, EnvironmentAction action) {
        LOGGER.info("Agent " + agentName + ", scheduling action: " + action.toString());

        System.out.println("Agent percepts start: " + agentPercepts.toString());

        runAndWait( () -> {
            try {
                ThreadContext.put("logFilename",agentName);
                LOGGER.info("Agent " + agentName + ", executing " + action.toString() + " on Environment.");
                if (executeAction(agentName, action)) {
                    LOGGER.info("Environment action executed: " + action.toString());
                } else {
                    LOGGER.info("Error executing environment action: " + action.toString());
                }
            } catch (Exception e) {
                LOGGER.error("Error executing environment action: " + action.toString() + ". Error: " + e.toString());
                e.printStackTrace();
            }
            notifyListener(agentName);
            ThreadContext.put("logFilename","Main");
        });
        System.out.println("Agent percepts end: " + agentPercepts.toString());
        return true;
        //TODO return true/false accordingly
    }

    public synchronized boolean executeAction(String agentName, EnvironmentAction action) throws Exception {
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

//    public void notifyListeners(Environment env) {
//        EnvironmentEvent event = new EnvironmentEvent(this, agentPercepts.g, perceptsAllAgents);
//        EnvironmentEventListener interested[] = listeners;
//        for (int i = 0; i < interested.length; i++)
//            interested[i].handleEnvEvent(event);
//    }

    public void notifyListener(String agentName) {
        if (agentPercepts.containsKey(agentName) && !upToDateAgents.contains(agentName)) {
            upToDateAgents.add(agentName);
            EnvironmentEvent event = new EnvironmentEvent(this, agentPercepts.get(agentName));
            EnvironmentEventListener interested[] = listeners;
            int i = agentList.get(agentName);
            interested[i].handleEnvEvent(event);
        }
        clearPercepts(agentName);
    }

    public void addEnvEventListener(EnvironmentEventListener listener) {
        if (listeners == null) {
            listeners = new EnvironmentEventListener[] { listener };
        } else {
            EnvironmentEventListener results[] = new EnvironmentEventListener[listeners.length + 1];
            for (int i = 0; i < listeners.length; i++)
                results[i] = listeners[i];
            results[listeners.length] = listener;
            listeners = results;
        }
    }


    /** Override in users evnironment to enable MASProject to listen for events from GUI (stage) */
    public void addViewEventListener(ViewEventListener viewEventListener) {
    }

//    /** Return percepts for a given agent */
//    public ArrayList<String> getPercepts(String agentName) {
//        if (upToDateAgents.contains(agentName)) {
//            return null;
//        }
//        upToDateAgents.add(agentName);
//        int size = perceptsAllAgents.size();
//        ArrayList<String> agPercepts = agentPercepts.get(agentName);
//        if (agPercepts != null) {
//            size += agPercepts.size();
//        }
//        ArrayList<String> p = new ArrayList<>(size);
//
//        if (!perceptsAllAgents.isEmpty()) {
//            synchronized (perceptsAllAgents) {
//                p.addAll(perceptsAllAgents);
//            }
//        }
//        if (agPercepts != null) {
//            synchronized (agPercepts) {
//                p.addAll(agPercepts);
//            }
//        }
//        return p;
//    }

//    /** Add percept for every agent */
//    public void addPercept(ArrayList<String> percepts) {
//        if (percepts != null) {
//            for (String percept : percepts) {
//                if (!perceptsAllAgents.contains(percept)) {
//                    perceptsAllAgents.add(percept);
//                }
//            }
//            upToDateAgents.clear();
//        }
//    }
//
//    /** Remove percept for all agents */
//    public boolean removePercept(ArrayList<String> percepts) {
//        boolean success = false;
//        if (percepts != null) {
//            upToDateAgents.clear();
//            for (String percept : percepts) {
//                if (perceptsAllAgents.contains(percept)) {
//                    perceptsAllAgents.remove(percept);
//                    success = true;
//                }
//            }
//        }
//        return success;
//    }

    /** Add percept for single agent */
    public void addPercept(String agentName, ArrayList<String> percepts) {
        System.out.println("Adding percept: " + percepts);
        if (percepts != null && agentList.containsKey(agentName)) {
            System.out.println("Inside if statement");
            ArrayList<String> agentPerceptsOld = agentPercepts.get(agentName);
            System.out.println("old percepts: " + agentPerceptsOld);
            if (agentPerceptsOld != null) {
                percepts.addAll(agentPerceptsOld);
            }

            System.out.println("old + new percepts: " + percepts);
            agentPercepts.put(agentName, percepts);
            System.out.println("added");
            upToDateAgents.remove(agentName);
//            for (String percept: percepts) {
//                if (!perceptsAllAgents.contains(percept)) {
//                    upToDateAgents.remove(agentName);
//                    perceptsAllAgents.add(percept);
//                }
//            }
        }
    }

    /** Remove percept for single agent */
    public void removePercept(String agentName, ArrayList<String> percepts) {
        if (percepts != null && agentList.containsKey(agentName) && agentPercepts.containsValue(percepts)) {
            agentPercepts.remove(agentName, percepts);
            upToDateAgents.remove(agentName);
        }
    }

    /** Clear all agents percepts */
    public void clearPercepts() {
        if (!agentPercepts.isEmpty()) {
            upToDateAgents.clear();
            agentPercepts.clear();
        }
    }

    /** Clear all of one agents percepts */
    public void clearPercepts(String agentName) {
        System.out.println("attempting to clear percepts for : " + agentName);
        System.out.println("agentpercepts: " + agentPercepts);
        if (agentPercepts.containsKey(agentName)) {
            System.out.println("inside clear if");
            System.out.println(agentPercepts);
            upToDateAgents.remove(agentName);
            agentPercepts.remove(agentName);
            System.out.println(agentPercepts);
        }
    }
}
