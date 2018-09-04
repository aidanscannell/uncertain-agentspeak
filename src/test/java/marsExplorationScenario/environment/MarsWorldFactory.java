package test.java.marsExplorationScenario.environment;

import main.java.uncertain_agentspeak.agentspeak.Agent;

import java.util.List;

public class MarsWorldFactory {

    public static MarsModel world4(List<Agent> agents) throws Exception {
        MarsModel model = new MarsModel(35, 35, 6);

        return model;
    }

    /** world with SAMPLE_A and obstacles */
    public static MarsModel world1(List<Agent> agents) throws Exception {
        MarsModel model = new MarsModel(35, 35, 4);
//        model.setAgPos(0, 1, 0);
//        model.setAgPos(1, 20, 0);
//        model.setAgPos(2, 6, 26);
//        model.setAgPos(3, 20, 20);
        model.add(MarsModel.WATER_OR_ICE, 20, 13);
        model.add(MarsModel.WATER_OR_ICE, 15, 20);
        model.add(MarsModel.WATER_OR_ICE, 1, 1);
        model.add(MarsModel.WATER_OR_ICE, 3, 5);
        model.add(MarsModel.WATER_OR_ICE, 24, 24);
        model.add(MarsModel.WATER_OR_ICE, 20, 20);

        model.add(MarsModel.FOSSILS, 20, 21);
        model.add(MarsModel.FOSSILS, 2, 22);
        model.add(MarsModel.FOSSILS, 2, 12);
        model.add(MarsModel.FOSSILS, 19, 2);
        model.add(MarsModel.FOSSILS, 14, 4);
        model.add(MarsModel.FOSSILS, 34, 34);

        model.add(MarsModel.LIVING_ORGANISMS, 12, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 13, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 14, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 15, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 18, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 19, 32);
        model.add(MarsModel.LIVING_ORGANISMS, 20, 32);

        model.add(MarsModel.OBSTACLE, 12, 3);
        model.add(MarsModel.OBSTACLE, 13, 3);
        model.add(MarsModel.OBSTACLE, 14, 3);
        model.add(MarsModel.OBSTACLE, 15, 3);
        model.add(MarsModel.OBSTACLE, 18, 3);
        model.add(MarsModel.OBSTACLE, 19, 3);
        model.add(MarsModel.OBSTACLE, 20, 3);
        model.add(MarsModel.OBSTACLE, 14, 8);
        model.add(MarsModel.OBSTACLE, 15, 8);
        model.add(MarsModel.OBSTACLE, 16, 8);
        model.add(MarsModel.OBSTACLE, 17, 8);
        model.add(MarsModel.OBSTACLE, 19, 8);
        model.add(MarsModel.OBSTACLE, 20, 8);

//        model.add(MarsModel.OBSTACLE, 12, 32);
//        model.add(MarsModel.OBSTACLE, 13, 32);
//        model.add(MarsModel.OBSTACLE, 14, 32);
//        model.add(MarsModel.OBSTACLE, 15, 32);
//        model.add(MarsModel.OBSTACLE, 18, 32);
//        model.add(MarsModel.OBSTACLE, 19, 32);
//        model.add(MarsModel.OBSTACLE, 20, 32);
//        model.add(MarsModel.OBSTACLE, 14, 28);
//        model.add(MarsModel.OBSTACLE, 15, 28);
//        model.add(MarsModel.OBSTACLE, 16, 28);
//        model.add(MarsModel.OBSTACLE, 17, 28);
//        model.add(MarsModel.OBSTACLE, 19, 28);
//        model.add(MarsModel.OBSTACLE, 20, 28);
//
        model.add(MarsModel.OBSTACLE, 3, 12);
        model.add(MarsModel.OBSTACLE, 3, 13);
        model.add(MarsModel.OBSTACLE, 3, 14);
        model.add(MarsModel.OBSTACLE, 3, 15);
        model.add(MarsModel.OBSTACLE, 3, 18);
        model.add(MarsModel.OBSTACLE, 3, 19);
        model.add(MarsModel.OBSTACLE, 3, 20);
        model.add(MarsModel.OBSTACLE, 8, 14);
        model.add(MarsModel.OBSTACLE, 8, 15);
        model.add(MarsModel.OBSTACLE, 8, 16);
        model.add(MarsModel.OBSTACLE, 8, 17);
        model.add(MarsModel.OBSTACLE, 8, 19);
        model.add(MarsModel.OBSTACLE, 8, 20);

        model.add(MarsModel.OBSTACLE, 32, 12);
        model.add(MarsModel.OBSTACLE, 32, 13);
        model.add(MarsModel.OBSTACLE, 32, 14);
        model.add(MarsModel.OBSTACLE, 32, 15);
        model.add(MarsModel.OBSTACLE, 32, 18);
        model.add(MarsModel.OBSTACLE, 32, 19);
        model.add(MarsModel.OBSTACLE, 32, 20);
        model.add(MarsModel.OBSTACLE, 28, 14);
        model.add(MarsModel.OBSTACLE, 28, 15);
        model.add(MarsModel.OBSTACLE, 28, 16);
        model.add(MarsModel.OBSTACLE, 28, 17);
        model.add(MarsModel.OBSTACLE, 28, 19);
        model.add(MarsModel.OBSTACLE, 28, 20);
//
//        model.add(MarsModel.OBSTACLE, 13, 13);
//        model.add(MarsModel.OBSTACLE, 13, 14);
//
//        model.add(MarsModel.OBSTACLE, 13, 16);
//        model.add(MarsModel.OBSTACLE, 13, 17);
//
//        model.add(MarsModel.OBSTACLE, 13, 19);
//        model.add(MarsModel.OBSTACLE, 14, 19);
//
//        model.add(MarsModel.OBSTACLE, 16, 19);
//        model.add(MarsModel.OBSTACLE, 17, 19);
//
//        model.add(MarsModel.OBSTACLE, 19, 19);
//        model.add(MarsModel.OBSTACLE, 19, 18);
//
//        model.add(MarsModel.OBSTACLE, 19, 16);
//        model.add(MarsModel.OBSTACLE, 19, 15);
//
//        model.add(MarsModel.OBSTACLE, 19, 13);
//        model.add(MarsModel.OBSTACLE, 18, 13);
//
//        model.add(MarsModel.OBSTACLE, 16, 13);
//        model.add(MarsModel.OBSTACLE, 15, 13);
//
//        // labirinto
//        model.add(MarsModel.OBSTACLE, 2, 32);
//        model.add(MarsModel.OBSTACLE, 3, 32);
//        model.add(MarsModel.OBSTACLE, 4, 32);
//        model.add(MarsModel.OBSTACLE, 5, 32);
//        model.add(MarsModel.OBSTACLE, 6, 32);
//        model.add(MarsModel.OBSTACLE, 7, 32);
//        model.add(MarsModel.OBSTACLE, 8, 32);
//        model.add(MarsModel.OBSTACLE, 9, 32);
//        model.add(MarsModel.OBSTACLE, 10, 32);
//        model.add(MarsModel.OBSTACLE, 10, 31);
//        model.add(MarsModel.OBSTACLE, 10, 30);
//        model.add(MarsModel.OBSTACLE, 10, 29);
//        model.add(MarsModel.OBSTACLE, 10, 28);
//        model.add(MarsModel.OBSTACLE, 10, 27);
//        model.add(MarsModel.OBSTACLE, 10, 26);
//        model.add(MarsModel.OBSTACLE, 10, 25);
//        model.add(MarsModel.OBSTACLE, 10, 24);
//        model.add(MarsModel.OBSTACLE, 10, 23);
//        model.add(MarsModel.OBSTACLE, 2, 23);
//        model.add(MarsModel.OBSTACLE, 3, 23);
//        model.add(MarsModel.OBSTACLE, 4, 23);
//        model.add(MarsModel.OBSTACLE, 5, 23);
//        model.add(MarsModel.OBSTACLE, 6, 23);
//        model.add(MarsModel.OBSTACLE, 7, 23);
//        model.add(MarsModel.OBSTACLE, 8, 23);
//        model.add(MarsModel.OBSTACLE, 9, 23);
//        model.add(MarsModel.OBSTACLE, 2, 29);
//        model.add(MarsModel.OBSTACLE, 2, 28);
//        model.add(MarsModel.OBSTACLE, 2, 27);
//        model.add(MarsModel.OBSTACLE, 2, 26);
//        model.add(MarsModel.OBSTACLE, 2, 25);
//        model.add(MarsModel.OBSTACLE, 2, 24);
//        model.add(MarsModel.OBSTACLE, 2, 23);
//        model.add(MarsModel.OBSTACLE, 2, 29);
//        model.add(MarsModel.OBSTACLE, 3, 29);
//        model.add(MarsModel.OBSTACLE, 4, 29);
//        model.add(MarsModel.OBSTACLE, 5, 29);
//        model.add(MarsModel.OBSTACLE, 6, 29);
//        model.add(MarsModel.OBSTACLE, 7, 29);
//        model.add(MarsModel.OBSTACLE, 7, 28);
//        model.add(MarsModel.OBSTACLE, 7, 27);
//        model.add(MarsModel.OBSTACLE, 7, 26);
//        model.add(MarsModel.OBSTACLE, 7, 25);
//        model.add(MarsModel.OBSTACLE, 6, 25);
//        model.add(MarsModel.OBSTACLE, 5, 25);
//        model.add(MarsModel.OBSTACLE, 4, 25);
//        model.add(MarsModel.OBSTACLE, 4, 26);
//        model.add(MarsModel.OBSTACLE, 4, 27);
////        model.setInitialNbSAMPLE_As(model.countObjects(MarsModel.SAMPLE_A));
        model.initAgents(agents);
        return model;
    }

    /** world with SAMPLE_A and obstacles */
    public static MarsModel world2(List<Agent> agents) {
        MarsModel model = new MarsModel(15, 15, agents.size());
        model.add(MarsModel.WATER_OR_ICE, 4, 3);

//        model.add(MarsModel.FOSSILS, 8, 4);

        model.add(MarsModel.LIVING_ORGANISMS, 14, 3);

        model.add(MarsModel.WATER_OR_ICE, 1, 6);

        model.add(MarsModel.FOSSILS, 8, 9);

//        model.add(MarsModel.WATER_OR_ICE, 14, 6);

        model.add(MarsModel.FOSSILS, 3, 14);

//        model.add(MarsModel.WATER_OR_ICE, 9, 14);

//        model.add(MarsModel.WATER_OR_ICE, 14, 12);

        model.initAgents(agents);
        return model;
    }
}
