package main.java.uncertain_agentspeak.environment.grid.AStar;

public class Point {
    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Point() {
        /*empty constructor*/
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String toString() {
        return "(" + String.format("%02d", getRow()) + ", " + String.format("%02d", getCol()) + ")";
    }
}
