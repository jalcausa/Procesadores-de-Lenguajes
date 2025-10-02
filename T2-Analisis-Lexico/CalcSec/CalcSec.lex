%%

%{
	private static int acc = 1;
	private static int pAcc = 1;

	private void sum(String lexema, int p) {
		lexema = lexema.trim();
		String[] parts = lexema.split("\\+");
		if (p == 0)
			acc += Integer.parseInt(parts[1]);
		else
			pAcc += Integer.parseInt(parts[1]);
	}

	private void substract(String lexema, int p) {
		lexema = lexema.trim();
		String[] parts = lexema.split("\\-");
		if (p == 0)
			acc -= Integer.parseInt(parts[1]);
		else
			pAcc -= Integer.parseInt(parts[1]);
	}

	private void multiply(String lexema, int p) {
		lexema = lexema.trim();
		String[] parts = lexema.split("\\*");
		if (p == 0)
			acc *= Integer.parseInt(parts[1]);
		else
			pAcc *= Integer.parseInt(parts[1]);
	}

	private void divide(String lexema, int p) {
		lexema = lexema.trim();
		String[] parts = lexema.split("\\/");
		if (p == 0)
			acc /= Integer.parseInt(parts[1]);
		else
			pAcc /= Integer.parseInt(parts[1]);
	}
%}

%int

%xstate PARENTESIS

//%debug

%%

[0-9]+												{acc = Integer.parseInt(yytext());}

\+[0-9]+											{sum(yytext(), 0);}

\-[0-9]+											{substract(yytext(), 0);}

\*[0-9]+											{multiply(yytext(), 0);}

\/[0-9]+											{divide(yytext(), 0);}

;													{System.out.println(acc);}

\(													{yybegin(PARENTESIS);}

[^]													{}

<PARENTESIS> {
	
	[0-9]+												{pAcc = Integer.parseInt(yytext());}

	\+[0-9]+											{sum(yytext(), 1);}

	\-[0-9]+											{substract(yytext(), 1);}

	\*[0-9]+											{multiply(yytext(), 1);}

	\/[0-9]+											{divide(yytext(), 1);}

	\(													{

															acc *= pAcc;
															pAcc = 1;

														}

	\)													{
															
															acc *= pAcc;
															pAcc = 1;
															yybegin(YYINITIAL);

														}
}

// Se puede rehacer para que la operación se haga directamente en las acciones de jflex y ahorrarnos tantas funciones