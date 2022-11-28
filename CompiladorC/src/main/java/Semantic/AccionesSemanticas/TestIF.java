package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_IF;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class TestIF implements IAccionSemantica{

    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_DO rs_do = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
        //este debería ser el resultado de la expresión del if
        String elseLabel = RS_IF.elseLabel+String.valueOf(RS_IF.cantidadLabels)+":";
        Traductor.getInstance().addLine(elseLabel);
    }
}
