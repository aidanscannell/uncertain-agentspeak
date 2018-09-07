package main.resources.antlr.mas_parser;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.resources.antlr.as_parser.AgentParser;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.mas.MASProject;
import main.resources.antlr.MASProjectBaseVisitor;
import main.resources.antlr.MASProjectParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MASProjectVisitor extends MASProjectBaseVisitor<Object> {

    private Logger LOGGER = LogManager.getLogger("Parser");

    public MASProject visitMas_project(MASProjectParser.Mas_projectContext ctx) {
        ThreadContext.put("logFilename","Main");
        String name = null;
        ArrayList<Agent> agentList = new ArrayList<>();
        Environment environment = new Environment();
        if (ctx.name() != null) {
            name = ctx.name().ATOM().toString();
        }
        if (ctx.content() != null) {
            if (ctx.content().agents() != null) {
                AgentParser agentAgentParser = new AgentParser();
                int agentID = 0;
                for (MASProjectParser.AgentContext agentContext : ctx.content().agents().agent()) {
                    String agentName = agentContext.agent_name().ATOM().toString();
                    String directory = System.getProperty("user.dir");
                    String filepath = directory + "/src/test/java/" + name + "/agents/" + agentName + ".agent";
                    File file = new File(filepath);
                    FileInputStream fis;
                    if (agentContext.numAgents() != null) {
                        for (int i=0; i<Integer.parseInt(agentContext.numAgents().getChild(0).toString()); i++) {
                            try {
                                fis = new FileInputStream(file);
                                Agent agent = agentAgentParser.parseUncertainAgentSpeak(fis);
                                agent.setName(agentName + Integer.toString(i));
                                agent.setId(agentID);
                                agentList.add(agent);
                                LOGGER.info("Successfully instantiated agent: " + agent.getName());
                                agentID++;
                            } catch (FileNotFoundException e) {
                                LOGGER.error("File not found: " + agentName);
                            } catch (Exception e) {
                                LOGGER.error("Error parsing file: " + e);
                            }
                        }
                    } else {
                        try {
                            fis = new FileInputStream(file);
                            Agent agent = agentAgentParser.parseUncertainAgentSpeak(fis);
                            agent.setName(agentName + Integer.toString(1));
                            agent.setId(agentID);
                            agentList.add(agent);
                            LOGGER.info("Successfully instantiated agent: " + agent.getName());
                        } catch (FileNotFoundException e) {
                            LOGGER.error("File not found: " + agentName);
                        } catch (Exception e) {
                            LOGGER.error("Error parsing file: " + e);
                        }
                    }
                    agentID++;
                }
            }
            if (ctx.content().environment() != null) {
                ArrayList args = new ArrayList();
                Object arg = null;
                for (int i=0; i<ctx.content().environment().arguments_list().arg().size(); i++) {
                    if (ctx.content().environment().arguments_list().arg(i).NUMBER() != null) {
                        arg = Integer.parseInt(ctx.content().environment().arguments_list().arg(i).NUMBER().toString());
                    } else if (ctx.content().environment().arguments_list().arg(i).STRING() != null) {
                        arg = ctx.content().environment().arguments_list().arg(i).STRING().toString();
                    }
                    args.add(arg);
                }
                String envName = "test.java.marsExplorationScenario.environment." + ctx.content().environment().env_class_name().CLASS_NAME().toString();
                try {
                    Class cl = Class.forName(envName);
                    java.lang.reflect.Constructor constructor = cl.getConstructor(List.class, List.class);
                    environment = (Environment) constructor.newInstance(args, agentList);
                } catch (Exception e) {
                    LOGGER.error("Error instantiating environment: " + e);
//                    e.printStackTrace();
                }
            }
        }
        return new MASProject(name, agentList, environment);
    }

}
