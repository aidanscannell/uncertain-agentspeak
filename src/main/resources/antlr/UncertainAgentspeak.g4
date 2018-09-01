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
init_bels               : (probabilistic_bel '.' | possibilistic_bel '.' | belief_atom '.')*;
probabilistic_bel       : 'Prob(' '(' belief_literal ',' number ')' ')' | 'Prob(' '(' belief_literal ',' number ')'( ',' '(' belief_literal ',' number ')' )* ')' ;
possibilistic_bel       : 'Pos(' '(' belief_literal ',' number ')' ')' | 'Pos(' '(' belief_literal ',' number ')'( ',' '(' belief_literal ',' number ')' )* ')' ;

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
test_goal                   : TEST_GOAL_OPERATOR term ;
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

//max_expr                : 'max(' belief_atom ')' ;

//log_expr                : simple_log_expr
//                          | negation_as_failure
//                          | log_expr '&' log_expr
//                          | log_expr '|' log_expr
//                          | '(' log_expr ')' ;
//negation_as_failure     : 'not' log_expr ;

//simple_log_expr         : belief_literal ;
//simple_log_expr         : ( belief_literal | rel_expr | variable ) ;

//rel_expr                : rel_term (less_than|less_equal|more_than|more_equal|equivalent|not_equal|equals) rel_term ;
//less_than               : '<' ;
//less_equal              : '<=' ;
//more_than               : '>' ;
//more_equal              : '>=' ;
//equivalent              : '==' ;
//not_equal               : '\\==' ;
//equals                  : '=' ;
//rel_term                : (belief_literal|arithm_expr) ;
//
//arithm_expr             : arithm_term ( ( '+' | '-' ) arithm_expr ) ;
//arithm_term             : arithm_factor ( ( '*' | '/' | 'div' | 'mod' ) arithm_term ) ;
//arithm_factor           : arithm_simple ( '**' arithm_factor ) ;
//arithm_simple           : NUMBER | VARIABLE | '-' arithm_simple | '(' arithm_expr ')' ;

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




/// /jason                   : ( init_bels | init_goals )* plans EOF;
//init_bels               : beliefs rules ;
//beliefs                 : ( literal '.' )* ;
//rules                   : ( literal ':-' log_expr '.')* ;
//init_goals              : ( '!' literal '.' )* ;
//uncertainAgentspeak2    : plans EOF;
//rules                   : ( belief_literal ':-' log_expr '.')* ;

//plan                    : ( '@' atomic_formula ) triggering_event ( ':' context ) ( '<-' body ) '.' ;
//plan                    : triggering_event ':' context '<-' body '.' ;
//triggering_event        : ( '+' | '-' ) ( '!' | '?' ) belief_literal ;

//belief                  : arguments_list '.' ;

//event               : '+' term | '-' term | '+!' term | '-!' term | '+?' term | '-?' term ;

//belief_literal          : ( '~' ) atomic_formula ;


//atomic_formula          : ( ATOM | VAR ) ( '(' list_of_terms ')' ) ( '[' list_of_terms ']' ) ; ///////////////
//atomic_formula          : ( ATOM | VARIABLE ) ( '(' list_of_terms ')' ) ; ///////////////

//term                    : belief_literal
//                          | list
//                          | arithm_expr
//                          | VAR ;

//body                    : body_formula ( ';' body_formula )* | 'true' ;
//
//body_formula            : ( '!' | '?' | '+' | '-' | '-+' ) belief_literal
//                          | atomic_formula
//                          | VAR
//                          | rel_expr ;






//log_expr
//    : VARIABLE          # variable
//    | '(' log_expr ')'      # braced_term
////    | '-'? integer      # integer_term //TODO: negative case should be covered by unary_operator
////    | '-'? FLOAT        # float
//    // structure / compound term
////    | atom '(' termlist ')'     # compound_term
//    |<assoc=right> log_expr operator log_expr        # binary_operator
//    | operator log_expr             # unary_operator
////    | '[' termlist ( '|' term )? ']' # list_term
////    | '{' termlist '}'          # curly_bracketed_term
////
////    | atom              # atom_term
//    ;

//operator                : strong_negation | negation_as_failure | conjunction | disjunction | greater_than | greater_equals ;

//binary_operator         : conjunction | disjunction | greater_than | greater_equals ;
//unary_operator          : strong_negation | negation_as_failure ;
//log_expr                : belief_literal # simple_log_expr
//                            | '~' log_expr # strong_negation
//                            | 'not' log_expr # negation_as_failure
//                            | log_expr '&' log_expr # conjunction
//                            | log_expr '|' log_expr # disjunction
//                            | '(' log_expr ')' # braced_term ;

//log_expr                : belief_literal
//                            | strong_negation log_expr
//                            | negation_as_failure log_expr
//                            | log_expr conjunction log_expr
//                            | log_expr disjunction log_expr
//                            | '(' log_expr ')' ;
//log_expr[int pr] : //( belief_atom | terminal )
//               ( {9 >= $pr}? (belief_atom | terminal)
//               | {8 >= $pr}? greater_equals  log_expr[9]
//               | {7 >= $pr}? greater_than log_expr[8]
//               | {6 >= $pr}? disjunction log_expr[7]
//               | {5 >= $pr}? conjunction log_expr[6]
//               | {4 >= $pr}? negation_as_failure  log_expr[5]
//               | {3 >= $pr}? strong_negation log_expr[4]
//               | {2 >= $pr}? '(' log_expr[0] ')'
//               )*
//             ;
//log_expr[int pr] : //( belief_atom | terminal )
//               ( {3 >= $pr}? (belief_atom | terminal)
//               | {4 >= $pr}? strong_negation log_expr[4]
//               | {4 >= $pr}? negation_as_failure  log_expr[4]
//               | {2 >= $pr}? greater_than log_expr[2]
//               | {2 >= $pr}? greater_equals  log_expr[2]
//               | {1 >= $pr}? conjunction log_expr[1]
//               | {1 >= $pr}? disjunction log_expr[1]
//               | {0 >= $pr}? '(' log_expr[0] ')'
//               )*
//             ;

//operator[int pr] : log_expr
////                    (log_expr[0])
//               ( {5 >= $pr}? (belief_atom | terminal) | operator[6]
//                //{5 >= $pr}?  (belief_atom | terminal)
//               | {4 >= $pr}? greater_than operator[5]
//               | {4 >= $pr}? greater_equals operator[5]
//               | {3 >= $pr}? conjunction operator[4]
//               | {3 >= $pr}? disjunction operator[4]
//               | {2 >= $pr}? '(' operator[0] ')'
//               )*
//             ;

//log_expr                : belief_atom
////                            | operator
//                            | relational_expression
//                            | terminal ;

//operator                : unary_operator | binary_operator ;
//unary_operator          : strong_negation | negation_as_failure ;
//binary_operator         : conjunction | disjunction | greater_than | greater_equals ;
//relational_expression   : equal | not_equal ;
//terminal                : belief_literal | primitive ;

//primitive               : tautology | contradiction ;

//contradiction           : 'false' ;

//greater_than            : '>' ;
//greater_equals          : '>=' ;
//equal                   : '=' ;
//not_equal               : '\\=' ;
//strong_negation         : '~' ;
//negation_as_failure     : 'not' ;
//conjunction             : '&' ;
//disjunction             : '|' ;