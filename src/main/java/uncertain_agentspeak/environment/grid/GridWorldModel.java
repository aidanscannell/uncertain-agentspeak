package main.java.uncertain_agentspeak.environment.grid;

public class GridWorldModel {

    public static int EMPTY = 0;
    public static int AGENT = 2;
    public static int OBSTACLE = 4;

    private int width;
    private int height;
    private int[][] grid;
    private Location[] agentPositions;
    private GridWorldView gridWorldView;

    public GridWorldModel(int width, int height, int numAgents) {
        this.width = width;
        this.height = height;

        grid = new int[width][height];
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++){
                grid[x][y] = 0;
            }
        }

        agentPositions = new Location[numAgents];
        for (int i=0; i<numAgents; i++) {
            agentPositions[i] = new Location(-1,-1);
        }
    }

    public void setGridWorldView(GridWorldView gridWorldView) {
        this.gridWorldView = gridWorldView;
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

    public int getAgentAtPos(Location location) {
        for (int i=0; i<agentPositions.length; i++) {
            if (agentPositions[i].x == location.x && agentPositions[i].y == location.y) {
                return i;
            }
        }
        return -1;
    }
}
