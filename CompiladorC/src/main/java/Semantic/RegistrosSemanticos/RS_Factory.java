package Semantic.RegistrosSemanticos;

import Enums.rsType;

public class RS_Factory {

    public static abstactRS create(rsType type){
        switch (type){
            case DO -> {
                return new RS_DO(type);
            }
            case ID -> {
                return new RS_ID(type);
            }
            case IF -> {
                return new RS_IF(type);
            }
            case OP -> {
                return new RS_OP(type);
            }
            case TIPO -> {
                return new RS_TIPO(type);
            }
            case WHILE -> {
                return new RS_WHILE(type);
            }
            default -> {
                return null;
            }
        }
    }
}
