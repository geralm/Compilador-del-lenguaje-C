package Semantic.TablaSimbolos;

import Semantic.TablaSimbolos.TSSymbol;
import java_cup.runtime.Symbol;

public class ErrorSemantico extends Exception {
    private TSSymbol symbol;
    public ErrorSemantico(String message, TSSymbol symbol) {
        super(message);
        this.symbol = symbol;
    }
    public ErrorSemantico(String message) {
        super(message);
    }
    public TSSymbol getSymbol() {
        return symbol;
    }
}
