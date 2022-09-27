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
    private JTable tableAceptados;
    private JScrollPane jtable;
    private JTable tablaErrores;
    private JLabel labelAceptados;
    private JLabel labelErrores;
    ArrayList<Token>listaTokens = new ArrayList<Token>();


    public LexerGui() {
        this.setContentPane(mainPanel);
        setTitle("Compilador C");
        setSize(1500, 500);
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
                borrarTodo();
            }
        });
    }
    public void borrarTodo(){
        textArea.setText("");
        listaTokens.clear();
        tableAceptados.setModel(new DefaultTableModel());
    }
    public void borrarTabla(JTable tabla){ //recibe una tabla y la limpia
        tabla.setModel(new DefaultTableModel());
    }

    private  int lexemaExiste(JTable tabla, String lexema){
        /*Retorna la posición de la fila en la que se encuentra el lexemna si lo encuentra
        en caso de que no lo encuentra entonces retorna la última posición de la tabla*/

        for(int i = 0; i <tabla.getModel().getRowCount(); i++)
        {
            if(tabla.getModel().getValueAt(i, 1).equals(lexema))
            {
                return i; // encontrado y retorna la posición
            }
        }
        return -1; // no encontrado
    }

    private String agregarLineas(Token unToken){
        ArrayList<String> lineas = new ArrayList<>();
        int cant = 0;
        int actLineNumber = unToken.getLineNumber();
        String linea = "";
        for (int i = 0; i < listaTokens.size(); i++){
            Token aToken = listaTokens.get(i);
            if (unToken.getLexema().equals(aToken.getLexema()) && actLineNumber == aToken.getLineNumber()){
                cant++;
                /*if(i == listaTokens.size()-1){
                    if (cant > 1){
                        lineas.add(actLineNumber + "(" + cant + ")");
                    }
                    else{
                        lineas.add(String.valueOf(actLineNumber + 1));
                    }
                }*/
            }
            else if(unToken.getLexema().equals(aToken.getLexema()) && actLineNumber != aToken.getLineNumber()){
                if (cant > 1){
                    lineas.add((actLineNumber + 1) + "(" + cant + ")");
                }
                else{
                    lineas.add(String.valueOf(actLineNumber + 1));
                }
                cant = 0;
                actLineNumber = aToken.getLineNumber();
                i--;
            }
        }
        if (cant > 1){
            lineas.add((actLineNumber + 1) + "(" + cant + ")");
        }
        else {
            lineas.add(String.valueOf(actLineNumber + 1));
        }
        for(int i = 0; i < lineas.size(); i++){
            if (i == lineas.size()-1){
                linea = linea.concat(lineas.get(i));
            }
            else{
                linea = linea.concat(lineas.get(i) + ", ");
            }
        }
        System.out.println("La linea generada es: " + linea);
        return linea;
    }



    public void colocarTokens( ){
        borrarTabla(tableAceptados); //limpio la tabla sin borrar el texto en el textArea
        borrarTabla(tablaErrores);
        DefaultTableModel modelAceptados =(DefaultTableModel) tableAceptados.getModel();
        DefaultTableModel modelErrores = (DefaultTableModel) tablaErrores.getModel();
        modelAceptados.setColumnIdentifiers(new String[]{"Token", "Lexema", "Linea", "Cantidad"});
        modelErrores.setColumnIdentifiers(new String[]{"Error", "Lexema", "Linea", "Cantidad"});


        for(int i = 0; i < listaTokens.size(); i++){
            Token unToken = listaTokens.get(i);
            if(unToken.getType().equals(TokensConstants.ERROR) ){
                //si es error va para la tabla de errores
                int fila = lexemaExiste(tablaErrores, unToken.getLexema());
                if(fila == -1){
                    //no existe el lexema en la tabla de errores
                    modelErrores.addRow(new Object[]{unToken.getType(), unToken.getLexema(), agregarLineas(unToken), 1});//String.valueOf(unToken.getLineNumber())
                }else{
                    //existe el lexema en la tabla de errore
                    modelErrores.setValueAt((int)modelErrores.getValueAt(fila, 3)+1, fila, 3);
                }
            }else{ //de lo contrario va para la tabla de aceptados
                int fila = lexemaExiste(tableAceptados, unToken.getLexema());
                if(fila == -1){
                    //no existe el lexema en la tabla de aceptados
                    modelAceptados.addRow(new Object[]{unToken.getType(), unToken.getLexema(), agregarLineas(unToken), 1});
                }else{
                    //existe el lexema en la tabla de aceptados
                    modelAceptados.setValueAt((int)modelAceptados.getValueAt(fila, 3)+1, fila, 3);

                }

            }

        }
        tableAceptados.setModel(modelAceptados);
        tablaErrores.setModel (modelErrores);
        listaTokens.clear();
    }



}





