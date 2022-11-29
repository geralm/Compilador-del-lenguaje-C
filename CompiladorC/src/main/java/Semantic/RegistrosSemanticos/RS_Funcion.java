package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_Funcion extends abstactRS {
    private int cantidadBytes = 0;
    public static final rsType type = rsType.FUNCION;;

    public RS_Funcion(rsType type) {
        super(type);
    }

    public void agregarBytes(int cantidadBytes) {
        this.cantidadBytes += cantidadBytes;
    }
}
