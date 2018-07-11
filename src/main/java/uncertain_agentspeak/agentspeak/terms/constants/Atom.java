package main.java.uncertain_agentspeak.agentspeak.terms.constants;

import main.java.uncertain_agentspeak.agentspeak.terms.Constant;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (label == null) ? 0 : label.hashCode() );
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
        Atom other = (Atom) obj;
        if (label == null && other.label == null) {
            return false;
        } else if (!label.equals(other.label)) {
            return false;
        }
        return true;
    }
}
