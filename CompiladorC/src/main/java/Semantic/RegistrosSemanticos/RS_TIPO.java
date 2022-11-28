package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

 public class RS_TIPO extends abstactRS {
     public final rsType type = rsType.TIPO;
    private String tipo;

     public RS_TIPO(rsType type) {
         super(type);

     }

     public String getTipo() {
         return tipo;
     }

     public void setTipo(String tipo) {
         this.tipo = tipo;
     }
 }
