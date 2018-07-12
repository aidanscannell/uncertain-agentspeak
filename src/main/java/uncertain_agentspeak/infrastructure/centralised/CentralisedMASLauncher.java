package main.java.uncertain_agentspeak.infrastructure.centralised;

import main.java.uncertain_agentspeak.infrastructure.MASLauncher;
import main.java.uncertain_agentspeak.mas.MASProject;

public class CentralisedMASLauncher implements MASLauncher {

    protected MASProject project;
    protected boolean stop = false;
    protected Process process = null;

    public void setProject(MASProject project) {
        this.project = project;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public void setMASProject(MASProject project) {

    }

    @Override
    public void stopMAS() {

    }

    @Override
    public void run() {

    }
}
