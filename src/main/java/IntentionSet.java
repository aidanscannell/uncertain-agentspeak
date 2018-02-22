package main.java;

import java.util.LinkedList;

public class IntentionSet extends LinkedList<Intention> {

    private LinkedList<Intention> intentions;

    public Intention selectIntention(){
        return intentions.pop();
    }

    public void addIntention(Event event, IntendedMeans intendedMeans) {
        Intention intention = event.getIntention();
        intention.push(intendedMeans);
        this.add(intention);
    }
}
