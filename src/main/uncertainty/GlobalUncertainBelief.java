package main.uncertainty;

import main.agentspeak.LogicalExpression;
import main.agentspeak.Unifier;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.RelationalExpression;
import main.agentspeak.logical_expressions.operators.Conjunction;
import main.agentspeak.logical_expressions.operators.Disjunction;
import main.agentspeak.logical_expressions.operators.GreaterEqualsPlausibility;
import main.agentspeak.logical_expressions.operators.GreaterThanPlausibility;
import main.agentspeak.logical_expressions.operators.negations.NegationAsFailure;
import main.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.agentspeak.logical_expressions.relational_expressions.Equal;
import main.agentspeak.logical_expressions.relational_expressions.NotEqual;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.Primitive;
import main.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.agentspeak.logical_expressions.terminals.primitives.Tautology;
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

    public HashSet<CompactEpistemicState> getRelevantEpistemicStates(LogicalExpression logicalExpression) {
        HashSet<CompactEpistemicState> relevantEpistemicStates = new HashSet<>();
        for (Map.Entry<HashSet<BeliefAtom>, CompactEpistemicState> epistemicState : epistemicStates.entrySet()) {
            CompactEpistemicState compactEpistemicState = epistemicState.getValue();
            if (compactEpistemicState.languageContains(logicalExpression)) {
                relevantEpistemicStates.add(compactEpistemicState);
            }
        }
        return relevantEpistemicStates;
    }

    public void revise(BeliefLiteral beliefLiteral, double weight) throws Exception {
        if (!beliefLiteral.isGround()) {
            throw new NotGroundException(beliefLiteral + "is not ground");
        }
        for (Map.Entry<HashSet<BeliefAtom>, CompactEpistemicState> epistemicStateEntry : epistemicStates.entrySet()) {
            BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();
            HashSet<BeliefAtom> domain = epistemicStateEntry.getKey();
            if ( domain.contains(beliefAtom) ) {
                CompactEpistemicState epistemicState = epistemicStateEntry.getValue();
                epistemicState.revise(beliefLiteral, weight);
                epistemicStates.put(domain, epistemicState);
                return;
            }
        }
        throw new Exception("No local epistemic state for: " + beliefLiteral);
    }

    public boolean languageContains(LogicalExpression logicalExpression) {
        for (Map.Entry<HashSet<BeliefAtom>, CompactEpistemicState> epistemicState : epistemicStates.entrySet()) {
            CompactEpistemicState compactEpistemicState = epistemicState.getValue();
            if (compactEpistemicState.languageContains(logicalExpression)) {
                return true;
            }
        }
        return false;
    }

//    public Unifier entails(LogicalExpression logicalExpression, Unifier unifier) {
//        LogicalExpression groundLogicalExpression = logicalExpression.substitute(unifier);
//        for (BeliefAtom beliefAtom : groundLogicalExpression.getBeliefAtoms()) {
//            if (this.languageContains(beliefAtom)) {
//
//            }
//        }
////        if (this.languageContains(groundBeliefAtom)) {
////            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundBeliefAtom);
////            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
////                compactEpistemicState.
////            }
////        }
//        return entails(logicalExpression, new Unifier());
//    }

