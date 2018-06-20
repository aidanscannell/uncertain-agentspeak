package main.uncertainty;

import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.exceptions.NotGroundException;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public abstract class EpistemicState {

    private HashSet<BeliefAtom> domain;
    private HashMap<BeliefAtom, Weight> weightedBeliefBase;

    private final Weight initialWeight = new Weight(0,0);

    public EpistemicState(HashSet<BeliefAtom> domain) throws NotGroundException {
        for (BeliefAtom d : domain) {
            if (!d.isGround()) {
                throw new NotGroundException("The belief atoms in the domain must be ground");
            }
        }
        this.domain = domain;
        this.weightedBeliefBase = new HashMap<BeliefAtom, Weight>();
    }

    public HashSet<BeliefAtom> getDomain() {
        return domain;
    }

    public HashMap<BeliefAtom, Weight> getWeightedBeliefBase() {
        return weightedBeliefBase;
    }

    public Weight getInitialWeight() {
        return initialWeight;
    }

    public abstract void revise(BeliefLiteral beliefLiteral, double weight) throws Exception;

//    @Override
//    public String toString() {
//        String string = "{";
//        Iterator it = weightedBeliefBase.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            string += "[" + pair.getKey().toString() + ", " + pair.getValue().toString() + "]";
//            if (it.hasNext()) {
//                string += ", ";
//            }
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//        string += "}";
//        return string;
//    }
}
