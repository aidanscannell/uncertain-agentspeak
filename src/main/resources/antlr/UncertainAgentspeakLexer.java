// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/UncertainAgentspeak.g4 by ANTLR 4.7
package main.resources.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UncertainAgentspeakLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "CONTEXT", "ACTIONS", 
		"ACTION_SEPERATOR", "ADD_EVENT_OPRTATOR", "DELETE_EVENT_OPRTATOR", "ACHIEVEMENT_GOAL_OPERATOR", 
		"TEST_GOAL_OPERATOR", "LOWERCASE", "UPPERCASE", "ATOM", "VARIABLE", "NUMBER", 
		"WHITESPACE", "NEWLINE", "DECIMAL", "LPAREN", "RPAREN", "AND", "OR", "LESS_THAN", 
		"LESS_EQUALS", "GREATER_THAN", "GREATER_EQUALS", "STRONG_NEGATION", "NEGATION_AS_FAILURE", 
		"EQUALS", "NOT_EQUALS", "Comment"
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


	public UncertainAgentspeakLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UncertainAgentspeak.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\6\22|\n\22\r\22\16\22}\5\22\u0080\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u0088\n\23\r\23\16\23\u0089\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u0094\n\23\r\23\16\23\u0095\5\23"+
		"\u0098\n\23\3\24\6\24\u009b\n\24\r\24\16\24\u009c\3\25\3\25\6\25\u00a1"+
		"\n\25\r\25\16\25\u00a2\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3"+
		"$\7$\u00d0\n$\f$\16$\u00d3\13$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\21%\22\'\23)\24+\25-\26/\27"+
		"\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#\3\2\7\3\2c|\3\2C\\\3"+
		"\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00e5\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2"+
		"\13X\3\2\2\2\r[\3\2\2\2\17`\3\2\2\2\21b\3\2\2\2\23d\3\2\2\2\25g\3\2\2"+
		"\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!s\3\2\2"+
		"\2#\177\3\2\2\2%\u0097\3\2\2\2\'\u009a\3\2\2\2)\u00a0\3\2\2\2+\u00a6\3"+
		"\2\2\2-\u00a8\3\2\2\2/\u00ac\3\2\2\2\61\u00ae\3\2\2\2\63\u00b0\3\2\2\2"+
		"\65\u00b3\3\2\2\2\67\u00b6\3\2\2\29\u00b8\3\2\2\2;\u00bb\3\2\2\2=\u00bd"+
		"\3\2\2\2?\u00c0\3\2\2\2A\u00c2\3\2\2\2C\u00c6\3\2\2\2E\u00c9\3\2\2\2G"+
		"\u00cd\3\2\2\2IJ\7\60\2\2J\4\3\2\2\2KL\7R\2\2LM\7t\2\2MN\7q\2\2NO\7d\2"+
		"\2OP\7*\2\2P\6\3\2\2\2QR\7.\2\2R\b\3\2\2\2ST\7R\2\2TU\7q\2\2UV\7u\2\2"+
		"VW\7*\2\2W\n\3\2\2\2XY\7,\2\2YZ\7*\2\2Z\f\3\2\2\2[\\\7v\2\2\\]\7t\2\2"+
		"]^\7w\2\2^_\7g\2\2_\16\3\2\2\2`a\7=\2\2a\20\3\2\2\2bc\7<\2\2c\22\3\2\2"+
		"\2de\7>\2\2ef\7/\2\2f\24\3\2\2\2gh\7=\2\2h\26\3\2\2\2ij\7-\2\2j\30\3\2"+
		"\2\2kl\7/\2\2l\32\3\2\2\2mn\7#\2\2n\34\3\2\2\2op\7A\2\2p\36\3\2\2\2qr"+
		"\t\2\2\2r \3\2\2\2st\t\3\2\2t\"\3\2\2\2u\u0080\5\37\20\2v{\5\37\20\2w"+
		"|\5\37\20\2x|\5!\21\2y|\5\'\24\2z|\7a\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2"+
		"\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177u\3\2\2\2"+
		"\177v\3\2\2\2\u0080$\3\2\2\2\u0081\u0098\5!\21\2\u0082\u0087\5!\21\2\u0083"+
		"\u0088\5\37\20\2\u0084\u0088\5!\21\2\u0085\u0088\5\'\24\2\u0086\u0088"+
		"\7a\2\2\u0087\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u0098\3\2\2\2\u008b\u008c\7a\2\2\u008c\u0098\5!\21\2\u008d"+
		"\u008e\7a\2\2\u008e\u0093\5!\21\2\u008f\u0094\5\37\20\2\u0090\u0094\5"+
		"!\21\2\u0091\u0094\5\'\24\2\u0092\u0094\7a\2\2\u0093\u008f\3\2\2\2\u0093"+
		"\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0081\3\2\2\2\u0097\u0082\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u008d\3\2"+
		"\2\2\u0098&\3\2\2\2\u0099\u009b\t\4\2\2\u009a\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d(\3\2\2\2\u009e"+
		"\u00a1\t\5\2\2\u009f\u00a1\5G$\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2"+
		"\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a5\b\25\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7\60\2\2\u00a7"+
		",\3\2\2\2\u00a8\u00a9\5\'\24\2\u00a9\u00aa\7\60\2\2\u00aa\u00ab\5\'\24"+
		"\2\u00ab.\3\2\2\2\u00ac\u00ad\7*\2\2\u00ad\60\3\2\2\2\u00ae\u00af\7+\2"+
		"\2\u00af\62\3\2\2\2\u00b0\u00b1\7(\2\2\u00b1\u00b2\7(\2\2\u00b2\64\3\2"+
		"\2\2\u00b3\u00b4\7~\2\2\u00b4\u00b5\7~\2\2\u00b5\66\3\2\2\2\u00b6\u00b7"+
		"\7>\2\2\u00b78\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9\u00ba\7>\2\2\u00ba:\3"+
		"\2\2\2\u00bb\u00bc\7@\2\2\u00bc<\3\2\2\2\u00bd\u00be\7@\2\2\u00be\u00bf"+
		"\7?\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7\u0080\2\2\u00c1@\3\2\2\2\u00c2\u00c3"+
		"\7p\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7v\2\2\u00c5B\3\2\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7\u00c8\7?\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7^\2\2\u00ca\u00cb"+
		"\7?\2\2\u00cb\u00cc\7?\2\2\u00ccF\3\2\2\2\u00cd\u00d1\7%\2\2\u00ce\u00d0"+
		"\n\6\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2H\3\2\2\2\u00d3\u00d1\3\2\2\2\17\2{}\177\u0087\u0089"+
		"\u0093\u0095\u0097\u009c\u00a0\u00a2\u00d1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}