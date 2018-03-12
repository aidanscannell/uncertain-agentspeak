package main.java;

public abstract class BeliefGoal {

    public abstract Term getTerm();

    public abstract Belief getBelief();

    public abstract BeliefGoal substitute(Unifier unifier);

}
