package main.java.uncertain_agentspeak.environment;

import java.util.EventListener;

public interface EnvironmentEventListener extends EventListener {

    void handleEnvEvent(EnvironmentEvent environmentEvent);

}
