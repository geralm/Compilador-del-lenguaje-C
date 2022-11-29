package CompiladorC;

import Semantic.TablaSimbolos.Funcion;
import Semantic.TablaSimbolos.TSSymbol;
import Semantic.Traductor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUISemantic extends JFrame {
    private JButton Volver;
    private JButton Generar;
    private JTextArea textArea;
    private JTable table;
    private JPanel mainpanel;
    String path = "";
    public GUISemantic(String ruta) {
        setContentPane(mainpanel);
        path= ruta;
        setExtendedState(JFrame.NORMAL);
        llenarTabla();
        textArea.setText(Traductor.getInstance().traducir());
        Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path.contains(".c")){
                    path = path.replace(".c",".txt");
                }
                else{
                    path = path.replace(".txt","1.txt");
                }
                String finalPath= path;
                System.out.println("Text to save: "+textArea.getText());
                System.out.println("Final path to save "+finalPath);
                try {
                    File file = new File(finalPath);
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);

                    fw = new FileWriter(file);
                    bw.write(textArea.getText());
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente "+finalPath);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
                }
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
