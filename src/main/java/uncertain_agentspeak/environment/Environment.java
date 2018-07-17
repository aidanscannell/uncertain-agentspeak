package main.java.uncertain_agentspeak.environment;

import javafx.stage.Stage;
import main.java.uncertain_agentspeak.agentspeak.Action;
import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.environment.grid.Location;

import java.util.*;
import java.util.concurrent.*;

public class Environment {

    private List<LogicalExpression> percepts = Collections.synchronizedList(new ArrayList<LogicalExpression>());
    private Map<String, List<LogicalExpression>> agentPercepts = new ConcurrentHashMap<String, List<LogicalExpression>>();

    private boolean isRunning = true;
    protected ExecutorService executor;

    private Set<String> upToDateAgents = Collections.synchronizedSet(new HashSet<String>());

    private Stage stage;

    public Environment(int n) {
        executor = Executors.newFixedThreadPool(n); // creates a thread pool with n threads
    }

    public Environment() {
        executor = Executors.newFixedThreadPool(4);
    }

    public void run() {
        isRunning = true;
    }

    /** Overwritten by user environment. */
    public void init(Object[] args) {
    }

    public Stage getStage() {
        return stage;
    }

    public void stop() {
        isRunning = false;
        try {
            System.out.println("Attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("Tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("Shutdown finished");
        }

    }

    public boolean isRunning() {
        return isRunning;
    }

    public Collection<LogicalExpression> getPercepts(String agentName) {
        if (upToDateAgents.contains(agentName)) {
            return null;
        }

        upToDateAgents.add(agentName);

        int size = percepts.size();
        List<LogicalExpression> agl = agentPercepts.get(agentName);
        if (agl != null) {
            size += agl.size();
        }
        Collection<LogicalExpression> p = new ArrayList<LogicalExpression>(size);

        if (!percepts.isEmpty()) {
            synchronized (percepts) {
                p.addAll(percepts);
            }
        }
        if (agl != null) {
            synchronized (agl) {
                p.addAll(agl);
            }
        }
        return p;
    }

    public void addPercept(LogicalExpression... perceptions) {
        if (perceptions != null) {
            for (LogicalExpression per: perceptions) {
                if (! percepts.contains(per)) {
                    percepts.add(per);
                }
            }
            upToDateAgents.clear();
        }
    }

    public boolean removePercept(LogicalExpression per) {
        if (per != null) {
            upToDateAgents.clear();
            return percepts.remove(per);
        }
        return false;
    }




    public void scheduleAction(final String agentName, final Action action) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    boolean success = executeAction(agentName,action);
                            //send result to agent
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
    }


    public boolean executeAction(String agentName, Action action) {
        System.out.println("The action " + action + " done by "+agentName+" is not implemented in the default environment.");
        return false;
    }
}
