/*
 * LLPLXC.java
 * Programa principal del compilador PLX a LLVM IR
 * 
 * Este programa lee un archivo fuente en lenguaje PLX y genera
 * código intermedio LLVM IR equivalente.
 * 
 * Uso: java LLPLXC archivo.plx archivo.ll
 */

import java.io.*;

public class LLPLXC {
    public static void main(String[] args) {
        try {
            // Verificar argumentos
            if (args.length < 2) {
                System.err.println("Uso: java LLPLXC archivo.plx archivo.ll");
                System.exit(1);
            }

            // Abrir archivo fuente
            FileReader archivoFuente = new FileReader(args[0]);
            
            // Redirigir salida estándar al archivo de salida
            PrintStream archivoSalida = new PrintStream(new FileOutputStream(args[1]));
            System.setOut(archivoSalida);

            // Crear el analizador léxico
            Yylex analizadorLexico = new Yylex(archivoFuente);
            
            // Crear el analizador sintáctico
            parser analizadorSintactico = new parser(analizadorLexico);

            // Ejecutar el análisis sintáctico (también genera el código)
            analizadorSintactico.parse();

            // Cerrar archivos
            archivoFuente.close();
            archivoSalida.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error: No se puede abrir el archivo " + args[0]);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error durante la compilación: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
