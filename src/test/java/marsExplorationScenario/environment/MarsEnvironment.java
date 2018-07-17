package test.java.marsExplorationScenario.environment;

import javafx.stage.Stage;
import main.java.uncertain_agentspeak.agentspeak.Action;
import main.java.uncertain_agentspeak.agentspeak.EventSet;
import main.java.uncertain_agentspeak.agentspeak.Intention;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.GridWorldView;
import main.java.uncertain_agentspeak.uncertainty.GlobalUncertainBelief;

import java.util.ArrayList;
import java.util.List;

public class MarsEnvironment extends Environment {

    private MarsModel model;
    private GridWorldView stage;

    public MarsEnvironment(List args) {
        super((int) args.get(3));
        model = new MarsModel((int) args.get(0), (int) args.get(1), (int) args.get(2), (int) args.get(3));
        stage = new MarsView(model, "Mars Exploration Scenario", (int) args.get(3));
    }

//    @Override
    public void run() {
        stage.animate();
    }

//    @Override
    public boolean executeAction(Intention intention, Unifier unifier, GlobalUncertainBelief beliefBase, EventSet eventSet) {
        return false;
    }

    public Stage getStage() {
        return stage;
    }

}
