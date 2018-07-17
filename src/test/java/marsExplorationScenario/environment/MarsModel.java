package test.java.marsExplorationScenario.environment;

import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.Location;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MarsModel extends GridWorldModel {

    private int numObstacles;
    private int numAgents;

    public MarsModel(int width, int height, int numObstacles, int windowSize) {
        super(width, height);
        this.numAgents = numAgents;
        this.numObstacles = numObstacles;
        init();
    }

    public void init() {
        grid = new int[width][height];
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++){
                grid[x][y] = 0;
            }
        }
        int counter = 0;
        super.agentPositions = new Location[numAgents];
        while (counter < numAgents) {
            int x = ThreadLocalRandom.current().nextInt(0, width);
            int y = ThreadLocalRandom.current().nextInt(0, height);
            if (grid[x][y] == EMPTY) {
                setAgPos(counter, new Location(x, y));
                counter++;
            }
        }
        counter = 0;
        while (counter < numObstacles) {
            int x = ThreadLocalRandom.current().nextInt(0, width);
            int y = ThreadLocalRandom.current().nextInt(0, height);
            if (grid[x][y] == EMPTY) {
                grid[x][y] = OBSTACLE;
                counter++;
            }
        }
    }

}
