
package CompiladorC;

import java_cup.runtime.*;

%%
%public
%line
%full
%char
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
{Operadores} {
            System.out.println(symbol(ParserSym.OPERADOR, yytext()).toString());
            switch (yytext()){
                case "+":
                    return symbol(ParserSym.Mas, yytext());
                case "-":
                    return symbol(ParserSym.Menos, yytext());
                case "*":
                    return symbol(ParserSym.Multiplicacion, yytext());
                case "/":
                    return symbol(ParserSym.Division, yytext());
                case "--":
                  return symbol(ParserSym.Decremento, yytext());
                case "++":
                    return symbol(ParserSym.Incremento, yytext());
                case "=":
                    return symbol(ParserSym.Igual, yytext());
                case "==":
                    return symbol(ParserSym.DobleIgual, yytext());
                case ">=":
                    return symbol(ParserSym.MayorIgual, yytext());
                case ">":
                    return  symbol(ParserSym.Mayor, yytext());
                case "<=":
                    return symbol(ParserSym.MenorIgual, yytext());
                case "<":
                    return symbol(ParserSym.Menor, yytext());
                case "!=":
                    return symbol(ParserSym.Diferente, yytext());
                case "||":
                    return symbol(ParserSym.OrDoble, yytext());
                case "&&":
                    return symbol(ParserSym.AndDoble, yytext());
                case "!":
                    return symbol(ParserSym.Not, yytext());
                case ",":
                    return symbol(ParserSym.Coma, yytext());
                case ";":
                    return symbol(ParserSym.PuntoComa, yytext());
                case "(":
                    return symbol(ParserSym.ParentesisIzq, yytext());
                case ")":
                    return symbol(ParserSym.ParentesisDer, yytext());
                case "[":
                    return symbol(ParserSym.CorcheteIzq, yytext());
                case "]":
                    return symbol(ParserSym.CorcheteDer, yytext());
                case "{":
                    return symbol(ParserSym.LlaveIzq, yytext());
                case "}":
                    return symbol(ParserSym.LlaveDer, yytext());
                case ":":
                    return symbol(ParserSym.DosPuntos, yytext());
                case ".":
                    return symbol(ParserSym.Punto, yytext());
                case "+=":
                    return symbol(ParserSym.SumaAsignacion, yytext());
                case "-=":
                    return symbol(ParserSym.RestaAsignacion, yytext());
                case "*=":
                    return symbol(ParserSym.MultiplicacionAsignacion, yytext());
                case "/=":
                    return symbol(ParserSym.DivisionAsignacion, yytext());
                case "?":
                    return symbol(ParserSym.SignoPregunta, yytext());
                case "&":
                    return symbol(ParserSym.And, yytext());
                case "^":
                    return symbol(ParserSym.Circunflejo, yytext());
                case "%":
                    return symbol(ParserSym.Porcentaje, yytext());
                case "|":
                    return symbol(ParserSym.Or, yytext());
                case ">>":
                    return symbol(ParserSym.DesplazamientoDerecha, yytext());
                case "<<":
                    return symbol(ParserSym.DesplazamientoIzquierda, yytext());
                case "~":
                    return symbol(ParserSym.Tilde, yytext());
                case "%=":
                    return symbol(ParserSym.PorcentajeAsignacion, yytext());
                case "&=":
                    return symbol(ParserSym.AndAsignacion, yytext());
                case "^=":
                    return symbol(ParserSym.CircunflejoAsignacion, yytext());
                case "|=":
                    return symbol(ParserSym.OrAsignacion, yytext());
                case "<<=":
                    return symbol(ParserSym.DesplazamientoIzquierdaAsignacion, yytext());
                case ">>=":
                    return symbol(ParserSym.DesplazamientoDerechaAsignacion, yytext());
                case "->":
                    return symbol(ParserSym.Flecha, yytext());
          }
      }

//--------------------------------LITERALES--------------------------------
{Literal} {System.out.println(symbol(ParserSym.LITERAL, yytext()).toString());
          return symbol(ParserSym.LITERAL, yytext());
      }

//--------------------------------ERRORES--------------------------------
<YYINITIAL> {Integer}+{Identificador} {Symbol errorSymb = symbol(ParserSym.error, yytext());
            System.out.println("Cadena ilegal <" + errorSymb.value + "> en la línea <" + errorSymb.right + ">");
            return errorSymb;}

//--------------------------------PALABRAS RESERVADAS--------------------------------

{Palabras_Reservadas} {System.out.println(symbol(ParserSym.PALABRA_RESERVADA, yytext()).toString());
         /* "auto" | "break" | "case" | "char" | "continue" | "default" | "do" | "double" |
                                    "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
                                    "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typedef" |
                                    "union" | "unsigned" | "void" | "volatile" | "while"*/
        switch (yytext().toString()){
            case "auto":
                return symbol(ParserSym.Auto, yytext());
            case "break":
                return symbol(ParserSym.Break, yytext());
            case "case":
              return symbol(ParserSym.Case, yytext());
            case "char":
                return symbol(ParserSym.Char, yytext());
            case "const":
                return symbol(ParserSym.Const, yytext());
            case "continue":
                return symbol(ParserSym.Continue, yytext());
            case "default":
                return symbol(ParserSym.Default, yytext());
            case "do":
                return symbol(ParserSym.Do, yytext());
            case "double":
                return symbol(ParserSym.Double, yytext());
            case "else":
              return symbol(ParserSym.Else, yytext());
            case "enum":
                return symbol(ParserSym.Enum, yytext());
            case "extern":
                return symbol(ParserSym.Extern, yytext());
            case "float":
                return symbol(ParserSym.Float, yytext());
            case "for":
                return symbol(ParserSym.For, yytext());
            case "goto":
                return symbol(ParserSym.Goto, yytext());
            case "if":
              return symbol(ParserSym.If, yytext());
            case "int":
                return symbol(ParserSym.Int, yytext());
            case "long":
                return symbol(ParserSym.Long, yytext());
            case "register":
                return symbol(ParserSym.Register, yytext());
            case "return":
                return symbol(ParserSym.Return, yytext());
            case "short":
                return symbol(ParserSym.Short, yytext());
            case "signed":
              return symbol(ParserSym.Signed, yytext());
            case "sizeof":
                return symbol(ParserSym.Sizeof, yytext());
            case "static":
                return symbol(ParserSym.Static, yytext());
            case "struct":
                return symbol(ParserSym.Struct, yytext());
            case "switch":
                return symbol(ParserSym.Switch, yytext());
            case "typedef":
                return symbol(ParserSym.Typedef, yytext());
            case "union":
                return symbol(ParserSym.Union, yytext());
            case "unsigned":
                return symbol(ParserSym.Unsigned, yytext());
            case "void":
                return symbol(ParserSym.Void, yytext());
            case "volatile":
                return symbol(ParserSym.Volatile, yytext());
            case "while":
                return symbol(ParserSym.While, yytext());
        }
  }

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
