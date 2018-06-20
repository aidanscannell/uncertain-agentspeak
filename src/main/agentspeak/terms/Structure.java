package main.agentspeak.terms;

import main.agentspeak.Term;
import main.agentspeak.Unifier;
import main.agentspeak.terms.constants.Atom;

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

                if (termStruct instanceof Constant){
                    if (termThis instanceof Variable) {
                        Variable var = (Variable) termThis;
                        unifier.put(var,termStruct);
                    }
                } else if (termStruct instanceof Variable){
                    if (!termStruct.equals(termThis)) {
                        Variable var = (Variable) termStruct;
                        unifier.put(var, termThis);
                    }
                } else if (termStruct instanceof Structure){
                    if (termThis instanceof Variable) {
                        Variable var = (Variable) termThis;
                        unifier.put(var,termStruct);
                    } else if (termThis instanceof Structure) {
//                        Unifier structUnifier = new Unifier();
                        Unifier structUnifier = this.getArgument(i).unify(struct.getArgument(i));
                        unifier.putAll(structUnifier);
                    }
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

    //    /** Unify two structures if they have the same functor. */
//    public Unifier unify(Structure struct){
//        if ( (this.getFunctor() == struct.getFunctor()) && (this.getArity() == struct.getArity()) ){
//            Unifier unifier = new Unifier();
//            for (int i = 0; i<this.getArity(); i++){
//                Term termStruct = struct.getArguments().get(i);
//                Term termThis = this.getArguments().get(i);
//
//                if (termStruct instanceof Constant){
//                    Constant c = (Constant) termStruct;
//                    if (termThis instanceof Constant){
////                        if (termThis.equals(termStruct)){
////                            return new Unifier();
////                        }
////                        return null;
//                    } else if (termThis instanceof Variable){
//                        Variable varThis = (Variable) termThis;
//                        unifier.put(varThis,c);
//                    } else if (termThis instanceof Structure){
//                        //null;
//                    }
//
//                } else if (termStruct instanceof Variable){
//                    Variable varStruct = (Variable) termStruct;
//                    if (termThis instanceof Constant){
//                        unifier.put(varStruct,termThis);
//
//                    } else if (termThis instanceof Variable){
//
//                        if (termThis.equals(termStruct)){
////                            return new Unifier();
//                        } else {
//                            unifier.put(varStruct, termThis);
//                        }
//
//                    } else if (termThis instanceof Structure){
//                        unifier.put(varStruct, termThis);
//                    }
//
//                } else if (termStruct instanceof Structure){
//                    Variable structStruct = (Variable) termStruct;
//                    if (termThis instanceof Constant){
//                        //null;
//                    } else if (termThis instanceof Variable){
//                        Variable varThis = (Variable) termThis;
//                        unifier.put(varThis,structStruct);
//                    } else if (termThis instanceof Structure){
//                        Unifier unifyStruct = this.unify(structStruct);
//                    }
//
//                } else {
//                    return null;
//                }
//            }
//            return unifier;
//        } else {
//            return null;
//        }
//    }

//    /** Unify two structures if they have the same functor. */
//    public Unifier unify(Structure struct){
//        if ( (this.getFunctor() == struct.getFunctor()) && (this.getArity() == struct.getArity()) ){
//            Unifier unifier = new Unifier();
//            for (int i = 0; i<this.getArity(); i++){
//                Term termStruct = struct.getArguments().get(i);
//                Term termThis = this.getArguments().get(i);
//
//                if (termStruct instanceof Constant){
//                    if (termThis instanceof Constant){
////                        if (termThis.equals(termStruct)){
////                            return new Unifier();
////                        }
////                        return null;
//                    } else if (termThis instanceof Variable){
//                        unifier.put(termThis,termStruct);
//                    } else if (termThis instanceof Structure){
//                        //null;
//                    }
//
//                } else if (termStruct instanceof Variable){
//                    if (termThis instanceof Constant){
//                        unifier.put(termStruct,termThis);
//
//                    } else if (termThis instanceof Variable){
//
//                        if (termThis.equals(termStruct)){
////                            return new Unifier();
//                        } else {
//                            unifier.put(termStruct, termThis);
//                        }
//
//                    } else if (termThis instanceof Structure){
//                        unifier.put(termStruct, termThis);
//                    }
//
//                } else if (termStruct instanceof Structure){
//                    if (termThis instanceof Constant){
//                        //null;
//                    } else if (termThis instanceof Variable){
//                        unifier.put(termThis,termStruct);
//                    } else if (termThis instanceof Structure){
//
//                    }
//
//                } else {
//                    return null;
//                }
////                Unifier args = this.getArguments().get(i).unify((Term) struct.getArguments().get(i));
////                if (args != null){
////                    unifier.put(struct.getArguments().get(i),this.getArguments().get(i));
////                }
//            }
//            return unifier;
//        } else {
//            return null;
//        }
//    }

}
