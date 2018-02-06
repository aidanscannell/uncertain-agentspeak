package main.java.terms;

import main.java.Term;
import main.java.Unifier;

public class Constant extends Term {


    // Unification:

    public Unifier unify(Constant c){
        if (this.equals(c)){
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

}
