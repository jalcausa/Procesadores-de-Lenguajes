/*
 * NOT.java
 * Clase que representa la negación lógica (!)
 * 
 * Simplemente intercambia las etiquetas de verdadero y falso
 */

public class NOT extends CONDICION {
    
    // Condición a negar
    private CONDICION condicion;

    /*
     * Constructor
     */
    public NOT(CONDICION c) {
        super(null, null);
        this.condicion = c;
    }

    /*
     * Genera código para la negación
     * Intercambia las etiquetas de verdadero y falso
     */
    @Override
    public void generarCodigoCondicion(String etiquetaV, String etiquetaF) {
        // Invertir las etiquetas
        condicion.generarCodigoCondicion(etiquetaF, etiquetaV);
    }
}
