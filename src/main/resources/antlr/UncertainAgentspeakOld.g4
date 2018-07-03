grammar UncertainAgentspeak;

/*
 * Lexer Rules
 */

fragment CONTEXT                            : (':') ;
fragment CONJUNCTION                        : ('&') ;
fragment DISJUNCTION                        : ('||');
fragment ACTIONS                            : ('<-') ;
fragment ACTION_SEPERATOR                   : (';') ;
fragment ADD_EVENT_OPRTATOR                 : ('+') ;
fragment DELETE_EVENT_OPRTATOR              : ('-') ;
fragment ACHIEVEMENT_GOAL_OPERATOR          : ('!') ;
fragment TEST_GOAL_OPERATOR                 : ('?') ;
fragment STRONG_NEGATION                    : ('~') ;
fragment NEGATION_AS_FAILURE                : ('not');
fragment PLAUSIBILITY_GREATER_THAN          : ('>');
fragment PLAUSIBILITY_GREATER_EQUAL         : ('>=');
fragment EQUAL                              : ('==');
fragment NOT_EQUAL                          : ('\\=');
fragment TAUTOLOGY                          : ('true');
fragment CONTRADICTION                      : ('false');


fragment LOWERCASE                      : [a-z] ;
fragment UPPERCASE                      : [A-Z] ;

ATOM                : LOWERCASE | LOWERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;
VARIABLE            : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE             : ('.') ;


/*
 * Parser Rules
 */

uncertainAgentspeak          : ( plan | belief )* EOF ;

plan                : event (':' context '<-' body) '.' ;

belief              : arguments_list '.' ;

event               : '+' term | '-' term | '+!' term | '-!' term | '+?' term | '-?' term ;

//context             : 'true' | context_list ;
////context             : 'true' | arguments_list ;
//context_list        : term | term ( '&' term )+ ;

//context             : logical_expression ;


//logical_expression  : belief_atom | operator | relational_expression |terminal ;
//logical_expression  :     belief_atom
//                        | logical_expression '&' logical_expression
//                        | logical_expression '||' logical_expression
//                        | logical_expression '>' logical_expression
//                        | logical_expression '>=' logical_expression
//                        | logical_expression '==' logical_expression
//                        | logical_expression '\\=' logical_expression
//                        | negation
//                        | terminal ;

//logical_expression  :   logical_expression seperator logical_expression
//                      | negation
//                      | terminal ;
//
//seperator           : conjunction | disjunction | greater_than | greater_equals |  ;

context                 : log_expr | 'true' ;
log_expr                : simple_log_expr
                          | 'not' log_expr
                          | log_expr '&' log_expr
                          | log_expr '|' log_expr
                          | '(' log_expr ')' ;

simple_log_expr         : ( belief_literal | rel_expr | <VAR> ) ;

rel_expr                : rel_term ('<'|'<='|'>'|'>='|'=='|'\\=='|'=') rel_term ;
rel_term                : (belief_literal|arithm_expr) ;

arithm_expr             : arithm_term ( ( '+' | '-' ) arithm_expr ) ;
arithm_term             : arithm_factor ( ( '*' | '/' | 'div' | 'mod' ) arithm_term ) ;
arithm_factor           : arithm_simple ( '**' arithm_factor ) ;
arithm_simple           : <NUMBER> | <VAR> | '-' arithm_simple | '(' arithm_expr ')' ;

negation_as_failure     : 'not' log_expr ;

// seperators
//conjunction         : CONJUNCTION ;
//disjunction         : DISJUNCTION ;
//greater_than        : PLAUSIBILITY_GREATER_THAN ;
//greater_equals      : PLAUSIBILITY_GREATER_EQUAL ;

// logical expressions
belief_atom             : term ;

//operator                : negation | conjunction | disjunction | greater_than | greater_equals ;
//relational_expression   : equal | not_equal ;
terminal                : belief_literal | primitive ;

// operators
//negation            : strong_negation | negation_as_failure ;
//conjunction         : logical_expression CONJUNCTION logical_expression ;
//disjunction         : logical_expression DISJUNCTION logical_expression ;
//greater_than        : logical_expression PLAUSIBILITY_GREATER_THAN logical_expression ;
//greater_equals      : logical_expression PLAUSIBILITY_GREATER_EQUAL logical_expression ;

// negations
//strong_negation     : '~(' logical_expression ')' ;
//negation_as_failure : 'not(' logical_expression ')' ;

// relational expressions
//equal               : logical_expression EQUAL logical_expression;
//not_equal           : logical_expression NOT_EQUAL logical_expression;

// terminals
belief_literal      : positive_literal | negative_literal ;
primitive           : contradiction | tautology ;

// belief literals
positive_literal    : belief_atom ;
negative_literal    : '~' belief_atom ;

// primitives
contradiction       : 'false' ;
tautology           : 'true' ;



body                : 'true' | body_list ;

body_list           : body_statement (';' body_statement)* ;

body_statement      : '-+' term | '+' term | '-' term | '!' term | '?' term | term ;

arguments_list      : term | term ( ',' term )+ ;

term                : constant | variable | structure ;

goal                : '!' term | '?' term ;

constant            : ATOM | NUMBER ;

structure           : ATOM '(' arguments_list ')' ;

variable            : VARIABLE ;