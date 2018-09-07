package main.java.uncertain_agentspeak.environment.grid;

import main.java.uncertain_agentspeak.environment.grid.AStar.AStar;
import main.java.uncertain_agentspeak.environment.grid.AStar.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GridWorldModel {

    protected Logger LOGGER   = LogManager.getLogger("Model");

    public static final int EMPTY = 0;
    public static final int OBSTACLE = 2;
    public static final int AGENT = 4;

    protected int width;
    protected int height;
    protected int[][] grid;
    public Position[] agentPositions;
    protected GridWorldView gridWorldView;
    protected HashMap<String, Integer> agentList;

    protected Random random = new Random();

    public GridWorldModel(int width, int height, int numAgents) {
        this.width = width;
        this.height = height;

        grid = new int[width][height];
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++){
                grid[x][y] = 0;
            }
        }

        agentPositions = new Position[numAgents];
        for (int i=0; i<numAgents; i++) {
            agentPositions[i] = new Position(-1,-1);
        }
    }

    public ArrayList<Node> aStar(int agentID, int targetX, int targetY) {
        Node start = new Node(getAgentPos(agentID).x, getAgentPos(agentID).y);
        Node target = new Node(targetX, targetY);
        AStar astar = new AStar(grid, width, height);
//        System.out.println("aStar start: " + start.toString());
//        System.out.println("aStar target: " + target.toString());
        return astar.findPath(start, target);
    }

    public void setGridWorldView(GridWorldView gridWorldView) {
        this.gridWorldView = gridWorldView;
    }

    public void setAgentList(HashMap<String, Integer> agentList) {
        this.agentList = agentList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getNumAgents() {
        return agentPositions.length;
    }

    public HashMap<String, Integer> getAgentList() {
        return agentList;
    }

    public int getAgentAtPos(int x, int y) {
        for (int i=0; i<agentPositions.length; i++) {
            if (agentPositions[i].x == x && agentPositions[i].y == y) {
                return i;
            }
        }
        return -1;
    }

    public int getAgentAtPos(Position position) {
        return getAgentAtPos(position.x, position.y);
    }

    protected Position getAgentPos(int ag) {
        try {
            if (agentPositions[ag].x == -1)
                return null;
            else
                return agentPositions[ag].clone();
        } catch (Exception e) {
            return null;
        }
    }

    protected void setPos(int object, Position oldPos, Position newPos) {
        if (oldPos != null) {
            remove(object, oldPos.x, oldPos.y);
        }
        add(object, newPos.x, newPos.y);
    }

//    public void setAgPos(int ag, Position l) {
//        Position oldLoc = getAgentPos(ag);
//        if (oldLoc != null) {
//            remove(AGENT, oldLoc.x, oldLoc.y);
//        }
//        agentPositions[ag] = l;
//        add(AGENT, l.x, l.y);
//    }
//
//    public void setAgPos(int ag, int x, int y) {
//        setAgPos(ag, new Position(x, y));
//    }

    protected boolean inGrid(int x, int y) {
        return x < this.width && x >= 0 && y < this.height && y >= 0;
    }

    protected boolean inGrid(Position position) {
        return inGrid(position.x, position.y);
    }

    protected boolean hasObject(int object, int x, int y) {
        return inGrid(x, y) && grid[x][y] == object;
    }

    protected boolean hasObject(int object, Position position) {
        return hasObject(object, position.x, position.y);
    }

    public void add(int value, Position l) {
        add(value, l.x, l.y);
    }

    public void add(int value, int x, int y) {
        grid[x][y] |= value;
        if (gridWorldView != null) gridWorldView.update(x,y);
    }

    protected void remove(int value, Position l) {
        remove(value, l.x, l.y);
    }

    protected void remove(int value, int x, int y) {
        grid[x][y] &= ~value;
        if (gridWorldView != null) gridWorldView.update(x,y);
    }

    protected boolean isEmpty(int x, int y) {
        return grid[x][y] == 0;
    }

    protected boolean isFree(Position l) {
        return isFree(l.x, l.y);
    }

    protected boolean isFree(int x, int y) {
        return inGrid(x, y) && (grid[x][y] & OBSTACLE) == 0 && (grid[x][y] & AGENT) == 0;
    }

    protected boolean isFree(int obj, Position l) {
        return inGrid(l.x, l.y) && (grid[l.x][l.y] & obj) == 0;
    }

    protected boolean isFree(int obj, int x, int y) {
        return inGrid(x, y) && (grid[x][y] & obj) == 0;
    }

    protected boolean isFreeOfObstacle(Position l) {
        return isFree(OBSTACLE, l);
    }
    protected boolean isFreeOfObstacle(int x, int y) {
        return isFree(OBSTACLE, x, y);
    }

    protected Position getFreePos() {
        for (int i=0; i<(getWidth()*getHeight()*5); i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            Position l = new Position(x,y);
            if (isFree(l)) {
                return l;
            }
        }
        return null; // not found
    }
}
