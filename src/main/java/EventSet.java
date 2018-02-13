package main.java;

import java.util.LinkedList;

public class EventSet extends LinkedList<Event> {

    public Event selectEvent(){
        return this.pop();
    }
}
