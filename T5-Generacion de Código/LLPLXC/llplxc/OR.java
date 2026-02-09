/*
 * OR.java
 * Clase que representa la disyunción lógica (||)
 * 
 * Implementa evaluación en cortocircuito:
 * Si la primera condición es verdadera, no se evalúa la segunda
 */

public class OR extends CONDICION {
    
    // Condiciones
    private CONDICION condicion1;
    private CONDICION condicion2;

    /*
     * Constructor
     */
    public OR(CONDICION c1, CONDICION c2) {
        super(null, null);
        this.condicion1 = c1;
        this.condicion2 = c2;
    }

    /*
     * Genera código para la disyunción con evaluación en cortocircuito
     * Si c1 es verdadera, saltar directamente a etiquetaVerdadero
     * Si c1 es falsa, evaluar c2
     */
    @Override
    public void generarCodigoCondicion(String etiquetaV, String etiquetaF) {
        // Crear etiqueta intermedia para evaluar segunda condición
        String etiquetaIntermedia = Generador.nuevaEtiqueta();
        
        // Evaluar primera condición
        // Si es verdadera, saltar directamente a etiquetaVerdadero (cortocircuito)
        // Si es falsa, ir a etiqueta intermedia para evaluar la segunda
        condicion1.generarCodigoCondicion(etiquetaV, etiquetaIntermedia);
        
        // Etiqueta intermedia
        Generador.emitirEtiqueta(etiquetaIntermedia);
        
        // Evaluar segunda condición
        condicion2.generarCodigoCondicion(etiquetaV, etiquetaF);
    }
}
