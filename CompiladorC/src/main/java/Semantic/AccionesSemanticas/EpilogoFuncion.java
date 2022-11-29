package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_Funcion;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class EpilogoFuncion implements IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_Funcion rs_funcion = (RS_Funcion) Traductor.getInstance().getPilaSemantica().pop(); // Saca el registro semantico de la funcion de la pila semantica

        String traduccion = "\nRET " + String.valueOf(rs_funcion.getCantidadBytes());  // RET n
        Traductor.getInstance().addLine(traduccion);
    }
}
