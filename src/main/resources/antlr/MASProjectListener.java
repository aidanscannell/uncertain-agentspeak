// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/MASProject.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MASProjectParser}.
 */
public interface MASProjectListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#mas_project}.
	 * @param ctx the parse tree
	 */
	void enterMas_project(MASProjectParser.Mas_projectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#mas_project}.
	 * @param ctx the parse tree
	 */
	void exitMas_project(MASProjectParser.Mas_projectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(MASProjectParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(MASProjectParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(MASProjectParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(MASProjectParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#infrastructure}.
	 * @param ctx the parse tree
	 */
	void enterInfrastructure(MASProjectParser.InfrastructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#infrastructure}.
	 * @param ctx the parse tree
	 */
	void exitInfrastructure(MASProjectParser.InfrastructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#centralised}.
	 * @param ctx the parse tree
	 */
	void enterCentralised(MASProjectParser.CentralisedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#centralised}.
	 * @param ctx the parse tree
	 */
	void exitCentralised(MASProjectParser.CentralisedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#environment}.
	 * @param ctx the parse tree
	 */
	void enterEnvironment(MASProjectParser.EnvironmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#environment}.
	 * @param ctx the parse tree
	 */
	void exitEnvironment(MASProjectParser.EnvironmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#env_class_name}.
	 * @param ctx the parse tree
	 */
	void enterEnv_class_name(MASProjectParser.Env_class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#env_class_name}.
	 * @param ctx the parse tree
	 */
	void exitEnv_class_name(MASProjectParser.Env_class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#agents}.
	 * @param ctx the parse tree
	 */
	void enterAgents(MASProjectParser.AgentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#agents}.
	 * @param ctx the parse tree
	 */
	void exitAgents(MASProjectParser.AgentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#agent}.
	 * @param ctx the parse tree
	 */
	void enterAgent(MASProjectParser.AgentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#agent}.
	 * @param ctx the parse tree
	 */
	void exitAgent(MASProjectParser.AgentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#agent_name}.
	 * @param ctx the parse tree
	 */
	void enterAgent_name(MASProjectParser.Agent_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#agent_name}.
	 * @param ctx the parse tree
	 */
	void exitAgent_name(MASProjectParser.Agent_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#numAgents}.
	 * @param ctx the parse tree
	 */
	void enterNumAgents(MASProjectParser.NumAgentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#numAgents}.
	 * @param ctx the parse tree
	 */
	void exitNumAgents(MASProjectParser.NumAgentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArguments_list(MASProjectParser.Arguments_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArguments_list(MASProjectParser.Arguments_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MASProjectParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(MASProjectParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MASProjectParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(MASProjectParser.ArgContext ctx);
}