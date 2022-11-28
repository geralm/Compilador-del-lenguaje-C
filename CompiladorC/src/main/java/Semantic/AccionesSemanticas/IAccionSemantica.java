package Semantic.AccionesSemanticas;

import Semantic.TablaSimbolos.ErrorSemantico;
import java_cup.runtime.Symbol;

public interface IAccionSemantica {
    public void ejecutar(String token) throws ErrorSemantico;
}
