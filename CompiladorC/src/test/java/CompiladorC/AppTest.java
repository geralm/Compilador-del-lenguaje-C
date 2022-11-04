package CompiladorC;



import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void parserAnaylysis()throws Exception
    {
        String expresion = "2*4+6*3";
        LexerCupAnalyzer lexer = new LexerCupAnalyzer(new StringReader(expresion));
        Parser p = new Parser(lexer);
        Integer resultado = (Integer) p.parse().value;
        System.out.println(resultado);
    }
}
