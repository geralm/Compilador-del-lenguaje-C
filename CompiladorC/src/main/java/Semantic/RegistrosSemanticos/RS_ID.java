package Semantic.RegistrosSemanticos;

import Enums.rsType;
import java_cup.runtime.Symbol;

 public class RS_ID extends abstactRS{

    private String nombre = "";

     public RS_ID(rsType type) {
         super(type);
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
 }
