package main.java.uncertain_agentspeak.environment.grid.AStar;

public class Node {
    private Node parent;
    private double g;
    private double h;

    private Node r_sibling;
    private Node l_child;

    private Point position;

    public Node() {
        /*empty constructor*/
    }

    public Node(Point pos) {
        position = pos;
    }

    public Node(int row, int col) {
        position = new Point(row, col);
    }

    public String toString() {
        return "(" + String.format("%02d", getPosition().getRow()) + ", "
                + String.format("%02d", getPosition().getCol()) + ")";
    }

    public boolean equals(Node n) {
        return this.getPosition().getRow() == n.getPosition().getRow() && this.getPosition().getCol() == n.getPosition().getCol();
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return g + h;
    }

    public Node getR_sibling() {
        return r_sibling;
    }

    public void setR_sibling(Node r_sibling) {
        this.r_sibling = r_sibling;
    }

    public Node getL_child() {
        return l_child;
    }

    public void setL_child(Node l_child) {
        this.l_child = l_child;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}