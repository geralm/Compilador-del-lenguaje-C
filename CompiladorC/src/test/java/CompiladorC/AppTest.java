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
        //String expresion = "int a = 0; ";
        String expresion = "int a = 0  int hola = 1; int prueba[2] = {1,2}; ";
        //String expresion = "int prueba(){switch(num){case 7: {printf(); break; default: {printf(\"hola\");break;}}}}";
        //String expresion = "i; int prueba(){if (a == b){int hola = 0; for(i = 0; i < 5; i++){}}else{} return 0;}"; //DEBERÍA FALLAR Y SEGUIR
        LexerCupAnalyzer lexer = new LexerCupAnalyzer(new StringReader(expresion));
        Parser p = new Parser(lexer);
        ControlParser controlParser = new ControlParser();
        p.setControlParser(controlParser);

        //Integer resultado = (Integer) p.parse().value;
        //System.out.println(resultado);
        try{
            p.parse();
        }catch (Exception e) {
            System.out.println("Error en el parser" );
        }
        controlParser.imprimirErrores();
        System.out.println("Funciona");

    }
}
