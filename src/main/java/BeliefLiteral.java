package main.java;

public class BeliefLiteral {

    private Term belief;
    private boolean positive; // true implies positive literal, false implies negation

    public BeliefLiteral(Term term) {
        this.belief = term;
        this.positive = true;
    }

    public BeliefLiteral(Term term, boolean positive) {
        this.belief = term;
        this.positive = positive;
    }

    public Term getTerm() {
        return belief;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setBelief(Term belief) {
        this.belief = belief;
    }
}
