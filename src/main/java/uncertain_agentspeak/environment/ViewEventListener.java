package main.java.uncertain_agentspeak.environment;

import java.util.EventListener;
import java.util.EventObject;

public interface ViewEventListener extends EventListener {

    void handleEvent(EventObject eventObject);

}
