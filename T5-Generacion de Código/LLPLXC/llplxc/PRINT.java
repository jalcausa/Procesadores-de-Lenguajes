/*
 * PRINT.java
 * Clase que representa la sentencia print
 * 
 * Imprime el valor de una expresión usando printf.
 */

public class PRINT extends AST {
    
    // Expresión a imprimir
    private EXPRESION expresion;

    /*
     * Constructor
     */
    public PRINT(EXPRESION expresion) {
        super(null, null);
        this.expresion = expresion;
    }

    /*
     * Genera código para print
     * Primero evalúa la expresión, luego llama a printf
     */
    @Override
    public void generarCodigo() {
        String valor = expresion.generarCodigoExpresion();
        Generador.emitirPrint(valor);
    }
}