//    public Unifier entails(LogicalExpression logicalExpression, Unifier unifier) throws Exception {
//        HashSet<Unifier> unifiers = this.getUnifiers(logicalExpression, unifier);
//
//        for (Unifier u : unifiers) {
//            LogicalExpression groundLogicalExpression = logicalExpression.substitute(u);
//            for (BeliefAtom beliefAtom : groundLogicalExpression.getBeliefAtoms()) {
//                if (this.languageContains(beliefAtom)) {
//                    System.out.println(groundLogicalExpression.toString());
//                    for (CompactEpistemicState compactEpistemicState : this.getRelevantEpistemicStates(groundLogicalExpression)) {
//                        System.out.println("here");
//                        Unifier unifierEntails = compactEpistemicState.entails(logicalExpression, u);
//                        if (unifierEntails != null) {
//                            return unifierEntails;
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }

    public Unifier entails(LogicalExpression logicalExpression) throws Exception {
        return entails(logicalExpression, new Unifier());
    }

    public Unifier entails(LogicalExpression logicalExpression, Unifier unifier) throws Exception {
        HashSet<Unifier> unifiers = this.getUnifiers(logicalExpression, unifier);

//        System.out.println(logicalExpression.);
        System.out.println(unifier);
        System.out.println(unifiers);
        for (Unifier u : unifiers) {
            Unifier unifierValid = null;
            if (logicalExpression instanceof Conjunction) {
                unifierValid = entails((Conjunction) logicalExpression, u);
            } else if (logicalExpression instanceof Disjunction) {
                unifierValid = entails((Disjunction) logicalExpression, u);
            } else if (logicalExpression instanceof GreaterEqualsPlausibility) {
                unifierValid = entails((GreaterEqualsPlausibility) logicalExpression, u);
            } else if (logicalExpression instanceof GreaterThanPlausibility) {
                unifierValid = entails((GreaterThanPlausibility) logicalExpression, u);
            } else if (logicalExpression instanceof StrongNegation) {
                unifierValid = entails((StrongNegation) logicalExpression, u);
            } else if (logicalExpression instanceof NegationAsFailure) {
                unifierValid = entails((NegationAsFailure) logicalExpression, u);
            } else if (logicalExpression instanceof BeliefAtom) {
                unifierValid = entails((BeliefAtom) logicalExpression, u);
            } else if (logicalExpression instanceof BeliefLiteral) {
                unifierValid = entails((BeliefLiteral) logicalExpression, u);
            } else if (logicalExpression instanceof Equal) {
                unifierValid = entails((Equal) logicalExpression, u);
            } else if (logicalExpression instanceof NotEqual) {
                unifierValid = entails((NotEqual) logicalExpression, u);
            } else if (logicalExpression instanceof Contradiction) {
                unifierValid = entails((Contradiction) logicalExpression, u);
            } else if (logicalExpression instanceof Tautology) {
                unifierValid = entails((Tautology) logicalExpression, u);
            }
            if (unifierValid != null) {
                return  unifierValid;
            }
        }
        return null;
    }

    public Unifier entails(Contradiction contradiction, Unifier unifier) {
        return null;
    }

    public Unifier entails(Tautology tautology, Unifier unifier) {
        return unifier;
    }

    public Unifier entails(BeliefAtom beliefAtom, Unifier unifier) throws Exception {
        BeliefAtom groundBeliefAtom = beliefAtom.substitute(unifier);
        if (this.languageContains(groundBeliefAtom)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundBeliefAtom);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(beliefAtom, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public Unifier entails(BeliefLiteral beliefLiteral, Unifier unifier) throws Exception {
        BeliefLiteral groundBeliefLiteral = beliefLiteral.substitute(unifier);
        if (this.languageContains(groundBeliefLiteral)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundBeliefLiteral);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(beliefLiteral, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public Unifier entails(Conjunction conjunction, Unifier unifier) throws Exception {
        Conjunction groundConjunction = conjunction.substitute(unifier);
        if (this.languageContains(groundConjunction)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundConjunction);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(conjunction, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
            return null;
        } else {
            Unifier unifierLeft = this.entails(conjunction.getLeft(), unifier);
            Unifier unifierRight = null;
            if (unifierLeft != null) {
                unifierRight = this.entails(conjunction.getRight(), unifierLeft);
            }
            return unifierRight;
        }
    }

    public Unifier entails(Disjunction disjunction, Unifier unifier) throws Exception {
        Disjunction groundDisjunction = disjunction.substitute(unifier);
        if (this.languageContains(groundDisjunction)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundDisjunction);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(disjunction, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
            return null;
        } else {
            Unifier unifierLeft = this.entails(disjunction.getLeft(), unifier);
            Unifier unifierRight = null;
            if (unifierLeft != null) {
                unifierRight = this.entails(disjunction.getRight(), unifierLeft);
            }
            return unifierRight;
        }
    }

    public Unifier entails(GreaterEqualsPlausibility greaterEqualsPlausibility, Unifier unifier) throws Exception {
        GreaterEqualsPlausibility groundGreaterEqualsPlausibility = greaterEqualsPlausibility.substitute(unifier);
        if (this.languageContains(groundGreaterEqualsPlausibility)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundGreaterEqualsPlausibility);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(greaterEqualsPlausibility, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
            return null;
        } else {
            Unifier unifierLeft = this.entails(greaterEqualsPlausibility.getLeft(), unifier);
            Unifier unifierRight = null;
            if (unifierLeft != null) {
                unifierRight = this.entails(greaterEqualsPlausibility.getRight(), unifierLeft);
            }
            return unifierRight;
        }
    }

    public Unifier entails(GreaterThanPlausibility greaterThanPlausibility, Unifier unifier) throws Exception {
        GreaterThanPlausibility groundGreaterThanPlausibility = greaterThanPlausibility.substitute(unifier);
        if (this.languageContains(groundGreaterThanPlausibility)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundGreaterThanPlausibility);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(greaterThanPlausibility, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
            return null;
        } else {
            Unifier unifierLeft = this.entails(greaterThanPlausibility.getLeft(), unifier);
            Unifier unifierRight = null;
            if (unifierLeft != null) {
                unifierRight = this.entails(greaterThanPlausibility.getRight(), unifierLeft);
            }
            return unifierRight;
        }
    }

    public Unifier entails(StrongNegation strongNegation, Unifier unifier) throws Exception {
        StrongNegation groundStrongNegation = strongNegation.substitute(unifier);
        if (this.languageContains(groundStrongNegation)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundStrongNegation);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(strongNegation, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public Unifier entails(NegationAsFailure negationAsFailure, Unifier unifier) throws Exception {
        NegationAsFailure groundNegationAsFailure = negationAsFailure.substitute(unifier);
        if (this.languageContains(groundNegationAsFailure)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundNegationAsFailure);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(negationAsFailure, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public Unifier entails(Equal equal, Unifier unifier) throws Exception {
        Equal groundEqual = equal.substitute(unifier);
        if (this.languageContains(groundEqual)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundEqual);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(equal, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public Unifier entails(NotEqual notEqual, Unifier unifier) throws Exception {
        NotEqual groundNotEqual = notEqual.substitute(unifier);
        if (this.languageContains(groundNotEqual)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundNotEqual);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(notEqual, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    public HashSet<Unifier> getUnifiers(LogicalExpression logicalExpression, Unifier unifier) {
        if (logicalExpression instanceof Conjunction) {
            return getUnifiers((Conjunction) logicalExpression, unifier);
        } else if (logicalExpression instanceof Disjunction) {
            return getUnifiers((Disjunction) logicalExpression, unifier);
        } else if (logicalExpression instanceof Primitive) {
            return getUnifiers((Primitive) logicalExpression, unifier);
        } else if (logicalExpression instanceof GreaterEqualsPlausibility) {
            return getUnifiers((GreaterEqualsPlausibility) logicalExpression, unifier);
        } else if (logicalExpression instanceof GreaterThanPlausibility) {
            return getUnifiers((GreaterThanPlausibility) logicalExpression, unifier);
        } else if (logicalExpression instanceof StrongNegation) {
            return getUnifiers((StrongNegation) logicalExpression, unifier);
        } else if (logicalExpression instanceof NegationAsFailure) {
            return getUnifiers((NegationAsFailure) logicalExpression, unifier);
        } else if (logicalExpression instanceof BeliefAtom) {
            return getUnifiers((BeliefAtom) logicalExpression, unifier);
        } else if (logicalExpression instanceof BeliefLiteral) {
            return getUnifiers((BeliefLiteral) logicalExpression, unifier);
        } else if (logicalExpression instanceof RelationalExpression) {
            return getUnifiers((RelationalExpression) logicalExpression, unifier);
        } else {
            return null;
            //TODO: throw exception
        }
    }

    public HashSet<Unifier> getUnifiers(Conjunction conjunction, Unifier unifier) {
        HashSet<Unifier> unifiersL = this.getUnifiers(conjunction.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(conjunction.getRight(), u));
        }
        return unifiersR;
    }

    public HashSet<Unifier> getUnifiers(Disjunction disjunction, Unifier unifier) {
        HashSet<Unifier> unifiersL = this.getUnifiers(disjunction.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(disjunction.getRight(), u));
        }
        return unifiersR;
    }

    public HashSet<Unifier> getUnifiers(Primitive primitive, Unifier unifier) {
        HashSet<Unifier> unifiers = new HashSet<>();
        unifiers.add(unifier);
        return unifiers;
    }

    public HashSet<Unifier> getUnifiers(GreaterEqualsPlausibility greaterEqualsPlausibility, Unifier unifier) {
        HashSet<Unifier> unifiersL = this.getUnifiers(greaterEqualsPlausibility.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(greaterEqualsPlausibility.getRight(), u));
        }
        return unifiersR;
    }

    public HashSet<Unifier> getUnifiers(GreaterThanPlausibility greaterThanPlausibility, Unifier unifier) {
        HashSet<Unifier> unifiersL = this.getUnifiers(greaterThanPlausibility.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(greaterThanPlausibility.getRight(), u));
        }
        return unifiersR;
    }

    public HashSet<Unifier> getUnifiers(StrongNegation strongNegation, Unifier unifier) {
        return this.getUnifiers(strongNegation.getTerm(), unifier);
    }

    public HashSet<Unifier> getUnifiers(NegationAsFailure negationAsFailure, Unifier unifier) {
        return this.getUnifiers(negationAsFailure.getTerm(), unifier);
    }

    public HashSet<Unifier> getUnifiers(BeliefAtom beliefAtom, Unifier unifier) {
        HashSet<Unifier> unifiers = new HashSet<>();
        for (BeliefAtom beliefAtomDomain : domain) {
            Unifier u = beliefAtom.substitute(unifier).getTerm().unify(beliefAtomDomain.getTerm());
            if (u != null) {
                u.putAll(unifier);
                unifiers.add(u);
            }
        }
        return unifiers;
    }

    public HashSet<Unifier> getUnifiers(BeliefLiteral beliefLiteral, Unifier unifier) {
        return this.getUnifiers(beliefLiteral.getBeliefAtom(), unifier);
    }

    public HashSet<Unifier> getUnifiers(RelationalExpression relationalExpression, Unifier unifier) {
        HashSet<Unifier> unifiers = new HashSet<>();
        unifiers.add(unifier);
        return unifiers;
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
