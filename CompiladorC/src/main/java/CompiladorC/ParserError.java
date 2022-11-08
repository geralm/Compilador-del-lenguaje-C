package CompiladorC;

import java_cup.runtime.Symbol;

public class ParserError {
    private int linea;
    private int columna;
    private String descripcion;
    private Symbol simbolo;

    public ParserError(Symbol simbolo,int linea, int columna, String descripcion) {
        this.simbolo = simbolo;
        this.linea = linea;
        this.columna = columna;
        this.descripcion = descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Symbol getSimbolo() {
        return simbolo;
    }
}
