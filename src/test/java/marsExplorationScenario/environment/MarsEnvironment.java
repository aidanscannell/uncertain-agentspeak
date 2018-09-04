package test.java.marsExplorationScenario.environment;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.environment.Environment;

import java.util.HashMap;
import java.util.List;

public class MarsEnvironment extends Environment {

    private int windowSize = 800;

    public MarsEnvironment(List args, List<Agent> agents) {
        this.agents = agents;
        agentList = new HashMap<>();
        for (Agent agent : agents) {
            agentList.put(agent.getName(),agent.getId());
        }
        init(args);
    }

    @Override
    public void init(List args) {
        if ((int) args.get(0) > 0 ) {
            initWorld((int) args.get(0));
        } else {
            //TODO: Initialise random world
//            model = new MarsModel((int) args.get(0), (int) args.get(1), (int) args.get(2), (int) args.get(3), (int) args.get(4));
        }
        stage = new MarsView(model, "Mars Exploration Scenario");
        stage.animate();
    }

    private void initWorld(int w) {
        try {
            switch (w) {
                case 1:
                    model = MarsWorldFactory.world1(agents);
                    break;
                case 2:
                    model = MarsWorldFactory.world2(agents);
                    break;
                case 4:
                    model = MarsWorldFactory.world4(agents);
                    break;
                default:
                    LOGGER.warn("Invalid index!");
                    return;
            }
            model.setAgentList(agentList);
//            stage = new MarsView(model, "Factory World " + w ,windowSize);
        } catch (Exception e) {
            LOGGER.warn("Error creating world " + e);
        }
    }

    @Override
    public synchronized boolean executeAction(String agentName, EnvironmentAction action) {
        MarsModel marsModel = (MarsModel) model;
        if (action.getFunctor().equals("travel")) {
            return marsModel.travel(agentName, action);
        } else if (action.getFunctor().equals("collectSampleWater")) {
            return marsModel.collectSampleWater(agentName, action);
        }
        return false;
    }
}
