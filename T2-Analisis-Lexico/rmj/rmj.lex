%%
%int
var = [a-zA-Z_][a-zA-Z_0-9_]*
special = (\\).


%{
	String key = "";
	String value = "";

%}

%state ASIG
%state PRINT

//%debug

%%

<YYINITIAL> {

	class" "[^\ \t\n]+		{System.out.print("class " + yytext().substring(6, yytext().length()) + "_rmj");}

	String" "{var}+" "=		{
								key = yytext().substring(7, yytext().length()-2);
								yybegin(ASIG);
							}

	String" "{var}+=		{
								key = yytext().substring(7, yytext().length()-1);
								yybegin(ASIG);
							}

	{var}+" "=				{
								key = yytext().substring(0, yytext().length()-2);
								yybegin(ASIG);
							}

	System.out.print(ln)?" "*\(	{

									System.out.print(yytext() + "\"");
									yybegin(PRINT);

								}

	[^]						{System.out.print(yytext());}

}

<ASIG> {

	\"([^\"] | {special})* \"	{value += yytext().substring(1, yytext().length()-1);}
	{var}+						{value += TablaSimbolos.get(yytext());}
	;							{
									TablaSimbolos.put(key, value);
									key = "";
									value = "";
									yybegin(YYINITIAL);
								}
	[^]							{}	
}

<PRINT> {

	\"([^\"\\] | {special})* \"	{System.out.print(yytext().substring(1, yytext().length()-1));}
	{var}+						{System.out.print(TablaSimbolos.get(yytext()));}
	\);							{
									System.out.print("\"" + yytext());
									yybegin(YYINITIAL);
								}
	[^]							{}	

}