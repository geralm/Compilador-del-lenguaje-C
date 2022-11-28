package CompiladorC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Control {
    public LexerGui screen;
    private ControlLexer controlLexer;
    private ControlParser controlParser;
    private ControlSemantic controlSemantic;
    //private ControlParser controlParser;
    //private ControlSemantic controlSemantic;

    public Control(LexerGui screen) {
        this.screen =screen;
        controlLexer = new ControlLexer();
        controlParser = new ControlParser();
        controlSemantic = new ControlSemantic();
    }

    public void limpiar() {
        //como si fuera el proxy de limpiar
        controlLexer.limpiar();
        //controlParser.limpiar();
        //controlSemantic.limpiar();
        screen.getTablaErroresLexicos().setModel(new DefaultTableModel(new Object[]{"Token", "Lexema", "Linea"}, 0));
        screen.getTableErroresSintacticos().setModel(new DefaultTableModel(new Object[]{"N/D", "N/D", "N/D"}, 0));
        //esto no limpia el text area
    }
    public void compilarTodo(String datos){
        //lexer
        screen.limpiarTabla(screen.getTablaErroresLexicos());
        screen.limpiarTabla(screen.getTableErroresSintacticos());
        tokenizar(datos);
        parsear(datos);
        traducir();
        //controlSemantic.procesar(datos);
        //colocarErroresSemanticos();
    }

    /*-----------------------------------------------------------------------------------------------------------------
    *                           LEXER - ANALIZADOR LEXICO
    * ----------------------------------------------------------------------------------------------------------------*/

    public void tokenizar(String datos){
        controlLexer.limpiar();//esto me evita que los errores se me acumulen en el arraylist
        screen.limpiarTabla(screen.getTablaErroresLexicos());
        controlLexer.procesar(datos);
        DefaultTableModel model = controlLexer.construirModelo(screen.getTablaErroresLexicos());
        screen.getTablaErroresLexicos().setModel(model);
    }
    /*-----------------------------------------------------------------------------------------------------------------
     *                               PARSER - ANALIZADOR SINTACTICO
     * ----------------------------------------------------------------------------------------------------------------*/


    public void parsear(String cadena){
        controlParser.limpiar();
        screen.limpiarTabla(screen.getTableErroresSintacticos());
        LexerCupAnalyzer lexerCupAnalyzer = new LexerCupAnalyzer(new StringReader(cadena));
        controlParser.procesar(lexerCupAnalyzer);
        DefaultTableModel modeloSintatico = controlParser.construirModelo(screen.getTableErroresSintacticos());
        screen.getTablaErroresSintacticos().setModel(modeloSintatico);
    }
    public void traducir(){
        controlSemantic.limpiar();
        DefaultTableModel modeloSemantico = controlParser.construirModelo(screen.getTableErroresSemanticos());
        screen.getTableErroresSemanticos().setModel(modeloSemantico);
    }
    /*-----------------------------------------------------------------------------------------------------------------
     *                               SEMANTIC - ANALIZADOR SEMANTICO
     * ----------------------------------------------------------------------------------------------------------------*/


    /* -----------------aquí terminar lo deL compilador*/
    //getter y setter
}
