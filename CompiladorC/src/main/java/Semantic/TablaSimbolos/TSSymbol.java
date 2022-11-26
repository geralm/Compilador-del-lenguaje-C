package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

public class TSSymbol {
    protected Symbol id;
    protected Symbol type;

    public TSSymbol(Symbol id, Symbol type) {
        this.id = id;
        this.type = type;
    }

    public Symbol getId() {
        return id;
    }
    public Symbol getType() {
        return type;
    }
}
