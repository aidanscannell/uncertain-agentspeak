package main.java.uncertain_agentspeak.agentspeak;

public abstract class Goal {

    private Term term;

    public Goal(Term term) {
        this.term = term;
    }

    public Term getTerm() {
        return term;
    }

    public abstract Goal substitute(Unifier unifier);

}
