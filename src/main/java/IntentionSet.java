package main.java;

import java.util.LinkedList;

public class IntentionSet extends LinkedList<Intention> {

    private LinkedList<Intention> intentions;

    public Intention selectIntention(){
        return intentions.pop();
    }

}
