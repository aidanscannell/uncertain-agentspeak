package main.java.uncertain_agentspeak.agentspeak.terms;

import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;

import java.util.HashSet;

/** Class that implements a term that represents constants (atom, number, text) */
public class Constant extends Term {

    @Override
    public boolean isGround() { return true; }

    // Unification:
    public Unifier unify(Constant c){
        if (this.toString().equals(c.toString())){
            return new Unifier();
        }
        return null;
    }

    public Unifier unify(Variable var){
        Unifier unifier = new Unifier();
        unifier.put(var,this);
        return unifier;
    }

    // return null for unification of structure and Constant
    public Unifier unify(Structure struct){
        return null;
    }

    @Override
    public Constant substitute(Unifier unifier) {
        return this;
    }

    @Override
    public HashSet<Variable> getVariables() {
        return new HashSet<>();
    }

}