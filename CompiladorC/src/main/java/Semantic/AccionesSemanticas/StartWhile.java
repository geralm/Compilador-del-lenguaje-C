package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.RegistrosSemanticos.abstactRS;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;
import Semantic.*;

public class StartWhile implements IAccionSemantica{
    public StartWhile() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_WHILE rs_while = (RS_WHILE) RS_Factory.create(rsType.WHILE);
        Traductor.getInstance().addLine(RS_WHILE.whileLabel +String.valueOf(RS_WHILE.cantidadLabels)+":");
        Traductor.getInstance().getPilaSemantica().push(rs_while);
    }
}
