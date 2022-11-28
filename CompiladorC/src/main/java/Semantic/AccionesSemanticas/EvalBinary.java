package Semantic.AccionesSemanticas;

import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_OP;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class EvalBinary implements IAccionSemantica{


    @Override
    public void ejecutar(String token) {
         RS_DO rs_do2 = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
         RS_OP rs_op = (RS_OP) Traductor.getInstance().getPilaSemantica().pop();
         RS_DO rs_do1 = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
        System.out.println("Por implementar");
         /*if(rs_do1.getTipo_RS_DO().equals(RS_DO.ETypoRs_Do.CONSTANTE) && rs_do2.getTipo_RS_DO().equals(RS_DO.ETypoRs_Do.CONSTANTE)){
            int resultado  =

        }else{

         }*/
    }
    /*
    private int evaluar(int direction1 ,Symbol operador, int direction2){
        switch (operador.sym){
            case 38:
                return direction1 + direction2;
            case 39:
                return direction1 - direction2;
            case 40:
                return direction1 * direction2;
            case 4:
                return direction1 / direction2;
            case 5:
                return direction1 % direction2;
            default:
                return 0;
        }
        switch(operador.sym){


        }


        return resultado;
    }

     */
}
