package Semantic.TablaSimbolos;

import java_cup.runtime.Symbol;

public class Variable  extends TSSymbol {
    private String memoria="No asignada";
    public Variable(String id, String type) {
        super(id, type);
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }
    public boolean isVariableDefinida(){
        if(this.getMemoria().equals("No asignada")){
            return false;
        }else{
            return true;
        }
    }
}
