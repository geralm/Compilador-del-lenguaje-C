package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_Funcion;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class TraducirEspacioParametros implements IAccionSemantica{

    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_Funcion rs_funcion = (RS_Funcion) Traductor.getInstance().getPilaSemantica().peek();  // Para obtener la cantidad de bytes
        String espacioParametros = "SUB sp, " + String.valueOf(rs_funcion.getCantidadBytes()); // SUB sp, n
        Traductor.getInstance().addLine(espacioParametros);
    }
}
