// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/UncertainAgentspeak.g4 by ANTLR 4.7
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
public class UncertainAgentspeakParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CONTEXT=8, ACTIONS=9, 
		ACTION_SEPERATOR=10, ADD_EVENT_OPRTATOR=11, DELETE_EVENT_OPRTATOR=12, 
		ACHIEVEMENT_GOAL_OPERATOR=13, TEST_GOAL_OPERATOR=14, ATOM=15, VARIABLE=16, 
		NUMBER=17, WHITESPACE=18, NEWLINE=19, DECIMAL=20, LPAREN=21, RPAREN=22, 
		AND=23, OR=24, LESS_THAN=25, LESS_EQUALS=26, GREATER_THAN=27, GREATER_EQUALS=28, 
		STRONG_NEGATION=29, NEGATION_AS_FAILURE=30, EQUALS=31, NOT_EQUALS=32, 
		Comment=33;
	public static final int
		RULE_uncertainAgentspeak = 0, RULE_init_bels = 1, RULE_probabilistic_bel = 2, 
		RULE_possibilistic_bel = 3, RULE_init_goals = 4, RULE_plans = 5, RULE_plan = 6, 
		RULE_event = 7, RULE_belief_event_trigger = 8, RULE_goal_event_trigger = 9, 
		RULE_add_goal_event_trigger = 10, RULE_delete_goal_event_trigger = 11, 
		RULE_goal = 12, RULE_achievement_goal = 13, RULE_test_goal = 14, RULE_tautology = 15, 
		RULE_context = 16, RULE_log_expr = 17, RULE_and_expr = 18, RULE_or_expr = 19, 
		RULE_less_than_expr = 20, RULE_less_equals_expr = 21, RULE_greater_than_expr = 22, 
		RULE_greater_equals_expr = 23, RULE_equals_expr = 24, RULE_not_equals_expr = 25, 
		RULE_negation_expr = 26, RULE_belief_atom_expr = 27, RULE_body = 28, RULE_body_statement = 29, 
		RULE_belief_action = 30, RULE_environment_action = 31, RULE_belief_literal = 32, 
		RULE_positive_literal = 33, RULE_negative_literal = 34, RULE_belief_atom = 35, 
		RULE_term = 36, RULE_constant = 37, RULE_atom = 38, RULE_number = 39, 
		RULE_intNum = 40, RULE_doubleNum = 41, RULE_variable = 42, RULE_arguments_list = 43, 
		RULE_structure = 44;
	public static final String[] ruleNames = {
		"uncertainAgentspeak", "init_bels", "probabilistic_bel", "possibilistic_bel", 
		"init_goals", "plans", "plan", "event", "belief_event_trigger", "goal_event_trigger", 
		"add_goal_event_trigger", "delete_goal_event_trigger", "goal", "achievement_goal", 
		"test_goal", "tautology", "context", "log_expr", "and_expr", "or_expr", 
		"less_than_expr", "less_equals_expr", "greater_than_expr", "greater_equals_expr", 
		"equals_expr", "not_equals_expr", "negation_expr", "belief_atom_expr", 
		"body", "body_statement", "belief_action", "environment_action", "belief_literal", 
		"positive_literal", "negative_literal", "belief_atom", "term", "constant", 
		"atom", "number", "intNum", "doubleNum", "variable", "arguments_list", 
		"structure"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'Prob('", "','", "'Pos('", "'*('", "'true'", "';'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'('", "')'", "'&&'", "'||'", "'<'", "'=<'", "'>'", "'>='", "'~'", "'not'", 
		"'=='", "'\\=='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "CONTEXT", "ACTIONS", 
		"ACTION_SEPERATOR", "ADD_EVENT_OPRTATOR", "DELETE_EVENT_OPRTATOR", "ACHIEVEMENT_GOAL_OPERATOR", 
		"TEST_GOAL_OPERATOR", "ATOM", "VARIABLE", "NUMBER", "WHITESPACE", "NEWLINE", 
		"DECIMAL", "LPAREN", "RPAREN", "AND", "OR", "LESS_THAN", "LESS_EQUALS", 
		"GREATER_THAN", "GREATER_EQUALS", "STRONG_NEGATION", "NEGATION_AS_FAILURE", 
		"EQUALS", "NOT_EQUALS", "Comment"
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
	public String getGrammarFileName() { return "UncertainAgentspeak.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UncertainAgentspeakParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UncertainAgentspeakContext extends ParserRuleContext {
		public Init_belsContext init_bels() {
			return getRuleContext(Init_belsContext.class,0);
		}
		public Init_goalsContext init_goals() {
			return getRuleContext(Init_goalsContext.class,0);
		}
		public PlansContext plans() {
			return getRuleContext(PlansContext.class,0);
		}
		public TerminalNode EOF() { return getToken(UncertainAgentspeakParser.EOF, 0); }
		public UncertainAgentspeakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncertainAgentspeak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterUncertainAgentspeak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitUncertainAgentspeak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitUncertainAgentspeak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UncertainAgentspeakContext uncertainAgentspeak() throws RecognitionException {
		UncertainAgentspeakContext _localctx = new UncertainAgentspeakContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_uncertainAgentspeak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			init_bels();
			setState(91);
			init_goals();
			setState(92);
			plans();
			setState(93);
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

	public static class Init_belsContext extends ParserRuleContext {
		public List<Probabilistic_belContext> probabilistic_bel() {
			return getRuleContexts(Probabilistic_belContext.class);
		}
		public Probabilistic_belContext probabilistic_bel(int i) {
			return getRuleContext(Probabilistic_belContext.class,i);
		}
		public List<Possibilistic_belContext> possibilistic_bel() {
			return getRuleContexts(Possibilistic_belContext.class);
		}
		public Possibilistic_belContext possibilistic_bel(int i) {
			return getRuleContext(Possibilistic_belContext.class,i);
		}
		public Init_belsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_bels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterInit_bels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitInit_bels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitInit_bels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_belsContext init_bels() throws RecognitionException {
		Init_belsContext _localctx = new Init_belsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_init_bels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__3) {
				{
				setState(101);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(95);
					probabilistic_bel();
					setState(96);
					match(T__0);
					}
					break;
				case T__3:
					{
					setState(98);
					possibilistic_bel();
					setState(99);
					match(T__0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(105);
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

	public static class Probabilistic_belContext extends ParserRuleContext {
		public List<Belief_literalContext> belief_literal() {
			return getRuleContexts(Belief_literalContext.class);
		}
		public Belief_literalContext belief_literal(int i) {
			return getRuleContext(Belief_literalContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public Probabilistic_belContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probabilistic_bel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterProbabilistic_bel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitProbabilistic_bel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitProbabilistic_bel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Probabilistic_belContext probabilistic_bel() throws RecognitionException {
		Probabilistic_belContext _localctx = new Probabilistic_belContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_probabilistic_bel);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(T__1);
				setState(107);
				match(LPAREN);
				setState(108);
				belief_literal();
				setState(109);
				match(T__2);
				setState(110);
				number();
				setState(111);
				match(RPAREN);
				setState(112);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(T__1);
				setState(115);
				match(LPAREN);
				setState(116);
				belief_literal();
				setState(117);
				match(T__2);
				setState(118);
				number();
				setState(119);
				match(RPAREN);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(120);
					match(T__2);
					setState(121);
					match(LPAREN);
					setState(122);
					belief_literal();
					setState(123);
					match(T__2);
					setState(124);
					number();
					setState(125);
					match(RPAREN);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				match(RPAREN);
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

	public static class Possibilistic_belContext extends ParserRuleContext {
		public List<Belief_literalContext> belief_literal() {
			return getRuleContexts(Belief_literalContext.class);
		}
		public Belief_literalContext belief_literal(int i) {
			return getRuleContext(Belief_literalContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public Possibilistic_belContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibilistic_bel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterPossibilistic_bel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitPossibilistic_bel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitPossibilistic_bel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Possibilistic_belContext possibilistic_bel() throws RecognitionException {
		Possibilistic_belContext _localctx = new Possibilistic_belContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_possibilistic_bel);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(T__3);
				setState(137);
				match(LPAREN);
				setState(138);
				belief_literal();
				setState(139);
				match(T__2);
				setState(140);
				number();
				setState(141);
				match(RPAREN);
				setState(142);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(T__3);
				setState(145);
				match(LPAREN);
				setState(146);
				belief_literal();
				setState(147);
				match(T__2);
				setState(148);
				number();
				setState(149);
				match(RPAREN);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(150);
					match(T__2);
					setState(151);
					match(LPAREN);
					setState(152);
					belief_literal();
					setState(153);
					match(T__2);
					setState(154);
					number();
					setState(155);
					match(RPAREN);
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(162);
				match(RPAREN);
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

	public static class Init_goalsContext extends ParserRuleContext {
		public List<Achievement_goalContext> achievement_goal() {
			return getRuleContexts(Achievement_goalContext.class);
		}
		public Achievement_goalContext achievement_goal(int i) {
			return getRuleContext(Achievement_goalContext.class,i);
		}
		public Init_goalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_goals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterInit_goals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitInit_goals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitInit_goals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_goalsContext init_goals() throws RecognitionException {
		Init_goalsContext _localctx = new Init_goalsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_init_goals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ACHIEVEMENT_GOAL_OPERATOR) {
				{
				{
				setState(166);
				achievement_goal();
				setState(167);
				match(T__0);
				}
				}
				setState(173);
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

	public static class PlansContext extends ParserRuleContext {
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public PlansContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plans; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterPlans(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitPlans(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitPlans(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlansContext plans() throws RecognitionException {
		PlansContext _localctx = new PlansContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plans);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << ADD_EVENT_OPRTATOR) | (1L << DELETE_EVENT_OPRTATOR))) != 0)) {
				{
				{
				setState(174);
				plan();
				}
				}
				setState(179);
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

	public static class PlanContext extends ParserRuleContext {
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public TerminalNode CONTEXT() { return getToken(UncertainAgentspeakParser.CONTEXT, 0); }
		public ContextContext context() {
			return getRuleContext(ContextContext.class,0);
		}
		public TerminalNode ACTIONS() { return getToken(UncertainAgentspeakParser.ACTIONS, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterPlan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitPlan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitPlan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			event();
			setState(181);
			match(CONTEXT);
			setState(182);
			context();
			setState(183);
			match(ACTIONS);
			setState(184);
			body();
			setState(185);
			match(T__0);
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
		public Belief_event_triggerContext belief_event_trigger() {
			return getRuleContext(Belief_event_triggerContext.class,0);
		}
		public Goal_event_triggerContext goal_event_trigger() {
			return getRuleContext(Goal_event_triggerContext.class,0);
		}
		public TautologyContext tautology() {
			return getRuleContext(TautologyContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_event);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				belief_event_trigger();
				}
				break;
			case ADD_EVENT_OPRTATOR:
			case DELETE_EVENT_OPRTATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				goal_event_trigger();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				tautology();
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

	public static class Belief_event_triggerContext extends ParserRuleContext {
		public Belief_literalContext belief_literal() {
			return getRuleContext(Belief_literalContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Belief_event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_event_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBelief_event_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBelief_event_trigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBelief_event_trigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_event_triggerContext belief_event_trigger() throws RecognitionException {
		Belief_event_triggerContext _localctx = new Belief_event_triggerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_belief_event_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__4);
			setState(193);
			belief_literal();
			setState(194);
			match(T__2);
			setState(195);
			term();
			setState(196);
			match(RPAREN);
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

	public static class Goal_event_triggerContext extends ParserRuleContext {
		public Add_goal_event_triggerContext add_goal_event_trigger() {
			return getRuleContext(Add_goal_event_triggerContext.class,0);
		}
		public Delete_goal_event_triggerContext delete_goal_event_trigger() {
			return getRuleContext(Delete_goal_event_triggerContext.class,0);
		}
		public Goal_event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal_event_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterGoal_event_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitGoal_event_trigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitGoal_event_trigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Goal_event_triggerContext goal_event_trigger() throws RecognitionException {
		Goal_event_triggerContext _localctx = new Goal_event_triggerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_goal_event_trigger);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_EVENT_OPRTATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				add_goal_event_trigger();
				}
				break;
			case DELETE_EVENT_OPRTATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				delete_goal_event_trigger();
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

	public static class Add_goal_event_triggerContext extends ParserRuleContext {
		public TerminalNode ADD_EVENT_OPRTATOR() { return getToken(UncertainAgentspeakParser.ADD_EVENT_OPRTATOR, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public Add_goal_event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_goal_event_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterAdd_goal_event_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitAdd_goal_event_trigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitAdd_goal_event_trigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_goal_event_triggerContext add_goal_event_trigger() throws RecognitionException {
		Add_goal_event_triggerContext _localctx = new Add_goal_event_triggerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_add_goal_event_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ADD_EVENT_OPRTATOR);
			setState(203);
			goal();
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

	public static class Delete_goal_event_triggerContext extends ParserRuleContext {
		public TerminalNode DELETE_EVENT_OPRTATOR() { return getToken(UncertainAgentspeakParser.DELETE_EVENT_OPRTATOR, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public Delete_goal_event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_goal_event_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterDelete_goal_event_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitDelete_goal_event_trigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitDelete_goal_event_trigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_goal_event_triggerContext delete_goal_event_trigger() throws RecognitionException {
		Delete_goal_event_triggerContext _localctx = new Delete_goal_event_triggerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_delete_goal_event_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(DELETE_EVENT_OPRTATOR);
			setState(206);
			goal();
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
		public Achievement_goalContext achievement_goal() {
			return getRuleContext(Achievement_goalContext.class,0);
		}
		public Test_goalContext test_goal() {
			return getRuleContext(Test_goalContext.class,0);
		}
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitGoal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_goal);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACHIEVEMENT_GOAL_OPERATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				achievement_goal();
				}
				break;
			case TEST_GOAL_OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				test_goal();
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

	public static class Achievement_goalContext extends ParserRuleContext {
		public TerminalNode ACHIEVEMENT_GOAL_OPERATOR() { return getToken(UncertainAgentspeakParser.ACHIEVEMENT_GOAL_OPERATOR, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Achievement_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_achievement_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterAchievement_goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitAchievement_goal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitAchievement_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Achievement_goalContext achievement_goal() throws RecognitionException {
		Achievement_goalContext _localctx = new Achievement_goalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_achievement_goal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ACHIEVEMENT_GOAL_OPERATOR);
			setState(213);
			term();
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

	public static class Test_goalContext extends ParserRuleContext {
		public TerminalNode TEST_GOAL_OPERATOR() { return getToken(UncertainAgentspeakParser.TEST_GOAL_OPERATOR, 0); }
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public Test_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterTest_goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitTest_goal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitTest_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_goalContext test_goal() throws RecognitionException {
		Test_goalContext _localctx = new Test_goalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_test_goal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(TEST_GOAL_OPERATOR);
			setState(216);
			and_expr();
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

	public static class TautologyContext extends ParserRuleContext {
		public TautologyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tautology; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterTautology(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitTautology(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitTautology(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TautologyContext tautology() throws RecognitionException {
		TautologyContext _localctx = new TautologyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tautology);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__5);
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
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public TautologyContext tautology() {
			return getRuleContext(TautologyContext.class,0);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitContext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_context);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
			case LPAREN:
			case STRONG_NEGATION:
			case NEGATION_AS_FAILURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				and_expr();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				tautology();
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

	public static class Log_exprContext extends ParserRuleContext {
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public Log_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterLog_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitLog_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitLog_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Log_exprContext log_expr() throws RecognitionException {
		Log_exprContext _localctx = new Log_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_log_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			and_expr();
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

	public static class And_exprContext extends ParserRuleContext {
		public List<Or_exprContext> or_expr() {
			return getRuleContexts(Or_exprContext.class);
		}
		public Or_exprContext or_expr(int i) {
			return getRuleContext(Or_exprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(UncertainAgentspeakParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(UncertainAgentspeakParser.AND, i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			or_expr();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(227);
				match(AND);
				setState(228);
				or_expr();
				}
				}
				setState(233);
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

	public static class Or_exprContext extends ParserRuleContext {
		public List<Less_than_exprContext> less_than_expr() {
			return getRuleContexts(Less_than_exprContext.class);
		}
		public Less_than_exprContext less_than_expr(int i) {
			return getRuleContext(Less_than_exprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(UncertainAgentspeakParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(UncertainAgentspeakParser.OR, i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterOr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitOr_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitOr_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			less_than_expr();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(235);
				match(OR);
				setState(236);
				less_than_expr();
				}
				}
				setState(241);
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

	public static class Less_than_exprContext extends ParserRuleContext {
		public List<Less_equals_exprContext> less_equals_expr() {
			return getRuleContexts(Less_equals_exprContext.class);
		}
		public Less_equals_exprContext less_equals_expr(int i) {
			return getRuleContext(Less_equals_exprContext.class,i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(UncertainAgentspeakParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(UncertainAgentspeakParser.LESS_THAN, i);
		}
		public Less_than_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_less_than_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterLess_than_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitLess_than_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitLess_than_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Less_than_exprContext less_than_expr() throws RecognitionException {
		Less_than_exprContext _localctx = new Less_than_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_less_than_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			less_equals_expr();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LESS_THAN) {
				{
				{
				setState(243);
				match(LESS_THAN);
				setState(244);
				less_equals_expr();
				}
				}
				setState(249);
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

	public static class Less_equals_exprContext extends ParserRuleContext {
		public List<Greater_than_exprContext> greater_than_expr() {
			return getRuleContexts(Greater_than_exprContext.class);
		}
		public Greater_than_exprContext greater_than_expr(int i) {
			return getRuleContext(Greater_than_exprContext.class,i);
		}
		public List<TerminalNode> LESS_EQUALS() { return getTokens(UncertainAgentspeakParser.LESS_EQUALS); }
		public TerminalNode LESS_EQUALS(int i) {
			return getToken(UncertainAgentspeakParser.LESS_EQUALS, i);
		}
		public Less_equals_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_less_equals_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterLess_equals_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitLess_equals_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitLess_equals_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Less_equals_exprContext less_equals_expr() throws RecognitionException {
		Less_equals_exprContext _localctx = new Less_equals_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_less_equals_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			greater_than_expr();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LESS_EQUALS) {
				{
				{
				setState(251);
				match(LESS_EQUALS);
				setState(252);
				greater_than_expr();
				}
				}
				setState(257);
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

	public static class Greater_than_exprContext extends ParserRuleContext {
		public List<Greater_equals_exprContext> greater_equals_expr() {
			return getRuleContexts(Greater_equals_exprContext.class);
		}
		public Greater_equals_exprContext greater_equals_expr(int i) {
			return getRuleContext(Greater_equals_exprContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(UncertainAgentspeakParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(UncertainAgentspeakParser.GREATER_THAN, i);
		}
		public Greater_than_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greater_than_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterGreater_than_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitGreater_than_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitGreater_than_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Greater_than_exprContext greater_than_expr() throws RecognitionException {
		Greater_than_exprContext _localctx = new Greater_than_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_greater_than_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			greater_equals_expr();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN) {
				{
				{
				setState(259);
				match(GREATER_THAN);
				setState(260);
				greater_equals_expr();
				}
				}
				setState(265);
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

	public static class Greater_equals_exprContext extends ParserRuleContext {
		public List<Equals_exprContext> equals_expr() {
			return getRuleContexts(Equals_exprContext.class);
		}
		public Equals_exprContext equals_expr(int i) {
			return getRuleContext(Equals_exprContext.class,i);
		}
		public List<TerminalNode> GREATER_EQUALS() { return getTokens(UncertainAgentspeakParser.GREATER_EQUALS); }
		public TerminalNode GREATER_EQUALS(int i) {
			return getToken(UncertainAgentspeakParser.GREATER_EQUALS, i);
		}
		public Greater_equals_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greater_equals_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterGreater_equals_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitGreater_equals_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitGreater_equals_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Greater_equals_exprContext greater_equals_expr() throws RecognitionException {
		Greater_equals_exprContext _localctx = new Greater_equals_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_greater_equals_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			equals_expr();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_EQUALS) {
				{
				{
				setState(267);
				match(GREATER_EQUALS);
				setState(268);
				equals_expr();
				}
				}
				setState(273);
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

	public static class Equals_exprContext extends ParserRuleContext {
		public List<Not_equals_exprContext> not_equals_expr() {
			return getRuleContexts(Not_equals_exprContext.class);
		}
		public Not_equals_exprContext not_equals_expr(int i) {
			return getRuleContext(Not_equals_exprContext.class,i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(UncertainAgentspeakParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(UncertainAgentspeakParser.EQUALS, i);
		}
		public Equals_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equals_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterEquals_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitEquals_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitEquals_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equals_exprContext equals_expr() throws RecognitionException {
		Equals_exprContext _localctx = new Equals_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_equals_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			not_equals_expr();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUALS) {
				{
				{
				setState(275);
				match(EQUALS);
				setState(276);
				not_equals_expr();
				}
				}
				setState(281);
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

	public static class Not_equals_exprContext extends ParserRuleContext {
		public List<Negation_exprContext> negation_expr() {
			return getRuleContexts(Negation_exprContext.class);
		}
		public Negation_exprContext negation_expr(int i) {
			return getRuleContext(Negation_exprContext.class,i);
		}
		public List<TerminalNode> NOT_EQUALS() { return getTokens(UncertainAgentspeakParser.NOT_EQUALS); }
		public TerminalNode NOT_EQUALS(int i) {
			return getToken(UncertainAgentspeakParser.NOT_EQUALS, i);
		}
		public Not_equals_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_equals_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterNot_equals_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitNot_equals_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitNot_equals_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_equals_exprContext not_equals_expr() throws RecognitionException {
		Not_equals_exprContext _localctx = new Not_equals_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_not_equals_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			negation_expr();
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOT_EQUALS) {
				{
				{
				setState(283);
				match(NOT_EQUALS);
				setState(284);
				negation_expr();
				}
				}
				setState(289);
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

	public static class Negation_exprContext extends ParserRuleContext {
		public TerminalNode NEGATION_AS_FAILURE() { return getToken(UncertainAgentspeakParser.NEGATION_AS_FAILURE, 0); }
		public Belief_atom_exprContext belief_atom_expr() {
			return getRuleContext(Belief_atom_exprContext.class,0);
		}
		public TerminalNode STRONG_NEGATION() { return getToken(UncertainAgentspeakParser.STRONG_NEGATION, 0); }
		public Negation_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterNegation_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitNegation_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitNegation_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negation_exprContext negation_expr() throws RecognitionException {
		Negation_exprContext _localctx = new Negation_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_negation_expr);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATION_AS_FAILURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				match(NEGATION_AS_FAILURE);
				setState(291);
				belief_atom_expr();
				}
				break;
			case STRONG_NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(STRONG_NEGATION);
				setState(293);
				belief_atom_expr();
				}
				break;
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				belief_atom_expr();
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

	public static class Belief_atom_exprContext extends ParserRuleContext {
		public Belief_atomContext belief_atom() {
			return getRuleContext(Belief_atomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UncertainAgentspeakParser.LPAREN, 0); }
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(UncertainAgentspeakParser.RPAREN, 0); }
		public Belief_atom_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_atom_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBelief_atom_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBelief_atom_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBelief_atom_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_atom_exprContext belief_atom_expr() throws RecognitionException {
		Belief_atom_exprContext _localctx = new Belief_atom_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_belief_atom_expr);
		try {
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				belief_atom();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(LPAREN);
				setState(299);
				and_expr();
				setState(300);
				match(RPAREN);
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

	public static class BodyContext extends ParserRuleContext {
		public List<Body_statementContext> body_statement() {
			return getRuleContexts(Body_statementContext.class);
		}
		public Body_statementContext body_statement(int i) {
			return getRuleContext(Body_statementContext.class,i);
		}
		public TautologyContext tautology() {
			return getRuleContext(TautologyContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_body);
		int _la;
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case ACHIEVEMENT_GOAL_OPERATOR:
			case TEST_GOAL_OPERATOR:
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				body_statement();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(305);
					match(T__6);
					setState(306);
					body_statement();
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				tautology();
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

	public static class Body_statementContext extends ParserRuleContext {
		public Belief_actionContext belief_action() {
			return getRuleContext(Belief_actionContext.class,0);
		}
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public Environment_actionContext environment_action() {
			return getRuleContext(Environment_actionContext.class,0);
		}
		public Body_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBody_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBody_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBody_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Body_statementContext body_statement() throws RecognitionException {
		Body_statementContext _localctx = new Body_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_body_statement);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				belief_action();
				}
				break;
			case ACHIEVEMENT_GOAL_OPERATOR:
			case TEST_GOAL_OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				goal();
				}
				break;
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				environment_action();
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

	public static class Belief_actionContext extends ParserRuleContext {
		public Belief_literalContext belief_literal() {
			return getRuleContext(Belief_literalContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Belief_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBelief_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBelief_action(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBelief_action(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_actionContext belief_action() throws RecognitionException {
		Belief_actionContext _localctx = new Belief_actionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_belief_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__4);
			setState(321);
			belief_literal();
			setState(322);
			match(T__2);
			setState(323);
			term();
			setState(324);
			match(RPAREN);
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

	public static class Environment_actionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Environment_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environment_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterEnvironment_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitEnvironment_action(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitEnvironment_action(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Environment_actionContext environment_action() throws RecognitionException {
		Environment_actionContext _localctx = new Environment_actionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_environment_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			term();
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

	public static class Belief_literalContext extends ParserRuleContext {
		public Positive_literalContext positive_literal() {
			return getRuleContext(Positive_literalContext.class,0);
		}
		public Negative_literalContext negative_literal() {
			return getRuleContext(Negative_literalContext.class,0);
		}
		public Belief_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBelief_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBelief_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBelief_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_literalContext belief_literal() throws RecognitionException {
		Belief_literalContext _localctx = new Belief_literalContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_belief_literal);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VARIABLE:
			case NUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				positive_literal();
				}
				break;
			case STRONG_NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				negative_literal();
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

	public static class Positive_literalContext extends ParserRuleContext {
		public Belief_atomContext belief_atom() {
			return getRuleContext(Belief_atomContext.class,0);
		}
		public Positive_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positive_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterPositive_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitPositive_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitPositive_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Positive_literalContext positive_literal() throws RecognitionException {
		Positive_literalContext _localctx = new Positive_literalContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_positive_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			belief_atom();
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

	public static class Negative_literalContext extends ParserRuleContext {
		public TerminalNode STRONG_NEGATION() { return getToken(UncertainAgentspeakParser.STRONG_NEGATION, 0); }
		public Belief_atomContext belief_atom() {
			return getRuleContext(Belief_atomContext.class,0);
		}
		public Negative_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negative_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterNegative_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitNegative_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitNegative_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negative_literalContext negative_literal() throws RecognitionException {
		Negative_literalContext _localctx = new Negative_literalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_negative_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(STRONG_NEGATION);
			setState(335);
			belief_atom();
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

	public static class Belief_atomContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Belief_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterBelief_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitBelief_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitBelief_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_atomContext belief_atom() throws RecognitionException {
		Belief_atomContext _localctx = new Belief_atomContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_belief_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			term();
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
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_term);
		try {
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
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

	public static class ConstantContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_constant);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				atom();
				}
				break;
			case NUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				number();
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(UncertainAgentspeakParser.ATOM, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(ATOM);
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

	public static class NumberContext extends ParserRuleContext {
		public IntNumContext intNum() {
			return getRuleContext(IntNumContext.class,0);
		}
		public DoubleNumContext doubleNum() {
			return getRuleContext(DoubleNumContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_number);
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				intNum();
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				doubleNum();
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

	public static class IntNumContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(UncertainAgentspeakParser.NUMBER, 0); }
		public IntNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterIntNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitIntNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitIntNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntNumContext intNum() throws RecognitionException {
		IntNumContext _localctx = new IntNumContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_intNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(NUMBER);
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

	public static class DoubleNumContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(UncertainAgentspeakParser.DECIMAL, 0); }
		public DoubleNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterDoubleNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitDoubleNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitDoubleNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleNumContext doubleNum() throws RecognitionException {
		DoubleNumContext _localctx = new DoubleNumContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_doubleNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(DECIMAL);
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
		public TerminalNode VARIABLE() { return getToken(UncertainAgentspeakParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
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
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterArguments_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitArguments_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitArguments_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_arguments_list);
		int _la;
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				term();
				setState(364); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(362);
					match(T__2);
					setState(363);
					term();
					}
					}
					setState(366); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
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

	public static class StructureContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(UncertainAgentspeakParser.ATOM, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UncertainAgentspeakListener ) ((UncertainAgentspeakListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UncertainAgentspeakVisitor ) return ((UncertainAgentspeakVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(ATOM);
			setState(371);
			match(LPAREN);
			setState(372);
			arguments_list();
			setState(373);
			match(RPAREN);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u017a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3h\n\3"+
		"\f\3\16\3k\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0082\n\4\f\4\16\4\u0085\13\4\3\4\3"+
		"\4\5\4\u0089\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00a0\n\5\f\5\16\5\u00a3\13\5\3\5\3"+
		"\5\5\5\u00a7\n\5\3\6\3\6\3\6\7\6\u00ac\n\6\f\6\16\6\u00af\13\6\3\7\7\7"+
		"\u00b2\n\7\f\7\16\7\u00b5\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\5\t\u00c1\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13\u00cb\n\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\5\16\u00d5\n\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\5\22\u00e1\n\22\3\23\3\23\3\24\3\24\3\24\7\24"+
		"\u00e8\n\24\f\24\16\24\u00eb\13\24\3\25\3\25\3\25\7\25\u00f0\n\25\f\25"+
		"\16\25\u00f3\13\25\3\26\3\26\3\26\7\26\u00f8\n\26\f\26\16\26\u00fb\13"+
		"\26\3\27\3\27\3\27\7\27\u0100\n\27\f\27\16\27\u0103\13\27\3\30\3\30\3"+
		"\30\7\30\u0108\n\30\f\30\16\30\u010b\13\30\3\31\3\31\3\31\7\31\u0110\n"+
		"\31\f\31\16\31\u0113\13\31\3\32\3\32\3\32\7\32\u0118\n\32\f\32\16\32\u011b"+
		"\13\32\3\33\3\33\3\33\7\33\u0120\n\33\f\33\16\33\u0123\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u012a\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u0131\n"+
		"\35\3\36\3\36\3\36\7\36\u0136\n\36\f\36\16\36\u0139\13\36\3\36\5\36\u013c"+
		"\n\36\3\37\3\37\3\37\5\37\u0141\n\37\3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\5"+
		"\"\u014d\n\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\5&\u0159\n&\3\'\3\'\5\'\u015d"+
		"\n\'\3(\3(\3)\3)\5)\u0163\n)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\6-\u016f\n"+
		"-\r-\16-\u0170\5-\u0173\n-\3.\3.\3.\3.\3.\3.\2\2/\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\2\2\u016f"+
		"\2\\\3\2\2\2\4i\3\2\2\2\6\u0088\3\2\2\2\b\u00a6\3\2\2\2\n\u00ad\3\2\2"+
		"\2\f\u00b3\3\2\2\2\16\u00b6\3\2\2\2\20\u00c0\3\2\2\2\22\u00c2\3\2\2\2"+
		"\24\u00ca\3\2\2\2\26\u00cc\3\2\2\2\30\u00cf\3\2\2\2\32\u00d4\3\2\2\2\34"+
		"\u00d6\3\2\2\2\36\u00d9\3\2\2\2 \u00dc\3\2\2\2\"\u00e0\3\2\2\2$\u00e2"+
		"\3\2\2\2&\u00e4\3\2\2\2(\u00ec\3\2\2\2*\u00f4\3\2\2\2,\u00fc\3\2\2\2."+
		"\u0104\3\2\2\2\60\u010c\3\2\2\2\62\u0114\3\2\2\2\64\u011c\3\2\2\2\66\u0129"+
		"\3\2\2\28\u0130\3\2\2\2:\u013b\3\2\2\2<\u0140\3\2\2\2>\u0142\3\2\2\2@"+
		"\u0148\3\2\2\2B\u014c\3\2\2\2D\u014e\3\2\2\2F\u0150\3\2\2\2H\u0153\3\2"+
		"\2\2J\u0158\3\2\2\2L\u015c\3\2\2\2N\u015e\3\2\2\2P\u0162\3\2\2\2R\u0164"+
		"\3\2\2\2T\u0166\3\2\2\2V\u0168\3\2\2\2X\u0172\3\2\2\2Z\u0174\3\2\2\2\\"+
		"]\5\4\3\2]^\5\n\6\2^_\5\f\7\2_`\7\2\2\3`\3\3\2\2\2ab\5\6\4\2bc\7\3\2\2"+
		"ch\3\2\2\2de\5\b\5\2ef\7\3\2\2fh\3\2\2\2ga\3\2\2\2gd\3\2\2\2hk\3\2\2\2"+
		"ig\3\2\2\2ij\3\2\2\2j\5\3\2\2\2ki\3\2\2\2lm\7\4\2\2mn\7\27\2\2no\5B\""+
		"\2op\7\5\2\2pq\5P)\2qr\7\30\2\2rs\7\30\2\2s\u0089\3\2\2\2tu\7\4\2\2uv"+
		"\7\27\2\2vw\5B\"\2wx\7\5\2\2xy\5P)\2y\u0083\7\30\2\2z{\7\5\2\2{|\7\27"+
		"\2\2|}\5B\"\2}~\7\5\2\2~\177\5P)\2\177\u0080\7\30\2\2\u0080\u0082\3\2"+
		"\2\2\u0081z\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\30\2\2"+
		"\u0087\u0089\3\2\2\2\u0088l\3\2\2\2\u0088t\3\2\2\2\u0089\7\3\2\2\2\u008a"+
		"\u008b\7\6\2\2\u008b\u008c\7\27\2\2\u008c\u008d\5B\"\2\u008d\u008e\7\5"+
		"\2\2\u008e\u008f\5P)\2\u008f\u0090\7\30\2\2\u0090\u0091\7\30\2\2\u0091"+
		"\u00a7\3\2\2\2\u0092\u0093\7\6\2\2\u0093\u0094\7\27\2\2\u0094\u0095\5"+
		"B\"\2\u0095\u0096\7\5\2\2\u0096\u0097\5P)\2\u0097\u00a1\7\30\2\2\u0098"+
		"\u0099\7\5\2\2\u0099\u009a\7\27\2\2\u009a\u009b\5B\"\2\u009b\u009c\7\5"+
		"\2\2\u009c\u009d\5P)\2\u009d\u009e\7\30\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u0098\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\30\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u008a\3\2\2\2\u00a6\u0092\3\2\2\2\u00a7\t\3\2\2\2"+
		"\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7\3\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a8"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\13\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\5\16\b\2\u00b1\u00b0\3\2\2"+
		"\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\r"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\5\20\t\2\u00b7\u00b8\7\n\2\2"+
		"\u00b8\u00b9\5\"\22\2\u00b9\u00ba\7\13\2\2\u00ba\u00bb\5:\36\2\u00bb\u00bc"+
		"\7\3\2\2\u00bc\17\3\2\2\2\u00bd\u00c1\5\22\n\2\u00be\u00c1\5\24\13\2\u00bf"+
		"\u00c1\5 \21\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2"+
		"\2\2\u00c1\21\3\2\2\2\u00c2\u00c3\7\7\2\2\u00c3\u00c4\5B\"\2\u00c4\u00c5"+
		"\7\5\2\2\u00c5\u00c6\5J&\2\u00c6\u00c7\7\30\2\2\u00c7\23\3\2\2\2\u00c8"+
		"\u00cb\5\26\f\2\u00c9\u00cb\5\30\r\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3"+
		"\2\2\2\u00cb\25\3\2\2\2\u00cc\u00cd\7\r\2\2\u00cd\u00ce\5\32\16\2\u00ce"+
		"\27\3\2\2\2\u00cf\u00d0\7\16\2\2\u00d0\u00d1\5\32\16\2\u00d1\31\3\2\2"+
		"\2\u00d2\u00d5\5\34\17\2\u00d3\u00d5\5\36\20\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\33\3\2\2\2\u00d6\u00d7\7\17\2\2\u00d7\u00d8\5J&\2"+
		"\u00d8\35\3\2\2\2\u00d9\u00da\7\20\2\2\u00da\u00db\5&\24\2\u00db\37\3"+
		"\2\2\2\u00dc\u00dd\7\b\2\2\u00dd!\3\2\2\2\u00de\u00e1\5&\24\2\u00df\u00e1"+
		"\5 \21\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1#\3\2\2\2\u00e2"+
		"\u00e3\5&\24\2\u00e3%\3\2\2\2\u00e4\u00e9\5(\25\2\u00e5\u00e6\7\31\2\2"+
		"\u00e6\u00e8\5(\25\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\'\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00f1\5*\26\2\u00ed\u00ee\7\32\2\2\u00ee\u00f0\5*\26\2\u00ef\u00ed\3"+
		"\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		")\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f9\5,\27\2\u00f5\u00f6\7\33\2\2"+
		"\u00f6\u00f8\5,\27\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa+\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u0101\5.\30\2\u00fd\u00fe\7\34\2\2\u00fe\u0100\5.\30\2\u00ff\u00fd\3"+
		"\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"-\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0109\5\60\31\2\u0105\u0106\7\35\2"+
		"\2\u0106\u0108\5\60\31\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a/\3\2\2\2\u010b\u0109\3\2\2\2"+
		"\u010c\u0111\5\62\32\2\u010d\u010e\7\36\2\2\u010e\u0110\5\62\32\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2"+
		"\2\2\u0112\61\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0119\5\64\33\2\u0115"+
		"\u0116\7!\2\2\u0116\u0118\5\64\33\2\u0117\u0115\3\2\2\2\u0118\u011b\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\63\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u0121\5\66\34\2\u011d\u011e\7\"\2\2\u011e\u0120\5"+
		"\66\34\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\65\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7 \2\2"+
		"\u0125\u012a\58\35\2\u0126\u0127\7\37\2\2\u0127\u012a\58\35\2\u0128\u012a"+
		"\58\35\2\u0129\u0124\3\2\2\2\u0129\u0126\3\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\67\3\2\2\2\u012b\u0131\5H%\2\u012c\u012d\7\27\2\2\u012d\u012e\5&\24\2"+
		"\u012e\u012f\7\30\2\2\u012f\u0131\3\2\2\2\u0130\u012b\3\2\2\2\u0130\u012c"+
		"\3\2\2\2\u01319\3\2\2\2\u0132\u0137\5<\37\2\u0133\u0134\7\t\2\2\u0134"+
		"\u0136\5<\37\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\u013c\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013c\5 \21\2\u013b\u0132\3\2\2\2\u013b\u013a\3\2\2\2\u013c;\3\2\2\2"+
		"\u013d\u0141\5> \2\u013e\u0141\5\32\16\2\u013f\u0141\5@!\2\u0140\u013d"+
		"\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141=\3\2\2\2\u0142"+
		"\u0143\7\7\2\2\u0143\u0144\5B\"\2\u0144\u0145\7\5\2\2\u0145\u0146\5J&"+
		"\2\u0146\u0147\7\30\2\2\u0147?\3\2\2\2\u0148\u0149\5J&\2\u0149A\3\2\2"+
		"\2\u014a\u014d\5D#\2\u014b\u014d\5F$\2\u014c\u014a\3\2\2\2\u014c\u014b"+
		"\3\2\2\2\u014dC\3\2\2\2\u014e\u014f\5H%\2\u014fE\3\2\2\2\u0150\u0151\7"+
		"\37\2\2\u0151\u0152\5H%\2\u0152G\3\2\2\2\u0153\u0154\5J&\2\u0154I\3\2"+
		"\2\2\u0155\u0159\5L\'\2\u0156\u0159\5V,\2\u0157\u0159\5Z.\2\u0158\u0155"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159K\3\2\2\2\u015a"+
		"\u015d\5N(\2\u015b\u015d\5P)\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2"+
		"\u015dM\3\2\2\2\u015e\u015f\7\21\2\2\u015fO\3\2\2\2\u0160\u0163\5R*\2"+
		"\u0161\u0163\5T+\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163Q\3\2"+
		"\2\2\u0164\u0165\7\23\2\2\u0165S\3\2\2\2\u0166\u0167\7\26\2\2\u0167U\3"+
		"\2\2\2\u0168\u0169\7\22\2\2\u0169W\3\2\2\2\u016a\u0173\5J&\2\u016b\u016e"+
		"\5J&\2\u016c\u016d\7\5\2\2\u016d\u016f\5J&\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2"+
		"\2\2\u0172\u016a\3\2\2\2\u0172\u016b\3\2\2\2\u0173Y\3\2\2\2\u0174\u0175"+
		"\7\21\2\2\u0175\u0176\7\27\2\2\u0176\u0177\5X-\2\u0177\u0178\7\30\2\2"+
		"\u0178[\3\2\2\2!gi\u0083\u0088\u00a1\u00a6\u00ad\u00b3\u00c0\u00ca\u00d4"+
		"\u00e0\u00e9\u00f1\u00f9\u0101\u0109\u0111\u0119\u0121\u0129\u0130\u0137"+
		"\u013b\u0140\u014c\u0158\u015c\u0162\u0170\u0172";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}