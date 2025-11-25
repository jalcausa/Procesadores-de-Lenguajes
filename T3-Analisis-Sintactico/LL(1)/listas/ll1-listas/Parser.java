import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

class Parser {

public final static int EOF = Yylex.EOF;
public final static int NUMERO = Yylex.NUMERO ;         
public final static int COMA = Yylex.COMA;
public final static int AC = Yylex.AC; // Abre corchete
public final static int CC = Yylex.CC; // Cierra corchete
public final static int AP = Yylex.AP; // Abre parentesis
public final static int CP = Yylex.CP; // Cierra parentesis
public final static int NELEM = Yylex.NELEM;         
public final static int MAXDEPTH = Yylex.MAXDEPTH;         
public final static int MAXLENGTH = Yylex.MAXLENGTH;         
	
private static int token;
private static Yylex lex;

private static int nElemB = 0;
private static int nAbreC = 0;
private static int maxDepth = 0;
private static int maxLength = 0;

private static int yylex() {
	int token = 0;
	try {
		token = lex.yylex();
	} catch (IOException e) {
		System.out.println("ERROR");
		System.exit(0);
	}
	return token;
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

private static void error() {
	System.out.println("ERROR");
	System.exit(1);
}

private static void axioma() {
	switch ((token)) {
		case AC:
			lista();
			if (token == EOF) {
				System.out.println("Correcto");
			} else {
				error();
			}
			break;
		case NELEM:
			token = yylex();
			if (token == AP) token = yylex();
			lista();
			if (token == CP) token = yylex();
			if (token == EOF) {
				System.out.print("NELEM=" + nElemB);
			} else {
				error();
			}
			break;
		case MAXDEPTH:
			token = yylex();
			if (token == AP) token = yylex();
			lista();
			if (token == CP) token = yylex();
			if (token == EOF) {
				System.out.print("MAXDEPTH=" + maxDepth);
			} else {
				error();
			}
			break;
		case MAXLENGTH:
			token = yylex();
			if (token == AP) token = yylex();
			lista();
			if (token == CP) token = yylex();
			if (token == EOF) {
				System.out.print("MAXLENGTH=" + maxLength);
			} else {
				error();
			}
			break;
		default:
			error();
	}
}

private static int lista() {
	int nElem = 0;
	switch (token) {
		case AC:
			token = yylex();
			nAbreC++;
			maxDepth = Math.max(maxDepth, nAbreC);
			nElem = restoLista();
			maxLength = Math.max(maxLength, nElem);
			break;
	
		default:
			error();
	}
	return nElem;
}

private static int restoLista() {
	int nElem = 0;
	switch (token) {
		case CC:
			token = yylex();
			nAbreC--;
			break;
		case AC:
		case NUMERO:
			nElem = listaElem();
			if (token == CC) {
				token = yylex();
				nAbreC--;
			}
			break;
		default:
			error();
	}
	return nElem;
}

private static int listaElem() {
	int nElem = 0;
	switch (token) {
		case AC:
		case NUMERO:
			nElem = elem() + restoElem();
			break;
		default:
			error();
	}
	return nElem;
}

private static int restoElem() {
	int nElem = 0;
	switch (token) {
		case CC:
			break;
		case COMA:
			token = yylex();
			nElem = listaElem();
			break;
		default:
			error();
	}
	return nElem;
}

private static int elem() {
	int nElem = 0;
	switch (token) {
		case AC:
			lista();
			nElem = 1;
			break;
		case NUMERO:
			token = yylex();
			nElemB++;
			nElem = 1;
			break;
		default:
			error();
	}
	return nElem;
}

}