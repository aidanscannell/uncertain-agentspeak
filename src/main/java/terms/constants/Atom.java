package main.java.terms.constants;

import main.java.terms.Constant;

import static java.lang.Character.*;

/* Represents an atom (a positive literal with no argument or annotation) */
public class Atom extends Constant{

    // Fields:
    private String functor;

    // Constructor:
    public Atom(String functor){
        this.functor = functor;
    }

    // Methods:

    // Check atom name is all lowercase
    public static boolean isValid(String s){
        char check = s.charAt(0);
        return isLowerCase(check);
    }
}
