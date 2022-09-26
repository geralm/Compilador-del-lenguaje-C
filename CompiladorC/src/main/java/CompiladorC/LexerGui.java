package CompiladorC;



import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
//

public class LexerGui extends JFrame  {
    private JLabel labeltitle;
    private JButton compilarButton;
    private JTextArea textArea;
    private JButton archivoButton;

    private JPanel mainPanel;
    private JButton bBorrar;
    private JTable table1;
    private JScrollPane jtable;
    ArrayList<Token>listaTokens = new ArrayList<Token>();


    public LexerGui() {
        this.setContentPane(mainPanel);
        setTitle("Compilador C");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        compilarButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e)  {
                //método para leer cada uno de los tokens y mostrarlos en la interfaz una vez terminados
                // aquí proceso la cadena
                String cadena = textArea.getText().trim();

                System.out.println("La cadena obtenida es: "+cadena);

                LexerAnalyzer demoLexer  = new LexerAnalyzer(new StringReader(cadena));
                /*
                try {
                    listaTokens.add(demoLexer.yylex());
                } catch (IOException ioException) {
                    System.out.println("Error al leer el token por IOException");
                    textArea.setText("Error al leer el token por IOException");
                }
                */
                try {
                    Token token = demoLexer.yylex();
                    while (token.getType() != TokensConstants.EOF) {
                        listaTokens.add(token);
                        token = demoLexer.yylex();
                        System.out.println(token.toString());
                    }
                } catch (IOException ioException) {
                    System.out.println("Error al leer el token por IOException");

                }

                colocarTokens();
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

                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un archivo txt ");

                }
            }
        });
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
    }
    public void borrar(){
        textArea.setText("");
        listaTokens.clear();
        table1.setModel(new DefaultTableModel());
    }
    public void colocarTokens( ){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Token", "Lexema", "Linea"});
        for(int i = 0; i < listaTokens.size(); i++){
            Token unToken = listaTokens.get(i);
            model.addRow(new Object[]{unToken.getType(), unToken.getLexema(), String.valueOf(unToken.getLineNumber())});
        }
        table1.setModel(model);

    }



}
