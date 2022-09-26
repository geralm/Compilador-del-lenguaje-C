
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

*/
//whitespace = [ \t\r]
//newLine =[\n]

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

//String
stringLit = \"[^\"]*\"

//Char
charLit = \'[^\']\'

//LITERALES
Literal = ({Float} | {Integer} | {stringLit} | {charLit})

//IDENTIFICADOR
Identificador = [A-Za-z][A-Za-z0-9]*
//DefMacro = <YYINITIAL> [^#]

Identificadores = ({Identificador})// | {DefMacro})

%type Token
%eofval{

    return new Token(TokensConstants.EOF, null, 0);
    /*Hacer algo al final del archivo*/

%eofval}
%%
//Espacios en blanco de cualquier tipo

//--------------------------------COMENTARIOS--------------------------------

"/*"~"*/" | "//"[^\r\n]* {System.out.println("Comentario encontrado");}


//--------------------------------PALABRAS RESERVADAS--------------------------------
//"" {return new Token(TokensConstants.,yytext());}}
<YYINITIAL> "auto" | "break" | "case" | "char" | "continue" | "default" | "do" | "double" |
    "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
    "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typefed" |
    "union" | "unsigned" | "void" | "volatile" | "while"
    { System.out.println(new Token(TokensConstants.PALABRA_RESERVADA, yytext(), yyline).toString());
          return new Token(TokensConstants.PALABRA_RESERVADA, yytext(), yyline); }
//espacios en blanco


//--------------------------------OPERADORES--------------------------------

<YYINITIAL> "," | ";" | "++" | "--" | "==" | ">=" | ">" | "?" | "<=" | "<" | "!=" | "||" |
     "&&" | "!"  | "=" | "+" | "-" | "*" | "/" | "%" | "(" | ")" | "[" | "]" | "{" | "}" |
     ":" | "." | "+=" | "-=" | "*=" | "/=" | "&" | "^" | "|" | ">>" | "<<" | "~" | "%=" |
     "&=" | "^=" | "|=" | "<<=" | ">>=" | "->"
    {System.out.println(new Token(TokensConstants.OPERADOR, yytext(), yyline).toString());
          return new Token(TokensConstants.OPERADOR, yytext(), yyline); }

//--------------------------------LITERALES--------------------------------

/*
//HEXADECIMALES
{hexadecimalInteger} { return new Token(TokensConstants.LITERALES, yytext(), yyline);}

//OCTALES
{octalInteger} { return new Token(TokensConstants.LITERALES, yytext(), yyline);}

//ENTEROS
{digit}+ { return new Token(TokensConstants.LITERALES, yytext(), yyline); }
*/

{Literal} {System.out.println(new Token(TokensConstants.LITERAL, yytext(), yyline).toString());
          return new Token(TokensConstants.LITERAL, yytext(), yyline); }

//--------------------------------IDENTIFICADORES--------------------------------
//{letter}({letter}|{digit})*

{Identificadores} | <<YYINITIAL> "S" {System.out.println(new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline).toString());
          return new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline); }

//--------------------------------ERRORES--------------------------------
[^] {System.out.println(new Token(TokensConstants.ERROR, yytext(), yyline).toString());
          return new Token(TokensConstants.ERROR, yytext(), yyline); }
