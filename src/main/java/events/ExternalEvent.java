package main.java.events;

import main.java.Event;
import main.java.EventTrigger;
import main.java.Intention;

public class ExternalEvent extends Event {

    public ExternalEvent(EventTrigger eventTrigger) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(new Intention());
    }
}
