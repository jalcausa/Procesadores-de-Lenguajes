import java.io.IOException;
import java_cup.runtime.*;
%%

/*  Declaraciones */   

%line
%cup 

Espacio = \s
Retorno = \R


%%   

/* Expresiones y reglas */
   
    "+"                		{ return new Symbol(sym.MAS); }
    "-"					  		{ return new Symbol(sym.MENOS); }
    "*"					  		{ return new Symbol(sym.MULT); }
	 "/"					  		{ return new Symbol(sym.DIVID); }
    "="                		{ return new Symbol(sym.IGUAL); }
    "("                		{ return new Symbol(sym.AP); }
    ")"                		{ return new Symbol(sym.CP); }
    ";"                		{ return new Symbol(sym.PYC); }
    "=="                   { return new Symbol(sym.CIGUAL); }
    "<"                    { return new Symbol(sym.MENOR); }
    ">"                    { return new Symbol(sym.MAYOR); }
    ","							{ return new Symbol(sym.COMA); }
    "write"						{ return new Symbol(sym.WRITE); }
    "if"							{ return new Symbol(sym.IF); }
    "then"                 { return new Symbol(sym.THEN); }
    "else"                 { return new Symbol(sym.ELSE); }
    "not"                  { return new Symbol(sym.NOT); }
    "and"                  { return new Symbol(sym.AND); }
    "or"                   { return new Symbol(sym.OR); }
    "print"						{ return new Symbol(sym.PRINT); }
    \"[^\"\R]*\" 				{ 
    									String c = yytext();
    									return new Symbol(sym.CADENA, new String(c.substring(1,c.length()-1)));
    							   }
    [A-Za-z][A-Za-z0-9_]* 	{ return new Symbol(sym.ID, new String( yytext() )); }    
    0|[1-9][0-9]*          { return new Symbol(sym.NUMERO, Integer.valueOf(yytext()) ); }
    {Retorno}          		{  }   
    {Espacio}          		{  }  
    [^]                		{ throw new  IOException("Illegal character <"+yytext()+"> en línea "+yyline);  }
    
