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
    //private ControlSemantic controlSemantic;

    public Control(LexerGui screen) {
        this.screen =screen;
        controlLexer = new ControlLexer();
        controlParser = new ControlParser();

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
        controlLexer.procesar(datos);
        DefaultTableModel modeloLexico = controlLexer.construirModelo(screen.getTablaErroresLexicos());

        //controlParser.procesar(datos);
        //colocarErroresSintacticos();
        //controlSemantic.procesar(datos);
        //colocarErroresSemanticos();
    }

    /*-----------------------------------------------------------------------------------------------------------------
    *                           LEXER - ANALIZADOR LEXICO
    * ----------------------------------------------------------------------------------------------------------------*/

    public void tokenizar(String datos){
        controlLexer.limpiar();//esto me evita que los errores se me acumulen en el arraylist
        controlLexer.procesar(datos);
        DefaultTableModel model = controlLexer.construirModelo(screen.getTablaErroresLexicos());
        screen.getTablaErroresLexicos().setModel(model);
    }
    /*-----------------------------------------------------------------------------------------------------------------
     *                               PARSER - ANALIZADOR SINTACTICO
     * ----------------------------------------------------------------------------------------------------------------*/


    public void parsear(){
        //controlParser.procesar(controlLexer.getListaTokens());
        //colocarErroresSintacticos();
    }
    /*-----------------------------------------------------------------------------------------------------------------
     *                               SEMANTIC - ANALIZADOR SEMANTICO
     * ----------------------------------------------------------------------------------------------------------------*/


    /* -----------------aquí terminar lo deL compilador*/
    //getter y setter
}
