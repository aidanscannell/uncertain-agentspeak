package main.uncertainty;

import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.exceptions.NotGroundException;
import main.uncertainty.epistemic_states.CompactEpistemicState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class GlobalUncertainBelief {

    private HashSet<BeliefAtom> domain;
    private HashMap<HashSet<BeliefAtom>, CompactEpistemicState> epistemicStates;

    public GlobalUncertainBelief() {
        domain = new HashSet<BeliefAtom>();
        epistemicStates = new HashMap<HashSet<BeliefAtom>, CompactEpistemicState>();
    }

    public void addEpistemicState(CompactEpistemicState epistemicState) throws Exception {
        if(!this.domain.isEmpty() && !epistemicState.getDomain().isEmpty()) {
            for (BeliefAtom t : epistemicState.getDomain()) {
                if (domain.contains(t)) {
                    throw new Exception("Intersects with existing epistemic state");
                }
            }
        }
        this.domain.addAll(epistemicState.getDomain());
        epistemicStates.put(epistemicState.getDomain(), epistemicState);
//        System.out.println("\nSuccessfully added epistemic state: \n\t" + epistemicStates.toString());
        System.out.println("\nSuccessfully added epistemic state.");
    }

    public HashMap<HashSet<BeliefAtom>, CompactEpistemicState> getGUB() {
        return epistemicStates;
    }

    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        if (!beliefLiteral.isGround()) {
            throw new NotGroundException(beliefLiteral + "is not ground");
        }
        for (Map.Entry<HashSet<BeliefAtom>, CompactEpistemicState> epistemicStateEntry : epistemicStates.entrySet()) {
            BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();
            HashSet<BeliefAtom> domain = epistemicStateEntry.getKey();
//            System.out.println(domain);
//            System.out.println(beliefAtom);
            if ( domain.contains(beliefAtom) ) {
//                System.out.println("here2");
                CompactEpistemicState epistemicState = epistemicStateEntry.getValue();
                epistemicState.revise(beliefLiteral, weight);
                epistemicStates.put(domain, epistemicState);
                return;
            }
        }
        throw new Exception("No local epistemic state for: " + beliefLiteral);
    }

    @Override
    public String toString() {
        String string = "\nGlobal Uncertain Belief:\n\t";
        Iterator it = epistemicStates.entrySet().iterator();
        int i = 1;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            string += "Epistemic State " + i + ": \n\t\tDomain: " + pair.getKey().toString() + "\n\t\t" + pair.getValue().toString();
            if (it.hasNext()) {
                string += ", \n\t";
            }
            i += 1;
        }
        string += "\n\t}";
        return string;
    }
}
