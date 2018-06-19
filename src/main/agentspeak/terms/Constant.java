package main.agentspeak.terms;

import main.agentspeak.Term;
import main.agentspeak.Unifier;

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


}