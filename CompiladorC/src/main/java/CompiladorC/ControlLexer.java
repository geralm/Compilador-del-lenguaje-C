package CompiladorC;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class ControlLexer implements IControl <String>{
    private ArrayList<Token> listaTokens;

    public ControlLexer() {
        listaTokens = new ArrayList<Token>();
    }
    @Override
    public void limpiar() {
        listaTokens.clear();
    }
    @Override
    public void procesar(String cadena){
        LexerAnalyzer demoLexer  = new LexerAnalyzer(new StringReader(cadena));
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
    }
    public String agregarLineas(Token unToken){
        ArrayList<String> lineas = new ArrayList<>();
        int cant = 0;
        int actLineNumber = unToken.getLineNumber();
        String linea = "";
        for (int i = 0; i < listaTokens.size(); i++){
            Token aToken = listaTokens.get(i);
            if (unToken.getLexema().equals(aToken.getLexema()) && actLineNumber == aToken.getLineNumber()){
                cant++;
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
    public ArrayList<Token> getListaTokens() {
        return listaTokens;
    }




}
