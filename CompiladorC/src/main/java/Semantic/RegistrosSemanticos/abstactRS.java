package Semantic.RegistrosSemanticos;

import Enums.rsType;

public  class abstactRS {
    protected rsType type;

    public abstactRS(rsType type) {
        this.type = type;
    }

    public rsType getType() {
        return type;
    }
}
