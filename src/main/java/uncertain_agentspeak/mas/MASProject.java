package main.java.uncertain_agentspeak.mas;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.environment.Environment;

import java.util.List;

public class MASProject {

    private List<Agent> agents;
    private Environment environment;

    public MASProject(List<Agent> agents, Environment environment) {
        this.agents = agents;
        this.environment = environment;
    }

}
