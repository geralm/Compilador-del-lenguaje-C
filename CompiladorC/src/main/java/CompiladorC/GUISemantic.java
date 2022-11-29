package CompiladorC;

import Semantic.TablaSimbolos.Funcion;
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
        textArea.setText(Traductor.getInstance().traducir());
        Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Tipo", "Identificador", "Valor"});
        for(TSSymbol tsSymbol : Traductor.getInstance().getTablaDeSimbolos().getTabla()){
            if(tsSymbol.getTipoTS_symbol().equals(TSSymbol.TipoTS.FUNCION)){
                Funcion f  = (Funcion) tsSymbol;
                modelo.addRow(new Object[]{f.getType(), f.getId(),TSSymbol.TipoTS.FUNCION.toString()});
                for(TSSymbol ts : f.getParametros()){
                    modelo.addRow(new Object[]{ts.getType(), ts.getId(),TSSymbol.TipoTS.PARAMETRO.toString()});
                }

            }else{
                modelo.addRow(new Object[]{tsSymbol.getType(), tsSymbol.getId()});
            }

        }
        table.setModel(modelo);

    }

}
