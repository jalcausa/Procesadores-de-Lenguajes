import java_cup.runtime.*;

%%

%cup
//%debug

%xstate STRING
%xstate UNICODE
%xstate ABREMAIN
%xstate COMENTARIOBLOQUE
%xstate COMENTARIOLINEA

%{
    StringBuffer str = new StringBuffer();
    StringBuffer comentario = new StringBuffer();
    boolean mainIniciado = false;
%}


%%

<YYINITIAL>{
    "package"                                               {return new Symbol(sym.PAQUETE); }
    "import"                                                {return new Symbol(sym.IMPORTA); }
    "func"                                                  {yybegin(ABREMAIN); return new Symbol(sym.FUNCION); }
    "/*"                                                    {comentario.setLength(0); yybegin(COMENTARIOBLOQUE); }
    "*/"                                                    {Generador.error(Generador.E_CCOMENT);}
    "//"                                                    {comentario.setLength(0); yybegin(COMENTARIOLINEA); }
    "int"                                                   {return new Symbol(sym.INT); }
    "float"                                                 {return new Symbol(sym.FLOAT); }
    "char"                                                  {return new Symbol(sym.CHAR); }
    "string"                                                {return new Symbol(sym.STRING); }
    "bool"                                                  {return new Symbol(sym.BOOL); }
    ","                                                     {return new Symbol(sym.COMA); }
    ";"                                                     {return new Symbol(sym.PYC); }
    "("                                                     {return new Symbol(sym.AP); }
    ")"                                                     {return new Symbol(sym.CP); }
    "{"                                                     {return new Symbol(sym.ALL); }
    "}"                                                     {return new Symbol(sym.CLL); }
    "["                                                     {return new Symbol(sym.AC); }
    "]"                                                     {return new Symbol(sym.CC); }
    fmt.Print                                               {return new Symbol(sym.PRINT); }
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
    [a-zA-Z][a-zA-Z0-9_]*                                   {return new Symbol(sym.IDENT, yytext()); }
    0|[1-9][0-9]*                                           {return new Symbol(sym.ENTERO, yytext()); }
    (([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)([eE][+-]?[0-9]+)?)     {return new Symbol(sym.REAL, yytext()); }
    \"                                                      {str.setLength(0); yybegin(STRING); }                                          
    \'                                                      {str.setLength(0); yybegin(STRING); }
    [^]                                                     {}

}

<STRING>{
    \"                                                      {yybegin(YYINITIAL); return new Symbol(sym.CADENA, str.toString()); }
    \'                                                      {yybegin(YYINITIAL); return new Symbol(sym.CARACTER, String.valueOf((int) str.charAt(0))); }
    [^\n\r\"\'\\]+                                          {str.append(yytext()); }
    \\\"                                                    {str.append('\"'); }
    \\\'                                                    {str.append('\''); }
    \\                                                      {str.append('\\'); }
    \\\\                                                    {str.append('\\'); }
    \\u                                                     {yybegin(UNICODE); }

}

<UNICODE> {
    [a-zA-Z0-9]{4}                                          {
                                                                int code = Integer.parseInt(yytext(), 16); 
                                                                str.append((char)code); 
                                                                yybegin(STRING); 
                                                            }
}

<ABREMAIN> {
    "main"                                                  { return new Symbol(sym.FMAIN); }
    "("                                                     { return new Symbol(sym.AP); }
    ")"                                                     { return new Symbol(sym.CP); }
    "{"                                                     { 
                                                                mainIniciado = true; 
                                                                return new Symbol(sym.ALL); 
                                                            }
    [\n\r]                                                  { 
                                                                if(!mainIniciado){
                                                                    Generador.error();
                                                                } else {
                                                                    yybegin(YYINITIAL);
                                                                }
                                                            }
    [^]                                                     {}
}

<COMENTARIOBLOQUE> {
    "*/"                                                    {yybegin(YYINITIAL); String st = comentario.toString(); return new Symbol(sym.COMENTARIO, st);} 
    [\n\r]                                                  {String st = comentario.toString(); comentario.setLength(0); return new Symbol(sym.COMENTARIO, st); }   
    [^]                                                     {comentario.append(yytext());}
}

<COMENTARIOLINEA> {
    [\n\r]                                                  {yybegin(YYINITIAL); String st = comentario.toString(); return new Symbol(sym.COMENTARIO, st); }   
    [^]                                                     {comentario.append(yytext());}                      
}

