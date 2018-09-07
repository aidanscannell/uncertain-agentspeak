package main.java.uncertain_agentspeak.ui.agent_console;

import java.util.EventListener;

public interface AgentEventListener extends EventListener {

    void handleEvent(AgentEvent agentEvent);

}
