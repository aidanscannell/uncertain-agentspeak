grammar UncertainAgentspeak;

/*
 * Lexer Rules
 */

fragment CONTEXT                        : (':') ;
fragment CONJUNCTION                    : ('&') ;
fragment ACTIONS                        : ('<-') ;
fragment ACTION_SEPERATOR               : (';') ;
fragment ADD_EVENT_OPRTATOR             : ('+') ;
fragment DELETE_EVENT_OPRTATOR          : ('-') ;
fragment ACHIEVEMENT_GOAL_OPERATOR      : ('!') ;
fragment TEST_GOAL_OPERATOR             : ('?') ;
fragment NEGATION                       : ('~') ;

fragment LOWERCASE                      : [a-z] ;
fragment UPPERCASE                      : [A-Z] ;

ATOM                : LOWERCASE | LOWERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;
VARIABLE                 : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE             : ('.') ;

/*
 * Parser Rules
 */

/// /jason                   : ( init_bels | init_goals )* plans EOF;
//init_bels               : beliefs rules ;
//beliefs                 : ( literal '.' )* ;
//rules                   : ( literal ':-' log_expr '.')* ;
//init_goals              : ( '!' literal '.' )* ;
//uncertainAgentspeak2    : plans EOF;
uncertainAgentspeak     :  init_bels init_goals plans EOF;
init_bels               : belief*;
//rules                   : ( belief_literal ':-' log_expr '.')* ;
init_goals              : ( '!' belief_literal'.' )* ;

plans                   : ( plan )* ;
//plan                    : ( '@' atomic_formula ) triggering_event ( ':' context ) ( '<-' body ) '.' ;
//plan                    : triggering_event ':' context '<-' body '.' ;
//triggering_event        : ( '+' | '-' ) ( '!' | '?' ) belief_literal ;

plan                    : event (':' context '<-' body) '.' ;

belief                  : arguments_list '.' ;

//event               : '+' term | '-' term | '+!' term | '-!' term | '+?' term | '-?' term ;
event                   : ( '+' | '-' ) ( '!' | '?' ) belief_literal ;

//belief_literal          : ( '~' ) atomic_formula ;
belief_literal          : positive_literal | negative_literal ;
positive_literal        : belief_atom ;
negative_literal        : '~' belief_atom ;

context                 : log_expr | 'true' ;
log_expr                : simple_log_expr
                          | 'not' log_expr
                          | log_expr '&' log_expr
                          | log_expr '|' log_expr
                          | '(' log_expr ')' ;

simple_log_expr         : ( belief_literal | rel_expr | VARIABLE ) ;


//atomic_formula          : ( ATOM | VAR ) ( '(' list_of_terms ')' ) ( '[' list_of_terms ']' ) ; ///////////////
//atomic_formula          : ( ATOM | VARIABLE ) ( '(' list_of_terms ')' ) ; ///////////////

list_of_terms           : term ( ',' term )* ;
//term                    : belief_literal
//                          | list
//                          | arithm_expr
//                          | VAR ;
list                    : '[' (term (',' term)* ('|' (list | VARIABLE) )) ']' ;

rel_expr                : rel_term ('<'|'<='|'>'|'>='|'=='|'\\=='|'=') rel_term ;

rel_term                : (belief_literal|arithm_expr) ;

arithm_expr             : arithm_term ( ( '+' | '-' ) arithm_expr ) ;
arithm_term             : arithm_factor ( ( '*' | '/' | 'div' | 'mod' ) arithm_term ) ;
arithm_factor           : arithm_simple ( '**' arithm_factor ) ;
arithm_simple           : NUMBER | VARIABLE | '-' arithm_simple | '(' arithm_expr ')' ;


body           : body_statement (';' body_statement)* | 'true' ;
//
body_statement      : '-+' term | '+' term | '-' term | '!' term | '?' term | term ;

//body                    : body_formula ( ';' body_formula )* | 'true' ;
//
//body_formula            : ( '!' | '?' | '+' | '-' | '-+' ) belief_literal
//                          | atomic_formula
//                          | VAR
//                          | rel_expr ;

belief_atom         : term ;
arguments_list      : term | term ( ',' term )+ ;

term                : constant | variable | structure ;

//goal                : '!' term | '?' term ;

constant            : ATOM | NUMBER ;

structure           : ATOM '(' arguments_list ')' ;

variable            : VARIABLE ;