package main.java.uncertain_agentspeak.mas;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.environment.Environment;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MASProject {

    private Logger LOGGER = Logger.getLogger("MAS Project");

    private String name;
    private List<Agent> agents;
    private Environment environment;

    private ExecutorService executor;

    public MASProject(String name, List<Agent> agents, Environment environment) {
        ThreadContext.put("logFilename","Main");
        LOGGER.info("Initialising MAS Project");
        this.name = name;
        this.agents = agents;
        this.environment = environment;
        executor = Executors.newFixedThreadPool(agents.size()+1);
        LOGGER.info("Successfully initialised MAS Project");
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
            LOGGER.error("Error whilst running agents: " + e);
//            e.printStackTrace();
        }

        stop();

    }

    public void stop() {
        try {
            LOGGER.info("Attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            LOGGER.info("Tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                LOGGER.error("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            LOGGER.info("Shutdown finished");
        }
    }

}
