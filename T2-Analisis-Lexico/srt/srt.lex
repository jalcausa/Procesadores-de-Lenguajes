%%

NSub = [1-9][0-9]*[\n]

Time = [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]

Timestamp = {Time}[\ ]* -->[\ ]*{Time}[\n]

Subs = (.+\n)+\n


%xstate ERROR
%xstate SUBS

//%debug

%%

{NSub} / {Timestamp} {Subs}				{return new Yytoken(Yytoken.NSUB, yytext());}

{NSub}.+								{yybegin(ERROR);}

{Timestamp} / {Subs}					{   
											yybegin(SUBS);
											return new Yytoken(Yytoken.TIMESTAMP, yytext());
										}

{Timestamp}.+							{yybegin(ERROR);}

<SUBS> {
	{Subs}								{
											yybegin(YYINITIAL);
											return new Yytoken(Yytoken.SUBS, yytext());
										}
}



[\ \t\n]								{}

[^]										{yybegin(ERROR);}




<ERROR> {
	\n\n+{Timestamp}?				{yybegin(YYINITIAL);}

	[^]					{}
}