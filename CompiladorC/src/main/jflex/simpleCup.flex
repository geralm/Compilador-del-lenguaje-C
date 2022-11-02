
package CompiladorC;

import java_cup.runtime.*;

%%
%public
%line
%class LexerCupAnalyzer
%cup

whitespace = [ \t\r]
newline =[\n]

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
Float = ( {Float1} | {Float2} | {Float3} | {Float4} ) [fFdD]? | [0-9]+ [fFDd]

//String
stringLit = \"[^\"]*\"

//Char
charLit = \'[^\']\'

//LITERALES
Literal = ({Float} | {Integer} | {stringLit} | {charLit})

//IDENTIFICADOR
Identificador = [_A-Za-z][_A-Za-z0-9]*
//DefMacro = <YYINITIAL> [^#]

Identificadores = ({Identificador})// | {DefMacro})

//PALABRAS PALABRA_RESERVADA
Palabras_Reservadas = ("auto" | "break" | "case" | "char" | "continue" | "default" | "do" | "double" |
                          "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
                          "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typedef" |
                          "union" | "unsigned" | "void" | "volatile" | "while")

//OPERADORES
Operadores = ("," | ";" | "++" | "--" | "==" | ">=" | ">" | "?" | "<=" | "<" | "!=" | "||" |
                "&&" | "!"  | "=" | "+" | "-" | "*" | "/" | "%" | "(" | ")" | "[" | "]" | "{" | "}" |
                ":" | "." | "+=" | "-=" | "*=" | "/=" | "&" | "^" | "|" | ">>" | "<<" | "~" | "%=" |
                "&=" | "^=" | "|=" | "<<=" | ">>=" | "->")

//COMENTARIOS
Comentarios = ("/*"~"*/" | "//"[^\r\n]*)

//ERRORES
Error = [^]

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
            return new Symbol(type, yyline, yycolumn, value);
    }
%}

%type Token
%eofval{

    return new symbol(ParserSym.EOF);
    /*Hacer algo al final del archivo*/

%eofval}
%%

//--------------------------------COMENTARIOS--------------------------------

{Comentarios} {System.out.println("Comentarios");}
//--------------------------------ESPACIOS EN BLANCO--------------------------------
{whitespace}+ {System.out.println("Espacio en blanco"); /*ignore*/}
{newline}+ {/*ignore*/}   //Ignorar saltos de linea
//--------------------------------OPERADORES--------------------------------
{Operadores} {System.out.println(new Token(TokensConstants.OPERADOR, yytext(), yyline).toString());
          return new Token(TokensConstants.OPERADOR, yytext(), yyline); }

//--------------------------------LITERALES--------------------------------
{Literal} {System.out.println(new Token(TokensConstants.LITERAL, yytext(), yyline).toString());
          return new Token(TokensConstants.LITERAL, yytext(), yyline); }

//--------------------------------ERRORES--------------------------------
<YYINITIAL> {Integer}+{Identificador} {System.out.println(new Token(TokensConstants.ERROR, yytext(), yyline).toString());
          return new Token(TokensConstants.ERROR, yytext(), yyline); }

{Palabras_Reservadas} {System.out.println("Palabras reservadas");return new Token(TokensConstants.PALABRA_RESERVADA,yytext(), yyline);}

//--------------------------------IDENTIFICADORES--------------------------------
//Identificadores
{Identificadores} {System.out.println(new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline).toString());
          return new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline); }

//MACROS E IMPORTACIONES
<YYINITIAL> ^"#" ("include " ("<"{Identificador}".h>" | \"{Identificador}".h"\")| "define "{Identificador}" "({Literal} | {Operadores} | {whitespace})+)
    {System.out.println(new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline).toString());
          return new Token(TokensConstants.IDENTIFICADOR, yytext(), yyline); }

//--------------------------------ERRORES--------------------------------
{Error} {System.out.println(new Token(TokensConstants.ERROR, yytext(), yyline).toString());
          return new Token(TokensConstants.ERROR, yytext(), yyline); }
