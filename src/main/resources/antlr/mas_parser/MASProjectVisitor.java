package main.resources.antlr.mas_parser;

import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.resources.antlr.as_parser.AgentParser;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.mas.MASProject;
import main.resources.antlr.MASProjectBaseVisitor;
import main.resources.antlr.MASProjectParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MASProjectVisitor extends MASProjectBaseVisitor<Object> {

    public MASProject visitMas_project(MASProjectParser.Mas_projectContext ctx) {
        String name = null;
        List<Agent> agentList = new ArrayList<Agent>();
        Environment environment = new Environment();
        if (ctx.name() != null) {
            name = ctx.name().ATOM().toString();
        }
        if (ctx.content() != null) {
            if (ctx.content().environment() != null) {
                List args = new ArrayList();
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
                    java.lang.reflect.Constructor constructor = cl.getConstructor(List.class);
                    environment = (Environment) constructor.newInstance(args);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ctx.content().agents() != null) {
                AgentParser agentAgentParser = new AgentParser();
                for (MASProjectParser.AgentContext agentContext : ctx.content().agents().agent()) {
                    String agentName = agentContext.agent_name().ATOM().toString();
                    String directory = System.getProperty("user.dir");
                    String filepath = directory + "/src/test/java/" + name + "/agents/" + agentName + ".agent";
                    File file = new File(filepath);
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                        Agent agent = agentAgentParser.parseUncertainAgentSpeak(fis);
                        agentList.add(agent);
                        System.out.println("Successfully instantiated agent");
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + agentName);
                    } catch (Exception e) {
                        System.err.println("Error parsing file");
                    }
                    
                }
            }
        }
        return new MASProject(name, agentList ,environment);
    }

//    T visitName(MASProjectParser.NameContext ctx);

//    public  visitContent(MASProjectParser.ContentContext ctx);

//    T visitInfrastructure(MASProjectParser.InfrastructureContext ctx);

//    T visitCentralised(MASProjectParser.CentralisedContext ctx);

//    T visitEnvironment(MASProjectParser.EnvironmentContext ctx);

//    T visitEnv_class_name(MASProjectParser.Env_class_nameContext ctx);

//    T visitAgents(MASProjectParser.AgentsContext ctx);

//    T visitAgent_name(MASProjectParser.Agent_nameContext ctx);

//    T visitArguments_list(MASProjectParser.Arguments_listContext ctx) {
//
//    }

//    @Override
//    visitArg(MASProjectParser.ArgContext ctx);
}
