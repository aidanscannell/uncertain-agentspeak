package main.java.uncertain_agentspeak.agentspeak.events;

import main.java.uncertain_agentspeak.agentspeak.Event;
import main.java.uncertain_agentspeak.agentspeak.EventTrigger;
import main.java.uncertain_agentspeak.agentspeak.Intention;

public class InternalEvent extends Event {

    public InternalEvent(EventTrigger eventTrigger, Intention intention) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(intention);
    }
}
