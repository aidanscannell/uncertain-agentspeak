package main.java.uncertain_agentspeak.infrastructure;

import main.java.uncertain_agentspeak.mas.MASProject;

public interface MASLauncher extends Runnable {

    public void setMASProject(MASProject project);

//    public void setListener();

    public void stopMAS();
}
