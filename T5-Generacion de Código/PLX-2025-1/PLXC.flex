import java_cup.runtime.*;

%%

%cup

%%

<YYINITIAL>{
    print                               {return new Symbol(sym.PRINT); }
    int                                 {return new Symbol(sym.INT); }
    if                                  {return new Symbol(sym.IF); }
    else                                {return new Symbol(sym.ELSE); }
    while                               {return new Symbol(sym.WHILE); }
    do                                  {return new Symbol(sym.DO); }
    for                                 {return new Symbol(sym.FOR); }
    repeat                              {return new Symbol(sym.REPEAT); }
    times                               {return new Symbol(sym.TIMES); }
    select                              {return new Symbol(sym.SELECT); }
    first                               {return new Symbol(sym.FIRST); }
    last                                {return new Symbol(sym.LAST); }
    from                                {return new Symbol(sym.FROM); }
    to                                  {return new Symbol(sym.TO); }
    step                                {return new Symbol(sym.STEP); }
    default                             {return new Symbol(sym.DEFAULT); }
    where                               {return new Symbol(sym.WHERE); }
    ";"                                 {return new Symbol(sym.PYC); }
    ","                                 {return new Symbol(sym.COMA); }
    "("                                 {return new Symbol(sym.AP); }
    ")"                                 {return new Symbol(sym.CP); }
    "{"                                 {return new Symbol(sym.ALL); }
    "}"                                 {return new Symbol(sym.CLL); }
    "+"                                 {return new Symbol(sym.MAS); }
    "-"                                 {return new Symbol(sym.MENOS); }
    "*"                                 {return new Symbol(sym.POR); }
    "/"                                 {return new Symbol(sym.DIV); }
    "<<"                                {return new Symbol(sym.SHIFTIZQ); }
    ">>"                                {return new Symbol(sym.SHIFTDER); }
    "="                                 {return new Symbol(sym.IGUAL); }
    "=="                                {return new Symbol(sym.IGUALDAD); }
    "!="                                {return new Symbol(sym.NOIGUALDAD); }
    "<="                                {return new Symbol(sym.MENOREQ); }
    ">="                                {return new Symbol(sym.MAYOREQ); }
    "<"                                 {return new Symbol(sym.MENOR); }
    ">"                                 {return new Symbol(sym.MAYOR); }
    "!"                                 {return new Symbol(sym.NOT); }
    "&&"                                {return new Symbol(sym.AND); }
    "||"                                {return new Symbol(sym.OR); }
    0|[1-9][0-9]*                       {return new Symbol(sym.ENTERO, yytext()); }
    [a-zA-Z][a-zA-Z0-9]*                {return new Symbol(sym.IDENT, yytext()); }
    [^]                                 {}
}
