package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

 public class RS_ID extends abstactRS{

    private Symbol nombre;

     public RS_ID(rsType type) {
         super(type);
     }

     public Symbol getNombre() {
         return nombre;
     }

     public void setNombre(Symbol nombre) {
         this.nombre = nombre;
     }
 }
