package main.java.uncertain_agentspeak.mas;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.environment.Environment;

import java.util.ArrayList;
import java.util.Arrays;
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
        executor = Executors.newFixedThreadPool(agents.size());
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getName() {
        return name;
    }

    public void run() throws Exception {
        environment.run();


        List<Callable<String>> callableTasks = new ArrayList<>();
        for (Agent agent : agents) {
            Callable<String> callableTask = () -> {
                agent.run();
                return "Task's execution";
            };

            callableTasks.add(callableTask);
        }

        List<Future<String>> futures = executor.invokeAll(callableTasks);


    }

}
