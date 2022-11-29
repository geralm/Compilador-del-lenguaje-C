package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_Funcion;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

public class CalcularBytesParametros implements  IAccionSemantica{
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_Funcion rs_funcion= (RS_Funcion) Traductor.getInstance().getPilaSemantica().pop();  // Sacar el registro semantico de la funcion para calcular los bytes de los parametros

        // Ve segun el tipo de dato cuantos bytes tiene que reservar
        switch (token){
            case "int":
                rs_funcion.agregarBytes(4);
                break;

            case "float":
                rs_funcion.agregarBytes(4);
                break;

            case "char":
                rs_funcion.agregarBytes(1);
                break;

            case "short":
                rs_funcion.agregarBytes(2);
                break;

            default:
                rs_funcion.agregarBytes(0);
                break;
        }

        Traductor.getInstance().getPilaSemantica().push(rs_funcion);  // Lo vuelve a meter en la pila semantica
    }
}
