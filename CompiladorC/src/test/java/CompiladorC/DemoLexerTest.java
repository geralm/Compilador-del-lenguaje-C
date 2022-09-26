package CompiladorC;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoLexerTest {
    @Test
    // System.out.println(new Token(TokensConstants.LITERALES, yytext(), yyline).toString());
    public void noMatch() throws IOException {
        String input = "#include \"hola.h\"";
        Reader stringReader = new StringReader(input);
        LexerAnalyzer lexer = new LexerAnalyzer(stringReader);
        Token token = lexer.yylex();
        assertEquals(TokensConstants.IDENTIFICADOR, token.getType());
    }
}
