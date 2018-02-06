package main.java.terms.constants;

import main.java.terms.Constant;

/** Class that implements a term that represents a number */
public class Number extends Constant {

    private int value;

    public Number(int val){
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
