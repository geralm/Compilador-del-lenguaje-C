package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

public class RS_OP extends abstactRS {
    public  final rsType type = rsType.OP;
    private Symbol operador;

    public RS_OP(rsType type) {
        super(type);
    }

    public Symbol getOperador() {
        return operador;
    }

    public void setOperador(Symbol operador) {
        this.operador = operador;
    }
}
