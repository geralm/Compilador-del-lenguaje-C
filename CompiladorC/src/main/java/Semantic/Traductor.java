package Semantic;

import Semantic.AccionesSemanticas.*;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.TablaSimbolos.TSSymbol;
import Semantic.TablaSimbolos.Tabla;
import Semantic.TablaSimbolos.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static Semantic.AccionesSemanticas.AccionSemantica.END_IF;

public class Traductor {
     public static  HashMap<AccionSemantica, IAccionSemantica> accionesSemanticas = new HashMap<>();
    private PilaSemantica pilaSemantica = new PilaSemantica();
    private LinkedList<ErrorSemantico> listaErrores = new LinkedList<>();

    private Tabla tablaDeSimbolos = new Tabla();
    private String texto_ensamblador = ".DATA";

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
        accionesSemanticas.put(AccionSemantica.START_IF, new StartIF());
        accionesSemanticas.put(AccionSemantica.START_ELSE, new StartElse());
        accionesSemanticas.put(AccionSemantica.TEST_IF, new TestIF());
        accionesSemanticas.put(AccionSemantica.END_IF, new End_IF());
        accionesSemanticas.put(AccionSemantica.EVAL_BINARY, new EvalBinary());
        accionesSemanticas.put(AccionSemantica.RECUERDA_CONSTANTE, new RecuerdaConstante());
        accionesSemanticas.put(AccionSemantica.RECUERDA_VARIABLE, new RecuerdaVariable());
        accionesSemanticas.put(AccionSemantica.RECUERDA_OP, new RecuerdaOP());
        accionesSemanticas.put(AccionSemantica.START_WHILE, new StartWhile());
        accionesSemanticas.put(AccionSemantica.TEST_WHILE, new testWhile());
        accionesSemanticas.put(AccionSemantica.END_WHILE, new endWhile());


    }
    public void reiniciar(){
         PilaSemantica pilaSemantica = new PilaSemantica();
         listaErrores.clear();
         tablaDeSimbolos = new Tabla();
         texto_ensamblador ="";
    }
    public String reservarMemoria(String typo){
        switch(typo){
            case "int":
                return "resd 1";
            case "char":
                return "resb 1";
            case "float":
                return "resb 1";
            default:
                return "";
        }
    }
    public int memoriaReservada(String typo){
        switch(typo){
            case "int":
                return 4 ;
            case "char":
                return 1;
            case "float":
                return 4;
            default:
                return 0;
        }
    }
    public String bytesToAsm(int b){
        switch(b){
            case 1:
                return "resb";
            case 2:
                return "resb";
            case 4:
                return "dword";
            default:
                return "";
        }

    }
    public String traducir(){
        String data = ".DATA\n";
        String udata = ".UDATA\n";
        String code = ".CODE\n.STARTUP\n";
        String undefinedVar = "";
        for(TSSymbol symbol: tablaDeSimbolos.getTabla()){
            if(symbol instanceof Variable){
                undefinedVar=undefinedVar+"\t"+symbol.getId()+" "+bytesToAsm(memoriaReservada(symbol.getType()))+" 1\n";
            }
        }
        String finalStr = data+udata+undefinedVar+code;
        return finalStr+texto_ensamblador+"\n.EXIT";

    }
    public String getTexto_ensamblador() {
        return texto_ensamblador;
    }
    public void addLine(String a){
        texto_ensamblador = texto_ensamblador+a+"\n"; //salto de línea
    }

    public static String direccionMemoria(String a ){
        String dir = "0x00000000";
        String hex = Integer.toHexString(a.hashCode());
        String res = dir.substring(0,dir.length()-hex.length())+hex;
        return res;
    }
    public static int StringHexToInt(String a){
        a = a.replace("x","");
        a = a.replace("0", "");
        return Integer.parseInt(a,16);
    }
}
