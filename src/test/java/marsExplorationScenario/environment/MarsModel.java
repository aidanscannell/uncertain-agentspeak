package test.java.marsExplorationScenario.environment;

import javafx.application.Platform;
import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.Unifier;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.BeliefAtom;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.BeliefLiteral;
import main.java.uncertain_agentspeak.agentspeak.logical_expressions.terminals.belief_literals.PositiveLiteral;
import main.java.uncertain_agentspeak.agentspeak.terms.Structure;
import main.java.uncertain_agentspeak.agentspeak.terms.constants.Atom;
import main.java.uncertain_agentspeak.environment.grid.AStar.AStar;
import main.java.uncertain_agentspeak.environment.grid.AStar.Node;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.Location;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.CompactEpistemicState;
import main.java.uncertain_agentspeak.uncertainty.epistemic_states.compact_epistemic_states.CompactProbabilisticEpistemicState;
import main.resources.antlr.as_parser.AgentParser;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static test.java.marsExplorationScenario.environment.MarsModel.Move.UP;

public class MarsModel extends GridWorldModel {

    private Logger logger   = Logger.getLogger("MarsEnvironment.mas2j." + MarsModel.class.getName());

    public static final int SAMPLE_A_AGENT = 4;
    public static final int SAMPLE_B_AGENT = 6;
    public static final int ANALYSIS_AGENT = 8;
    public static final int EXCAVATION_AGENT = 10;

    public static final int WATER_OR_ICE = 12;
    public static final int FOSSILS = 14;
    public static final int LIVING_ORGANISMS = 16;

    private Set<Integer> agentsWithWater;
    private Set<Integer> agentsWithFossil;
    private Set<Integer> agentsWithLiving;

    public enum Move {
        UP, DOWN, RIGHT, LEFT
    };

    public MarsModel(int width, int height, int numAgents) {
        super(width, height, numAgents);
    }

//    public MarsModel create(int width, int height, int numAgents) {
//        return new MarsModel(width, height, numAgents);
//    }

    public void initAgents(List<Agent> agents) {
        for (Agent agent : agents) {
            Location location = getFreePos();
            agentPositions[agent.getId()] = location;
            if (agent.getName().contains("sampleAgentA")) {
                add(SAMPLE_A_AGENT, location.x, location.y);
            } else if (agent.getName().contains("sampleAgentB")) {
                add(SAMPLE_B_AGENT, location.x, location.y);
            } else if (agent.getName().contains("analysisAgent")) {
                add(ANALYSIS_AGENT, location.x, location.y);
            } else if (agent.getName().contains("excavationAgent")) {
                add(EXCAVATION_AGENT, location.x, location.y);
            }
            AgentParser parser = new AgentParser();
            double weight = 1;
            try {
                HashSet<BeliefAtom> domain = new HashSet<>();
                for (int x=0; x<width; x++){
                    for (int y=0; y<height; y++) {
                        domain.add(parser.parseBeliefAtom("at(location(" + x + "," + y + "))"));
                    }
                }
                agent.getBeliefBase().addEpistemicState(new CompactProbabilisticEpistemicState(domain));
                for (BeliefAtom beliefAtom : domain){
                    BeliefLiteral beliefLiteral = new PositiveLiteral(beliefAtom);
                    agent.getBeliefBase().revise(beliefLiteral,0);
                }
                agent.getBeliefBase().revise(parser.parseBeliefLiteral("at(location(" + location.x + "," + location.y + "))"), 1);
                logger.info("[" + agent.getName() + "]: " + "Successfully revised belief at(location(X))");
            } catch (Exception e) {
                logger.warn("[" + agent.getName() + "]: " + "Failed to revise belief at(location(X))");
            }
        }
    }

    public synchronized boolean travel(int agentID, EnvironmentAction action) throws Exception {
        System.out.println(action.toString());
        Pattern p = Pattern.compile("location\\((.*?)\\)");
        Matcher m = p.matcher(action.toString());
        ArrayList<String> locations = new ArrayList<>();
        while(m.find()) {
            locations.add(m.group(1));
        }
        int x = Integer.parseInt(locations.get(0).split(", ")[0]);
        int y = Integer.parseInt(locations.get(0).split(", ")[1]);
//        System.out.println(locations.get(0).split(",")[1]);
//        System.out.println("TARGET LOCATION: " + x + "," + y);
        //TODO: Update method for obtaining path number
//        String pathNum = action.toString().substring(action.toString().length()-2);
        Node start = new Node(getAgentPos(agentID).x, getAgentPos(agentID).y);
        Node target = new Node(x,y);
        AStar astar = new AStar(grid, width, height);
        ArrayList<Node> path = astar.findPath(start,target);

        for (Node node : path) {
            move(agentID, new Location(node.getPosition().getRow(), node.getPosition().getCol()));
        }
        System.out.println("AGENT POSITION: " + agentPositions[agentID].x + ", " + agentPositions[agentID].y);
        System.out.println("TARGET POSITION: " + x + ", " + y);
        if ( agentPositions[agentID].x == x && agentPositions[agentID].y == y ) {
            //TODO: return true if at neighbouring cell
            System.out.println("Inside flag");
        }
        return false;

    }

