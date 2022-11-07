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
        String expresion = "int i = 5, j[2] = {}, l[2],s ,a, s;\nint i = 5, j, l ,s ,a, s;";
        LexerCupAnalyzer lexer = new LexerCupAnalyzer(new StringReader(expresion));
        Parser p = new Parser(lexer);
        //Integer resultado = (Integer) p.parse().value;
        //System.out.println(resultado);
        try{
            p.parse();
            System.out.println("Funciona");
        }
        catch(Exception e){
            System.out.println("Falló");
        }
    }
}
