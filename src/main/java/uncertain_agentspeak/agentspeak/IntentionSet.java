package main.java.uncertain_agentspeak.agentspeak;

import java.util.LinkedList;

public class IntentionSet extends LinkedList<Intention> {

//    public Intention selectIntention(){
//        return this.pollLast();
//    }

    public void addIntention(Event event, IntendedMeans intendedMeans) {
        Intention intention = event.getIntention();
        intention.push(intendedMeans);
        this.add(intention);
    }

    @Override
    public String toString() {
        IntentionSet intentionSet = (IntentionSet) this.clone();
        StringBuilder string = new StringBuilder();
        int ii =1;
        for (int i=intentionSet.size()-1; i>=0; i--) {
            string.append("\n\t Intention " + ii + ":" + intentionSet.get(i).toString("\n\t\t"));
            ii++;
        }
        return string.toString();
    }
}
