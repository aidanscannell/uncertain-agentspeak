package main.agentspeak.terms.constants;

import main.agentspeak.terms.Constant;

/** Class that implements a constant term that represents a number */
public abstract class Number extends Constant {

    public abstract int getIntVal();

    public abstract double getDoubleVal();

}
