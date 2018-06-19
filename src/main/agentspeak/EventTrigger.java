package main.agentspeak;

public abstract class EventTrigger {

    private BeliefGoal beliefGoal;

    public BeliefGoal getBeliefGoal() {
        return beliefGoal;
    }

    public void setBeliefGoal(BeliefGoal eventTrigger) {
        this.beliefGoal = eventTrigger;
    }
}
