%%


%{

	int lCommentCount = 0;
	int nCommentCount = 0;
	int dCommentCount = 0;

%}

%eof{
	System.out.println("//" + "  " + lCommentCount);
	System.out.println("/*" + "  " + nCommentCount);
	System.out.println("/**" + " " + dCommentCount);
%eof}

%state LCOMMENT
%state NCOMMENT
%state DCOMMENT
%state STRING

%int
//%debug

%%

<YYINITIAL> {

	\/\/				{yybegin(LCOMMENT);}
	\/\*				{yybegin(NCOMMENT);}
	\/\*\*				{yybegin(DCOMMENT);}
	\"					{yybegin(STRING);}
	[^]					{}
}

<LCOMMENT> {

	[^ \t\n]			{lCommentCount++;}
	[\n]				{yybegin(YYINITIAL);}
	[^]					{}
}

<NCOMMENT> {

	\*\/				{yybegin(YYINITIAL);}
	[^ \t\n]			{nCommentCount++;}
	[^]						{}
}


<DCOMMENT> {
	\*\/				{yybegin(YYINITIAL);}
	[^ \t\n]			{dCommentCount++;}
	[^]					{}
}

<STRING> {
	\"					{yybegin(YYINITIAL);}
	\\\"				{}
	[^]					{}
}