package main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.primitives;

import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.Primitive;

public class Tautology extends Primitive {

    private final boolean value = true;

    public Tautology substitute(Unifier unifier) {
        return this;
    }

    public Contradiction negation() {
        return new Contradiction();
    }

    @Override
    public String toString() {
        return "true";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( value ? 1231 : 1237 );
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
        Tautology other = (Tautology) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

}
