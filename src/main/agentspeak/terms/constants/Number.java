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
}
