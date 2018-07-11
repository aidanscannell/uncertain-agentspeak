package main.java.uncertain_agentspeak.environment.grid;

public class GridWorldModel {

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

    public int getNumAgents() {
        return agentPositions.length;
    }
}
