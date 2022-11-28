package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_IF extends abstactRS {
    public static int cantidadLabels = 0;
    public static String ifLabel = "iFlabel";
    public  static String elseLabel = "elseLabel";
    public  static String endIfLabel = "endIfLabel";


    public RS_IF(rsType type) {
        super(type);
    }
}
