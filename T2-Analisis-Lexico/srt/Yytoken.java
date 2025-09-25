public class Yytoken {
    public final static int NSUB = 1;
    public final static int TIMESTAMP = 2;
    public final static int SUBS = 3;

    private int token;
	private int valor;
	private String lexema;

	public Yytoken(int token, int valor, String lexema) {
		this.token = token;
		this.valor = valor;
		this.lexema = lexema;
	}
	public Yytoken(int token, int valor) {
		this(token, valor, String.valueOf(valor));
	}
	public Yytoken(int token, String lexema) {
		this(token, 0, lexema);
	}
	public int getToken() {
		return token;
	}
	public int getValor() {
		return valor;
	}
	public String getLexema() {
		return lexema;
	}
	public String toString() {
		return "<"+token+","+valor+","+lexema+">";
	}
}
