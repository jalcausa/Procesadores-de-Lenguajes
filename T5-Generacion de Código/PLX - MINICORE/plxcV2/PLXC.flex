import java_cup.runtime.*;

%%

%cup

%%

<YYINITIAL>{
    "int"                                                   {return new Symbol(sym.INT); }
    "float"                                                 {return new Symbol(sym.FLOAT); }
    "char"                                                  {return new Symbol(sym.CHAR); }
    "String"                                                {return new Symbol(sym.STRING); }
    ","                                                     {return new Symbol(sym.COMA); }
    ";"                                                     {return new Symbol(sym.PYC); }
    "("                                                     {return new Symbol(sym.AP); }
    ")"                                                     {return new Symbol(sym.CP); }
    "{"                                                     {return new Symbol(sym.ALL); }
    "}"                                                     {return new Symbol(sym.CLL); }
    "["                                                     {return new Symbol(sym.AC); }
    "]"                                                     {return new Symbol(sym.CC); }
    print                                                   {return new Symbol(sym.PRINT); }
    do                                                      {return new Symbol(sym.DO); }
    while                                                   {return new Symbol(sym.WHILE); }
    if                                                      {return new Symbol(sym.IF); }
    else                                                    {return new Symbol(sym.ELSE); }
    for                                                     {return new Symbol(sym.FOR); }
    "+"                                                     {return new Symbol(sym.MAS); }
    "-"                                                     {return new Symbol(sym.MENOS); }
    "*"                                                     {return new Symbol(sym.POR); }
    "/"                                                     {return new Symbol(sym.DIV); }
    "="                                                     {return new Symbol(sym.IGUAL); }
    "=="                                                    {return new Symbol(sym.IGUALDAD); }
    "!="                                                    {return new Symbol(sym.NOIGUALDAD); }
    "<"                                                     {return new Symbol(sym.MENOR); }
    ">"                                                     {return new Symbol(sym.MAYOR); }
    "<="                                                    {return new Symbol(sym.MENOREQ); }
    ">="                                                    {return new Symbol(sym.MAYOREQ); }
    "!"                                                     {return new Symbol(sym.NOT); }
    "&&"                                                    {return new Symbol(sym.AND); }
    "||"                                                    {return new Symbol(sym.OR); }
    [a-zA-Z][a-zA-Z0-9]*                                    {return new Symbol(sym.IDENT, yytext()); }
    0|[1-9][0-9]*                                           {return new Symbol(sym.ENTERO, yytext()); }
    (([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)([eE][+-]?[0-9]+)?)     {return new Symbol(sym.REAL, yytext()); }
    \"[^\"\r\n]*\"                                          {return new Symbol(sym.CADENA, yytext()); }
    \'[^\'\r\n]\'                                           {return new Symbol(sym.CARACTER, yytext());}
    [^]                                                     {}

}