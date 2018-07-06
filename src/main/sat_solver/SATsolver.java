package main.sat_solver;

import main.agentspeak.LogicalExpression;
import main.agentspeak.logical_expressions.BeliefAtom;
import main.agentspeak.logical_expressions.Terminal;
import main.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.agentspeak.logical_expressions.terminals.primitives.Tautology;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import java.util.HashMap;
import java.util.HashSet;

public class SATsolver {

    private ISolver solver;
    private final int MAXVAR = 1000000;
    private final int NBCLAUSES = 500000;

    public SATsolver() {
        solver = SolverFactory.newDefault();
        solver.setTimeout(10); // 10 second timeout
    }

    public boolean solve(LogicalExpression logicalExpression) throws ContradictionException {
        try {
            HashSet<HashSet<Terminal>> clauses = logicalExpression.convertToNNF(false).convertToCNF().getSetClauses();

            HashMap<BeliefAtom, Integer> labels = new HashMap<>();
            int nextLabel = 2;
            final int tautLabal = 1;
            VecInt clauseVect = new VecInt();
            for (HashSet<Terminal> clause : clauses) {

                for (Terminal terminal : clause) {
                    if (terminal instanceof BeliefLiteral) {
                        BeliefLiteral beliefLiteral = (BeliefLiteral) terminal;
                        BeliefAtom beliefAtom = beliefLiteral.getBeliefAtom();
                        int label;
                        if (labels.containsKey(beliefAtom)) {
                            label = labels.get(beliefAtom);
                        } else {
                            label = nextLabel;
                            labels.put(beliefAtom,label);
                            nextLabel++;
                        }
                        if (beliefLiteral.isPositive()) {
                            clauseVect.push(label);
                        } else {
                            clauseVect.push(-label);
                        }
                    } else if (terminal instanceof Tautology) {
                        clauseVect.push(tautLabal);
                        clauseVect.push(-tautLabal);
                    }
                }
                solver.addClause(clauseVect);
            }

            IProblem problem = solver;
            if (problem.isSatisfiable()) {
                System.out.println("Satisfiable !");
                solver.reset();
                return true;
            } else {
                System.out.println("Unsatisfiable !");
                solver.reset();
                return false;
            }
        } catch (ContradictionException e) {
            System.out.println("Unsatisfiable (trivial)!");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timeout, sorry!");
            return false;
        }

    }


}
