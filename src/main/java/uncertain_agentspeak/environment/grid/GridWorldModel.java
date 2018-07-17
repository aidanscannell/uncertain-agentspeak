package main.java.uncertain_agentspeak.environment.grid;

public class GridWorldModel {

    public static int EMPTY = 0;
    public static int AGENT = 2;
    public static int OBSTACLE = 4;

    protected int width;
    protected int height;
    protected int[][] grid;
    protected Location[] agentPositions;
    private GridWorldView gridWorldView;

    public GridWorldModel(int width, int height) {
        this.width = width;
        this.height = height;

        grid = new int[width][height];
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++){
                grid[x][y] = 0;
            }
        }

//        agentPositions = new Location[numAgents];
//        for (int i=0; i<numAgents; i++) {
//            agentPositions[i] = new Location(-1,-1);
//        }
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

    public int getAgentAtPos(int x, int y) {
        for (int i=0; i<agentPositions.length; i++) {
            if (agentPositions[i].x == x && agentPositions[i].y == y) {
                return i;
            }
        }
        return -1;
    }

    public int getAgentAtPos(Location location) {
        return getAgentAtPos(location.x, location.y);
    }

    public Location getAgentPos(int ag) {
        try {
            if (agentPositions[ag].x == -1)
                return null;
            else
                return (Location) agentPositions[ag].clone();
        } catch (Exception e) {
            return null;
        }
    }

    public void setAgPos(int ag, Location l) {
        Location oldLoc = getAgentPos(ag);
        if (oldLoc != null) {
            remove(AGENT, oldLoc.x, oldLoc.y);
        }
        agentPositions[ag] = l;
        add(AGENT, l.x, l.y);
    }

    public void setAgPos(int ag, int x, int y) {
        setAgPos(ag, new Location(x, y));
    }

    public void add(int value, Location l) {
        add(value, l.x, l.y);
    }

    public void add(int value, int x, int y) {
        grid[x][y] |= value;
        if (gridWorldView != null) gridWorldView.update(x,y);
    }

    public void remove(int value, Location l) {
        remove(value, l.x, l.y);
    }

    public void remove(int value, int x, int y) {
        grid[x][y] &= ~value;
        if (gridWorldView != null) gridWorldView.update(x,y);
    }
}
