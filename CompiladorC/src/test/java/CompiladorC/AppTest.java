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
        //String expresion = "int prueba(){if (a == b){int hola = 0; for(i = 0; i < 5; i++){}}else{} return 0;}";
        //String expresion = "static int prueba(int i, long prueba[]){if (a == b){int hola = 0; while(i < 5){}}else{} return 0;}";
        String expresion = "int prueba(){switch(num){case 7: {printf(); break; default: {printf(\"hola\");break;}}}}";
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
