package main.java.uncertain_agentspeak.ui.agent_console;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import main.java.uncertain_agentspeak.agentspeak.Agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AgentConsole extends Stage {

    private Map<String,AgentTab> agentTabs;
    private ArrayList<Agent> agents;

    public AgentConsole(ArrayList<Agent> agents){
        this.agents = agents;
        this.setTitle("Agent Console");

        TabPane tabPane = addTabPane();
        VBox layout = new VBox(10,tabPane);
        layout.setPadding(new Insets(10));

        Group root = new Group();
        root.getChildren().add(layout);
        Scene scene = new Scene(root,1300, 400);
        this.setScene(scene);
        this.sizeToScene();
        this.show();
    }

    public AgentTab getAgentTabs(String agentName) {
        return agentTabs.get(agentName);
    }

    public TabPane addTabPane() {
        agentTabs = new HashMap<>();
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(1280, 400);
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        for (Agent agent : agents) {
            AgentTab tab = new AgentTab(agent.getName());
            agentTabs.put(agent.getName(),tab);
            tabPane.getTabs().add(tab);
        }
        return tabPane;
    }

}
