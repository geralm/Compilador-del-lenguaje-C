package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.TablaSimbolos.TSSymbol;
import Semantic.Traductor;

public class RecuerdaConstante implements IAccionSemantica {
    @Override
    public void ejecutar(String token) {
        RS_DO rs = (RS_DO)RS_Factory.create(rsType.DO);
        rs.setTipo(RS_DO.ETypoRs_Do.CONSTANTE);
        rs.setValor(token);
        Traductor.getInstance().getPilaSemantica().push(rs);
    }
}