    public synchronized boolean move(int agentID, Location newPos) {
        Location oldPos = getAgentPos(agentID);
        int agentType = grid[oldPos.x][oldPos.y];
        if (oldPos == null) {
            logger.warn("** We lost the location of agent " + (agentID + 1) + "!" + this);
            return false;
        }
//        System.out.println("Old Pos: " + oldPos.x + ", " + oldPos.y);
//        System.out.println("New Pos: " + newPos.x + ", " + newPos.y);
        if (newPos != null && canMoveTo(agentID, newPos) && newPos != oldPos) {
            setPos(agentType, oldPos, newPos);
            agentPositions[agentID] = newPos;
            return true;
        }
        return false;
    }

    private boolean canMoveTo(int ag, Location l) {
        if (isFreeOfObstacle(l)) {
            return true;
        }
        return false;
    }

//    public boolean collectWater(int agentID, EnvironmentAction action) {
//        Location l = getAgentPos(agentID);
//        if (!agentsWithSampleA.contains(ag)) {
//            if (hasObject(MarsModel.WATER_OR_ICE, l.x+1, l.y)) {
//                remove(MarsModel.WATER_OR_ICE, l.x+1, l.y);
//                return true;
//            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x, l.y+1)) {
//                remove(MarsModel.SAMPLE_B, l.x, l.y+1);
//                return true;
//            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x-1, l.y)) {
//                remove(MarsModel.SAMPLE_B, l.x-1, l.y);
//                return true;
//            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x, l.y-1)) {
//                remove(MarsModel.SAMPLE_B, l.x, l.y-1);
//                return true;
//            } else {
//                System.out.println("Agent " + (ag + 1) + " is trying to collect sample of type A, but there is none at " + l.x + "x" + l.y + "!");
//            }
//        } else {
//            System.out.println("Agent " + (ag + 1) + " is trying to collect sample of type A, but is already carrying a sample!");
//        }
//        return false;
//    }

    public synchronized boolean collectSampleWater(int agentID, EnvironmentAction action) {
        System.out.println(action.toString());
        Pattern p = Pattern.compile("collectSampleWater\\(location\\((.*?)\\)\\)");
        Matcher m = p.matcher(action.toString());
        ArrayList<String> locations = new ArrayList<>();
        while(m.find()) {
            locations.add(m.group(1));
        }
        int x = Integer.parseInt(locations.get(0).split(", ")[0]);
        int y = Integer.parseInt(locations.get(0).split(", ")[1]);
        System.out.println("WATER X: " + x);
        System.out.println("WATER Y: " + y);
        Location l = getAgentPos(agentID);
        if (!agentsWithWater.contains(agentID)) {
            if (hasObject(MarsModel.WATER_OR_ICE, l.x+1, l.y)) {
                remove(MarsModel.WATER_OR_ICE, l.x+1, l.y);
                return true;
            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x, l.y+1)) {
                remove(MarsModel.WATER_OR_ICE, l.x, l.y+1);
                return true;
            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x-1, l.y)) {
                remove(MarsModel.WATER_OR_ICE, l.x-1, l.y);
                return true;
            } else if (hasObject(MarsModel.WATER_OR_ICE, l.x, l.y-1)) {
                remove(MarsModel.WATER_OR_ICE, l.x, l.y-1);
                return true;
            } else {
                System.out.println("Agent " + (agentID + 1) + " is trying to collect sample number " + MarsModel.WATER_OR_ICE + ", but there is none at " + l.x + "x" + l.y + "!");
            }
        } else {
            System.out.println("Agent " + (agentID + 1) + " is trying to collect sample number " + MarsModel.WATER_OR_ICE + ", but is already carrying a sample!");
        }
        return false;
    }


//
//    public boolean sampleB(int ag) {
//        Location l = getAgentPos(ag);
//        if (!agentsWithSampleB.contains(ag)) {
//            if (hasObject(MarsModel.SAMPLE_B, l.x, l.y)) {
//                remove(MarsModel.SAMPLE_B, l.x, l.y);
//                return true;
//            } else {
//                System.out.println("Agent " + (ag + 1) + " is trying to collect sample of type B, but there is none at " + l.x + "x" + l.y + "!");
//            }
//        } else {
//            System.out.println("Agent " + (ag + 1) + " is trying to collect sample of type B, but is already carrying a sample!");
//        }
//        return false;
//    }

}
