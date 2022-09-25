
package CompiladorC;

import java.io.*;

%%
%public
%line //INICIA EL TRACKEO DE LAS LÍNEAS DEL ARCHIVO
%class LexerAnalyzer
/*
digit = [0-9]
octalInteger = 1[0-7]+
hexadecimalInteger = 1[xX][0-9A-Fa-f]+
letter = [A-Za-z]


//identifier = [A-Za-z][A-Za-z0-9]*
whitespace = [ \t\r]
*/

//ENTEROS
Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = 0[xX][0-9a-fA-F]+
Integer = ( {HexInt} | {OctalInt} | {DecInt} | {Zero} ) [1L]?

//FLOTANTES
Exponent = [eE] [\+\-]? [0-9]+
Float1 = [0-9]+ \. [0-9]+ {Exponent}?
Float2 = \. [0-9]+ {Exponent}?
Float3 = [0-9]+ \. {Exponent}?
Float4 = [0-9]+ {Exponent}
Float = ( {Float1} | {Float2} | {Float3} | {Float4} ) [fFdD]? |
[0-9]+ [fFDd]

//LITERALESS
Literal = ({Float} | {Integer} )

//IDENTIFICADORES
Identifier = [A-Za-z][A-Za-z0-9]*
%type Token
/*%eofval{

    return new Token(TokensConstants.EOF, null, 0);
    /*Hacer algo al final del archivo*/

%eofval}*/
%%

//PALABRAS RESERVADAS
//"" {return new Token(TokensConstants.,yytext());}}
<YYINITIAL> "auto" | "break" | "case" | "char" | "continue" | "default" | "do" | "double" |
    "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
    "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typefed" |
    "union" | "unsigned" | "void" | "volatile" | "while"
    { return new Token(TokensConstants.PALABRAS_RESERVADAS, yytext(), yyline); }

//OPERADORES

<YYINITIAL> "," | ";" | "++" | "--" | "==" | ">=" | ">" | "?" | "<=" | "<" | "!=" | "||" |
     "&&" | "!"  | "=" | "+" | "-" | "*" | "/" | "%" | "(" | ")" | "[" | "]" | "{" | "}" |
     ":" | "." | "+=" | "-=" | "*=" | "/=" | "&" | "^" | "|" | ">>" | "<<" | "~" | "%=" |
     "&=" | "^=" | "|=" | "<<=" | ">>=" | "->"
    { return new Token(TokensConstants.OPERADORES, yytext(), yyline); }

//LITERALES

/*
//HEXADECIMALES
{hexadecimalInteger} { return new Token(TokensConstants.LITERALES, yytext(), yyline);}

//OCTALES
{octalInteger} { return new Token(TokensConstants.LITERALES, yytext(), yyline);}

//ENTEROS
{digit}+ { return new Token(TokensConstants.LITERALES, yytext(), yyline); }
*/

{Literal} { return new Token(TokensConstants.LITERALES, yytext(), yyline); }

//IDENTIFICADORES
//{letter}({letter}|{digit})*

{Identifier} { return new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline); }

//ERRORES
[^] { return new Token(TokensConstants.ERROR, yytext(), yyline); }
