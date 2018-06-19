package main.agentspeak.terms.constants;

import main.agentspeak.terms.Constant;

/** Class that implements a constant term that represents text */
public class Text extends Constant {

    private String value;

    public Text(String val){
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
