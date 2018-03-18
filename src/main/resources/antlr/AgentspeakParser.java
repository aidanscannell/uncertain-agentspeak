// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/agentspeak/src/main/resources/antlr/Agentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AgentspeakParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ATOM=19, VARIABLE=20, NUMBER=21, WHITESPACE=22, NEWLINE=23;
	public static final int
		RULE_agentspeak = 0, RULE_plan = 1, RULE_belief = 2, RULE_event = 3, RULE_context = 4, 
		RULE_context_list = 5, RULE_body = 6, RULE_body_list = 7, RULE_body_statement = 8, 
		RULE_arguments_list = 9, RULE_term = 10, RULE_goal = 11, RULE_constant = 12, 
		RULE_structure = 13, RULE_variable = 14;
	public static final String[] ruleNames = {
		"agentspeak", "plan", "belief", "event", "context", "context_list", "body", 
		"body_list", "body_statement", "arguments_list", "term", "goal", "constant", 
		"structure", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'<-'", "'.'", "'+'", "'-'", "'+!'", "'-!'", "'+?'", "'-?'", 
		"'true'", "'&'", "';'", "'-+'", "'!'", "'?'", "','", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "ATOM", "VARIABLE", "NUMBER", 
		"WHITESPACE", "NEWLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Agentspeak.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AgentspeakParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AgentspeakContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AgentspeakParser.EOF, 0); }
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public List<BeliefContext> belief() {
			return getRuleContexts(BeliefContext.class);
		}
		public BeliefContext belief(int i) {
			return getRuleContext(BeliefContext.class,i);
		}
		public AgentspeakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentspeak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterAgentspeak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitAgentspeak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitAgentspeak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentspeakContext agentspeak() throws RecognitionException {
		AgentspeakContext _localctx = new AgentspeakContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_agentspeak);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << ATOM) | (1L << VARIABLE) | (1L << NUMBER))) != 0)) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
					{
					setState(30);
					plan();
					}
					break;
				case ATOM:
				case VARIABLE:
				case NUMBER:
					{
					setState(31);
					belief();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlanContext extends ParserRuleContext {
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public ContextContext context() {
			return getRuleContext(ContextContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterPlan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitPlan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitPlan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			event();
			{
			setState(40);
			match(T__0);
			setState(41);
			context();
			setState(42);
			match(T__1);
			setState(43);
			body();
			}
			setState(45);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeliefContext extends ParserRuleContext {
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public BeliefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterBelief(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitBelief(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitBelief(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeliefContext belief() throws RecognitionException {
		BeliefContext _localctx = new BeliefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_belief);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			arguments_list();
			setState(48);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_event);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__3);
				setState(51);
				term();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__4);
				setState(53);
				term();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(T__5);
				setState(55);
				term();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				match(T__6);
				setState(57);
				term();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				match(T__7);
				setState(59);
				term();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(60);
				match(T__8);
				setState(61);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextContext extends ParserRuleContext {
		public Context_listContext context_list() {
			return getRuleContext(Context_listContext.class,0);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitContext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_context);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__9);
				}
				break;
			case ATOM:
			case VARIABLE:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				context_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Context_listContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Context_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterContext_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitContext_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitContext_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Context_listContext context_list() throws RecognitionException {
		Context_listContext _localctx = new Context_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_context_list);
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				term();
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(70);
					match(T__10);
					setState(71);
					term();
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Body_listContext body_list() {
			return getRuleContext(Body_listContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__9);
				}
				break;
			case T__3:
			case T__4:
			case T__12:
			case T__13:
			case T__14:
			case ATOM:
			case VARIABLE:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				body_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Body_listContext extends ParserRuleContext {
		public List<Body_statementContext> body_statement() {
			return getRuleContexts(Body_statementContext.class);
		}
		public Body_statementContext body_statement(int i) {
			return getRuleContext(Body_statementContext.class,i);
		}
		public Body_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterBody_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitBody_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitBody_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Body_listContext body_list() throws RecognitionException {
		Body_listContext _localctx = new Body_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_body_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			body_statement();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(83);
				match(T__11);
				setState(84);
				body_statement();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Body_statementContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Body_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterBody_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitBody_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitBody_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Body_statementContext body_statement() throws RecognitionException {
		Body_statementContext _localctx = new Body_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_body_statement);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__12);
				setState(91);
				term();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__3);
				setState(93);
				term();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__4);
				setState(95);
				term();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(T__13);
				setState(97);
				term();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(T__14);
				setState(99);
				term();
				}
				break;
			case ATOM:
			case VARIABLE:
			case NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arguments_listContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Arguments_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterArguments_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitArguments_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitArguments_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arguments_list);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				term();
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(105);
					match(T__15);
					setState(106);
					term();
					}
					}
					setState(109); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__15 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				structure();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GoalContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitGoal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_goal);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(T__13);
				setState(119);
				term();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__14);
				setState(121);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(AgentspeakParser.ATOM, 0); }
		public TerminalNode NUMBER() { return getToken(AgentspeakParser.NUMBER, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==ATOM || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(AgentspeakParser.ATOM, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ATOM);
			setState(127);
			match(T__16);
			setState(128);
			arguments_list();
			setState(129);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(AgentspeakParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgentspeakListener ) ((AgentspeakListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgentspeakVisitor ) return ((AgentspeakVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u0088\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\5\6E\n\6"+
		"\3\7\3\7\3\7\3\7\6\7K\n\7\r\7\16\7L\5\7O\n\7\3\b\3\b\5\bS\n\b\3\t\3\t"+
		"\3\t\7\tX\n\t\f\t\16\t[\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nh\n\n\3\13\3\13\3\13\3\13\6\13n\n\13\r\13\16\13o\5\13r\n\13\3\f"+
		"\3\f\3\f\5\fw\n\f\3\r\3\r\3\r\3\r\5\r}\n\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		"\2\3\4\2\25\25\27\27\2\u008e\2$\3\2\2\2\4)\3\2\2\2\6\61\3\2\2\2\b@\3\2"+
		"\2\2\nD\3\2\2\2\fN\3\2\2\2\16R\3\2\2\2\20T\3\2\2\2\22g\3\2\2\2\24q\3\2"+
		"\2\2\26v\3\2\2\2\30|\3\2\2\2\32~\3\2\2\2\34\u0080\3\2\2\2\36\u0085\3\2"+
		"\2\2 #\5\4\3\2!#\5\6\4\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%"+
		"\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2\2\3(\3\3\2\2\2)*\5\b\5\2*+\7\3\2"+
		"\2+,\5\n\6\2,-\7\4\2\2-.\5\16\b\2./\3\2\2\2/\60\7\5\2\2\60\5\3\2\2\2\61"+
		"\62\5\24\13\2\62\63\7\5\2\2\63\7\3\2\2\2\64\65\7\6\2\2\65A\5\26\f\2\66"+
		"\67\7\7\2\2\67A\5\26\f\289\7\b\2\29A\5\26\f\2:;\7\t\2\2;A\5\26\f\2<=\7"+
		"\n\2\2=A\5\26\f\2>?\7\13\2\2?A\5\26\f\2@\64\3\2\2\2@\66\3\2\2\2@8\3\2"+
		"\2\2@:\3\2\2\2@<\3\2\2\2@>\3\2\2\2A\t\3\2\2\2BE\7\f\2\2CE\5\f\7\2DB\3"+
		"\2\2\2DC\3\2\2\2E\13\3\2\2\2FO\5\26\f\2GJ\5\26\f\2HI\7\r\2\2IK\5\26\f"+
		"\2JH\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NF\3\2\2\2NG\3\2\2"+
		"\2O\r\3\2\2\2PS\7\f\2\2QS\5\20\t\2RP\3\2\2\2RQ\3\2\2\2S\17\3\2\2\2TY\5"+
		"\22\n\2UV\7\16\2\2VX\5\22\n\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z\21\3\2\2\2[Y\3\2\2\2\\]\7\17\2\2]h\5\26\f\2^_\7\6\2\2_h\5\26\f\2`a\7"+
		"\7\2\2ah\5\26\f\2bc\7\20\2\2ch\5\26\f\2de\7\21\2\2eh\5\26\f\2fh\5\26\f"+
		"\2g\\\3\2\2\2g^\3\2\2\2g`\3\2\2\2gb\3\2\2\2gd\3\2\2\2gf\3\2\2\2h\23\3"+
		"\2\2\2ir\5\26\f\2jm\5\26\f\2kl\7\22\2\2ln\5\26\f\2mk\3\2\2\2no\3\2\2\2"+
		"om\3\2\2\2op\3\2\2\2pr\3\2\2\2qi\3\2\2\2qj\3\2\2\2r\25\3\2\2\2sw\5\32"+
		"\16\2tw\5\36\20\2uw\5\34\17\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\27\3\2\2"+
		"\2xy\7\20\2\2y}\5\26\f\2z{\7\21\2\2{}\5\26\f\2|x\3\2\2\2|z\3\2\2\2}\31"+
		"\3\2\2\2~\177\t\2\2\2\177\33\3\2\2\2\u0080\u0081\7\25\2\2\u0081\u0082"+
		"\7\23\2\2\u0082\u0083\5\24\13\2\u0083\u0084\7\24\2\2\u0084\35\3\2\2\2"+
		"\u0085\u0086\7\26\2\2\u0086\37\3\2\2\2\17\"$@DLNRYgoqv|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}