/*
 * LLPLXC.flex
 * Especificación léxica JFlex para el lenguaje PLX
 * 
 * Reconoce todos los tokens del lenguaje: palabras reservadas,
 * identificadores, constantes numéricas, operadores y delimitadores.
 */

import java_cup.runtime.*;

%%

/* Opciones de JFlex */
%cup
%line
%column

%%

/* Palabras reservadas */
"print"                                 { return new Symbol(sym.PRINT); }
"int"                                   { return new Symbol(sym.INT); }
"if"                                    { return new Symbol(sym.IF); }
"else"                                  { return new Symbol(sym.ELSE); }
"while"                                 { return new Symbol(sym.WHILE); }
"do"                                    { return new Symbol(sym.DO); }
"for"                                   { return new Symbol(sym.FOR); }

/* Delimitadores */
";"                                     { return new Symbol(sym.PYC); }
","                                     { return new Symbol(sym.COMA); }
"("                                     { return new Symbol(sym.PARENABRE); }
")"                                     { return new Symbol(sym.PARENCIERRA); }
"{"                                     { return new Symbol(sym.LLAVEABRE); }
"}"                                     { return new Symbol(sym.LLAVECIERRA); }

/* Operadores aritméticos */
"+"                                     { return new Symbol(sym.MAS); }
"-"                                     { return new Symbol(sym.MENOS); }
"*"                                     { return new Symbol(sym.POR); }
"/"                                     { return new Symbol(sym.DIV); }

/* Operadores de comparación */
"=="                                    { return new Symbol(sym.IGUALDAD); }
"!="                                    { return new Symbol(sym.NOIGUALDAD); }
"<="                                    { return new Symbol(sym.MENORIGUAL); }
">="                                    { return new Symbol(sym.MAYORIGUAL); }
"=>"                                    { return new Symbol(sym.MAYORIGUAL); }
"<"                                     { return new Symbol(sym.MENOR); }
">"                                     { return new Symbol(sym.MAYOR); }

/* Operador de asignación */
"="                                     { return new Symbol(sym.IGUAL); }

/* Operadores lógicos */
"!"                                     { return new Symbol(sym.NOT); }
"&&"                                    { return new Symbol(sym.AND); }
"||"                                    { return new Symbol(sym.OR); }

/* Constantes numéricas (enteros) */
0|[1-9][0-9]*                           { return new Symbol(sym.ENTERO, yytext()); }

/* Identificadores */
[a-zA-Z_][a-zA-Z0-9_]*                  { return new Symbol(sym.IDENT, yytext()); }

/* Espacios en blanco, tabuladores y saltos de línea - ignorar */
[ \t\r\n]+                              { /* Ignorar espacios en blanco */ }

/* Comentarios de una línea estilo C++ */
"//"[^\n]*                              { /* Ignorar comentarios de línea */ }

/* Comentarios multilínea estilo C */
"/*"([^*]|\*+[^*/])*\*+"/"              { /* Ignorar comentarios multilínea */ }

/* Cualquier otro carácter - error léxico (lo ignoramos) */
.                                       { /* Ignorar caracteres no reconocidos */ }
