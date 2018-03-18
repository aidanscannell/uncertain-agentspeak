package main.java;

import java.util.ArrayList;

public class PlanLibrary extends ArrayList<Plan> {

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Plan plan: this) {
            string.append("\t").append(plan.toString());
            if (plan != this.get(this.size()-1)) {
                string.append("\n");
            }
        }
        return string.toString();
    }

}
