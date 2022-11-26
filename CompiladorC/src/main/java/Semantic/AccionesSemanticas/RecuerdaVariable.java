package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.TablaSimbolos.TSSymbol;
import Semantic.TablaSimbolos.Tabla;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class RecuerdaVariable implements IAccionSemantica{


    @Override
    public void ejecutar(Symbol token) throws ErrorSemantico {
        RS_DO rs_do = (RS_DO) RS_Factory.create(rsType.DO);
        rs_do.setDireccionMemoria("Prueba direccion de memoria, cambiar esto en la clase Semantic\\AccionesSemanticas\\RecuerdaVariable.java");
        rs_do.setNombre(token);
        if(!Traductor.getInstance().getTablaDeSimbolos().existe(token)){
            //en caso de que no exista
            Traductor.getInstance().getTablaDeSimbolos().insertar(new TSSymbol(token, token));
            System.out.println("Se inserta los dos tokens hay que solucionar eso en la clase Semantic\\AccionesSemanticas\\RecuerdaVariable.java");
            throw new ErrorSemantico("La variable " + token.value + " no ha sido declarada");
        }
        Traductor.getInstance().getPilaSemantica().push(rs_do);
    }
}
