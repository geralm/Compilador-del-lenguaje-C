package Semantic;

import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.TablaSimbolos.Tabla;

import java.util.ArrayList;
import java.util.LinkedList;

public class Traductor {
    private PilaSemantica pilaSemantica = new PilaSemantica();
    private LinkedList<ErrorSemantico> listaErrores = new LinkedList<>();

    private Tabla tablaDeSimbolos = new Tabla();

    private static Traductor instance = null;
    private Traductor() {}
    public static Traductor getInstance() {
        if (instance == null) {
            instance = new Traductor();
        }
        return instance;
    }

    public PilaSemantica getPilaSemantica() {
        return pilaSemantica;
    }

    public LinkedList<ErrorSemantico> getListaErrores() {
        return listaErrores;
    }

    public Tabla getTablaDeSimbolos() {
        return tablaDeSimbolos;
    }
    public void addError(ErrorSemantico error){
        listaErrores.add(error);
    }

}
