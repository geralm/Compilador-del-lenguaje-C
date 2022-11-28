package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

import java.util.ArrayList;

public class Funcion extends TSSymbol {

    private ArrayList<Variable> locales = new ArrayList<>();
    private ArrayList<Variable> parametros = new ArrayList<>();

    public Funcion(String id, String type) {
        super(id, type);
    }
    public void addLocal(Variable local) throws ErrorSemantico {
        if(buscarVar(local)){
            locales.add(local);
        }
    }
    public void addParametro(Variable parametro) throws ErrorSemantico {
        if(buscarVar(parametro)){
            parametros.add(parametro);
        }
    }
    private boolean buscarVar(Variable var)throws ErrorSemantico{
        for (Variable local : locales) {
            if (local.getId().equals(var.getId())) {
                    throw new ErrorSemantico("Variable ya esta declarada dentro de la funcion", local);
            }
        }
        for (Variable parametro : parametros) {
            if (parametro.getId().equals(var.getId())) {
                throw new ErrorSemantico("Variable ya esta declarada dentro de los parámetros", parametro);
            }
        }
        return true;
    }
}

