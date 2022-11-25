package CompiladorC;

import java_cup.runtime.Symbol;
//import java_cup.symbol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControlParser implements IControl <LexerCupAnalyzer>{
    private ArrayList<ParserError> listaErrores;
    private Parser parser;
    public ControlParser() {
        listaErrores = new ArrayList<>();
    }
    @Override
    public void limpiar() {
        listaErrores.clear();
    }
    public void addError(ParserError error){
        listaErrores.add(error);
    }

    @Override
    public void procesar(LexerCupAnalyzer lexer) {
        try {
            parser = new Parser(lexer);
            parser.setControlParser(this);
            Symbol s = parser.parse();
        } catch (Exception e) {
            System.out.println("Parseado incompleto");
            imprimirErrores();
        }

    }
    public void imprimirErrores(){
        for(ParserError error: listaErrores){
            System.out.println(error.getSimbolo().value+ " " + error.getLinea() + " " + error.getColumna() + " " + error.getDescripcion());
        }

    }

    @Override
    public DefaultTableModel construirModelo(JTable tabla) {
        DefaultTableModel modelErrores = (DefaultTableModel) tabla.getModel(); //crea un nuevo modelo
        modelErrores.setColumnIdentifiers(new String[]{"Inesperado", "Linea", "Mensage"}); //cambia los nombres de las columnas
        for(ParserError simboloError : listaErrores){
            modelErrores.addRow(new Object[]{simboloError.getSimbolo().value, simboloError.getLinea(), simboloError.getDescripcion()}); //agrega el token a la tabla
        }
        return modelErrores;
    }
}
