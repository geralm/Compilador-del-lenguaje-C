package Semantic.AccionesSemanticas;


import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_Funcion;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class PrologoFuncion implements  IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_Funcion rs_funcion = (RS_Funcion) RS_Factory.create(rsType.FUNCION); // Crea el registro semantico de la funcion
        Traductor.getInstance().getPilaSemantica().push(rs_funcion);  // Lo agrega a la pila semantica

        // Genera en la traduccion el prologo de la funcion
        String iniciar = "PROC " + token;  // PROC nombreFuncion
        Traductor.getInstance().addLine(iniciar);

        String registrosPila = "MOV sp, bp";
        Traductor.getInstance().addLine(registrosPila);
    }

}
