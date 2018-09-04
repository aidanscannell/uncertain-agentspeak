grammar UncertainAgentspeak;

/*
 * Lexer Rules
 */

CONTEXT                        : (':') ;
ACTIONS                        : ('<-') ;
ACTION_SEPERATOR               : (';') ;
ADD_EVENT_OPRTATOR             : ('+') ;
DELETE_EVENT_OPRTATOR          : ('-') ;
ACHIEVEMENT_GOAL_OPERATOR      : ('!') ;
TEST_GOAL_OPERATOR             : ('?') ;

fragment LOWERCASE                      : [a-z] ;
fragment UPPERCASE                      : [A-Z] ;

ATOM                : LOWERCASE | LOWERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;
VARIABLE                 : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r' | Comment)+ -> skip;

NEWLINE             : ('.') ;

DECIMAL             : NUMBER '.' NUMBER ;

LPAREN              : '(' ;
RPAREN              : ')' ;
AND                 : '&&' ;
OR                  : '||' ;
LESS_THAN           : '<' ;
LESS_EQUALS         : '=<' ;
GREATER_THAN        : '>' ;
GREATER_EQUALS      : '>=' ;
STRONG_NEGATION     : '~' ;
NEGATION_AS_FAILURE : 'not' ;
EQUALS              : '==' ;
NOT_EQUALS          : '\\==' ;

Comment             :  '#' ~( '\r' | '\n' )* ;

/*
 * AgentParser Rules
 */
uncertainAgentspeak     : init_bels init_goals plans EOF;

// Initial beliefs
init_bels               : (probabilistic_es | possibilistic_es )*;
//probabilistic_bel       : 'Prob(' '(' belief_literal ',' number ')' ')' | 'Prob(' '(' belief_literal ',' number ')'( ',' '(' belief_literal ',' number ')' )* ')' ;
//possibilistic_bel       : 'Pos(' '(' belief_literal ',' number ')' ')' | 'Pos(' '(' belief_literal ',' number ')'( ',' '(' belief_literal ',' number ')' )* ')' ;
probabilistic_es        : probabilistic_bel+ ;
possibilistic_es        : possibilistic_bel+ ;
probabilistic_bel       : '**(' belief_literal ',' number ')' '.' ;
possibilistic_bel       : '***(' belief_literal ',' number ')' '.';



// Initial goals
init_goals              : ( achievement_goal '.' )* ;


// Plans
plans                   : ( plan )* ;
plan                    : event CONTEXT context ACTIONS body '.' ;

// Event
//event                       : ( '+' | '-' ) ( '!' | '?' ) belief_literal ;
event                       : belief_event_trigger | goal_event_trigger | tautology;
belief_event_trigger        : '*(' belief_literal ',' term ')' ;
goal_event_trigger          : add_goal_event_trigger | delete_goal_event_trigger ;
add_goal_event_trigger      : ADD_EVENT_OPRTATOR goal ;
delete_goal_event_trigger   : DELETE_EVENT_OPRTATOR goal ;
goal                        : achievement_goal | test_goal ;
achievement_goal            : ACHIEVEMENT_GOAL_OPERATOR term ;
//test_goal                   : TEST_GOAL_OPERATOR term ;
test_goal                   : TEST_GOAL_OPERATOR and_expr ;
tautology                   : 'true' ;

// Plan Context
context                 : and_expr | tautology ;
log_expr                : and_expr ;

and_expr                : or_expr (AND or_expr)* ;
or_expr                 : less_than_expr (OR less_than_expr)* ;
less_than_expr          : less_equals_expr (LESS_THAN less_equals_expr)* ;
less_equals_expr        : greater_than_expr (LESS_EQUALS greater_than_expr)* ;
greater_than_expr       : greater_equals_expr (GREATER_THAN greater_equals_expr)* ;
greater_equals_expr     : equals_expr (GREATER_EQUALS equals_expr)* ;
equals_expr             : not_equals_expr (EQUALS not_equals_expr)* ;
not_equals_expr         : negation_expr (NOT_EQUALS negation_expr)* ;
negation_expr           : NEGATION_AS_FAILURE belief_atom_expr | STRONG_NEGATION belief_atom_expr | belief_atom_expr ;
//finally, we found either name, or a sub-expression
//belief_atom_expr        : belief_atom | LPAREN and_expr RPAREN | max_expr ;
belief_atom_expr        : belief_atom | LPAREN and_expr RPAREN ;



// Plan body
body                    : body_statement (';' body_statement)* | tautology ;
body_statement          : belief_action | goal | environment_action ;
belief_action           : '*(' belief_literal ',' term ')' ;
environment_action      : term ;
//body_statement          : '-+' term | '+' term | '-' term | '!' term | '?' term | term ;

// Beliefs
belief_literal          : positive_literal | negative_literal ;
positive_literal        : belief_atom ;
negative_literal        : STRONG_NEGATION belief_atom ;
belief_atom             : term ;

// Terms
term                    : constant | variable | structure ;
constant                : atom | number ;
atom                    : ATOM ;
number                  : intNum | doubleNum ;
intNum                  : NUMBER ;
doubleNum               : DECIMAL ;
variable                : VARIABLE ;
arguments_list          : term | term ( ',' term )+ ;
structure               : ATOM '(' arguments_list ')' ;