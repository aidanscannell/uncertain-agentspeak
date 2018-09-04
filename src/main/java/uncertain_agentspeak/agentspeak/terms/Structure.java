package main.java.uncertain_agentspeak.agentspeak.terms;

import main.java.uncertain_agentspeak.agentspeak.Term;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.Atom;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements a term that represents an structure taking the form "functor(arguments)"
 *      -> functor is an atom
 *      -> arguments is a list of terms
 */
public class Structure extends Term {

    private Atom functor;
    private List<Term> arguments;
    private int arity;

    public Structure(Atom functor, List<Term> arguments){
        this.functor = functor;
        this.arguments = arguments;
        this.arity = arguments.size();
    }

    public Atom getFunctor() {
        return functor;
    }

    public List<Term> getArguments() {
        return arguments;
    }

    public Term getArgument(int i) {
        return arguments.get(i);
    }

    public int getArity(){
        return arity;
    }

    @Override
    public boolean isGround() {
        for (Term arg : this.arguments) {
            if (!arg.isGround()) {
                return false;
            }
        }
        return true;
    }

    // Unification
    public Unifier unify(Constant c){
        return null;
    }

    public Unifier unify(Variable var){
        Unifier unifier = new Unifier();
        unifier.put(var,this);
        return unifier;
    }

    /** Unify two structures if they have the same functor and arity. */
    public Unifier unify(Structure struct){
        if ( (this.getFunctor().toString().equals(struct.getFunctor().toString())) && (this.getArity() == struct.getArity()) ) {
            Unifier unifier = new Unifier();
            for (int i = 0; i<this.getArity(); i++){
                Term termStruct = struct.getArgument(i);
                Term termThis = this.getArgument(i);

                Unifier argUnifier = termThis.unify(termStruct, unifier);
                if (argUnifier != null) {
                    unifier.putAll(argUnifier);
                } else {
                    return null;
                }
            }
            return unifier;
        } else {
            return null;
        }
    }

    @Override
    public Term substitute(Unifier unifier) {
        List<Term> newArgs = new ArrayList<>();
         for (Term arg : arguments) {
             newArgs.add(arg.substitute(unifier));
         }
         return new Structure(this.functor,newArgs);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(functor + "(");
        boolean flag = true;
        for (Term argument: arguments) {
            if (flag) {
                string.append(argument);
            } else {
                string.append(", ").append(argument);
            }
            flag = false;
        }
        string.append(")");
        return string.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (functor == null) ? 0 : functor.hashCode() );
        result = prime * result + ( (arguments == null) ? 0 : arguments.hashCode() );
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
        Structure other = (Structure) obj;
        if (functor == null && other.functor == null) {
            return false;
        } else if (!functor.equals(other.functor)) {
            return false;
        }
        if (arguments == null && other.arguments == null) {
            return false;
        } else if (!arguments.equals(other.arguments)) {
            return false;
        }
        return true;
    }
}
