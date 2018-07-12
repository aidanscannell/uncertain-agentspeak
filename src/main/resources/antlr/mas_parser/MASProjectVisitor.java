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
import java.util.List;

public class MASProjectVisitor extends MASProjectBaseVisitor<Object> {

    public MASProject visitMas_project(MASProjectParser.Mas_projectContext ctx) {
        String name = null;
        List<Agent> agentList = null;
        Environment environment = null;
        if (ctx.name() != null) {
            name = ctx.name().ATOM().toString();
        }
        if (ctx.content() != null) {
            if (ctx.content().environment() != null) {
//                Environment environment = new Environment(ctx.content().environment().)
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
                        System.out.println("Successfully instantiated agent: " + agent.toString());
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
