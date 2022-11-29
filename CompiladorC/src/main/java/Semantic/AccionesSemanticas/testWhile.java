package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.Traductor;

public class testWhile implements IAccionSemantica{
    @Override
    public void ejecutar(String token) {
        RS_DO rs_do = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();  // POP RS_DO
        //este debería ser el resultado de la expresión del while

        // Genera en la traduccion el de la evaluacion del while
        String comparacion = "CMP " + String.valueOf(rs_do.getValor()) + ", 0";  // CMP [direccion], 0
        Traductor.getInstance().addLine(comparacion);

        // Genera en la traduccion para terminar del while
        String jump = "JE " + RS_WHILE.endWhileLabel + String.valueOf(RS_WHILE.cantidadLabels); // JE endWhileLabelN
        Traductor.getInstance().addLine(jump);
    }

}
