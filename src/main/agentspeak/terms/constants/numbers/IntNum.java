package main.agentspeak.terms.constants.numbers;

import main.agentspeak.terms.constants.Number;

public class IntNum extends Number {

    private int value;

    public IntNum(int val){
        this.value = val;
    }

    public int getIntVal() {
        return value;
    }

    public double getDoubleVal() {
        return (double) value;
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
        IntNum other = (IntNum) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

}
