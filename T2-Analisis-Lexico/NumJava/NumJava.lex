%%

%%

// Enteros en decimal
0 | [1-9][0-9]*							{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, yytext());}

// Enteros en octal
[0-7]+									{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, yytext());}

// Enteros en hexadecimal
0x[0-7a-fA-F]+							{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, yytext());}

// Entero largo
0 | [1-9][0-9]*	[Ll]					{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO, yytext());}
[0-7]+ [Ll]								{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO, yytext());}
0x[0-7a-fA-F]* [Ll]						{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO, yytext());}

// Errores en octal: todos los que sean correctos entran por la de arriba porque está antes
0[0-9]+									{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

// Errores en hexadecimal
0+x[0-9a-zA-Z]*							{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

// Decimales sin exponente
[0-9]+\.[0-9]*[Dd]? 				|
[0-9]*\.[0-9]+[Dd]?					|

// Reales largos con d sin parte decimal
[0-9]+[dD]							|

// Decimales con exponente
[0-9]+[Ee][+-]?[0-9]+[Dd]?			|
[0-9]+\.[0-9]*[Ee][+-]?[0-9]+[Dd]?	|
[0-9]*\.[0-9]+[Ee][+-]?[0-9]+[Dd]?		{return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO, yytext());}


// Decimales cortos sin exponente
[0-9]+\.[0-9]*[fF] 					|
[0-9]*\.[0-9]+[fF]					|

// Decimales cortos sin parte decimal
[0-9]+[fF]							|

// Decimales cortos con exponente
[0-9]+[Ee][+-]?[0-9]+[fF]			|
[0-9]+\.[0-9]*[Ee][+-]?[0-9]+[fF]	|
[0-9]*\.[0-9]+[Ee][+-]?[0-9]+[fF]		{return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO, yytext());}

// Errores en reales largos
[0-9.eEa-zA-Z+-]+						{return new Yytoken(Yytoken.TOKEN_ERROR, yytext());}

[^]					{}

/* Activar hexadecimal en vim :%!xxd
NO guardarlo, salir con q!

Para borrar lo que escribe en hexadecimal si lo he guardado :%!xxd -r

*/