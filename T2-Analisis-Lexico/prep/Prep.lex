%%

%int

id = [a-zA-Z][a-zA-Z0-9_]*

%xstate DEF, IF, IFDEF, IFNDEF, ERROR, IGNORAR_RESTO_LINEA

%{

	String key = "";
	String value = "";
	boolean flag = false;
%}

//%debug

%%

^#define" "+ / {id}+								{yybegin(DEF);}

^#define" "+										{
														System.out.println("ERROR_DEFINICION");
														yybegin(ERROR);
													}

\$\{{id}\}										{
														if (TablaSimbolos.get("$" + yytext().substring(2, yytext().length() - 1)) == "") {
															System.out.print("ID_NO_DEFINIDO");
														} else {
															System.out.print(TablaSimbolos.get("$" + yytext().substring(2, yytext().length() - 1)));
														}
												}

^#ifdef" "										{
													yybegin(IF);
												}

^#endif.*										{System.out.print("ERROR_ENDIF_SIN_IF");}

[^]												{System.out.print(yytext());}

<DEF> {

	{id}+											{key = yytext().trim();}
	" "+.+											{
														value = yytext().trim();
														TablaSimbolos.put(key, value);
														//TablaSimbolos.dump();
														key = "";
														value = "";
													}
	\n												{yybegin(YYINITIAL);}
}

<ERROR> {
	.												{}
	\n												{yybegin(YYINITIAL);}
}

<IF> {
	{id}										{
														if (TablaSimbolos.get("$"+yytext()) == "") {
															flag = false;
														} else {
															flag = true;
														}
														yybegin(IGNORAR_RESTO_LINEA);
												}
}
<IGNORAR_RESTO_LINEA>{
	.											{}
	\n											{
														if (flag) {
															yybegin(IFDEF);
														} else {
															yybegin(IFNDEF);
														}
												}
}

<IFNDEF> {
	^#endif\n										{yybegin(YYINITIAL);}
	^#define" "+.*									{System.out.print("ERROR_DEFINE_EN_IF");}
	^#ifdef" ".*									{System.out.print("ERROR_IF_ANIDADO");}
	[^]												{}
}

<IFDEF> {
	^#endif\n										{yybegin(YYINITIAL);}
	^#endif" ".*\n									{yybegin(YYINITIAL);}
	^#endif.*										{System.out.print(yytext());}
	\$\{{id}\}										{
														if (TablaSimbolos.get("$" + yytext().substring(2, yytext().length() - 1)) == "") {
															System.out.print("ID_NO_DEFINIDO");
														} else {
															System.out.print(TablaSimbolos.get("$" + yytext().substring(2, yytext().length() - 1)));
														}
													}
	^#define" "+.*									{System.out.print("ERROR_DEFINE_EN_IF");}
	^#ifdef" ".*									{System.out.print("ERROR_IF_ANIDADO");}
	[^]												{System.out.print(yytext());}
}