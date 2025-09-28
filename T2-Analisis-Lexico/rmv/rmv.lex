%%

%int

var = [a-zA-Z_][a-zA-Z_0-9_]*
cmd = [a-zA-Z][a-zA-Z_0-9_]*
special = (\\).

%state ASIG
%state ARGS
%state QUOTES

%{
	String key = "";
	String value = "";

%}


//%debug

%%

<YYINITIAL> {

	/* Se reconoce una asignación de variable */
	{var}=		{
					key = yytext().substring(0, yytext().length() - 1);
					yybegin(ASIG);
				}

	/* Se reconoce un comando */
	{cmd}" "	{

					System.out.print(yytext());
					yybegin(ARGS);
				
				}

	[^]			{}

}

<ASIG> {

	/* Hay comillas, se deben incluir espacios */
	\"			{yybegin(QUOTES);}

	/* Hay otra variable dentro de la asignacion */
	\${var}		{value += TablaSimbolos.get(yytext());}

	/* Texto normal */
	{special} | [^\ \t\n;|]		{value += yytext();}

	/* Final de la asignación */
	[\ \t\n;|]					{

									TablaSimbolos.put(key, value);
									key = "";
									value = "";
									yybegin(YYINITIAL);
								}

}

<QUOTES> {

	/* Hay alguna variable dentro */
	\${var}				{ value += TablaSimbolos.get(yytext());}

	/* Texto normal */
	{special} | [^\"]	{ value += yytext();}

	\"					{
							TablaSimbolos.put(key, value);
							key = "";
							value = "";
							yybegin(YYINITIAL);
						}
}

<ARGS>{

	/* Se reconoce una variable */
	\${var}				{System.out.print(TablaSimbolos.get(yytext()));}

	/* El resto se deja igual */
	[^]					{System.out.print(yytext());}
}