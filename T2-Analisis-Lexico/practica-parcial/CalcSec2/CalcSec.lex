%%
%int

%{

	int res = 1;
	int accP = 1;

%}

%xstate SUMA, RESTA, MULTIPLICACION, DIVISION
%xstate PARENTESIS
%xstate SUMAP, RESTAP, MULTIPLICACIONP, DIVISIONP

//%debug

%%

0 | [1-9][0-9]*						{res = Integer.parseInt(yytext());}

\+									{yybegin(SUMA);}

\-									{yybegin(RESTA);}

\*									{yybegin(MULTIPLICACION);}

\/									{yybegin(DIVISION);}

\(									{yybegin(PARENTESIS);}

;									{System.out.println(res);}

[^]									{}

<SUMA> {

	0 | [1-9][0-9]*						{
											
											res += Integer.parseInt(yytext());
											yybegin(YYINITIAL);
										}
	[^]									{}
}

<RESTA> {

	0 | [1-9][0-9]*						{
											
											res -= Integer.parseInt(yytext());
											yybegin(YYINITIAL);
										}
	[^]									{}
}

<MULTIPLICACION> {

	0 | [1-9][0-9]*						{
											
											res *= Integer.parseInt(yytext());
											yybegin(YYINITIAL);
										}
	[^]									{}
}

<DIVISION> {

	0 | [1-9][0-9]*						{
											
											res /= Integer.parseInt(yytext());
											yybegin(YYINITIAL);
										}
	[^]									{}
}

<PARENTESIS> {

	0 | [1-9][0-9]*						{accP = Integer.parseInt(yytext());}

	\+									{yybegin(SUMAP);}

	\-									{yybegin(RESTAP);}

	\*									{yybegin(MULTIPLICACIONP);}

	\/									{yybegin(DIVISIONP);}

	\(									{

											res *= accP;
											accP = 1;

										}

	\)									{
											
											res *= accP;
											accP = 1;
											yybegin(YYINITIAL);

										}
	[^]									{}
}

<SUMAP> {

	0 | [1-9][0-9]*						{
											
											accP += Integer.parseInt(yytext());
											yybegin(PARENTESIS);
										}
	[^]									{}
}

<RESTAP> {

	0 | [1-9][0-9]*						{
											
											accP -= Integer.parseInt(yytext());
											yybegin(PARENTESIS);
										}
	[^]									{}
}

<MULTIPLICACIONP> {

	0 | [1-9][0-9]*						{
											
											accP *= Integer.parseInt(yytext());
											yybegin(PARENTESIS);
										}
	[^]									{}
}

<DIVISIONP> {

	0 | [1-9][0-9]*						{
											
											accP /= Integer.parseInt(yytext());
											yybegin(PARENTESIS);
										}
	[^]									{}
}