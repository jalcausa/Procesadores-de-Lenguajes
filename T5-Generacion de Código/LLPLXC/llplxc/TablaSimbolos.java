/*
 * TablaSimbolos.java
 * Tabla de símbolos para el compilador PLX
 * 
 * Almacena las variables declaradas en el programa y permite
 * verificar si una variable ya ha sido declarada.
 */

import java.util.*;

public class TablaSimbolos {
    
    // Conjunto de variables declaradas
    private static Set<String> variables = new HashSet<String>();

    /*
     * Declara una nueva variable
     * Retorna true si la variable no existía, false si ya estaba declarada
     */
    public static boolean declarar(String nombre) {
        return variables.add(nombre);
    }

    /*
     * Verifica si una variable está declarada
     */
    public static boolean estaDeclarada(String nombre) {
        return variables.contains(nombre);
    }

    /*
     * Limpia la tabla de símbolos
     */
    public static void limpiar() {
        variables.clear();
    }
}
