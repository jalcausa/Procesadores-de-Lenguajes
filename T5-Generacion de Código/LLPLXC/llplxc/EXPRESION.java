/*
 * EXPRESION.java
 * Clase abstracta base para todas las expresiones
 * 
 * Las expresiones generan código y devuelven el valor (como String)
 * que representa el resultado de la expresión (una temporal o constante).
 */

public abstract class EXPRESION extends AST {

    /*
     * Constructor
     */
    public EXPRESION(AST izq, AST der) {
        super(izq, der);
    }

    /*
     * Genera código y devuelve el valor de la expresión
     * (una variable temporal como "%1" o una constante como "5")
     */
    public abstract String generarCodigoExpresion();

    /*
     * Implementación de generarCodigo que simplemente llama a generarCodigoExpresion
     */
    @Override
    public void generarCodigo() {
        generarCodigoExpresion();
    }
}
