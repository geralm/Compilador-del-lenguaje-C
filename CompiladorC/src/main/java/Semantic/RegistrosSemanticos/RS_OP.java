package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

public class RS_OP extends abstactRS {
    public  final rsType type = rsType.OP;
    private String operador;

    public RS_OP(rsType type) {
        super(type);
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
