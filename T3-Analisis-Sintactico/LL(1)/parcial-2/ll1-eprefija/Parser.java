import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

class Parser {

	// Tokens
	public final static int EOF = Yylex.EOF;
	public final static int NUMERO = Yylex.NUMERO ;         
	public final static int MAS = Yylex.MAS ;
	public final static int MENOS = Yylex.MENOS ;
	public final static int POR = Yylex.POR ;
	public final static int DIV = Yylex.DIV ;
	public final static int AP = Yylex.AP; // Abre parentesis
	public final static int CP = Yylex.CP; // Cierra parentesis
	public final static int NOPER = Yylex.NOPER;
	public final static int MAXPROF = Yylex.MAXPROF;
	public final static int EVAL = Yylex.EVAL;

	private final static int INDEFINIDO = -1;

	private static int nOp = 0;
	private static int maxD = 0;
	    
	private static int token; // token que se acaba de leer
	private static int valor; // valor del token (si es un numero)
	private static Yylex lex;
	private static int yylex() {
		int token = 0;
		try {
			token = lex.yylex();
	        if (token == NUMERO) {
	            valor = lex.yylval;
	        } else {
	            valor = INDEFINIDO;
	        }
		} catch (IOException e) {
			System.out.println("ERROR");
			System.exit(0);
		}
		return token;
	}

	private static void error() {
	    System.out.println("ERROR");
	    System.exit(0);
	}

	public static void main(String[] arg) {
	    if (arg.length>0) {
	        try {
	            lex = new Yylex(new FileReader(arg[0]));
	            token = yylex();
	            axioma();
	        } catch (IOException e) {
	        } 
	    }
	}

	public static void axioma() {
		switch (token) {
			case NUMERO:
			case MAS:
			case MENOS:
			case POR:
			case DIV:
				exp();
				if (token == EOF) {
					System.out.println("CORRECTO");
				} else {
					error();
				};
				break;
			case NOPER:
				token = yylex();
				if (token == AP) {
					token = yylex();
				} else {
					error();
				}
				exp();
				if (token == CP) {
					token = yylex();
				} else {
					error();
				}
				if (token == EOF) {
					System.out.print("NOPER=" + nOp);
				} else {
					error();
				}
				break;
			case MAXPROF:
				token = yylex();
				if (token == AP) {
					token = yylex();
				} else {
					error();
				}
				maxD = expProf();
				if (token == CP) {
					token = yylex();
				} else {
					error();
				}
				if (token == EOF) {
					System.out.print("MAXPROF=" + maxD);
				} else {
					error();
				}
				break;
			case EVAL:
				token = yylex();
				if (token == AP) {
					token = yylex();
				} else {
					error();
				}
				int resultado = expEval();
				if (token == CP) {
					token = yylex();
				} else {
					error();
				}
				if (token == EOF) {
					System.out.print("EVAL=" + resultado);
				} else {
					error();
				}
				break;
			default:
				error();
				break;
		}
	}

	public static void exp() {
		switch (token) {
			case MAS:
			case MENOS:
			case POR:
			case DIV:
				op();
				exp();
				exp();
				break;
			case NUMERO:
				token = yylex();
				break;
			default:
				error();
				break;
		}
	}

	public static void op() {
		switch (token) {
			case MAS:
			case MENOS:
			case POR:
			case DIV:
				nOp++;
				token = yylex();
				break;
			default:
				error();
				break;
		}
	}

	public static int expProf() {
		int prof = 0;
		switch (token) {
			case MAS:
			case MENOS:
			case POR:
			case DIV:
				token = yylex();
				int prof1 = expProf();
				int prof2 = expProf();
				// Después de evaluar exp1, su resultado está en la pila (nivel 1)
				// Luego evaluamos exp2 desde ese nivel
				prof = Math.max(prof1 + 1, prof2 + 1);
				break;
			case NUMERO:
				token = yylex();
				prof = 0;
				break;
			default:
				error();
				break;
		}
		return prof;
	}

	public static int expEval() {
		int resultado = 0;
		switch (token) {
			case MAS:
				token = yylex();
				int val1_suma = expEval();
				int val2_suma = expEval();
				resultado = val1_suma + val2_suma;
				break;
			case MENOS:
				token = yylex();
				int val1_resta = expEval();
				int val2_resta = expEval();
				resultado = val1_resta - val2_resta;
				break;
			case POR:
				token = yylex();
				int val1_mult = expEval();
				int val2_mult = expEval();
				resultado = val1_mult * val2_mult;
				break;
			case DIV:
				token = yylex();
				int val1_div = expEval();
				int val2_div = expEval();
				resultado = val1_div / val2_div;
				break;
			case NUMERO:
				resultado = valor;
				token = yylex();
				break;
			default:
				error();
				break;
		}
		return resultado;
	}

}
