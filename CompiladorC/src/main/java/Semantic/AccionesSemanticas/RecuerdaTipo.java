package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.PilaSemantica;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_TIPO;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class RecuerdaTipo implements IAccionSemantica{


    @Override
    public void ejecutar(Symbol token) {
        RS_TIPO rs_tipo = (RS_TIPO) RS_Factory.create(rsType.TIPO);
        rs_tipo.setTipo(token);
        Traductor.getInstance().getPilaSemantica().push(rs_tipo);
    }
}
