package main.java;

public class IntendedMeans {

    private Plan plan;
    private Unifier unifier;

    public IntendedMeans(Plan plan, Unifier unifer) {
        this.plan = plan;
        this.unifier = unifer;
    }

    public Plan getPlan() {
        return plan;
    }

    public Unifier getUnifier() {
        return unifier;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setUnifier(Unifier unifier) {
        this.unifier = unifier;
    }
}
