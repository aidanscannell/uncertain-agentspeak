package main.java.events;

import main.java.Event;
import main.java.EventTrigger;
import main.java.Goal;
import main.java.Intention;
import main.java.goals.AchievementGoal;

public class InternalEvent extends Event {

    public InternalEvent(EventTrigger eventTrigger, Intention intention) {
        super.setEventTrigger(eventTrigger);
        super.setIntention(intention);
    }
}
