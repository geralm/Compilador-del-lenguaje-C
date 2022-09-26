package CompiladorC;

public class Token {
    private TokensConstants type;
    private String lexema;
    private int lineNumber;

    public Token() {
    }

    public Token(TokensConstants type, String lexema, int lineNumber) {
        this.type = type;
        this.lexema = lexema;
        this.lineNumber = lineNumber;
    }

    public TokensConstants getType() {
        return type;
    }

    public void setType(TokensConstants type) {
        this.type = type;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }


    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexema='" + lexema + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                '}';
    }
}
