package main.java.uncertain_agentspeak.agentspeak;

import java.util.ArrayList;

public class Plan {

    private EventTrigger eventTrigger;
    private LogicalExpression context;
    private ArrayList<Action> actions;

    public Plan(EventTrigger eventTrigger, LogicalExpression context, ArrayList<Action> actions){
        this.eventTrigger = eventTrigger;
        this.context = context;
        this.actions = actions;
    }

    public EventTrigger getEventTrigger() {
        return eventTrigger;
    }

    public LogicalExpression getContext() {
        return context;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

//    public Term getTerm(){
//        return event.getEventTrigger().getBeliefGoal().getTerm();
//    }

    @Override
    public String toString() {
        String eventTriggerString = eventTrigger.toString();
        StringBuilder contextString = new StringBuilder();
        contextString.append(context.toString());
        StringBuilder actionsString = new StringBuilder(" <- ");
        if (!actions.isEmpty()) {
            for (Action action : actions) {
                actionsString.append(action.toString());
                if (action != actions.get(actions.size() - 1)) {
                    actionsString.append("; ");
                }
            }
        } else {
            actionsString.append("true");
        }
        return eventTriggerString + " : " + contextString + actionsString;
    }
}
