package main.java.uncertain_agentspeak.uncertainty;

import main.java.uncertain_agentspeak.agentspeak.LogicalExpression;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.RelationalExpression;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.*;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.operators.negations.StrongNegation;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.Primitive;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.primitives.Contradiction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.primitives.Tautology;
import main.java.uncertain_agentspeak.exceptions.NotGroundException;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactPossibilisticEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class GlobalUncertainBelief {

    private final Logger LOGGER = LogManager.getLogger("Global Uncertain Belief");

    private HashSet<BeliefAtom> domain;
    private HashMap<HashSet<BeliefAtom>, CompactEpistemicState> epistemicStates;

    public GlobalUncertainBelief() {
        domain = new HashSet<>();
        epistemicStates = new HashMap<>();
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
//        System.out.println("\nSuccessfully added epistemic state.");
//        LOGGER.info("Successfully added epistemic state.");
    }

    public HashMap<HashSet<BeliefAtom>, CompactEpistemicState> getGUB() {
        return epistemicStates;
    }

    private HashSet<CompactEpistemicState> getRelevantEpistemicStates(LogicalExpression logicalExpression) {
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
//                System.out.println("Revised Epistemic State: " + epistemicState.toString());
//                LOGGER.info("Successfully revised epistemic state: ");
                return;
            }
        }
        LOGGER.error("No local epistemic state for: " + beliefLiteral);
        throw new Exception("No local epistemic state for: " + beliefLiteral);
    }

    private boolean languageContains(LogicalExpression logicalExpression) {
        for (Map.Entry<HashSet<BeliefAtom>, CompactEpistemicState> epistemicState : epistemicStates.entrySet()) {
            CompactEpistemicState compactEpistemicState = epistemicState.getValue();
            if (compactEpistemicState.languageContains(logicalExpression)) {
                return true;
            }
        }
        return false;
    }

    public Unifier entails(LogicalExpression logicalExpression) throws Exception {
        return entails(logicalExpression, new Unifier());
    }

    public Unifier entails(LogicalExpression logicalExpression, Unifier unifier) throws Exception {
//        System.out.println("getting unifiers");
        HashSet<Unifier> unifiers = this.getUnifiers(logicalExpression, unifier);
//        System.out.println("Got unifiers");
//        System.out.println(unifiers);

        for (Unifier u : unifiers) {
//            System.out.println("NEW UNIFIER TEST: " + u);
//            System.out.println(logicalExpression.getClass());
            Unifier unifierValid = null;
            if (logicalExpression instanceof Conjunction) {
                unifierValid = entails((Conjunction) logicalExpression, u);
            } else if (logicalExpression instanceof Disjunction) {
                unifierValid = entails((Disjunction) logicalExpression, u);
            } else if (logicalExpression instanceof GreaterEqualsPlausibility) {
                unifierValid = entails((GreaterEqualsPlausibility) logicalExpression, u);
            } else if (logicalExpression instanceof GreaterThanPlausibility) {
                unifierValid = entails((GreaterThanPlausibility) logicalExpression, u);
            } else if (logicalExpression instanceof Negation) {
                unifierValid = entails((Negation) logicalExpression, u);
            } else if (logicalExpression instanceof BeliefAtom) {
                unifierValid = entails((BeliefAtom) logicalExpression, u);
            } else if (logicalExpression instanceof BeliefLiteral) {
                unifierValid = entails((BeliefLiteral) logicalExpression, u);
            } else if (logicalExpression instanceof RelationalExpression) {
                unifierValid = entails((RelationalExpression) logicalExpression, u);
            } else if (logicalExpression instanceof Contradiction) {
                unifierValid = entails((Contradiction) logicalExpression, u);
            } else if (logicalExpression instanceof Tautology) {
                unifierValid = entails((Tautology) logicalExpression, u);
            }
//            System.out.println("Valid unifier: " + unifierValid);
//            System.out.println(logicalExpression.getClass());
            if (unifierValid != null) {
                return  unifierValid;
            }
        }
        return null;
    }

    private Unifier entails(Contradiction contradiction, Unifier unifier) {
        return null;
    }

    private Unifier entails(Tautology tautology, Unifier unifier) {
        return unifier;
    }

    private Unifier entails(BeliefAtom beliefAtom, Unifier unifier) throws Exception {
        BeliefAtom groundBeliefAtom = beliefAtom.substitute(unifier);
        if (this.languageContains(groundBeliefAtom)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundBeliefAtom);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
//                System.out.println(compactEpistemicState.toString());
                Unifier unifierValid = compactEpistemicState.entails(beliefAtom, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    private Unifier entails(BeliefLiteral beliefLiteral, Unifier unifier) throws Exception {
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

    private Unifier entails(Conjunction conjunction, Unifier unifier) throws Exception {
        Conjunction groundConjunction = conjunction.substitute(unifier);
        if (this.languageContains(groundConjunction)) {
//            System.out.println("CONJUNCTION FIRST: " + groundConjunction.toString());
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundConjunction);
//            System.out.println("RELEVANT ES: " + relevantEpistemicStates.toString());
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(conjunction, unifier);
                if (unifierValid != null) {
//                    System.out.println("UNIFIER VALID: " + unifierValid);
                    return unifierValid;
                }
            }
            return null;
        } else {
//            System.out.println("CONJUNCTION SECOND: " + groundConjunction.toString());
            Unifier unifierLeft = this.entails(conjunction.getLeft(), unifier);
            Unifier unifierRight = null;
            if (unifierLeft != null) {
                unifierRight = this.entails(conjunction.getRight(), unifierLeft);
            }
            return unifierRight;
        }
    }

    private Unifier entails(Disjunction disjunction, Unifier unifier) throws Exception {
        Disjunction groundDisjunction = disjunction.substitute(unifier);
//        System.out.println("DISJUNCTION: " + groundDisjunction);
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
            if ( this.entails(disjunction.getLeft(), unifier) != null || this.entails(disjunction.getRight(), unifier) != null && groundDisjunction.isGround()) {
                return unifier;
            }
            return null;
        }
    }

    private Unifier entails(GreaterEqualsPlausibility greaterEqualsPlausibility, Unifier unifier) throws Exception {
        GreaterEqualsPlausibility groundGreaterEqualsPlausibility = greaterEqualsPlausibility.substitute(unifier);
//        System.out.println("GREATER EQUALS: " + groundGreaterEqualsPlausibility.toString());
        if (this.languageContains(groundGreaterEqualsPlausibility)) {
//            System.out.println("GREATER EQUAL IN LANGUAGE: " + groundGreaterEqualsPlausibility.toString());
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundGreaterEqualsPlausibility);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(greaterEqualsPlausibility, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
            return null;
        } else {
//            System.out.println("GREATER EQUAL NOT IN LANGUAGE: " + groundGreaterEqualsPlausibility.toString());
            if (groundGreaterEqualsPlausibility.isGround() ) {
                if (languageContains(groundGreaterEqualsPlausibility.getLeft()) && languageContains(groundGreaterEqualsPlausibility.getRight())) {
                    double lambdaLeft = 0;
                    double lambdaRight = 0;
                    CompactEpistemicState classLeft = null;
                    CompactEpistemicState classRight = null;

                    StrongNegation negatedLeft = new StrongNegation(groundGreaterEqualsPlausibility.getLeft());
                    StrongNegation negatedRight = new StrongNegation(groundGreaterEqualsPlausibility.getRight());

                    for (CompactEpistemicState compactEpistemicState : getRelevantEpistemicStates(negatedLeft)) {
                        classLeft = compactEpistemicState;
                        lambdaLeft = compactEpistemicState.getLambda(negatedLeft);
                    }

                    for (CompactEpistemicState compactEpistemicState : getRelevantEpistemicStates(negatedRight)) {
                        classRight = compactEpistemicState;
                        lambdaRight = compactEpistemicState.getLambda(negatedRight);
                    }
                    if (classLeft instanceof CompactProbabilisticEpistemicState && !(classRight instanceof CompactProbabilisticEpistemicState)) {
                        LOGGER.error("The operands of a qualitative operator must be of the same type");
//                        throw new Exception("The operands of a qualitative operator must be of the same type");
                    } else if (classLeft instanceof CompactPossibilisticEpistemicState && !(classRight instanceof CompactPossibilisticEpistemicState)) {
                        LOGGER.error("The operands of a qualitative operator must be of the same type");
//                        throw new Exception("The operands of a qualitative operator must be of the same type");
                    }

//                    System.out.println("GUB entailment with >= : left lambda = " + lambdaLeft + ", right lambda = " + lambdaRight);
                    if (lambdaLeft <= lambdaRight) {
//                        System.out.println("Lambda left <= lambda right");
                        return unifier;
                    }
                    return null;
                } else {
                    //TODO: Add exception
                    LOGGER.error("The operands must be formulas in the language L_G");
//                    System.out.println("The operands must be formulas in the language L_G");
                    return null;
                }
            } else {
                LOGGER.error("Formula is not ground.");
                return null;
            }
        }
    }

    private Unifier entails(GreaterThanPlausibility greaterThanPlausibility, Unifier unifier) throws Exception {
        GreaterThanPlausibility groundGreaterThanPlausibility = greaterThanPlausibility.substitute(unifier);
//        System.out.println("GREATER THAN: " + groundGreaterThanPlausibility.toString());
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
            if (groundGreaterThanPlausibility.isGround() ) {
                if (languageContains(groundGreaterThanPlausibility.getLeft()) && languageContains(groundGreaterThanPlausibility.getRight())) {
                    double lambdaLeft = 0;
                    double lambdaRight = 0;
                    CompactEpistemicState classLeft = null;
                    CompactEpistemicState classRight = null;

                    StrongNegation negatedLeft = new StrongNegation(groundGreaterThanPlausibility.getLeft());
                    StrongNegation negatedRight = new StrongNegation(groundGreaterThanPlausibility.getRight());

                    for (CompactEpistemicState compactEpistemicState : getRelevantEpistemicStates(negatedLeft)) {
                        classLeft = compactEpistemicState;
                        lambdaLeft = compactEpistemicState.getLambda(negatedLeft);
                    }

                    for (CompactEpistemicState compactEpistemicState : getRelevantEpistemicStates(negatedRight)) {
                        classRight = compactEpistemicState;
                        lambdaRight = compactEpistemicState.getLambda(negatedRight);
                    }
                    if (classLeft instanceof CompactProbabilisticEpistemicState && !(classRight instanceof CompactProbabilisticEpistemicState)) {
                        LOGGER.error("The operands of a qualitative operator must be of the same type");
//                        throw new Exception("The operands of a qualitative operator must be of the same type");
                    } else if (classLeft instanceof CompactPossibilisticEpistemicState && !(classRight instanceof CompactPossibilisticEpistemicState)) {
                        LOGGER.error("The operands of a qualitative operator must be of the same type");
//                        throw new Exception("The operands of a qualitative operator must be of the same type");
                    }

//                    System.out.println("GUB entailment with > : left lambda = " + lambdaLeft + ", right lambda = " + lambdaRight);
                    if (lambdaLeft < lambdaRight) {
//                        System.out.println("Lambda left < lambda right");
                        return unifier;
                    }
                    return null;
                } else {
                    //TODO: Add exception
                    LOGGER.error("The operands must be formulas in the language L_G");
//                    System.out.println("The operands must be formulas in the language L_G");
                    return null;
                }
            } else {
                LOGGER.error("Formula is not ground.");
//                System.out.println("Formula is not ground.");
                return null;
            }
        }
    }

    private Unifier entails(Negation negation, Unifier unifier) throws Exception {
        Negation groundNegation = (Negation) negation.substitute(unifier);
        if (this.languageContains(groundNegation)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundNegation);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(negation, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }

    private Unifier entails(RelationalExpression relationalExpression, Unifier unifier) throws Exception {
        RelationalExpression groundRelationalExpression = (RelationalExpression) relationalExpression.substitute(unifier);
        if (this.languageContains(groundRelationalExpression)) {
            HashSet<CompactEpistemicState> relevantEpistemicStates = getRelevantEpistemicStates(groundRelationalExpression);
            for (CompactEpistemicState compactEpistemicState : relevantEpistemicStates) {
                Unifier unifierValid = compactEpistemicState.entails(relationalExpression, unifier);
                if (unifierValid != null) {
                    return unifierValid;
                }
            }
        }
        return null;
    }


    private HashSet<Unifier> getUnifiers(LogicalExpression logicalExpression, Unifier unifier) throws Exception {

        if(logicalExpression instanceof Primitive) {
            return this.getUnifiers((Primitive)logicalExpression, unifier);
        } else if(logicalExpression instanceof BeliefAtom) {
            return this.getUnifiers((BeliefAtom)logicalExpression, unifier);
        } else if(logicalExpression instanceof BeliefLiteral) {
            return this.getUnifiers((BeliefLiteral)logicalExpression, unifier);
        } else if(logicalExpression instanceof Conjunction) {
            return this.getUnifiers((Conjunction)logicalExpression, unifier);
        } else if(logicalExpression instanceof Disjunction) {
            return this.getUnifiers((Disjunction)logicalExpression, unifier);
        } else if(logicalExpression instanceof GreaterEqualsPlausibility) {
            return this.getUnifiers((GreaterEqualsPlausibility)logicalExpression, unifier);
        } else if(logicalExpression instanceof GreaterThanPlausibility) {
            return this.getUnifiers((GreaterThanPlausibility)logicalExpression, unifier);
        } else if(logicalExpression instanceof Negation) {
            return this.getUnifiers((Negation)logicalExpression, unifier);
        } else if(logicalExpression instanceof RelationalExpression) {
            return this.getUnifiers((RelationalExpression)logicalExpression, unifier);
        } else {
            return null;
//            //TODO: throw exception
        }
    }

    private HashSet<Unifier> getUnifiers(Conjunction conjunction, Unifier unifier) throws Exception {
        HashSet<Unifier> unifiersL = this.getUnifiers(conjunction.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(conjunction.getRight(), u));
        }
        return unifiersR;
    }

    private HashSet<Unifier> getUnifiers(Disjunction disjunction, Unifier unifier) throws  Exception {
        HashSet<Unifier> unifiersL = this.getUnifiers(disjunction.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(disjunction.getRight(), u));
        }
        return unifiersR;
    }

    private HashSet<Unifier> getUnifiers(Primitive primitive, Unifier unifier) {
        HashSet<Unifier> unifiers = new HashSet<>();
        unifiers.add(unifier);
        return unifiers;
    }

    private HashSet<Unifier> getUnifiers(GreaterEqualsPlausibility greaterEqualsPlausibility, Unifier unifier) throws Exception {
        HashSet<Unifier> unifiersL = this.getUnifiers(greaterEqualsPlausibility.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(greaterEqualsPlausibility.getRight(), u));
        }
        return unifiersR;
    }

    private HashSet<Unifier> getUnifiers(GreaterThanPlausibility greaterThanPlausibility, Unifier unifier) throws Exception {
        HashSet<Unifier> unifiersL = this.getUnifiers(greaterThanPlausibility.getLeft(), unifier);
        HashSet<Unifier> unifiersR = new HashSet<>();
        for (Unifier u : unifiersL) {
            unifiersR.addAll(this.getUnifiers(greaterThanPlausibility.getRight(), u));
        }
        return unifiersR;
    }

    private HashSet<Unifier> getUnifiers(Negation negation, Unifier unifier) throws Exception {
        return this.getUnifiers(negation.getTerm(), unifier);
    }

    private HashSet<Unifier> getUnifiers(BeliefAtom beliefAtom, Unifier unifier) {
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

    private HashSet<Unifier> getUnifiers(BeliefLiteral beliefLiteral, Unifier unifier) {
        return this.getUnifiers(beliefLiteral.getBeliefAtom(), unifier);
    }

    private HashSet<Unifier> getUnifiers(RelationalExpression relationalExpression, Unifier unifier) throws Exception {
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
