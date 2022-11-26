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
    public void ejecutar(Symbol token){
        RS_TIPO rsTipo = (RS_TIPO) Traductor.getInstance().getPilaSemantica().buscar(rsType.TIPO);
        while(Traductor.getInstance().getPilaSemantica().peek().getType() != rsType.TIPO){
            RS_ID rsID = (RS_ID) Traductor.getInstance().getPilaSemantica().pop();
            try {
                Traductor.getInstance().getTablaDeSimbolos().insertar(new TSSymbol(rsID.getNombre(), rsTipo.getTipo()));
            } catch (ErrorSemantico error) {
                Traductor.getInstance().addError(error);
            }
        }
        Traductor.getInstance().getPilaSemantica().pop();
    }
}
