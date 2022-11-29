package Semantic.TablaSimbolos;

import Semantic.TablaSimbolos.TSSymbol;
import java_cup.runtime.Symbol;

public class ErrorSemantico extends Exception {
    private TSSymbol symbol;
    private String message;
    public ErrorSemantico(String message, TSSymbol symbol) {
        super(message);
        this.message = message;
        this.symbol = symbol;
    }
    public TSSymbol getSymbol() {
        return symbol;
    }
    public String getMessage() {
        return message;
    }
}
