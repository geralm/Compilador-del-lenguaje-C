package Semantic;

import Enums.rsType;

public class RS_Factory {

    public static RS createRS(rsType type, String TOKEN){
        if (type.equals(rsType.ID)){
            return new RS_ID(TOKEN);
        }
        else if (type.equals(rsType.TIPO)){
            return new RS_TIPO(TOKEN);
        }
        else if (type.equals(rsType.INSERTARTS)){
            return new RS_INSERTARTS(TOKEN);
        }
        //NEVER HAPPENS
        else {
            return null;
        }
    }
}
