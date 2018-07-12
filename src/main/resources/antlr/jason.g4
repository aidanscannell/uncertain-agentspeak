grammar jason;

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
VAR                 : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE             : ('.') ;

/*
 * AgentParser Rules
 */

agent                   : ( init_bels | init_goals )* plans EOF;
init_bels               : beliefs rules ;
beliefs                 : ( literal '.' )* ;
rules                   : ( literal ':-' log_expr '.')* ;
init_goals              : ( '!' literal '.' )* ;
plans                   : ( plan )* ;
plan                    : ( '@' atomic_formula ) triggering_event ( ':' context ) ( '<-' body ) '.' ;
triggering_event        : ( '+' | '-' ) ( '!' | '?' ) literal ;
literal                 : ( '~' ) atomic_formula ;
context                 : log_expr | 'true' ;
log_expr                : simple_log_expr
                          | 'not' log_expr
                          | log_expr '&' log_expr
                          | log_expr '|' log_expr
                          | '(' log_expr ')' ;
simple_log_expr         : ( literal | rel_expr | <VAR> ) ;
body                    : body_formula ( ';' body_formula )* | 'true' ;
body_formula            : ( '!' | '?' | '+' | '-' | '-+' ) literal
                          | atomic_formula
                          | <VAR>
                          | rel_expr ;
atomic_formula          : ( <ATOM> | <VAR> ) ( '(' list_of_terms ')' ) ( '[' list_of_terms ']' ) ; ///////////////
list_of_terms           : term ( ',' term )* ;
term                    : literal
                          | list
                          | arithm_expr
                          | <VAR>
                          | <STRING> ;
list                    : '[' (term (',' term)* ('|' (list | <VAR>) )) ']' ;
rel_expr                : rel_term ('<'|'<='|'>'|'>='|'=='|'\\=='|'=') rel_term ;
rel_term                : (literal|arithm_expr) ;
arithm_expr             : arithm_term ( ( '+' | '-' ) arithm_expr ) ;
arithm_term             : arithm_factor ( ( '*' | '/' | 'div' | 'mod' ) arithm_term ) ;
arithm_factor           : arithm_simple ( '**' arithm_factor ) ;
arithm_simple           : <NUMBER> | <VAR> | '-' arithm_simple | '(' arithm_expr ')' ;
