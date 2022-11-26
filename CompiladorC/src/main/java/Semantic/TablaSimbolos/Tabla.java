package Semantic.TablaSimbolos;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<TSSymbol> tabla = new ArrayList<>();
    public Tabla() {}
    public void insertar(TSSymbol simbolo) throws ErrorSemantico {
        if(!existe(simbolo)){
            tabla.add(simbolo);
        }
    }
    private boolean existe(TSSymbol id) throws ErrorSemantico {
        for (TSSymbol simbolo : tabla) {
            if (simbolo.getId().equals(id)) {
                throw new ErrorSemantico("Variable ya esta declarada", simbolo);
            }
        }
        return false;
    }



}
