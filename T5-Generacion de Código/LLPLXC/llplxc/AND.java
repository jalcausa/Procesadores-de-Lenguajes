/*
 * AND.java
 * Clase que representa la conjunción lógica (&&)
 * 
 * Implementa evaluación en cortocircuito:
 * Si la primera condición es falsa, no se evalúa la segunda
 */

public class AND extends CONDICION {
    
    // Condiciones
    private CONDICION condicion1;
    private CONDICION condicion2;

    /*
     * Constructor
     */
    public AND(CONDICION c1, CONDICION c2) {
        super(null, null);
        this.condicion1 = c1;
        this.condicion2 = c2;
    }

    /*
     * Genera código para la conjunción con evaluación en cortocircuito
     * Si c1 es verdadera, evaluar c2
     * Si c1 es falsa, saltar directamente a etiquetaFalso
     */
    @Override
    public void generarCodigoCondicion(String etiquetaV, String etiquetaF) {
        // Crear etiqueta intermedia para evaluar segunda condición
        String etiquetaIntermedia = Generador.nuevaEtiqueta();
        
        // Evaluar primera condición
        // Si es verdadera, ir a etiqueta intermedia para evaluar la segunda
        // Si es falsa, saltar directamente a etiquetaFalso (cortocircuito)
        condicion1.generarCodigoCondicion(etiquetaIntermedia, etiquetaF);
        
        // Etiqueta intermedia
        Generador.emitirEtiqueta(etiquetaIntermedia);
        
        // Evaluar segunda condición
        condicion2.generarCodigoCondicion(etiquetaV, etiquetaF);
    }
}
