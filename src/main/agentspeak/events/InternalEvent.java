package main.agentspeak.events;

import main.agentspeak.Event;
import main.agentspeak.EventTrigger;
import main.agentspeak.Intention;

public class InternalEvent extends Event {

    public InternalEvent(EventTrigger eventTrigger, Intention intention) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(intention);
    }
}
