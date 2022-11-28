package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<TSSymbol> tabla = new ArrayList<>();
    public Tabla() {}
    public void insertar(TSSymbol simbolo) throws ErrorSemantico {
        tabla.add(simbolo);
    }
    public  boolean existe(TSSymbol id) throws ErrorSemantico {
        for (TSSymbol simbolo : tabla) {
            System.out.println("Comparo " + simbolo.getId()+ " con " + id.getId());
            if (simbolo.getId().equals(id.getId())) {
                throw new ErrorSemantico("Variable ya esta declarada", simbolo);
            }
        }
        return false;
    }
    public boolean existe(String id){
        for(TSSymbol simbolo : tabla){
            if(simbolo.getId().equals(id)){
                return true;
            }
        }
        return false;
    }


}
