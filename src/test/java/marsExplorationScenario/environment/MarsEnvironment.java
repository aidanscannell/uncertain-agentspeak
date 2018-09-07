package test.java.marsExplorationScenario.environment;

import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.environment.grid.Position;
import main.java.uncertain_agentspeak.environment.ViewEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarsEnvironment extends Environment {


    public MarsView stage;
    protected MarsModel model;

    private int windowSize = 1000;

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
        model.setGridWorldView(stage);
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
        } catch (Exception e) {
            LOGGER.warn("Error creating world " + e);
        }
    }

    @Override
    public synchronized boolean executeAction(String agentName, EnvironmentAction action) throws Exception {
        boolean result = false;
        if (action.getFunctor().equals("travel")) {
            result = model.travel(agentName, action);
        } else if (action.getFunctor().equals("collectSample")) {
            result = model.collectSample(agentName, action);
            clearPercepts(agentName);
        }
        if (result) {
            updateAgentPercepts(agentName);
            return true;
        }
        return false;
    }

    public void updateAgentPercepts(String agentName) {
        Position position = model.agentPositions[agentList.get(agentName)];
        int locationNum = model.getLocation(position.x, position.y);
        Location location = model.locations[locationNum-1];
        for (int x=location.getX_min(); x<=location.getX_max(); x++) {
            for (int y=location.getY_min(); y<=location.getY_max(); y++) {
                updateAgentPercepts(agentName, x, y);
            }
        }
        if (model.agentsWithWater.contains(agentName)) {
            ArrayList<String> beliefUpdate = new ArrayList<>();
            beliefUpdate.add("*(carrying(water), 1)");
            addPercept(agentName,beliefUpdate);
        }
    }

    public void updateAgentPercepts(String agentName, int x, int y) {

        if (model.getGrid()[x][y] == model.WATER_OR_ICE) {
            ArrayList<String> beliefUpdate = new ArrayList<>();
            beliefUpdate.add("*(water_or_ice(location(" + x + "," + y + ")), 1).");
            addPercept(agentName,beliefUpdate);
        }
    }

    @Override
    public void addViewEventListener(ViewEventListener viewEventListener) {
        stage.addEventListener(viewEventListener);
    }
}
