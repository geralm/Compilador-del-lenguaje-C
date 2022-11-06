package CompiladorC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControlParser implements IControl <Object>{

    public ControlParser() {
    }
    @Override
    public void limpiar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void procesar(Object datos) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DefaultTableModel construirModelo(JTable tabla) {
        throw new UnsupportedOperationException();
    }
}
