package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_IF;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class End_IF implements IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        String exit = RS_IF.endIfLabel+String.valueOf(RS_IF.cantidadLabels)+":";
        //la pila queda como antes
        while(!Traductor.getInstance().getPilaSemantica().peek().getType().equals(rsType.IF)){
           Traductor.getInstance().getPilaSemantica().pop();
        }
        Traductor.getInstance().addLine(exit);
        RS_IF.cantidadLabels++;//aumenta la cantidad de labels para que no existan conflictos en la traducción
    }
}
