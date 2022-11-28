package CompiladorC;

import Semantic.TablaSimbolos.ErrorSemantico;
import Semantic.Traductor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControlSemantic implements IControl{

    Semantic.Traductor traductor =  Traductor.getInstance();

    public ControlSemantic( ) {}

    @Override
    public void limpiar() {
        traductor.reiniciar();
    }

    @Override
    public void procesar(Object datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel construirModelo(JTable tabla) {
        DefaultTableModel modelErrores = (DefaultTableModel) tabla.getModel(); //crea un nuevo modelo
        modelErrores.setColumnIdentifiers(new Object[]{"Mensaje","Tipo","Simbolo"});
        System.out.println("Lista de errores semanticos");
        for(ErrorSemantico error : traductor.getListaErrores()){
            System.out.println(error.getMessage());
            modelErrores.addRow(new Object[]{error.getMessage(), error.getSymbol().getType(), error.getSymbol().getId() }); //agrega el token a la tabla
        }
        return modelErrores;
    }
}
