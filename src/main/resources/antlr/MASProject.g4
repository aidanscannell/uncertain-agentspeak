grammar MASProject;

/*
 * Lexer Rules
 */

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;

ATOM                : LOWERCASE | LOWERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;
CLASS_NAME          : UPPERCASE | UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ | '_' UPPERCASE | '_' UPPERCASE ( LOWERCASE | UPPERCASE | NUMBER | '_' )+ ;

NUMBER              : [0-9]+ ;

WHITESPACE          : (' ' | '\t' | '\n' | '\r' | COMMENT)+ -> skip;

NEWLINE             : (';') ;

COMMENT             :  '#' ~( '\r' | '\n' )* ;

STRING : '"' ~('\r' | '\n' | '"')* '"' ;

/*
 * AgentParser Rules
 */
mas_project     : 'MAS' name '{' content '}' EOF ;

name            : ATOM;

content         : infrastructure environment agents ;

infrastructure  : 'infrastructure:' centralised ;
centralised     : 'centralised' ;

environment     : 'environment:' 'env.' env_class_name '(' arguments_list ')' ;
env_class_name  : CLASS_NAME ;

agents          : 'agents:' agent+ ;
agent           : agent_name NEWLINE ;
agent_name      : ATOM ;


arguments_list  : arg | arg ( ',' arg )+ ;
arg             : NUMBER | STRING | 'true' | 'false' ;