package main.java.uncertain_agentspeak.environment.grid;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.stage.WindowEvent;
import main.java.uncertain_agentspeak.environment.ViewEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class GridWorldView extends Stage {

    protected Logger LOGGER   = LogManager.getLogger("MASProject");

    protected int cellWidth;
    protected int cellHeight;

    protected GridWorldModel model;
    protected Grid grid;

//    public Map<String,AgentTab> agentTabs;

    public ViewEventListener[] listeners;

    public GridWorldView(GridWorldModel gridWorldModel, String title, int windowSize) {

        this.model = gridWorldModel;
        model.setGridWorldView(this);
        cellWidth = windowSize / model.getWidth();
        cellHeight = windowSize / model.getHeight();

        this.setTitle(title);

        grid = new Grid(model.getWidth(), model.getHeight(), windowSize, windowSize);

        BorderPane border = new BorderPane();
        border.setTop(addHBox());
        border.setCenter(grid);
//        border.setRight(addTabPane());

        Group root = new Group();
        root.getChildren().addAll(border);

        Scene scene = new Scene(root);

        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                //TODO: add env stop() call
//                stop();
            }
        });

        this.setScene(scene);
        this.sizeToScene();
        this.show();

    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        Button buttonStop = new Button("Stop");
        buttonStop.setOnAction(e -> notifyListener());
        HBox.setHgrow(buttonStop, Priority.ALWAYS);
        buttonStop.setMaxWidth(Double.MAX_VALUE / 3);
        hbox.getChildren().addAll(buttonStop);
        return hbox;
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

    /** Event listener methods */
    public void notifyListener() {
        EventObject event = new EventObject(this);
        ViewEventListener[] interested = listeners;
        for (int i=0; i<listeners.length; i++) {
            interested[i].handleEvent(event);
        }
    }

    public void addEventListener(ViewEventListener listener) {
        if (listeners == null) {
            listeners = new ViewEventListener[] { listener };
        } else {
            ViewEventListener results[] = new ViewEventListener[listeners.length + 1];
            for (int i = 0; i < listeners.length; i++)
                results[i] = listeners[i];
            results[listeners.length] = listener;
            listeners = results;
        }
    }


    /** Grid and cell classes */
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
                    this.add(new Empty(x, y), y, x);
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
        protected String name;

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
            super.name = name;
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