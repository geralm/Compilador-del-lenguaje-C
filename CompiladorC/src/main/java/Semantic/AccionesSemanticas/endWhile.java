package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.Traductor;

public class endWhile implements IAccionSemantica{
    @Override
    public void ejecutar(String token) {
        Traductor.getInstance().addLine("jmp "+RS_WHILE.whileLabel);
        Traductor.getInstance().addLine("endWhile"+String.valueOf(RS_WHILE.cantidadLabels)+":");
        RS_WHILE.cantidadLabels--;
        Traductor.getInstance().getPilaSemantica().pop();

    }

}

