package CompiladorC;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class DemoLexerTest {
    @Test
    public void matchId() throws IOException {
        String input = "?";
        Reader stringReader = new StringReader(input);
        LexerAnalyzer lexer = new LexerAnalyzer(stringReader);
        Token token = lexer.yylex();

    }
}
