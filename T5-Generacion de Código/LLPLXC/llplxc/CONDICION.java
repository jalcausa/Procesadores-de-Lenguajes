/*
 * CONDICION.java
 * Clase abstracta base para todas las condiciones
 * 
 * Las condiciones generan código con etiquetas de verdadero y falso
 * para implementar la evaluación en cortocircuito.
 */

public abstract class CONDICION extends AST {

    // Etiquetas para el salto condicional
    protected String etiquetaVerdadero;
    protected String etiquetaFalso;

    /*
     * Constructor
     */
    public CONDICION(AST izq, AST der) {
        super(izq, der);
    }

    /*
     * Establece las etiquetas de destino para la condición
     */
    public void setEtiquetas(String verdadero, String falso) {
        this.etiquetaVerdadero = verdadero;
        this.etiquetaFalso = falso;
    }

    /*
     * Genera código para la condición con las etiquetas establecidas
     * Las subclases deben implementar este método
     */
    public abstract void generarCodigoCondicion(String etiquetaV, String etiquetaF);
    
    /*
     * Implementación por defecto de generarCodigo
     * No hace nada ya que las condiciones necesitan las etiquetas
     */
    @Override
    public void generarCodigo() {
        // Las condiciones no generan código directamente
        // Deben usar generarCodigoCondicion con etiquetas
    }
}
