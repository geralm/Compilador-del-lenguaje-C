package Semantic.RegistrosSemanticos;


import Enums.rsType;
import java_cup.runtime.Symbol;

public class RS_DO extends abstactRS {
    private ETypoRs_Do tipo_RS_DO;
    private int direction;
    private String tipo_variable; // Tipo de dato que se va a guardar en la dirección

    public RS_DO(rsType type ) {
        super(type);
    }

    public void setDireccion(int resultado) {
        this.direction = resultado;
    }
    public void setTipoVariable(String tipo) {
        this.tipo_variable = tipo;
    }

    public ETypoRs_Do getTipo_RS_DO() {
        return tipo_RS_DO;
    }

    public void setTipo_RS_DO(ETypoRs_Do tipo_RS_DO) {
        this.tipo_RS_DO = tipo_RS_DO;
    }

    public int getDirection() {
        return direction;
    }

    public String getTipo_variable() {
        return tipo_variable;
    }

    public enum ETypoRs_Do {
        CONSTANTE, NO_CONSTANTE
    }
}
