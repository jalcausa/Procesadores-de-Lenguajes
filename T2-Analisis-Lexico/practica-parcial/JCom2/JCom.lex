%%

%int

%{

	int	nLinea = 0;
	int nBloque = 0;
	int nDoc = 0;

%}

%eof{

	System.out.println("//  " + nLinea);
	System.out.println("/*  " + nBloque);
	System.out.println("/** " + nDoc);

%eof}

%xstate CLINEA, CBLOQUE, CDOC, COMILLAS

//%debug

%%

\/\/											{yybegin(CLINEA);}

\/\*											{yybegin(CBLOQUE);}

\/\*\*											{yybegin(CDOC);}

\"												{yybegin(COMILLAS);}

[^]												{}

<CLINEA> {

	\n											{yybegin(YYINITIAL);}

	[^\ \t]										{nLinea++;}

	[^]											{}

}

<CBLOQUE> {

	\*\/										{yybegin(YYINITIAL);}

	[^\ \t\n]									{nBloque++;}

	[^]											{}

}

<CDOC> {

	\*\/										{yybegin(YYINITIAL);}

	[^\ \t\n]									{nDoc++;}

	[^]											{}

}

<COMILLAS> {

	\"											{{yybegin(YYINITIAL);}}

	\\\"										{}

	[^]											{}

}