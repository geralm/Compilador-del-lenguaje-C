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

    /*return new Token(TokenConstant.EOF, null);*/
    /*Hacer algo al final del archivo*/

%eofval}
%%

//IDENTIFICADORES
{letter}({letter}|{digit})* { /* Hacer algo */}

//NÚMEROS
{digit}+ { /* Hacer algo más numéricamente*/ }
