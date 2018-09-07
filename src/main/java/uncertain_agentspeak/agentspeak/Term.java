package main.java.uncertain_agentspeak.agentspeak;

import main.java.uncertain_agentspeak.agentspeak.terms.*;

import java.util.HashSet;

/** Common class that implements all terms */
public abstract class Term {

    public Unifier unify(Term term){
        if (term instanceof Constant){
            return this.unify((Constant) term);
        } else if (term instanceof Variable){
            return this.unify((Variable) term);
        } else if (term instanceof Structure){
            return this.unify((Structure) term);
        } else {
            return null;
        }
    }

    public abstract boolean isGround();

    public abstract Unifier unify(Constant c);
    public abstract Unifier unify(Variable var);
    public abstract Unifier unify(Structure struct);

    public Unifier unify(Term term, Unifier unifier) {
        if (unifier != null) {
            Unifier copy = unifier.copy();
            Unifier substitution = this.substitute(copy).unify(term.substitute(copy));
            if (substitution != null) {
                copy.putAll(substitution);
                return copy;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public abstract Term substitute(Unifier unifier);

    public abstract HashSet<Variable> getVariables();

}
