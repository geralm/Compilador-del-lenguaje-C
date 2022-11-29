package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.Traductor;

public class Continue implements IAccionSemantica{
    @Override
    public void ejecutar(String token) {
        Traductor.getInstance().addLine("jmp "+ RS_WHILE.whileLabel+String.valueOf(RS_WHILE.cantidadLabels));
    }

}
