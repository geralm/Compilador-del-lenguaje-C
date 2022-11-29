package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_ID;
import Semantic.RegistrosSemanticos.RS_TIPO;
import Semantic.RegistrosSemanticos.abstactRS;
import Semantic.TablaSimbolos.*;
import Semantic.Traductor;

import java.util.ArrayList;

public class InsertarTS implements IAccionSemantica {
    private ArrayList<TSSymbol> parametrosTemporal = new ArrayList<>();
    public InsertarTS() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_TIPO rsTipo = (RS_TIPO) Traductor.getInstance().getPilaSemantica().buscar(rsType.TIPO);
        RS_ID rsID;
        if(rsTipo!=null){
            System.out.println("identificadores en la pila");
            while(Traductor.getInstance().getPilaSemantica().peek().getType() != rsType.TIPO){
                abstactRS RS_TOPE =Traductor.getInstance().getPilaSemantica().pop();
                if(RS_TOPE instanceof RS_ID){
                    rsID = (RS_ID) RS_TOPE;
                    TSSymbol.TipoTS tst = TSSymbol.obtenerTipo(token);
                    if(tst.equals( TSSymbol.TipoTS.VARIABLE)){
                        Variable variable = new Variable(rsID.getNombre(), rsTipo.getTipo());
                        System.out.println(rsID.getNombre());
                        variable.setTipoTS_symbol(tst);
                        Traductor.getInstance().getTablaDeSimbolos().existe(variable);
                        Traductor.getInstance().getTablaDeSimbolos().insertar(variable);
                    }else if(tst.equals( TSSymbol.TipoTS.FUNCION)){
                        Funcion funcion = new Funcion(rsID.getNombre(), rsTipo.getTipo());
                        funcion.setTipoTS_symbol(tst);
                        for(TSSymbol ts: parametrosTemporal){
                            funcion.addParametro((Variable) ts);
                        }
                        Traductor.getInstance().getTablaDeSimbolos().existe(funcion);
                        Traductor.getInstance().getTablaDeSimbolos().insertar(funcion);
                        parametrosTemporal.clear();
                    }else if(tst.equals( TSSymbol.TipoTS.PARAMETRO)){
                        Variable variable = new Variable(rsID.getNombre(), rsTipo.getTipo());
                        variable.setTipoTS_symbol(tst);
                        parametrosTemporal.add(variable);
                    }

                }


            }
        }else{
            Traductor.getInstance().addError(new ErrorSemantico("No se ha encontrado el tipo de la variable", new Variable(token, "Error!")));
        }
        Traductor.getInstance().getTablaDeSimbolos().getTabla().forEach((k)-> System.out.println(k.getId()+"->"+k.getType()+"="+k.getTipoTS_symbol().toString()));
        Traductor.getInstance().getPilaSemantica().pop();
    }

}
