package main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states;

import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Conjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.Disjunction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.uncertainty.sat_solver.SATsolver;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.Weight;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CompactProbabilisticEpistemicState extends CompactEpistemicState {

    public CompactProbabilisticEpistemicState(HashSet<BeliefAtom> atoms) throws Exception {
        super(atoms);
    }

    public double getMinWeight() {
        return 0;
    }

    public double getMaxWeight() {
        return 1;
    }

    @Override
    public Weight getInitialWeight() {
        return new Weight(0.5, 0.5);
    }

    @Override
    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();

        if (!super.getDomain().contains(beliefAtom)) {
            throw new Exception("Belief atom is not in domain");
        }

        /** If belief atom in domain revise it's corresponding weight, otherwise revise initial probabilistic weight
         * **/
        Weight w;
        if (this.getWeightedBeliefBase().containsKey(beliefAtom)) {
            w = this.getWeightedBeliefBase().get(beliefAtom);
        } else {
            w = this.getInitialWeight().copy();
        }

        /** Check if the belief literal is positive or negative and revise accordingly
         * **/
        if (beliefLiteral.isPositive()) {
            w.setPositive(weight);
            w.setNegative(this.getMaxWeight() - weight);
        } else {
            w.setNegative(weight);
            w.setPositive(this.getMaxWeight() - weight);
        }

        /** If the atom is contained in the weighted belief base and it's revised weight is equal to the initial
         * probabilistic weight then remove it from the weighted belief base, otherwise put the belief atom and
         * its associated weight into the weighted belief base.
         * **/
        if (this.getWeightedBeliefBase().containsKey(beliefAtom) && w.equals(this.getInitialWeight())) {
            this.getWeightedBeliefBase().remove(beliefAtom);
        } else {
            this.getWeightedBeliefBase().put(beliefAtom, w);
        }

    }

    public double getProbability(BeliefLiteral beliefLiteral) throws Exception {
        return this.getWeight(beliefLiteral);
    }

    @Override
    public double getLambda(BeliefLiteral beliefLiteral, HashSet<BeliefLiteral> beliefLiterals) throws Exception {
        return this.getProbability(beliefLiteral);
    }

    @Override
    public double getLambda(Conjunction conjunction, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        SATsolver satSolver = new SATsolver();
        if (satSolver.solve(conjunction)) {
            return this.getLambda(conjunction.getLeft()) * this.getLambda(conjunction.getRight());
        } else {
            return this.getMinWeight();
        }

    }

    @Override
    public double getLambda(Disjunction disjunction, HashSet<BeliefLiteral> boundedLiterals) throws Exception {
        return this.getLambda(disjunction.getLeft()) + this.getLambda(disjunction.getRight()) - this.getLambda(new Conjunction(disjunction.getLeft(), disjunction.getRight()));
    }

    @Override
    public String toString() {
        String string = "{ ";
        Iterator it = this.getWeightedBeliefBase().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            string += "\n\t\t\tProb( " + pair.getKey().toString() + ", " + pair.getValue().toString() + " )";
            if (it.hasNext()) {
                string += ", ";
            }
        }
        string += " \n\t\t}";
        return string;
    }
}
