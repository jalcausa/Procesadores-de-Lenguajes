%%

%int

%%

// S1
[A-Z][A-Z]?-?[1-9][0-9]{0,5}			{System.out.print("S1");}

// S2
[A-Z][A-Z]?-?[0-9]{4}-?[A-PS-Z]{1,2}	{System.out.print("S2");}

// S3
[0-9]{4}-?[BCDFGHJKLMNOPRSTUVWXYZ]{3}	{System.out.print("S3");}

[^\ \t\n,]+								{System.out.print("X");}

[^]										{System.out.print(yytext());}