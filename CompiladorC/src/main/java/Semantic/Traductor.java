package Semantic;

import Semantic.AccionesSemanticas.*;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.TablaSimbolos.Tabla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Traductor {
     public static  HashMap<AccionSemantica, IAccionSemantica> accionesSemanticas = new HashMap<>();
    private PilaSemantica pilaSemantica = new PilaSemantica();
    private LinkedList<ErrorSemantico> listaErrores = new LinkedList<>();

    private Tabla tablaDeSimbolos = new Tabla();

    private static Traductor instance = null;
    private Traductor() {}
    public static Traductor getInstance() {
        if (instance == null) {
            instance = new Traductor();
            init_acciones();
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



    private static void init_acciones(){
        accionesSemanticas.put(AccionSemantica.INSERTAR_TS, new InsertarTS());
        accionesSemanticas.put(AccionSemantica.RECUERDA_ID, new RecuerdaId());
        accionesSemanticas.put(AccionSemantica.RECUERDA_TIPO, new RecuerdaTipo());

    }
    public void reiniciar(){
         PilaSemantica pilaSemantica = new PilaSemantica();
         listaErrores.clear();
         tablaDeSimbolos = new Tabla();
    }

}
