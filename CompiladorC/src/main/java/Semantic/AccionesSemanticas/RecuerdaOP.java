package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_OP;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class RecuerdaOP implements IAccionSemantica{


    @Override
    public void ejecutar(Symbol token) {
        RS_OP rs_op = (RS_OP) RS_Factory.create(rsType.OP);
        rs_op.setOperador(token);
        Traductor.getInstance().getPilaSemantica().push(rs_op);
    }
}
