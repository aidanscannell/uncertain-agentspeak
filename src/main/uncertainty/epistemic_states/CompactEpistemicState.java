package main.uncertainty.epistemic_states;

import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.belief_literals.NegativeLiteral;
import main.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.exceptions.NotGroundException;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.uncertainty.EpistemicState;
import main.uncertainty.epistemic_states.Weight;

import java.util.HashMap;
import java.util.HashSet;

public abstract class CompactEpistemicState extends EpistemicState {

    private HashSet<BeliefAtom> domain;
    private HashMap<BeliefAtom, Weight> weightedBeliefBase;

    private final Weight initialWeight = new Weight(0,0);

    public CompactEpistemicState(HashSet<BeliefAtom> domain) throws NotGroundException {
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

    public Weight getWeight(BeliefAtom beliefAtom) throws Exception {
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(beliefAtom);
            } else {
                return getInitialWeight().copy();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

    public double getWeight(BeliefLiteral beliefLiteral) throws Exception {
        if (beliefLiteral.isPositive()) {
            return getWeight((PositiveLiteral) beliefLiteral);
        } else {
            return getWeight((NegativeLiteral) beliefLiteral);
        }
    }

    public double getWeight(PositiveLiteral positiveLiteral) throws Exception {
        BeliefAtom beliefAtom = positiveLiteral.getBeliefAtom();
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(positiveLiteral.getBeliefAtom()).getPositive();
            } else {
                return this.getInitialWeight().getPositive();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

    public double getWeight(NegativeLiteral negativeLiteral) throws Exception {
        BeliefAtom beliefAtom = negativeLiteral.getBeliefAtom();
        if (this.domain.contains(beliefAtom)) {
            if (this.weightedBeliefBase.containsKey(beliefAtom)) {
                return this.weightedBeliefBase.get(negativeLiteral.getBeliefAtom()).getNegative();
            } else {
                return this.getInitialWeight().getPositive();
            }
        } else {
            throw new Exception("Belief atom not contained in domain");
        }
    }

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
