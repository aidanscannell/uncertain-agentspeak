package main.java.terms.constants;

import main.java.terms.Constant;

/** Class that implements a term that represents text/string */
public class Text extends Constant {

    private String value;

    public Text(String val){
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
