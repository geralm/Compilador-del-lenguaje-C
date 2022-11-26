package Semantic.RegistrosSemanticos;


import Enums.rsType;
import java_cup.runtime.Symbol;

public class RS_DO extends abstactRS {
    private String direccion;
    private Symbol tipo; // Tipo de dato que se va a guardar en la dirección
    private Symbol nombre; // nombre de la variable

    public RS_DO(rsType type ) {
        super(type);
    }

    public void setDireccionMemoria(String direccionMemoria) {
        this.direccion = direccionMemoria;
    }

    public String getDireccionMemoria() {
        return direccion;
    }
    public int getHex(){
        return Integer.parseInt(direccion, 16);
    }

    public Symbol getNombre() {
        return nombre;
    }

    public void setNombre(Symbol nombre) {
        this.nombre = nombre;
    }
}
