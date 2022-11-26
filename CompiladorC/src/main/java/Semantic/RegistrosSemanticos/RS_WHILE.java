package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_WHILE extends abstactRS {
    public  final rsType type = rsType.WHILE;
    public  final String whileLabel = "whileLabel";
    public  final String endWhileLabel = "endWhileLabel";

    public RS_WHILE(rsType type) {
        super(type);
    }
}
