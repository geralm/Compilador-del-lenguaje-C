package Semantic.RegistrosSemanticos;


import Enums.rsType;

public class RS_DO extends abstactRS {
    private String direccionMemoria;

    public RS_DO(rsType type ) {
        super(type);
    }

    public void setDireccionMemoria(String direccionMemoria) {
        this.direccionMemoria = direccionMemoria;
    }

    public String getDireccionMemoria() {
        return direccionMemoria;
    }
    public int getHex(){
        return Integer.parseInt(direccionMemoria, 16);
    }
}
