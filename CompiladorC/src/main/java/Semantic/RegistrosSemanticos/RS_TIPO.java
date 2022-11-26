package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

 public class RS_TIPO extends abstactRS {
     public final rsType type = rsType.TIPO;
    private Symbol tipo;

     public RS_TIPO(rsType type) {
         super(type);

     }

     public Symbol getTipo() {
         return tipo;
     }

     public void setTipo(Symbol tipo) {
         this.tipo = tipo;
     }
 }
