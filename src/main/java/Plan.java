package main.java;

import java.util.ArrayList;

public class Plan {

    private EventTrigger eventTrigger;
    private Context context;
    private ArrayList<Action> actions;

    public Plan(EventTrigger eventTrigger, Context context, ArrayList<Action> actions){
        this.eventTrigger = eventTrigger;
        this.context = context;
        this.actions = actions;
    }

    public EventTrigger getEventTrigger() {
        return eventTrigger;
    }

    public Context getContext() {
        return context;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Term getTerm(){
        return eventTrigger.getBeliefGoal().getTerm();
    }
}
