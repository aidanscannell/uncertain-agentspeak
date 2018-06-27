package main.agentspeak.terms.constants.numbers;

import main.agentspeak.terms.constants.Number;

import static java.lang.Double.doubleToLongBits;

public class Double extends Number {

    private double value;

    public Double(double val){
        this.value = val;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        long bits = doubleToLongBits(value);
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(bits ^ (bits >>> 32));
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
        Double other = (Double) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

}
