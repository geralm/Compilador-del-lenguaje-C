package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_IF;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class TestIF implements IAccionSemantica{
    public TestIF() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_DO rs_do_resultado = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
        String exp = rs_do_resultado.getValor();
        String cmp = "cmp "+exp+", 0";
        String codigoEvaluacion = "je "+RS_IF.elseLabel+String.valueOf(RS_IF.cantidadLabels)+"\n";
        String elseLabel = RS_IF.elseLabel+String.valueOf(RS_IF.cantidadLabels)+":";
        Traductor.getInstance().addLine(cmp);
        Traductor.getInstance().addLine(codigoEvaluacion);
        Traductor.getInstance().addLine(elseLabel);
    }
}
