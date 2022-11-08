package CompiladorC;

import java_cup.runtime.Symbol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class ControlLexer implements IControl <String>{
    private ArrayList<Token> listaTokens;
    LexerAnalyzer demoLexer;
    public ControlLexer() {
        listaTokens = new ArrayList<>();
    }
    @Override
    public void limpiar() {
        listaTokens.clear();
    }
    @Override
    public void procesar(String cadena){
        demoLexer  = new LexerAnalyzer(new StringReader(cadena));
        try {
            Token token = demoLexer.yylex();
            while (token.getType() != TokensConstants.EOF) {
                if (token.getType() == TokensConstants.ERROR) {//si es un error léxico lo agrego a la lista de errores
                    listaTokens.add(token);
                    System.out.println("Error léxico: " + token.toString());
                }
                token = demoLexer.yylex();
                System.out.println(token.toString());
            }
        } catch (IOException ioException) {
            System.out.println("Error al leer el token por IOException");

        }
    }

    @Override
    public DefaultTableModel construirModelo(JTable tablaErroresLexicos) {
        DefaultTableModel modelErrores = (DefaultTableModel) tablaErroresLexicos.getModel(); //crea un nuevo modelo
        modelErrores.setColumnIdentifiers(new String[]{"Error", "Lexema", "Linea", "Cantidad"}); //cambia los nombres de las columnas
        for(Token unToken : listaTokens){
            if(unToken.getType().equals(TokensConstants.ERROR)){ //si es error
                int fila = lexemaInTable(tablaErroresLexicos,unToken.getLexema()); //busca si el lexema ya está en la tabla
                if(fila == -1){ //si no está en la tabla
                    modelErrores.addRow(new Object[]{unToken.getType(), unToken.getLexema(), agregarLineas(unToken), 1}); //agrega el token a la tabla
                }else{ //si está en la tabla
                    modelErrores.setValueAt((int)modelErrores.getValueAt(fila, 3)+1, fila, 3);
                }
            }
        }
        return modelErrores;
        //Aquí liimpiaba los tokens pero ya no pueedo limpiarlos porque los necesito para el parser
    }

    public String agregarLineas(Token unToken){
        ArrayList<String> lineas = new ArrayList<>();
        int cant = 0;
        int actLineNumber = unToken.getLineNumber();
        String linea = "";
        for (int i = 0; i < listaTokens.size(); i++){
            Token aToken = listaTokens.get(i);
            if (unToken.getLexema().equals(aToken.getLexema()) && actLineNumber == aToken.getLineNumber()){
                cant++;
            }
            else if(unToken.getLexema().equals(aToken.getLexema()) && actLineNumber != aToken.getLineNumber()){
                if (cant > 1){
                    lineas.add((actLineNumber + 1) + "(" + cant + ")");
                }
                else{
                    lineas.add(String.valueOf(actLineNumber + 1));
                }
                cant = 0;
                actLineNumber = aToken.getLineNumber();
                i--;
            }
        }
        if (cant > 1){
            lineas.add((actLineNumber + 1) + "(" + cant + ")");
        }
        else {
            lineas.add(String.valueOf(actLineNumber + 1));
        }
        for(int i = 0; i < lineas.size(); i++){
            if (i == lineas.size()-1){
                linea = linea.concat(lineas.get(i));
            }
            else{
                linea = linea.concat(lineas.get(i) + ", ");
            }
        }
        System.out.println("La linea generada es: " + linea);
        return linea;
    }
    private int lexemaInTable(JTable tabla, String lexema){
        /*Retorna la posición de la fila en la que se encuentra el lexemna si lo encuentra
        en caso de que no lo encuentra entonces retorna la última posición de la tabla*/
        for(int i = 0; i <tabla.getModel().getRowCount(); i++)
        {
            if(tabla.getModel().getValueAt(i, 1).equals(lexema))
            {
                return i; // encontrado y retorna la posición
            }
        }
        return -1; // no encontrado
    }
    public ArrayList<Token> getListaTokens() {
        return listaTokens;
    }




}
