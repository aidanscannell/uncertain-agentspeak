package main.agentspeak.terms.constants;

import main.agentspeak.terms.Constant;

import static java.lang.Character.isLowerCase;

/** Class that implements a constant term that represents an atom
 * (a positive literal with no argument or annotation)
 */
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

    @Override
    public String toString() {
        return label;
    }
}
