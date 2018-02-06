package main.java.terms.constants;

import main.java.terms.Constant;

import static java.lang.Character.*;

/** Class that implements a term that represents an atom (a positive literal with no argument or annotation) */
public class Atom extends Constant{

    private String label;

    public Atom(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // Check atom name is all lowercase
    public static boolean isValid(String s){
        char check = s.charAt(0);
        return isLowerCase(check);
    }
}
