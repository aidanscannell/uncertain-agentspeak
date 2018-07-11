package main.java.uncertain_agentspeak.agentspeak;

import java.util.HashMap;
import main.java.uncertain_agentspeak.agentspeak.terms.*;

public class Unifier extends HashMap<Variable, Term> {

    public Unifier copy(){
        Unifier unifier = new Unifier();
        unifier.putAll(this);
        return unifier;
    }

}
