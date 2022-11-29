package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_ID;
import Semantic.RegistrosSemanticos.RS_TIPO;
import Semantic.TablaSimbolos.*;
import Semantic.Traductor;

public class InsertarTS implements IAccionSemantica {
    public InsertarTS() {
    }
    @Override
    public void ejecutar(String token) throws ErrorSemantico {
        RS_TIPO rsTipo = (RS_TIPO) Traductor.getInstance().getPilaSemantica().buscar(rsType.TIPO);
        if(rsTipo!=null){
            System.out.println("identificadores en la pila");
            while(Traductor.getInstance().getPilaSemantica().peek().getType() != rsType.TIPO){
                RS_ID rsID = (RS_ID) Traductor.getInstance().getPilaSemantica().pop();
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
                    Traductor.getInstance().getTablaDeSimbolos().existe(funcion);
                    Traductor.getInstance().getTablaDeSimbolos().insertar(funcion);
                 }else if(tst.equals( TSSymbol.TipoTS.PARAMETRO)){
                    Variable variable = new Variable(rsID.getNombre(), rsTipo.getTipo());
                    variable.setTipoTS_symbol(tst);
                    Tabla t = Traductor.getInstance().getTablaDeSimbolos();
                    Funcion f = t.buscarUltimaFuncion();

                    f.addParametro(variable);
                }

                TSSymbol simbolo = new TSSymbol(rsID.getNombre(), rsTipo.getTipo());

            }
        }else{
            Traductor.getInstance().addError(new ErrorSemantico("No se ha encontrado el tipo de la variable", new Variable(token, "Error!")));
        }
        Traductor.getInstance().getTablaDeSimbolos().getTabla().forEach((k)-> System.out.println(k.getId()+"->"+k.getType()+"="+k.getTipoTS_symbol().toString()));
        Traductor.getInstance().getPilaSemantica().pop();
    }

}
