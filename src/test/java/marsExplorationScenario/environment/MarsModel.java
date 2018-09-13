package test.java.marsExplorationScenario.environment;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.agentspeak.actions.EnvironmentAction;
import main.java.uncertain_agentspeak.environment.grid.AStar.Node;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.Position;
import main.resources.antlr.as_parser.AgentParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsModel extends GridWorldModel {

    public Location[] locations;

    public static final int SAMPLE_A_AGENT = 4;
    public static final int SAMPLE_B_AGENT = 6;
    public static final int ANALYSIS_AGENT = 8;
    public static final int EXCAVATION_AGENT = 10;

    public static final int WATER_OR_ICE = 12;
    public static final int FOSSILS = 14;
    public static final int LIVING_ORGANISMS = 16;

    public Set<String> agentsWithWater;
    public HashMap<String,Agent> agents;

    public AgentParser parser = new AgentParser();

    public MarsModel(int width, int height, int numAgents) {
        super(width, height, numAgents);
        agentsWithWater = new HashSet<>();
    }

    public void initAgents(List<Agent> agents) {
        this.agents = new HashMap<>();
        for (Agent agent : agents) {
            this.agents.put(agent.getName(), agent);
            Position position = getFreePos();
            agentPositions[agent.getId()] = position;
            if (agent.getName().contains("sampleAgentA")) {
                add(SAMPLE_A_AGENT, position.x, position.y);
            } else if (agent.getName().contains("sampleAgentB")) {
                add(SAMPLE_B_AGENT, position.x, position.y);
            } else if (agent.getName().contains("analysisAgent")) {
                position.x = 7; position.y = 7;
                add(ANALYSIS_AGENT, position.x, position.y);
            } else if (agent.getName().contains("excavationAgent")) {
                add(EXCAVATION_AGENT, position.x, position.y);
            }


            try {
                agent.getBeliefBase().revise(parser.parseBeliefLiteral("at(position(" + getLocation(position.x, position.y) +"))"),1);
            } catch (Exception e) {}
        }
    }

    public void initLocations() {
        locations = new Location[9];
        locations[0] = new Location(0,4,0,4,2, 2);
        locations[1] = new Location(0,4,5,9,2,7);
        locations[2] = new Location(0,4,10,14,2,12);
        locations[3] = new Location(5,9,0,4,7,2);
        locations[4] = new Location(5,9,5,9,7,7);
        locations[5] = new Location(5,9,10,14,7,12);
        locations[6] = new Location(10,14,0,4,12,2);
        locations[7] = new Location(10,14,5,9,12,7);
        locations[8] = new Location(10,14,10,14,12,12);
    }

    public int getLocation(int x, int y) {
        for (int i=0; i<locations.length; i++) {
            if (locations[i].insideLocation(x,y)) {
                return i+1;
            }
        }
        return -1;
    }


    /** Actions */

    /** Move agent to target location  */
    public boolean travel(String agentName, EnvironmentAction action) throws Exception {
        System.out.println("Inside travel");
        int agentID = agentList.get(agentName);
//        System.out.println("AGENT POSITIONS BEFORE MOVE" + agentPositions[agentID].toString());
        String []splits = action.toString().replaceAll("^\\s*travel\\(location\\(|\\)\\)\\s*$", "").split("\\s*,\\s*");
        int x, y;
        if (splits.length == 1) {
            x = this.locations[Integer.parseInt(splits[0])-1].getX();
            y = this.locations[Integer.parseInt(splits[0])-1].getY();
        } else if (splits.length == 2) {
            x = Integer.parseInt(splits[0]);
            y = Integer.parseInt(splits[1]);
        } else {
            throw new Exception("Could not parse action: " + action.toString());
        }
        System.out.println("x = " + x + ", y = " + y);
        Position oldPos = new Position(agentPositions[agentID].x,agentPositions[agentID].y);
        LOGGER.info("Agent " + agentName + " moving from (" + agentPositions[agentID].x + ", " + agentPositions[agentID].y + ") to ("
                + x + ", " + y + ")");

        ArrayList<Node> path = aStar(agentID, x, y);
        System.out.println(x);
        System.out.println(y);
        System.out.println(agentID);
        if (path.size() > 0) {
            for (Node node : path) {
                move(agentName, new Position(node.getPosition().getRow(), node.getPosition().getCol()));
            }
        }
        System.out.println("after mvoe");
        if ( (agentPositions[agentID].x >= x-1 && agentPositions[agentID].x <= x+1) || (agentPositions[agentID].y >= y-1 && agentPositions[agentID].y <= y+1) ) {
//            double weight = Math.random() * (1 - 0.6) + 0.6;
//            try {
//                ArrayList<String> beliefUpdate = new ArrayList<>();
//                beliefUpdate.add("*(at(location(" + oldPos.x + ", " + oldPos.y +" )), W)");
//                beliefUpdate.add("*(at(location(" + agentPositions[agentID].x + ", " + agentPositions[agentID].y +")), W)");
//                addPercept(agentName,beliefUpdate);
////                agents.get(agentName).getBeliefBase().revise(parser.parseBeliefLiteral(c);
//                agents.get(agentName).getBeliefBase().revise(parser.parseBeliefLiteral("at(position(" + agentPositions[agentID].x + ", " + agentPositions[agentID].y +"))"),weight);
//            } catch (Exception e) {}
            return true;
        }
//        System.out.println("AGENT POSITIONS AFTER MOVE: " + agentPositions[agentID].x + ", " + agentPositions[agentID].y);
        return false;
    }

    /** Move agent to neighbouring cell */
    public boolean move(String agentName, Position newPos) {
        int agentID = agentList.get(agentName);
        Position oldPos = getAgentPos(agentID);
        if (oldPos == null) {
            LOGGER.warn("** We lost the location of agent " + agentName + "!" + this);
            return false;
        }
        if (newPos != null && canMoveTo(agentID, newPos) && newPos != oldPos) {
            setPos(grid[oldPos.x][oldPos.y], oldPos, newPos);
            agentPositions[agentID] = newPos;
//            try { Thread.sleep(1000); } catch (Exception e) {}
            return true;
        }
        return false;
    }

    private boolean canMoveTo(int ag, Position l) {
        if (isFreeOfObstacle(l)) {
            return true;
        }
        return false;
    }

    public boolean collectSample(String agentName, EnvironmentAction action) {
        int agentID = agentList.get(agentName);
        int objectNum = -1;
        String splits = action.toString().replaceAll("^\\s*collectSample\\(|\\)\\s*$", "");
        if (splits.contains("water")) {
            objectNum = MarsModel.WATER_OR_ICE;
        } else if (splits.contains("fossil")) {
            objectNum = MarsModel.FOSSILS;
        } else if (splits.contains("living_organism")) {
            objectNum = MarsModel.LIVING_ORGANISMS;
        }
        System.out.println("before loop");
        int locNum = getLocation(getAgentPos(agentID).x,getAgentPos(agentID).y);
        boolean success = false;
        int x_item = -1; int y_item = -1;
        for (int x=locations[locNum-1].getX_min(); x<=locations[locNum-1].getX_max(); x++) {
            for (int y=locations[locNum-1].getY_min(); y<=locations[locNum-1].getY_max(); y++) {
                if (grid[x][y] == WATER_OR_ICE) {
                    System.out.println("INSIDE WATER_OR_ICE");
                    x_item = x;
                    y_item = y;
                }
            }
        }
        ArrayList<Node> path = aStar(agentID, x_item, y_item);
        if (path.size() > 0) {
            for (Node node : path) {
                move(agentName, new Position(node.getPosition().getRow(), node.getPosition().getCol()));
            }
        }
        if ( (agentPositions[agentID].x >= x_item-1 && agentPositions[agentID].x <= x_item+1) || (agentPositions[agentID].y >= y_item-1 && agentPositions[agentID].y <= y_item+1) ) {
            Position l = getAgentPos(agentID);
            System.out.println("after loop : " + success);
            if (!agentsWithWater.contains(agentID)) {
                if (hasObject(objectNum, l.x + 1, l.y)) {
                    remove(objectNum, l.x + 1, l.y);
                    agentsWithWater.add(agentName);
                    return true;
                } else if (hasObject(objectNum, l.x, l.y + 1)) {
                    remove(objectNum, l.x, l.y + 1);
                    agentsWithWater.add(agentName);
                    return true;
                } else if (hasObject(objectNum, l.x - 1, l.y)) {
                    remove(objectNum, l.x - 1, l.y);
                    agentsWithWater.add(agentName);
                    return true;
                } else if (hasObject(objectNum, l.x, l.y - 1)) {
                    remove(objectNum, l.x, l.y - 1);
                    agentsWithWater.add(agentName);
                    return true;
                } else {
                    LOGGER.warn("Agent " + agentName + " is trying to collect sample number " + objectNum + ", but there is none at " + l.x + "x" + l.y + "!");
                }
            } else {
                LOGGER.warn("Agent " + agentName + " is trying to collect sample number " + objectNum + ", but is already carrying a sample!");
            }
        }
        return false;
    }

    public boolean depositSample(String agentName, EnvironmentAction action) {
        int agentID = agentList.get(agentName);
        int objectNum = -1;
        String splits = action.toString().replaceAll("^\\s*depositSample\\(|\\)\\s*$", "");
        if (splits.contains("water")) {
            objectNum = MarsModel.WATER_OR_ICE;
        } else if (splits.contains("fossil")) {
            objectNum = MarsModel.FOSSILS;
        } else if (splits.contains("living_organism")) {
            objectNum = MarsModel.LIVING_ORGANISMS;
        }
        Position l = getAgentPos(agentID);
        if (agentsWithWater.contains(agentID)) {
            if (hasObject( ANALYSIS_AGENT,l.x+1, l.y)) {
//                remove(objectNum, l.x+1, l.y);
                agentsWithWater.remove(agentName);
                return true;
            } else if (hasObject(ANALYSIS_AGENT, l.x, l.y+1)) {
//                remove(objectNum, l.x, l.y+1);
                agentsWithWater.remove(agentName);
                return true;
            } else if (hasObject(ANALYSIS_AGENT, l.x-1, l.y)) {
//                remove(objectNum, l.x-1, l.y);
                agentsWithWater.remove(agentName);
                return true;
            } else if (hasObject(ANALYSIS_AGENT, l.x, l.y-1)) {
//                remove(objectNum, l.x, l.y-1);
                agentsWithWater.remove(agentName);
                return true;
            } else {
                LOGGER.warn("Agent " + agentName + " is trying to collect sample number " + objectNum + ", but there is none at " + l.x + "x" + l.y + "!");
            }
        } else {
            LOGGER.warn("Agent " + agentName + " is trying to collect sample number " + objectNum + ", but is already carrying a sample!");
        }
        return false;
    }

//    public boolean depositSample(String agentName, EnvironmentAction action) {
//
//    }
}
