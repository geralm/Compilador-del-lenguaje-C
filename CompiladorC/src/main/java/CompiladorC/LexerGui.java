package CompiladorC;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LexerGui extends JFrame  {
    private JLabel labeltitle;
    private JButton compilarButton;
    private JTextArea textArea;
    private JButton archivoButton;
    private JList list1;
    private JPanel mainPanel;

    public LexerGui() {
        this.setContentPane(mainPanel);
        setTitle("Compilador C");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        compilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //método para leer cada uno de los tokens y mostrarlos en la interfaz una vez terminados
            }
        });
        archivoButton.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
                int selection = fc.showOpenDialog(null);
                if (selection == JFileChooser.APPROVE_OPTION) {
                    //método para leer el archivo y mostrarlo en el textArea
                    File fichero = fc.getSelectedFile();
                    String ruta = fichero.getAbsolutePath();
                    if(ruta.endsWith(".txt")){
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
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo");
                    }
                }
                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un archivo txt ");

                }
            }
        });
    }

    public static void main(String[] args) {
        LexerGui lexerGui = new LexerGui();

    }

}
