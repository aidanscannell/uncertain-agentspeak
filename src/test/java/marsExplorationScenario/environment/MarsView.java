package test.java.marsExplorationScenario.environment;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.GridWorldView;

public class MarsView extends GridWorldView {

    protected static GridWorldModel model;

    public MarsView(GridWorldModel model, String title) {
        super(model, title, 800);
        this.model = model;
    }

    private class Sample_A extends Cell {

        public Sample_A(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(color);
            r1.setFill(color);
            getChildren().add(r1);
            super.name = name;
        }
    }

    private class Sample_B extends Cell {

        public Sample_B(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(color);
            r1.setFill(color);
            getChildren().add(r1);
            super.name = name;
        }
    }

    private class Analysis_Agent extends Cell {

        public Analysis_Agent(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(color);
            r1.setFill(color);
            getChildren().add(r1);
        }
    }

    private class Excavation_Agent extends Cell {

        public Excavation_Agent(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(color);
            r1.setFill(color);
            getChildren().add(r1);
        }
    }

    @Override
    public void update(int x, int y) {
        Cell node = null;
        Text helpText = null;
        if (model.getGrid()[x][y] == GridWorldModel.OBSTACLE) {
            node = new Obstacle("Obstacle", Color.GRAY, x, y);
        } else if (model.getGrid()[x][y] == MarsModel.WATER_OR_ICE) {
            node = new Sample_A("Water or Ice", Color.SKYBLUE, x, y);
            helpText = new Text("Water");
        } else if (model.getGrid()[x][y] == MarsModel.FOSSILS) {
            node = new Sample_A("Fossils", Color.GREY, x, y);
            helpText = new Text("Fossil");
        } else if (model.getGrid()[x][y] == MarsModel.LIVING_ORGANISMS) {
            node = new Sample_A("Living Organism", Color.RED, x, y);
            helpText = new Text("Life");
        } else if (model.getGrid()[x][y] == MarsModel.SAMPLE_A_AGENT) {
            node = new Sample_A("Sample A Agent", Color.BLUE, x, y);
            helpText = new Text("A");
        } else if (model.getGrid()[x][y] == MarsModel.SAMPLE_B_AGENT) {
            node = new Sample_B("Sample B Agent", Color.DARKKHAKI, x, y);
            helpText = new Text("B");
        } else if (model.getGrid()[x][y] == MarsModel.ANALYSIS_AGENT) {
            node = new Agent("Analysis Agent", Color.GREEN, x, y);
            helpText = new Text("Analysis");
        } else if (model.getGrid()[x][y] == MarsModel.EXCAVATION_AGENT) {
            node = new Agent("Excavation Agent", Color.BROWN, x, y);
        } else if (model.getGrid()[x][y] == MarsModel.EMPTY) {
            node = new Empty(x, y);
        }

        // add node to group
        if (node != null) {
            if (helpText != null) {
                node.getChildren().addAll(helpText);
                node.setAlignment(Pos.CENTER);     // Right-justify nodes in stack
//                node.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"
            }
            grid.add(node, y, x);
        }
    }
}
