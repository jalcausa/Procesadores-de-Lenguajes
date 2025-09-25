public class Yytoken {
	public static final int WORD = 1;
	public static final int NL = 2;
	public static final int CHARACTER = 3;

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