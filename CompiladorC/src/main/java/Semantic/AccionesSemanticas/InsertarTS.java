package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.PilaSemantica;
import Semantic.RegistrosSemanticos.RS_ID;
import Semantic.RegistrosSemanticos.RS_TIPO;
import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.TablaSimbolos.TSSymbol;
import Semantic.TablaSimbolos.Tabla;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class InsertarTS implements IAccionSemantica {

    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_TIPO rsTipo = (RS_TIPO) Traductor.getInstance().getPilaSemantica().buscar(rsType.TIPO);
        if(rsTipo!=null){
            System.out.println("identificadores en la pila");
            while(Traductor.getInstance().getPilaSemantica().peek().getType() != rsType.TIPO){
                RS_ID rsID = (RS_ID) Traductor.getInstance().getPilaSemantica().pop();
                TSSymbol simbolo = new TSSymbol(rsID.getNombre(), rsTipo.getTipo());
                System.out.println(rsID.getNombre());
                Traductor.getInstance().getTablaDeSimbolos().existe(simbolo);
                Traductor.getInstance().getTablaDeSimbolos().insertar(simbolo);
            }
        }else{
            Traductor.getInstance().addError(new ErrorSemantico("No se ha encontrado el tipo de la variable"));
        }

        Traductor.getInstance().getPilaSemantica().pop();
    }
}
