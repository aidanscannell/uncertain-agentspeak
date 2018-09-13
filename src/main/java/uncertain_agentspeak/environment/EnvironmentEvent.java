package main.java.uncertain_agentspeak.environment;

import java.lang.String;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.numbers.DoubleNum;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Map;

public class EnvironmentEvent extends EventObject {

    private Map<String, DoubleNum> perceptsAllAgents;
    private ArrayList<String> agentPercepts;
    private Environment environment;

    public EnvironmentEvent(Object source, Environment environment, ArrayList<String> agentPercepts, Map<String, DoubleNum> perceptsAllAgents) {
        super(source);
        this.environment = environment;
        this.agentPercepts = agentPercepts;
        this.perceptsAllAgents = perceptsAllAgents;
    }

    public EnvironmentEvent(Object source, ArrayList<String> agentPercepts, Map<String, DoubleNum> perceptsAllAgents) {
        super(source);
        this.agentPercepts = agentPercepts;
        this.perceptsAllAgents = perceptsAllAgents;
    }

    public EnvironmentEvent(Object source, ArrayList<String> agentPercepts) {
        super(source);
        this.agentPercepts = agentPercepts;
    }

    public Map<String, DoubleNum> getPerceptsAllAgents() {
        return perceptsAllAgents;
    }

    public ArrayList<String> getAgentPercepts() {
        return agentPercepts;
    }
}
