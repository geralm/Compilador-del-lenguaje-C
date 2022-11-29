package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_WHILE extends abstactRS {
    public static final rsType type = rsType.WHILE;
    public static final String whileLabel = "whileLabel";
    public static final String endWhileLabel = "endWhileLabel";
    public  static int cantidadLabels = 0;
    public RS_WHILE(rsType type) {
        super(type);
    }
}
