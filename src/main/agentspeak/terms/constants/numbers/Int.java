package main.agentspeak.terms.constants.numbers;

import main.agentspeak.terms.constants.Number;

public class Int extends Number {

    private int value;

    public Int(int val){
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
        Int other = (Int) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

}
