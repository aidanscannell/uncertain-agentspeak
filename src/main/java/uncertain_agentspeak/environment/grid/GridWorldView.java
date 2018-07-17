package main.java.uncertain_agentspeak.environment.grid;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridWorldView extends Stage {

    private int cellWidth;
    private int cellHeight;

    private GridWorldModel model;
    private Grid grid;

    private Font font = new Font("Arial", 10);

    public GridWorldView(GridWorldModel gridWorldModel, String title, int windowSize) {

        this.model = gridWorldModel;
        model.setGridWorldView(this);
        cellWidth = windowSize / model.getWidth();
        cellHeight = windowSize / model.getHeight();

//        Stage subStage = new Stage();
        this.setTitle(title);

        grid = new Grid(model.getWidth(), model.getHeight(), windowSize, windowSize);

        Group root = new Group();
        root.getChildren().addAll(grid);

        Scene scene = new Scene(root, windowSize, windowSize);

        this.setScene(scene);
        this.sizeToScene();
//        subStage.show();

        // move bugs
//        animate();
    }

    public Stage getStage() {
        return this;
    }

    public void animate() {
        this.show();
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

    private class Grid extends Pane {

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
                    if ((model.getGrid()[x][y] & GridWorldModel.OBSTACLE) != 0) {
                        node = new Obstacle("Obstacle", Color.GRAY, x, y);
                    } else if ((model.getGrid()[x][y] & GridWorldModel.AGENT) != 0) {
                        System.out.println("here");
                        node = new Agent("Agent", Color.GREEN, x, y);
                    }

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

    private class Cell extends StackPane {

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

    private class Agent extends Cell {
        public Agent(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(Color.BLUE);
            getChildren().add(r1);
        }
    }

    private class Obstacle extends Cell {
        public Obstacle(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(Color.BLACK);
            getChildren().add(r1);
        }
    }

    private class Empty extends Cell {
        public Empty(String name, Color color, int x, int y) {
            super(x, y);
            Rectangle r1 = new Rectangle(x, y, cellWidth, cellHeight);
            r1.setStroke(Color.BLACK);
            r1.setFill(Color.WHITE);
            getChildren().add(r1);
        }
    }


}

//    private class GridCanvas extends Canvas {
//
////        public MyNode( String name, Color color, double x, double y) {
//
//            private static final long serialVersionUID = 1L;
//
//            public void paint(GraphicsContext gc) {
//                cellWidth = drawArea.getWidth() / model.getWidth();
//                cellHeight = drawArea.getHeight() / model.getHeight();
//                int mwidth = model.getWidth();
//                int mheight = model.getHeight();
//
//                gc.setFill(Color.GREEN);
//                gc.setStroke(Color.BLUE);
//
//                for (int l = 1; l <= mheight; l++) {
//                    gc.strokeLine(0, l * cellHeight, mwidth * cellWidth, l * cellHeight);
//                }
//                for (int c = 1; c <= mwidth; c++) {
//                    gc.strokeLine(c * cellWidth, 0, c * cellWidth, mheight * cellHeight);
//                }
//
//                for (int x = 0; x < mwidth; x++) {
//                    for (int y = 0; y < mheight; y++) {
//                        draw(gc,x,y);
//                    }
//                }
//            }
//
////            // create rectangle
////            Rectangle rectangle = new Rectangle( gridWidth, gridHeight);
////            rectangle.setStroke( color);
////            rectangle.setFill( color.deriveColor(1, 1, 1, 0.7));
////
////            final Canvas canvas = new Canvas(x,y);
////            GraphicsContext gc = canvas.getGraphicsContext2D();
////
////            gc.setFill(Color.BLUE);
////            gc.fillRect(75,75,100,100);
////            gc.
////
////            r
////            // create label
////            Label label = new Label( name);
////
////            // set position
////            setTranslateX( x * gridWidth);
////            setTranslateY( y * gridHeight);
////
////            getChildren().addAll( rectangle, label);
//
//        }



//    public void initComponents(int width) {
//        setSize(width, width);
//        getContentPane().setLayout(new BorderLayout());
//        drawArea = new GridCanvas();
//        getContentPane().add(BorderLayout.CENTER, drawArea);
//    }
//
////    @Override
////    public void repaint() {
////        cellWidth = drawArea.getWidth() / model.getWidth();
////        cellHeight = drawArea.getHeight() / model.getHeight();
////        super.repaint();
////        drawArea.repaint();
////    }
//
////    public void update() {
////        repaint();
////    }
//
//    public void update(int x, int y) {
//        GraphicsContext gc = drawArea.getGraphicsContext2D();
//        if (gc == null) {
//            return;
//        }
//        drawEmpty(gc, x, y);
//        draw(gc, x, y);
//    }
//
//    public void drawObstacle(GraphicsContext g, int x, int y) {
//        g.setFill(Color.LIGHTGRAY);
//        g.fillRect(x * cellWidth + 1, y * cellHeight+1, cellWidth-1, cellHeight-1);
//        g.setFill(Color.LIGHTGRAY);
//        g.fillRect(x * cellWidth + 2, y * cellHeight+2, cellWidth-4, cellHeight-4);
//    }
//
//    public void drawAgent(GraphicsContext gc, int x, int y, Color c, int id) {
//        gc.setFill(c);
//        gc.fillOval(x * cellWidth+2, y * cellHeight+2, cellWidth-4, cellHeight-4);
//        if (id >= 0) {
//            gc.setFill(Color.BLACK);
//            drawString(gc, x, y, font, String.valueOf(id+1));
//        }
//    }
//
//    public void drawString(GraphicsContext gc, int x, int y, Font f, String s) {
//        Text text = new Text(s);
//        text.setFont(f);
//        gc.setFont(f);
//
//        final double width = text.getLayoutBounds().getWidth();
//        final double height = text.getLayoutBounds().getHeight();
////        text.setLayoutX(x*cellWidth+(cellWidth/2-width/2));
////        text.setLayoutY(y*cellHeight+(cellHeight/2+height/2));
//        gc.fillText(s, x*cellWidth+(cellWidth/2-width/2), y*cellHeight+(cellHeight/2+height/2));
////        gc.drawString( s, x*cellWidth+(cellWidth/2-width/2), y*cellHeight+(cellHeight/2+height/2));
//    }
//
//    public void drawEmpty(GraphicsContext gc, int x, int y) {
//        gc.setFill(Color.WHITE);
//        gc.fillRect(x * cellWidth + 1, y * cellHeight+1, cellWidth-1, cellHeight-1);
//        gc.setFill(Color.LIGHTGRAY);
//        gc.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
//    }
//
//    public void draw(GraphicsContext gc, int x, int y, int object) {}
//
//    private void draw(GraphicsContext gc, int x, int y) {
//        if ((model.getGrid()[x][y] & GridWorldModel.OBSTACLE) != 0) {
//            drawObstacle(gc, x, y);
//        }
//
//        int vl = GridWorldModel.OBSTACLE*2;
//        while (vl < limit) {
//            if ((model.getGrid()[x][y] & vl) != 0) {
//                draw(gc, x, y, vl);
//            }
//            vl *= 2;
//        }
//
//        if ((model.getGrid()[x][y] & GridWorldModel.AGENT) != 0) {
//            drawAgent(drawArea.getGraphicsContext2D(), x, y, Color.BLUE, model.getAgentAtPos(new Location(x, y)));
//        }
//    }