package main.java.uncertain_agentspeak.mas;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MASProject {

    private String name;
    private List<Agent> agents;
    private Environment environment;

    private ExecutorService executor;

    public MASProject(String name, List<Agent> agents, Environment environment) {
        this.name = name;
        this.agents = agents;
        this.environment = environment;
        executor = Executors.newFixedThreadPool(agents.size()+1);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getName() {
        return name;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void run() {

        List<Callable<String>> callableTasks = new ArrayList<>();

        for (Agent agent : agents) {

            agent.setEnvironment(environment);

            Callable<String> callableTask = () -> {
                agent.run();
                return "Task's execution";
            };

            callableTasks.add(callableTask);
        }

        try {
            List<Future<String>> futures = executor.invokeAll(callableTasks);
        } catch (Exception e) {
            e.printStackTrace();
        }

        stop();

    }

    public void stop() {
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

}
