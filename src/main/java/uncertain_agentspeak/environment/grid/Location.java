package main.java.uncertain_agentspeak.environment.grid;

public class Location {

    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location clone() {
        return new Location(this.x, this.y);
    }
}
