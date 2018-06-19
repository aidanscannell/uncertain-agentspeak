package main.agentspeak;

public abstract class Goal extends BeliefGoal {

    private Belief belief;

    public void setBelief(Belief belief) {
        this.belief = belief;
    }

    @Override
    public Belief getBelief() {
        return belief;
    }

    public Term getTerm() {
        return this.belief.getTerm();
    }

    @Override
    public abstract Goal substitute(Unifier unifier);

}
