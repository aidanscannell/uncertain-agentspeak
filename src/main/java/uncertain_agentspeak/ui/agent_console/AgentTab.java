package main.java.uncertain_agentspeak.ui.agent_console;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class AgentTab extends Tab implements AgentEventListener {

    private TextArea textArea;

    public AgentTab(String agentName) {
        this.setText(agentName);
        textArea = new TextArea();
        this.setContent(textArea);
    }

    @Override
    public void handleEvent(AgentEvent agentEvent) {
        textArea.appendText("\n" + agentEvent.getTimestamp() + "  -  " + agentEvent.getText());
    }
}
