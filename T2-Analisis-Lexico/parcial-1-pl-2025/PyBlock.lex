%%
%int

%{

	int nLinea = 0;
	int nBloque = 0;

%}

%xstate BLOQUE, LINEAOK, ERROR
//%debug
%%

:\n						{
							nBloque++;
							nLinea++;
							System.out.print(nLinea + " ");
							System.out.print("{" + " ");
							yybegin(BLOQUE);
						}

\n						{
							nLinea++;
							System.out.print(nLinea + " ");
						}

[^]						{}

<BLOQUE> {

	^" "+				{

							if (yytext().length() == nBloque * 4) {
								yybegin(LINEAOK);
							} else if (yytext().length() < nBloque * 4 && yytext().length() % 4 == 0) {
								nBloque--;
								if (nBloque == 0)
									yybegin(YYINITIAL);
								else
									System.out.print("} ");
									yybegin(LINEAOK);
							} else {
								System.out.print("ERROR LEXICO");
								yybegin(ERROR);
							}

						}
	[^\ ].+				{
							nBloque = 0;
							yybegin(YYINITIAL);
						}
}

<LINEAOK> {
	:\n / " "+			{
							nLinea++;
							System.out.print(nLinea + " ");
							nBloque++;
							System.out.print("{" + " ");
							yybegin(BLOQUE);
						}
	\n / " "+			{
							nLinea++;
							System.out.print(nLinea + " ");
							yybegin(BLOQUE);
						}
	\n					{
							if (nBloque > 1)
							{
								for (int i = 0; i < nBloque - 1; ++i)
									System.out.print("} ");
							}
							nBloque = 0;
							nLinea++;
							System.out.print(nLinea + " ");
							System.out.print("} ");
							yybegin(YYINITIAL);
						}
	.					{}
}

<ERROR> {
	[^]					{}
}