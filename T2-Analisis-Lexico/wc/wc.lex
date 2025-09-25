%%

%%

[^\ \t\n]+					{return new Yytoken(Yytoken.WORD, yytext());}

\n							{return new Yytoken(Yytoken.NL, yytext());}

[^]							{return new Yytoken(Yytoken.CHARACTER, yytext());}
