package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_IF;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class StartIF implements IAccionSemantica {
    public StartIF() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_IF rs_if = (RS_IF) RS_Factory.create(rsType.IF);
        Traductor.getInstance().getPilaSemantica().push(rs_if);
    }
}
