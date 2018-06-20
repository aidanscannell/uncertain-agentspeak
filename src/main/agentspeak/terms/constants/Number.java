package main.agentspeak.terms.constants;

import main.agentspeak.terms.Constant;

/** Class that implements a constant term that represents a number */
public class Number extends Constant {

    private int value;

    public Number(int val){
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
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
        Number other = (Number) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }
}
