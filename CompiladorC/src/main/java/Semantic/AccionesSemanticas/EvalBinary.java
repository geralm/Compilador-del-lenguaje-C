package Semantic.AccionesSemanticas;

import Enums.rsType;
import Semantic.RegistrosSemanticos.RS_DO;
import Semantic.RegistrosSemanticos.RS_Factory;
import Semantic.RegistrosSemanticos.RS_OP;
import Semantic.Traductor;
import java_cup.runtime.Symbol;

public class EvalBinary implements IAccionSemantica{


    @Override
    public void ejecutar(String token) {
         RS_DO rs_do2 = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
         RS_OP rs_op = (RS_OP) Traductor.getInstance().getPilaSemantica().pop();
         RS_DO rs_do1 = (RS_DO) Traductor.getInstance().getPilaSemantica().pop();
         Traductor.getInstance().addLine("cmp "+rs_do1.getValor()+", "+rs_do2.getValor());
         RS_DO nuevo = (RS_DO) RS_Factory.create(rsType.DO);
         if(rs_do1.getTipo().equals(RS_DO.ETypoRs_Do.CONSTANTE) && rs_do2.getTipo().equals(RS_DO.ETypoRs_Do.CONSTANTE)){
            int resultado  = evaluar(Integer.parseInt(rs_do1.getValor()) ,Integer.parseInt(rs_do2.getValor()) , rs_op.getOperador());
            nuevo.setTipo(RS_DO.ETypoRs_Do.CONSTANTE);
            nuevo.setValor(String.valueOf(resultado));
            Traductor.getInstance().getPilaSemantica().push(nuevo);
            System.out.println("Aplicando constant folding");
        }else{
            nuevo.setTipo(RS_DO.ETypoRs_Do.NO_CONSTANTE);
            Traductor.getInstance().addLine("mov eax, ["+String.valueOf(rs_do1.getValor())+"]");
            Traductor.getInstance().addLine("mov ebx, ["+String.valueOf(rs_do2.getValor())+"]");
            nuevo.setValor("generar Código de la expresión");
            Traductor.getInstance().getPilaSemantica().push(nuevo);
         }
    }
    private int evaluar(int op1, int op2, String operador){
        switch (operador){
            case "+":
                return op1+op2;
            case "-":
                return op1-op2;
            case "*":
                return op1*op2;
            case "/":
                return op1/op2;
            case "%":
                return op1%op2;
            case "==":
                return op1==op2?1:0;
            case "!=":
                return op1!=op2?1:0;
            case ">":
                return op1>op2?1:0;
            case "<":
                return op1<op2?1:0;
            case ">=":
                return op1>=op2?1:0;
            case "<=":
                return op1<=op2?1:0;
            case "&&":
                return op1==1 && op2==1?1:0;
            case "||":
                return op1==1 || op2==1?1:0;
            default:
                return 0;
        }
    }
    public String traducir(int op1, int op2, String operador){
        switch(operador){
            case "+":
                return "add "+String.valueOf(op1)+", "+String.valueOf(op2);
            case "-":
                return "sub "+String.valueOf(op1)+", "+String.valueOf(op2);
            case "*":
                return "mul "+String.valueOf(op1)+", "+String.valueOf(op2);
            case "/":
                return "div "+String.valueOf(op1)+", "+String.valueOf(op2);
            default:
                return "";
        }

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
