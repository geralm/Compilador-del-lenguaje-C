package CompiladorC;



import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//

public class LexerGui extends JFrame  {
    private JLabel labeltitle;
    private JButton compilarButton;
    private JTextArea textArea;
    private JButton archivoButton;
    private JPanel mainPanel;
    private JButton bBorrar;
    private JTable tablaErroresLexicos;

    private JLabel labelErroresLexicos;
    private JTable tableErroresSintacticos;
    private JLabel labelErroresSintacticos;
    private JButton buttonParsear;
    private JButton buttonTokenizar;
    private JLabel JLabelPrograma;
    private JPanel JPanelTittle;
    private JPanel JPanelPrograma;
    private JPanel JPanelCompilador;
    private JButton buttonSalir;

    private Control control;

    public JTable getTableErroresSintacticos() {
        return tableErroresSintacticos;
    }

    public LexerGui() {
        this.setContentPane(mainPanel);
        setTitle("Compilador C");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setLocationRelativeTo(null);
        control = new Control(this);
        compilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                //método para leer cada uno de los tokens y mostrarlos en la interfaz una vez terminados
                // aquí proceso la cadena
                String cadena = textArea.getText().trim();
                System.out.println("La cadena obtenida es: "+cadena);
                control.compilarTodo(cadena); //procesa la cadena y de una vez colocarErroresLexicos en la tabla
            }
        });

        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.limpiar();
                //ya las tablas han sido limpiadas en el método limpiar
                textArea.setText("");
            }
        });

        buttonTokenizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //método para leer cada uno de los tokens y mostrarlos en la interfaz una vez terminados
                // aquí proceso la cadena
                String cadena = textArea.getText().trim();
                control.tokenizar(cadena); //procesa la cadena y de una vez colocarErroresLexicos en la tabla
                buttonParsear.setEnabled(true);
            }
        });
        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        archivoButton.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt", "c");
                int selection = fc.showOpenDialog(null);
                if (selection == JFileChooser.APPROVE_OPTION) {
                    //método para leer el archivo y mostrarlo en el textArea
                    File fichero = fc.getSelectedFile();
                    String ruta = fichero.getAbsolutePath();
                    if(ruta.endsWith(".txt") || ruta.endsWith(".c")){
                        System.out.println("La ruta del archivo seleccionado ha sido obtenida exitosamente");
                        try(FileReader fr = new FileReader(fichero)){
                            String cadena = "";
                            int valor = fr.read();
                            while(valor != -1){
                                cadena = cadena + (char)valor;
                                valor = fr.read();
                            }
                            textArea.setText(cadena);

                        }catch(IOException ex){
                            System.out.println("Error al leer el archivo");

                        }
                    }
                    control.limpiar();
                }
            }
        });
        buttonParsear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena = textArea.getText().trim();
                control.parsear(cadena);
            }
        });
    }

    public String getArchivo(){
        return textArea.getText().trim();
    } 
    public void limpiarTabla(JTable tabla){ //recibe una tabla y la limpia
        tabla.setModel(new DefaultTableModel());
    }
    public JTable getTablaErroresLexicos() {
        return tablaErroresLexicos;
    }
    public JTable getTablaErroresSintacticos() {
        return tableErroresSintacticos;
    }
}





