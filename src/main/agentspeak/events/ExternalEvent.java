package main.agentspeak.events;

import main.agentspeak.Event;
import main.agentspeak.EventTrigger;
import main.agentspeak.Intention;

public class ExternalEvent extends Event {

    public ExternalEvent(EventTrigger eventTrigger) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(new Intention());
    }
}
