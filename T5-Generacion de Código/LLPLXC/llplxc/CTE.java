/*
 * CTE.java
 * Clase que representa una constante entera
 * 
 * Las constantes se representan directamente como su valor numérico.
 */

public class CTE extends EXPRESION {
    
    // Valor de la constante
    private String valor;

    /*
     * Constructor
     */
    public CTE(String valor) {
        super(null, null);
        this.valor = valor;
    }

    /*
     * Genera código para una constante
     * No genera ninguna instrucción, simplemente devuelve el valor
     */
    @Override
    public String generarCodigoExpresion() {
        return valor;
    }
}
