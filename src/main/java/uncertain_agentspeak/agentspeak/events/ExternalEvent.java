package main.java.uncertain_agentspeak.agentspeak.events;

import main.java.uncertain_agentspeak.agentspeak.Event;
import main.java.uncertain_agentspeak.agentspeak.EventTrigger;
import main.java.uncertain_agentspeak.agentspeak.Intention;

public class ExternalEvent extends Event {

    public ExternalEvent(EventTrigger eventTrigger) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(new Intention());
    }
}
