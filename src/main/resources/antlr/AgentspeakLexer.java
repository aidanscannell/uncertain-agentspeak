// Generated from /Users/aidanscannell/Google Drive/Bristol PG/Academic/Research Project/uncertain-agentspeak/src/main/resources/antlr/Agentspeak.g4 by ANTLR 4.7
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
public class AgentspeakLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ATOM=19, VARIABLE=20, NUMBER=21, WHITESPACE=22, NEWLINE=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "CONTEXT", "CONJUNCTION", "ACTIONS", "ACTION_SEPERATOR", "ADD_EVENT_OPRTATOR", 
		"DELETE_EVENT_OPRTATOR", "ACHIEVEMENT_GOAL_OPERATOR", "TEST_GOAL_OPERATOR", 
		"NEGATION", "LOWERCASE", "UPPERCASE", "ATOM", "VARIABLE", "NUMBER", "WHITESPACE", 
		"NEWLINE"
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


	public AgentspeakLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Agentspeak.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\6\37\u0092\n\37\r\37\16\37\u0093\5\37\u0096\n\37\3 \3"+
		" \3 \3 \3 \3 \6 \u009e\n \r \16 \u009f\3 \3 \3 \3 \3 \3 \3 \3 \6 \u00aa"+
		"\n \r \16 \u00ab\5 \u00ae\n \3!\6!\u00b1\n!\r!\16!\u00b2\3\"\6\"\u00b6"+
		"\n\"\r\"\16\"\u00b7\3\"\3\"\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\2+\2-\2/\2"+
		"\61\2\63\2\65\2\67\29\2;\2=\25?\26A\27C\30E\31\3\2\6\3\2c|\3\2C\\\3\2"+
		"\62;\5\2\13\f\17\17\"\"\2\u00c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7L\3\2\2\2\tN\3"+
		"\2\2\2\13P\3\2\2\2\rR\3\2\2\2\17U\3\2\2\2\21X\3\2\2\2\23[\3\2\2\2\25^"+
		"\3\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35j\3\2\2\2\37l\3\2\2\2!"+
		"n\3\2\2\2#p\3\2\2\2%r\3\2\2\2\'t\3\2\2\2)v\3\2\2\2+x\3\2\2\2-{\3\2\2\2"+
		"/}\3\2\2\2\61\177\3\2\2\2\63\u0081\3\2\2\2\65\u0083\3\2\2\2\67\u0085\3"+
		"\2\2\29\u0087\3\2\2\2;\u0089\3\2\2\2=\u0095\3\2\2\2?\u00ad\3\2\2\2A\u00b0"+
		"\3\2\2\2C\u00b5\3\2\2\2E\u00bb\3\2\2\2GH\7<\2\2H\4\3\2\2\2IJ\7>\2\2JK"+
		"\7/\2\2K\6\3\2\2\2LM\7\60\2\2M\b\3\2\2\2NO\7-\2\2O\n\3\2\2\2PQ\7/\2\2"+
		"Q\f\3\2\2\2RS\7-\2\2ST\7#\2\2T\16\3\2\2\2UV\7/\2\2VW\7#\2\2W\20\3\2\2"+
		"\2XY\7-\2\2YZ\7A\2\2Z\22\3\2\2\2[\\\7/\2\2\\]\7A\2\2]\24\3\2\2\2^_\7v"+
		"\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2b\26\3\2\2\2cd\7(\2\2d\30\3\2\2\2ef\7="+
		"\2\2f\32\3\2\2\2gh\7/\2\2hi\7-\2\2i\34\3\2\2\2jk\7#\2\2k\36\3\2\2\2lm"+
		"\7A\2\2m \3\2\2\2no\7.\2\2o\"\3\2\2\2pq\7*\2\2q$\3\2\2\2rs\7+\2\2s&\3"+
		"\2\2\2tu\7<\2\2u(\3\2\2\2vw\7(\2\2w*\3\2\2\2xy\7>\2\2yz\7/\2\2z,\3\2\2"+
		"\2{|\7=\2\2|.\3\2\2\2}~\7-\2\2~\60\3\2\2\2\177\u0080\7/\2\2\u0080\62\3"+
		"\2\2\2\u0081\u0082\7#\2\2\u0082\64\3\2\2\2\u0083\u0084\7A\2\2\u0084\66"+
		"\3\2\2\2\u0085\u0086\7\u0080\2\2\u00868\3\2\2\2\u0087\u0088\t\2\2\2\u0088"+
		":\3\2\2\2\u0089\u008a\t\3\2\2\u008a<\3\2\2\2\u008b\u0096\59\35\2\u008c"+
		"\u0091\59\35\2\u008d\u0092\59\35\2\u008e\u0092\5;\36\2\u008f\u0092\5A"+
		"!\2\u0090\u0092\7a\2\2\u0091\u008d\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u008b\3\2\2\2\u0095\u008c\3\2"+
		"\2\2\u0096>\3\2\2\2\u0097\u00ae\5;\36\2\u0098\u009d\5;\36\2\u0099\u009e"+
		"\59\35\2\u009a\u009e\5;\36\2\u009b\u009e\5A!\2\u009c\u009e\7a\2\2\u009d"+
		"\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00ae\3\2\2\2\u00a1\u00a2\7a\2\2\u00a2\u00ae\5;\36\2\u00a3\u00a4\7a\2"+
		"\2\u00a4\u00a9\5;\36\2\u00a5\u00aa\59\35\2\u00a6\u00aa\5;\36\2\u00a7\u00aa"+
		"\5A!\2\u00a8\u00aa\7a\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u0097\3\2\2\2\u00ad"+
		"\u0098\3\2\2\2\u00ad\u00a1\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ae@\3\2\2\2"+
		"\u00af\u00b1\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3B\3\2\2\2\u00b4\u00b6\t\5\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\"\2\2\u00baD\3\2\2\2\u00bb\u00bc"+
		"\7\60\2\2\u00bcF\3\2\2\2\r\2\u0091\u0093\u0095\u009d\u009f\u00a9\u00ab"+
		"\u00ad\u00b2\u00b7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}