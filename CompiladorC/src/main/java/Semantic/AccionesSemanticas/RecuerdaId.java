package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_ID;
import Semantic.RegistrosSemanticos.RS_TIPO;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class RecuerdaId implements IAccionSemantica {
    public RecuerdaId() {}

    @Override
    public void ejecutar(String token) {
        System.out.println("Token->"+token);
        RS_ID rs_tipo = (RS_ID) RS_Factory.create(rsType.ID);
        rs_tipo.setNombre(token);
        Traductor.getInstance().getPilaSemantica().push(rs_tipo);
    }
}

