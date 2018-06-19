package main.agentspeak;

import java.util.LinkedList;

public class Context extends LinkedList<ContextBelief> {

    public Context copy(){
        Context copy = new Context();
        copy.addAll(this);
        return copy;
    }
}
