package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<TSSymbol> tabla = new ArrayList<>();
    public Tabla() {}
    public void insertar(TSSymbol simbolo) throws ErrorSemantico {
        if(!existe(simbolo)){
            tabla.add(simbolo);
        }
    }
    public  boolean existe(TSSymbol id) throws ErrorSemantico {
        for (TSSymbol simbolo : tabla) {
            System.out.println("Comparo " + simbolo.getId().value + " con " + id.getId().value);
            if (simbolo.getId().equals(id.getId())) {
                throw new ErrorSemantico("Variable ya esta declarada", simbolo);
            }
        }
        return false;
    }
    public boolean existe(Symbol id){
        for(TSSymbol simbolo : tabla){
            if(simbolo.getId().value.equals(id.value)){
                return true;
            }
        }
        return false;
    }


}
