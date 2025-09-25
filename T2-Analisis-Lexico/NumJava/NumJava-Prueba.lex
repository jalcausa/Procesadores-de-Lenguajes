%%

%%

0 | [1-9][0-9]* | 0x[0-9a-fA-F]+ | 0[0-7]+																{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, yytext());}

(0 | [1-9][0-9]* | 0x[0-9a-fA-F]+ | 0[0-7])+ (l|L)														{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO, yytext());}

(([0-9]* ([eE][+-]?[0-9]*)? \. ([0-9]* ([eE][+-]?[0-9]+)?)) | ([0-9]+[eE][+-]?[0-9]*)) [dD]?			{return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO, yytext());}

(([0-9]* ([eE][+-]?[0-9]*)? \. ([0-9]* ([eE][+-]?[0-9]+)?)) | ([0-9]+[eE][+-]?[0-9]*)) [fF]				{return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO, yytext());}

[ \t\r\n]+																								{}

// Errores en octales
0[0-7]*[89][0-9]*																						{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

// Errores en hexadecimales
0+x																										{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}
00+x[0-9a-fA-F]+																						{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}
0+x[0-9a-fA-F]*[g-zG-z][a-zA-Z0-9]*																		{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

// Errores en números reales
\.[eE][+-]?[0-9]*																						{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}
[0-9]+([eE][+-]?[0-9]*)?\.																				{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

// Error general
[^]																										{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}