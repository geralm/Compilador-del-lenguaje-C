package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_WHILE;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class EndWhile implements IAccionSemantica {
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        String ciclar = "\nJMP " + RS_WHILE.whileLabel + String.valueOf(RS_WHILE.cantidadLabels);
        Traductor.getInstance().addLine(ciclar);

        String exit = RS_WHILE.endWhileLabel + String.valueOf(RS_WHILE.cantidadLabels) + ":";
        Traductor.getInstance().addLine(exit);


        //la pila queda como antes
        while (!Traductor.getInstance().getPilaSemantica().peek().getType().equals(rsType.WHILE)) {
            Traductor.getInstance().getPilaSemantica().pop();
        }


        RS_WHILE.cantidadLabels++;//aumenta la cantidad de labels para que no existan conflictos en la traducción
    }
}