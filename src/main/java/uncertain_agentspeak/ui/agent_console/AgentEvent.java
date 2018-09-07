package main.java.uncertain_agentspeak.ui.agent_console;

import java.sql.Timestamp;
import java.util.EventObject;

public class AgentEvent extends EventObject {

    private String text;
    private Timestamp timestamp;

    public AgentEvent(Object source, String text, Timestamp timestamp) {
        super(source);
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
