package Semantic.RegistrosSemanticos;


import Enums.rsType;
import java_cup.runtime.Symbol;

public class RS_DO extends abstactRS {
    private ETypoRs_Do tipo= ETypoRs_Do.CONSTANTE;//por defecto es constante

    private String valor; // Tipo de dato que se va a guardar en la dirección

    public RS_DO(rsType type ) {
        super(type);
    }

    public ETypoRs_Do getTipo() {
        return tipo;
    }

    public void setTipo(ETypoRs_Do tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public enum ETypoRs_Do {
        CONSTANTE, NO_CONSTANTE
    }
}
