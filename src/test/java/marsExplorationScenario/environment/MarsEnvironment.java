package test.java.marsExplorationScenario.environment;

import javafx.application.Platform;
import javafx.stage.Stage;
import main.java.uncertain_agentspeak.agentspeak.*;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.GridWorldView;
import main.java.uncertain_agentspeak.environment.grid.Location;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;
import org.apache.log4j.Logger;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsEnvironment extends Environment {

    private Logger          logger   = Logger.getLogger("MarsEnvironment.mas2j." + MarsEnvironment.class.getName());

    private MarsModel model;
    private MarsView stage;

    private HashMap<String, Integer> agentList;

    private int numAgents;

    int windowSize = 800;

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
        stage = new MarsView(model, "Mars Exploration Scenario", windowSize);
        stage.animate();
    }

//    @Override
//    public void run() {
//        stage.animate();
//    }

    public void initWorld(int w) {
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
                    logger.warn("Invalid index!");
                    return;
            }
//            stage = new MarsView(model, "Factory World " + w ,windowSize);
        } catch (Exception e) {
            logger.warn("Error creating world "+e);
        }
    }

//    @Override
//    public void start() {
//        stage.animate();
//    }


    @Override
    public synchronized boolean executeAction(String agentName, EnvironmentAction action) {
        System.out.println("EXECUTE ACTION MARS");
        boolean result = false;

        int agentID = agentList.get(agentName);

        if (action.getFunctor().equals("travel")) {
            runAndWait( () -> {
                try {
                    model.travel(agentID, action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else if (action.getFunctor().equals("collectSampleWater")) {
            runAndWait( () -> {
                try {
                    model.collectSampleWater(agentID, action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        return result;
    }

    @Override
    public synchronized boolean scheduleAction(String agentName, EnvironmentAction action) {
        System.out.println("SCHEDULE action");
//        final boolean result;
//        Runnable runnable = () -> {
//            executeAction(agentName, action);
//        };
//        runAndWait(() -> {
//            executeAction(agentName, action);
//        });
        executeAction(agentName, action);
//        runAndWait(() -> {
//            executeAction(agentName, action);
//        });
        System.out.println("AFYTER RUN AND WAIT");
        return true;
        //TODO return true/false accordingly
    }

    public Stage getStage() {
        return stage;
    }

}
