package main.java.uncertain_agentspeak.agentspeak.terms.constants;

import main.java.uncertain_agentspeak.agentspeak.terms.Constant;

/** Class that implements a constant term that represents text */
public class Text extends Constant {

    private String value;

    public Text(String val){
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (value == null) ? 0 : value.hashCode() );
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
        Text other = (Text) obj;
        if (value == null && other.value == null) {
            return false;
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }
}
