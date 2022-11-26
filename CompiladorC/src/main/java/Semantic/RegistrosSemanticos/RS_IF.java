package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_IF extends abstactRS {

    public final String ifLabel = "iFlabel";
    public   final String elseLabel = "elseLabel";
    public  final String endIfLabel = "endIfLabel";

    public RS_IF(rsType type) {
        super(type);
    }
}
