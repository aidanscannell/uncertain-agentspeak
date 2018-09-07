package test.java.marsExplorationScenario.environment;

public class Location {

    private int x_min;
    private int x_max;
    private int y_min;
    private int y_max;
    private int x;
    private int y;

    public Location(int x_min, int x_max, int y_min, int y_max, int x, int y) {
        this.x_min = x_min;
        this.x_max = x_max;
        this.y_min = y_min;
        this.y_max = y_max;
        this.x = x;
        this.y = y;
    }

    public int getX_min() {
        return x_min;
    }

    public int getX_max() {
        return x_max;
    }

    public int getY_min() {
        return y_min;
    }

    public int getY_max() {
        return y_max;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean insideLocation(int x, int y) {
        if (x >= x_min && x <= x_max && y >= y_min && y <= y_max) {
            return true;
        }
        return false;
    }
}
