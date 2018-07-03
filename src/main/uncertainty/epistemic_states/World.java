package main.uncertainty.epistemic_states;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.operators.Conjunction;
import main.agentspeak.logical_expressions.operators.Disjunction;
import main.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.agentspeak.logical_expressions.terminals.primitives.Tautology;

import java.util.HashSet;

public class World {

    private HashSet<BeliefAtom> atoms;

    public World() {
        atoms = new HashSet<BeliefAtom>();
    }

    public World(BeliefAtom... beliefAtoms) {
        for (BeliefAtom beliefAtom : beliefAtoms) {
            this.atoms.add(beliefAtom);
        }
    }

    public boolean entails(LogicalExpression logicalExpression) throws Exception {
        if (logicalExpression instanceof BeliefAtom) {
            return this.entails((BeliefAtom) logicalExpression);
        } else if (logicalExpression instanceof BeliefLiteral) {
            return this.entails((BeliefLiteral) logicalExpression);
        } else if (logicalExpression instanceof Conjunction) {
            return this.entails((Conjunction) logicalExpression);
        } else if (logicalExpression instanceof  Disjunction) {
            return this.entails((Disjunction) logicalExpression);
        } else if (logicalExpression instanceof Contradiction) {
            return this.entails((Contradiction) logicalExpression);
        } else if (logicalExpression instanceof Tautology) {
            return this.entails((Tautology) logicalExpression);
        } else if (logicalExpression instanceof StrongNegation) {
            return this.entails((StrongNegation) logicalExpression);
        } else {
            throw new Exception("Operation no supported in language");
        }
    }

    public boolean entails(BeliefAtom beliefAtom) {
        return atoms.contains(beliefAtom);
    }

    public boolean entails(BeliefLiteral beliefLiteral) {
        if (beliefLiteral.isPositive()) {
            return atoms.contains(beliefLiteral.getBeliefAtom());
        } else {
            return !atoms.contains(beliefLiteral.getBeliefAtom());
        }
    }

    public boolean entails(Conjunction conjunction) throws Exception {
        return this.entails(conjunction.getLeft()) && this.entails(conjunction.getRight());
    }

    public boolean entails(Disjunction disjunction) throws Exception {
        return this.entails(disjunction.getLeft()) || this.entails(disjunction.getRight());
    }

    public boolean entails(Contradiction contradiction) {
        return false;
    }

    public boolean entails(Tautology tautology) {
        return true;
    }

    public boolean entails(StrongNegation strongNegation) throws Exception {
        return !this.entails(strongNegation.getTerm());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (atoms == null) ? 0 : atoms.hashCode() );
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
        World other = (World) obj;
        if (atoms == null && other.atoms == null) {
            return false;
        } else if (!atoms.equals(other.atoms)) {
            return false;
        }
        return true;
    }

}

