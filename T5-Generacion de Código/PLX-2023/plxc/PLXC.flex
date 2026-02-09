import java_cup.runtime.*;

%%

%cup

%%

"int"                                                   {return new Symbol(sym.INT); }
"float"                                                 {return new Symbol(sym.FLOAT); }
"char"                                                  {return new Symbol(sym.CHAR); }
"set"                                                   {return new Symbol(sym.SET); }
","                                                     {return new Symbol(sym.COMA); }
";"                                                     {return new Symbol(sym.PYC); }
"("                                                     {return new Symbol(sym.AP); }
")"                                                     {return new Symbol(sym.CP); }
"{"                                                     {return new Symbol(sym.ALL); }
"}"                                                     {return new Symbol(sym.CLL); }
print                                                   {return new Symbol(sym.PRINT); }
"+="                                                    {return new Symbol(sym.MASIGUAL); }
"-="                                                    {return new Symbol(sym.MENOSIGUAL); }
"*="                                                    {return new Symbol(sym.PORIGUAL); }
"+"                                                     {return new Symbol(sym.MAS); }
"-"                                                     {return new Symbol(sym.MENOS); }
"*"                                                     {return new Symbol(sym.POR); }
"="                                                     {return new Symbol(sym.IGUAL); }
[a-zA-Z][a-zA-Z0-9]*                                    {return new Symbol(sym.IDENT, yytext()); }
0|[1-9][0-9]*                                           {return new Symbol(sym.ENTERO, yytext()); }
(([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)([eE][+-]?[0-9]+)?)     {return new Symbol(sym.REAL, yytext()); }
\'[^']\'                                                {return new Symbol(sym.CARACTER, String.valueOf((int)yytext().charAt(1))); }
[^]                                                     {}
