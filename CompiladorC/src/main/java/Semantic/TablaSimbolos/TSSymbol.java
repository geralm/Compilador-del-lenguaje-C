package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

public class TSSymbol {
    protected String id;
    protected String type;

    public TSSymbol(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
}
