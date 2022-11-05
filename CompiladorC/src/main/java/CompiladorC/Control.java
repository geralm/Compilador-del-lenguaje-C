package CompiladorC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Control implements IControl <String>{
    public LexerGui screen;
    private ControlLexer controlLexer;
    private ControlParser controlParser;
    //private ControlSemantic controlSemantic;

    public Control(LexerGui screen) {
        this.screen =screen;
        controlLexer = new ControlLexer();
        controlParser = new ControlParser();

    }
    @Override
    public void limpiar() {
        //como si fuera el proxy de limpiar
        controlLexer.limpiar();
        controlParser.limpiar();
        //controlSemantic.limpiar();
        screen.getTablaErroresLexicos().setModel(new DefaultTableModel(new Object[]{"Token", "Lexema", "Linea"}, 0));
        screen.getTableErroresSintacticos().setModel(new DefaultTableModel(new Object[]{"N/D", "N/D", "N/D"}, 0));
        //esto no limpia el text area
    }
    @Override
    public void procesar(String datos){
        controlLexer.procesar(datos);
        colocarErroresLexicos();
        //controlParser.procesar(datos);
        //colocarErroresSintacticos();
        //controlSemantic.procesar(datos);
        //colocarErroresSemanticos();
    }

    /*-----------------------------------------------------------------------------------------------------------------
    *                           LEXER - ANALIZADOR LEXICO
    * ----------------------------------------------------------------------------------------------------------------*/
    private int lexemaInTable(String lexema){
        /*Retorna la posición de la fila en la que se encuentra el lexemna si lo encuentra
        en caso de que no lo encuentra entonces retorna la última posición de la tabla*/
        for(int i = 0; i <this.screen.getTablaErroresLexicos().getModel().getRowCount(); i++)
        {
            if(this.screen.getTablaErroresLexicos().getModel().getValueAt(i, 1).equals(lexema))
            {
                return i; // encontrado y retorna la posición
            }
        }
        return -1; // no encontrado
    }
    public void colocarErroresLexicos(){
        this.screen.limpiarTabla(this.screen.getTablaErroresLexicos()); //limpio la tabla sin borrar el texto en el textArea
        DefaultTableModel modelErrores = (DefaultTableModel) this.screen.getTablaErroresLexicos().getModel(); //crea un nuevo modelo
        modelErrores.setColumnIdentifiers(new String[]{"Error", "Lexema", "Linea", "Cantidad"}); //cambia los nombres de las columnas
        for(Token unToken : controlLexer.getListaTokens()){
            if(unToken.getType().equals(TokensConstants.ERROR)){ //si es error
                int fila = lexemaInTable(unToken.getLexema()); //busca si el lexema ya está en la tabla
                if(fila == -1){ //si no está en la tabla
                    modelErrores.addRow(new Object[]{unToken.getType(), unToken.getLexema(), controlLexer.agregarLineas(unToken), 1}); //agrega el token a la tabla
                }else{ //si está en la tabla
                    modelErrores.setValueAt((int)modelErrores.getValueAt(fila, 3)+1, fila, 3);
                }
            }
        }
        this.screen.getTablaErroresLexicos().setModel (modelErrores);
        //Aquí liimpiaba los tokens pero ya no pueedo limpiarlos porque los necesito para el parser
    }
    public void tokenizar(String datos){
        controlLexer.procesar(datos);
        colocarErroresLexicos();
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
