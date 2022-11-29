package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.RegistrosSemanticos.abstactRS;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

import java.util.LinkedList;


public class VerifyContinue implements  IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        LinkedList<abstactRS> pilaAuxiliar = Traductor.getInstance().getPilaSemantica().getPila();
        abstactRS rs = null;
        //la pila queda como antes
        while (!pilaAuxiliar.peek().getType().equals(rsType.WHILE)) {
            rs = pilaAuxiliar.pop();
        }

        if(pilaAuxiliar.isEmpty()){
            throw new ErrorSemantico("No se puede usar break fuera de un ciclo");
        } else {
            RS_WHILE rs_while = (RS_WHILE) rs;
            String traduccion = "\nJMP " + RS_WHILE.whileLabel + String.valueOf(RS_WHILE.cantidadLabels);
            Traductor.getInstance().addLine(traduccion);
        }

    }
}
