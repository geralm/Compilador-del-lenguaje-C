package CompiladorC;

import java.io.*;

%%
%public
%class LexerAnalyzer

digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r]
%type Token

%eofval{

    return new Token(TokenConstant.EOF, null);
    /*Hacer algo al final del archivo*/

%eofval}
%%

//IDENTIFICADORES
{letter}({letter}|{digit})* { return new Token(TokenConstant.ID, yytext()); }

//NÚMEROS
{digit}+ { RETURN new Token(TokenConstant.NUM, yytext()); }
[^] { return new Token(TokenConstant.ERROR, yytext()); }
