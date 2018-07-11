package main.java.uncertain_agentspeak.agentspeak;

import java.util.LinkedList;

public class EventSet extends LinkedList<Event> {

    public Event selectEvent(){
        return this.pop();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Event event: this) {
            string.append("\t").append(event.toString());
            if (event != this.get(this.size()-1)) {
                string.append("\n");
            }
        }
        return string.toString();
    }
}
