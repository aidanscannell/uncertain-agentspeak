grammar Agentspeak;

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
VARIABLE            : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE             : ('.') ;


/*
 * AgentParser Rules
 */

agentspeak          : ( plan | belief )* EOF ;

plan                : event (':' context '<-' body) '.' ;

belief              : arguments_list '.' ;

event               : '+' term | '-' term | '+!' term | '-!' term | '+?' term | '-?' term ;

context             : 'true' | context_list ;
//context             : 'true' | arguments_list ;
context_list        : term | term ( '&' term )+ ;

body                : 'true' | body_list ;

body_list           : body_statement (';' body_statement)* ;

body_statement      : '-+' term | '+' term | '-' term | '!' term | '?' term | term ;

arguments_list      : term | term ( ',' term )+ ;

term                : constant | variable | structure ;

goal                : '!' term | '?' term ;

constant            : ATOM | NUMBER ;

structure           : ATOM '(' arguments_list ')' ;

variable            : VARIABLE ;