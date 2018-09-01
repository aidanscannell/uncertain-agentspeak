package main.java.uncertain_agentspeak.agentspeak;

import java.util.LinkedList;

public class IntentionSet extends LinkedList<Intention> {

    public Intention selectIntention(){
        return this.pop();
    }

    public void addIntention(Event event, IntendedMeans intendedMeans) {
        Intention intention = event.getIntention();
        intention.push(intendedMeans);
        this.add(intention);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Intention intention : this) {
            string.append("\n\t" + intention.toString());
        }
        return string.toString();
    }
}
