package main.java;

public class Belief extends BeliefGoal {

    private Term belief;
    private boolean positive; // true implies positive literal, false implies negation

    public Belief(Term term) {
        this.belief = term;
        this.positive = true;
    }

    public Belief(Term term, boolean positive) {
        this.belief = term;
        this.positive = positive;
    }

    @Override
    public Term getTerm() {
        return belief;
    }

    @Override
    public Belief getBelief() {
        return null;
    }

    @Override
    public BeliefGoal substitute(Unifier unifier) {
        return null;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setBelief(Term belief) {
        this.belief = belief;
    }

    @Override
    public String toString() {
        return belief.toString();
    }
}
