package CompiladorC;

public class Token {
    private TokensConstants type;
    private String lexema;

    public Token() {
    }

    public Token(TokensConstants type, String lexema) {
        this.type = type;
        this.lexema = lexema;
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

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexema='" + lexema + '\'' +
                '}';
    }
}
