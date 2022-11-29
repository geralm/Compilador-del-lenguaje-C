package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.Traductor;

public class Break implements IAccionSemantica{
    @Override
    public void ejecutar(String token) {
        Traductor.getInstance().addLine("jmp "+ RS_WHILE.endWhileLabel+String.valueOf(RS_WHILE.cantidadLabels));
    }
}
