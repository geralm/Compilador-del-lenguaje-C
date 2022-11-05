package CompiladorC;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private Control control;

    public JTable getTableErroresSintacticos() {
        return tableErroresSintacticos;
    }

    public LexerGui() {
        this.setContentPane(mainPanel);
        setTitle("Compilador C");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                control.procesar(cadena); //procesa la cadena y de una vez colocarErroresLexicos en la tabla
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
}





