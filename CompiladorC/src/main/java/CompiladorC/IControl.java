package CompiladorC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public interface IControl <T>{
    public void limpiar();
    public void procesar(T datos);
    public DefaultTableModel construirModelo(JTable tabla);
}
