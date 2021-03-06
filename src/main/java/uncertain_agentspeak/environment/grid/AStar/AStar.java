package main.java.uncertain_agentspeak.environment.grid.AStar;

import java.util.ArrayList;
import java.util.Collections;

public class AStar {

    private int[][] grid;
    private int rows;
    private int cols;
    private Node start;
    private Node target;

    public AStar(int[][] grid, int rows, int cols) {
        this.grid = grid;
        this.rows = rows;
        this.cols = cols;
    }

    /* A* main function */
    public ArrayList<Node> findPath(Node start, Node target) {
        this.start = start;
        this.target = target;

        ArrayList<Node> openList = new ArrayList<>();
        ArrayList<Node> closedList = new ArrayList<>();

        start.setG(0);
        start.setH(manhattanDistance(start, target));
        start.setParent(null);
        openList.add(start);

        int nodes = 0;

        Node current;
        do {
            current = lowestScore(openList);
            closedList.add(current);
            openList.remove(current);

            System.out.println("Before is in list:");
//            System.out.println("cloase list:" + closedList);
            if (isInList(target, closedList)) {
                System.out.println("total nodes A: " + nodes);
                return getPath(current);
            }

            ArrayList<Node> neighbours = getNeighbours(current);
            nodes += neighbours.size();

            for (Node n : neighbours) {
                n.setG(current.getG() + 1);
                n.setParent(current);

                if (isInList(n, closedList)) {
                    continue;
                }

                if (!isInList(n, openList)) {
                    openList.add(n);
                } else {
                    if (current.getG() + 1 < n.getG()) {
                        n.setParent(current);
                    }
                }
            }

        } while (!openList.isEmpty());

        return null;
    }

    private Node lowestScore(ArrayList<Node> list) {
        double minF = list.get(0).getF();
        Node node = list.get(0);
        for (Node n : list) {
            if (n.getF() < minF) {
                minF = n.getF();
                node = n;
            }
        }
        return node;
    }

    private boolean isInList(Node node, ArrayList<Node> list) {
        for (Node n : list) {
            if (n.equals(node)) {
                return true;
            }
        }
        return false;
    }

    private int manhattanDistance(Node n1, Node n2) {
        return Math.abs(n1.getPosition().getRow() - n2.getPosition().getRow())
                + Math.abs(n1.getPosition().getCol() - n2.getPosition().getCol());
    }

    private boolean isInsideBounds(Point point, int rows, int columns){
        int row = point.getRow();
        int col = point.getCol();
        return (row >= 0) && (row <= rows) && (col >= 0) && (col <= columns);
    }

    private boolean isObstacle(Node node) {
        if (node.getPosition().getCol() >= grid[0].length || node.getPosition().getRow() >= grid.length) {
            return true;
        }
        return grid[node.getPosition().getCol()][node.getPosition().getRow()] != 0;
    }

    private ArrayList<Node> getNeighbours(Node node) {

        Point pos = node.getPosition();
        int row = pos.getRow();
        int col = pos.getCol();

        ArrayList<Node> neighbours = new ArrayList<>();
        Node north = new Node();
        north.setPosition(new Point(row - 1, col));

        Node east = new Node();
        east.setPosition(new Point(row, col + 1));

        Node south = new Node();
        south.setPosition(new Point(row + 1, col));

        Node west = new Node();
        west.setPosition(new Point(row, col - 1));

        if (isInsideBounds(north.getPosition(), rows, cols) && !isObstacle(north)) {
            neighbours.add(north);
        }
        if (isInsideBounds(east.getPosition(), rows, cols) && !isObstacle(east)) {
            neighbours.add(east);
        }
        if (isInsideBounds(south.getPosition(), rows, cols) && !isObstacle(south)) {
            neighbours.add(south);
        }
        if (isInsideBounds(west.getPosition(), rows, cols) && !isObstacle(west)) {
            neighbours.add(west);
        }

        for (Node n : neighbours) {
            n.setH(manhattanDistance(n, target));
        }

        return neighbours;
    }

    private ArrayList<Node> getPath(Node target) {
        ArrayList<Node> path = new ArrayList<>();
        Node node = target.getParent();
        while (node != null) {
            path.add(node);
            node = node.getParent();
        }
        Collections.reverse(path);
        return path;
    }
}