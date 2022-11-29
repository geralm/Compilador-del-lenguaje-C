package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class StartWhile implements IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_WHILE rs_while = (RS_WHILE) RS_Factory.create(rsType.WHILE); // Crea el registro semantico del while
        Traductor.getInstance().getPilaSemantica().push(rs_while);  // Lo agrega a la pila semantica

        // Genera en la traduccion el label del while
        String elseLabel = RS_WHILE.whileLabel + String.valueOf(RS_WHILE.cantidadLabels)+":";
        Traductor.getInstance().addLine(elseLabel);
    }
}
