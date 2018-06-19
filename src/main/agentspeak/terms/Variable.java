package main.agentspeak.terms;

import main.agentspeak.Term;
import main.agentspeak.Unifier;

/** Class that implements a term that represents a Variable */
public class Variable extends Term {

    private String label;

    public Variable(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean isGround() { return false; }

    // Unification
    public Unifier unify(Constant c){
        Unifier unifier = new Unifier();
        unifier.put(this, c);
        return unifier;
    }

    public Unifier unify(Variable var){
        if (this.equals(var)){
            return new Unifier();
        } else {
            Unifier unifier = new Unifier();
            unifier.put(this, var);
            return unifier;
        }
    }

    public Unifier unify(Structure struct){
        Unifier unifier = new Unifier();
        unifier.put(this, struct);
        return unifier;
    }

    @Override
    public Term substitute(Unifier unifier) {
        if (unifier != null && unifier.containsKey(this)) {
            Term newVar = unifier.get(this);
            return newVar.substitute(unifier);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return label;
    }
}
