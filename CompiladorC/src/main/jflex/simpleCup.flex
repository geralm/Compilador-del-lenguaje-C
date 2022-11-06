
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

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%
//--------------------------------COMENTARIOS--------------------------------

{Comentarios} {System.out.println("Comentarios");}
//--------------------------------ESPACIOS EN BLANCO--------------------------------
{whitespace}+ {System.out.println("Espacio en blanco"); /*ignore*/}
{newline}+ {/*ignore*/}   //Ignorar saltos de linea
//--------------------------------OPERADORES--------------------------------
{Operadores} {System.out.println(symbol(ParserSym.OPERADOR, yytext()).toString());
          return symbol(ParserSym.OPERADOR, yytext()); }

//--------------------------------LITERALES--------------------------------
{Literal} {System.out.println(symbol(ParserSym.LITERAL, yytext()).toString());
          return symbol(ParserSym.LITERAL, yytext()); }

//--------------------------------ERRORES--------------------------------
<YYINITIAL> {Integer}+{Identificador} {Symbol errorSymb = symbol(ParserSym.error, yytext());
            System.out.println("Cadena ilegal <" + errorSymb.value + "> en la línea <" + errorSymb.right + ">");
            return errorSymb;}

//--------------------------------PALABRAS RESERVADAS--------------------------------

{Palabras_Reservadas} {System.out.println(symbol(ParserSym.PALABRA_RESERVADA, yytext()).toString());
          return symbol(ParserSym.PALABRA_RESERVADA, yytext());}

//--------------------------------IDENTIFICADORES--------------------------------
//Identificadores
{Identificadores} {System.out.println(symbol(ParserSym.IDENTIFICADOR, yytext()).toString());
          return symbol(ParserSym.IDENTIFICADOR, yytext()); }

//MACROS E IMPORTACIONES
<YYINITIAL> ^"#" ("include " ("<"{Identificador}".h>" | \"{Identificador}".h"\")| "define "{Identificador}" "({Literal} | {Operadores} | {whitespace})+)
    {System.out.println(symbol(ParserSym.IDENTIFICADOR, yytext()).toString());
          return symbol(ParserSym.IDENTIFICADOR, yytext()); }

//--------------------------------ERRORES--------------------------------
{Error} {Symbol errorSymb = symbol(ParserSym.error, yytext());
                     System.out.println("Cadena ilegal <" + errorSymb.value + "> en la línea <" + errorSymb.right + ">");
                     return errorSymb;}
