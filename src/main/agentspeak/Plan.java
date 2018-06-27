package main.agentspeak;

import java.util.ArrayList;

public class Plan {

    private Event event;
    private LogicalExpression context;
    private ArrayList<Action> actions;

    public Plan(Event event, LogicalExpression context, ArrayList<Action> actions){
        this.event = event;
        this.context = context;
        this.actions = actions;
    }

    public Event getEventTrigger() {
        return event;
    }

    public LogicalExpression getContext() {
        return context;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Term getTerm(){
        return event.getEventTrigger().getBeliefGoal().getTerm();
    }

    @Override
    public String toString() {
        String eventTriggerString = event.toString();
        StringBuilder contextString = new StringBuilder();
//        if (!context.isEmpty()) {
//            for (ContextBelief contextBelief : context) {
//                contextString.append(contextBelief.getBelief().getTerm().toString());
//                if (contextBelief != context.getLast()) {
//                    contextString.append(" & ");
//                }
//            }
//        } else {
//            contextString.append("true");
//        }
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
