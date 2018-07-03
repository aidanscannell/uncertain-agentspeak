package main.agentspeak.logical_expressions.terminals.primitives;

import main.agentspeak.logical_expressions.terminals.Primitive;

public class Contradiction extends Primitive {

    private final boolean value = false;

    @Override
    public String toString() {
        return "false";
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
        Contradiction other = (Contradiction) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }
}
