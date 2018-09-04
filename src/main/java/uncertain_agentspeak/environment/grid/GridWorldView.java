package main.java.uncertain_agentspeak.environment.grid;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class GridWorldView extends Stage {

    protected Logger LOGGER   = Logger.getLogger("View");

    protected int cellWidth;
    protected int cellHeight;

    protected GridWorldModel model;
    protected Grid grid;

    protected Font font = new Font("Arial", 10);

    public GridWorldView(GridWorldModel gridWorldModel, String title, int windowSize) {

        this.model = gridWorldModel;
        model.setGridWorldView(this);
        cellWidth = windowSize / model.getWidth();
        cellHeight = windowSize / model.getHeight();

//        Stage subStage = new Stage();
        this.setTitle(title);

        grid = new Grid(model.getWidth(), model.getHeight(), windowSize, windowSize);

        final Button openButton = new Button("View Performance Metrics");

        openButton.setOnAction(
                e -> viewMetrics());
//
//        Group root = new Group();
//        root.getChildren().addAll(grid);
//
//        Scene scene = new Scene(root, windowSize, windowSize);
//
//        this.setScene(scene);
//        this.sizeToScene();
//        this.show();
//
//        // move bugs
//        animate();

        BorderPane border = new BorderPane();
//        HBox hbox = addHBox();
//        border.setTop(addHBox());
//        border.setLeft(addVBox());
//        addStackPane(hbox);         // Add stack to HBox in top region

        border.setCenter(grid);
//        border.setRight(addGridPane());

        Group root = new Group();
        root.getChildren().addAll(border);

        Scene scene = new Scene(root, windowSize, windowSize);

        this.setScene(scene);
        this.sizeToScene();
        this.show();

//        animate();
    }

    private void viewMetrics() {
    }

    public void animate() {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                update();
            }
        }.start();

    }

    public void update() {
        for (int x=0; x<model.getWidth(); x++) {
            for (int y = 0; y < model.getHeight(); y++) {
                update(x,y);
            }
        }
    }

    public void update(int x, int y) {
        Cell node = null;
        if ((model.getGrid()[x][y] & GridWorldModel.OBSTACLE) != 0) {
            node = new Obstacle("Obstacle", Color.GRAY, x, y);
        } else if ((model.getGrid()[x][y] & GridWorldModel.AGENT) != 0) {
            node = new Agent("Agent", Color.GREEN, x, y);
        }

        // add node to group
        if (node != null) {
            grid.add(node, y, x);
        }
    }

    public GridWorldModel getModel() {
        return model;
    }

    protected class Grid extends Pane {

        int rows;
        int columns;

        double width;
        double height;

        Cell[][] cells;

        public Grid(int columns, int rows, double width, double height) {

            this.columns = columns;
            this.rows = rows;
            this.width = width;
            this.height = height;

            cells = new Cell[rows][columns];

            for (int x=0; x<model.getWidth(); x++) {
                for (int y=0; y<model.getHeight(); y++) {
                    Cell node = null;
//                    if ((model.getGrid()[x][y] & GridWorldModel.OBSTACLE) != 0) {
//                        node = new Obstacle("Obstacle", Color.GRAY, x, y);
//                    } else if ((model.getGrid()[x][y] & GridWorldModel.AGENT) != 0) {
//                        System.out.println("here");
//                        node = new Agent("Agent", Color.GREEN, x, y);
//                    }
                    this.add(new Empty(x, y), y, x);

                    // add node to group
                    if (node != null) {
                        this.add(node, y, x);
                    }
                }
            }

        }

        public void add(Cell cell, int column, int row) {

            cells[row][column] = cell;

            double w = width / columns;
            double h = height / rows;
            double x = w * column;
            double y = h * row;

            cell.setLayoutX(x);
            cell.setLayoutY(y);
            cell.setPrefWidth(w);
            cell.setPrefHeight(h);

            getChildren().add(cell);

        }

    }

    protected class Cell extends StackPane {

        int column;
        int row;

        public Cell(int column, int row) {

            this.column = column;
            this.row = row;

            getStyleClass().add("cell");

            setOpacity(0.9);
        }

        public String toString() {
            return this.column + "/" + this.row;
        }
    }

    protected class Agent extends Cell {
        public Agent(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(color);
            getChildren().add(r1);
        }
    }

    protected class Obstacle extends Cell {
        public Obstacle(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(Color.BLACK);
            getChildren().add(r1);
        }
    }

    protected class Empty extends Cell {
        public Empty(int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(Color.WHITE);
            getChildren().add(r1);
        }
    }
}