package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_IF;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class StartElse implements IAccionSemantica{

    public StartElse() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        System.out.println("Aún no están implementadas las funciones del traductor");
        String jump  = RS_IF.endIfLabel+String.valueOf(RS_IF.cantidadLabels)+":";
        String elseLabel = RS_IF.elseLabel+String.valueOf(RS_IF.cantidadLabels)+":";
        Traductor.getInstance().addLine(jump);
        Traductor.getInstance().addLine(elseLabel);

        System.out.println("Aún se debe concatenar al string traductor");
    }
}
