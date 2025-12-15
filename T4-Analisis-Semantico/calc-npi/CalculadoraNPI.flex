import java_cup.runtime.*;

%%

/* Declaraciones */

%cup


%%
/* Expresiones y reglas */

    "+"                     {return new Symbol(sym.MAS);}
    "-"                     {return new Symbol(sym.MENOS);}
    "*"                     {return new Symbol(sym.POR);}
    "/"                     {return new Symbol(sym.DIV);}
    "("                     {return new Symbol(sym.AP);}
    ")"                     {return new Symbol(sym.CP);}
    0|[1-9][0-9]*           {return new Symbol(sym.NUMERO, yytext());}
    \r|\n                   {return new Symbol(sym.EOL);}
    \ |\t\f                 { }
    [^]                     {throw new Error("Illegal character <"+yytext()+">");}