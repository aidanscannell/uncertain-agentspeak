// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/MASProject.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MASProjectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MASProjectVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#mas_project}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas_project(MASProjectParser.Mas_projectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MASProjectParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(MASProjectParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#infrastructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfrastructure(MASProjectParser.InfrastructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#centralised}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCentralised(MASProjectParser.CentralisedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#environment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment(MASProjectParser.EnvironmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#env_class_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnv_class_name(MASProjectParser.Env_class_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#agents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgents(MASProjectParser.AgentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#agent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent(MASProjectParser.AgentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#agent_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_name(MASProjectParser.Agent_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#numAgents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumAgents(MASProjectParser.NumAgentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments_list(MASProjectParser.Arguments_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MASProjectParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(MASProjectParser.ArgContext ctx);
}