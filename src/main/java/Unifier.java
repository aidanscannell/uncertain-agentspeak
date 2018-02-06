package main.java;

import java.util.HashMap;
import main.java.terms.*;

public class Unifier extends HashMap<Variable, Term> {

    public Unifier copy() {
        Unifier unifier = new Unifier();
        unifier.putAll(this);
        return unifier;
    }
}
