package Semantic;

import Enums.rsType;
import Semantic.RegistrosSemanticos.abstactRS;

import java.util.LinkedList;

public class PilaSemantica {
    private LinkedList<abstactRS> pila = new LinkedList<>();
    private int tope = -1;
    public void push(abstactRS rs){
        pila.add(rs);
        tope++;
    }
    public abstactRS pop(){
        if(tope >= 0){
            abstactRS rs = pila.get(tope);
            pila.remove(tope);
            tope--;
            return rs;
        }
        return null;
    }
    public abstactRS peek(){
        if(tope >= 0){
            return pila.get(tope);
        }
        return null;
    }
    public boolean isPilaVacia(){
        return tope == -1;
    }
    public abstactRS buscar(rsType type){
        for(int i = tope; i >= 0; i--){
            if(pila.get(i).getType() == type){
                return pila.get(i);
            }
        }
        System.out.println("El registro semántico no fue encontrado en la pila");
        return null;
    }





}
