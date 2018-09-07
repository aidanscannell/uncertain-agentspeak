package main.java.uncertain_agentspeak.mas;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.environment.Environment;

import main.java.uncertain_agentspeak.environment.ViewEventListener;
import main.java.uncertain_agentspeak.ui.agent_console.AgentConsole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.*;

public class MASProject implements ViewEventListener {

    private Logger LOGGER = LogManager.getLogger("MAS Project");

    private String name;
    private List<Agent> agents;
    private Environment environment;
    private AgentConsole agentConsole;

    private ExecutorService executor;

    public MASProject(String name, ArrayList<Agent> agents, Environment environment) {
        ThreadContext.put("logFilename","Main");
        LOGGER.info("Initialising MAS Project");
        this.name = name;
        this.agents = agents;
        this.environment = environment;
        this.agentConsole = new AgentConsole(agents);
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

        environment.addViewEventListener(this);
        executor = Executors.newFixedThreadPool(agents.size()+1);
        for (Agent agent : agents) {
            environment.addEnvEventListener(agent);
            environment.addViewEventListener(agent);
            agent.setEnvironment(environment);
            agent.addAgentEventListener(this.agentConsole.getAgentTabs(agent.getName()));
        }

        Collection<Callable<String>> callables = new ArrayList<>();

        /** Create callable's for each agent*/
        for (Agent agent : agents) {
            Callable callable = () -> {
                agent.run();
                return "Complete execution";
            };
            callables.add(callable);
        }

        try {
            List<Future<String>> futures = executor.invokeAll(callables);
        } catch (Exception e) {
            LOGGER.error("Error whilst running agents: " + e);
//            e.printStackTrace();
        }

        stop();

    }

    public void stop() {
        ThreadContext.put("logFilename","Main");
        try {
            LOGGER.info("Attempt to shutdown MASProject executor");
            executor.shutdown();
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
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

    @Override
    public void handleEvent(EventObject event) {
        System.out.println("Shutting down project...");
        stop();
    }
}
