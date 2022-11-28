package CompiladorC;

import Semantic.TablaSimbolos.TSSymbol;
import Semantic.Traductor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISemantic extends JFrame {
    private JButton Volver;
    private JButton Generar;
    private JTextArea textArea;
    private JTable table;
    private JPanel mainpanel;

    public GUISemantic( ) {
        setContentPane(mainpanel);
        setExtendedState(JFrame.NORMAL);
        llenarTabla();
        textArea.setText(Traductor.getInstance().getTexto_ensamblador());
        Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Tipo", "Identificador"});
        for(TSSymbol tsSymbol : Traductor.getInstance().getTablaDeSimbolos().getTabla()){
            modelo.addRow(new Object[]{tsSymbol.getType(), tsSymbol.getId()});
        }
        table.setModel(modelo);

    }

}
