package main.java.uncertain_agentspeak.agentspeak.terms;

import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;

import java.util.HashSet;

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
    public HashSet<Variable> getVariables() {
        HashSet<Variable> variables = new HashSet<>();
        variables.add(this);
        return variables;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (label == null) ? 0 : label.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        Variable other = (Variable) obj;
        if (label == null && other.label == null) {
            return false;
        } else if (!label.equals(other.label)) {
            return false;
        }
        return true;
    }
}
