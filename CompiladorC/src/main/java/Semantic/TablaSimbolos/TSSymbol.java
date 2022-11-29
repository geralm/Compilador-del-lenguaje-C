package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

public class TSSymbol {
    protected TipoTS tipoTS_symbol = TipoTS.ERROR;
    protected String id;
    protected String type;

    public TSSymbol(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public TipoTS getTipoTS_symbol() {
        return tipoTS_symbol;
    }

    public void setTipoTS_symbol(TipoTS tipoTS_symbol) {
        this.tipoTS_symbol = tipoTS_symbol;
    }
    public static TipoTS obtenerTipo(String str){
        switch (str){
            case "Variable":
                return TipoTS.VARIABLE;
            case "Funcion":
                return TipoTS.FUNCION;
            case "Parametro":
                return TipoTS.PARAMETRO;
            default:
                return TipoTS.VARIABLE;
        }
    }
    public static enum TipoTS{
        VARIABLE, FUNCION, PARAMETRO, ERROR
    }
}
