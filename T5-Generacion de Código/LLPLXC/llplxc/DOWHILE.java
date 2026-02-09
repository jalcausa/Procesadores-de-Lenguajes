/*
 * DOWHILE.java
 * Clase que representa la sentencia do-while
 * 
 * Estructura:
 *   saltar a L0
 *   L0: ejecutar cuerpo
 *       evaluar condición -> si verdadera ir a L0, si falsa ir a L1
 *   L1: (fin del do-while)
 */

public class DOWHILE extends AST {
    
    // Cuerpo del do-while
    private AST sentencia;
    
    // Condición del do-while
    private CONDICION condicion;

    /*
     * Constructor
     */
    public DOWHILE(AST sentencia, CONDICION condicion) {
        super(null, null);
        this.sentencia = sentencia;
        this.condicion = condicion;
    }

    /*
     * Genera código para la sentencia do-while
     */
    @Override
    public void generarCodigo() {
        // Crear etiquetas
        String etiquetaCuerpo = Generador.nuevaEtiqueta(); // L0: cuerpo del do-while
        String etiquetaFin = Generador.nuevaEtiqueta();    // L1: fin del do-while
        
        // Saltar al cuerpo
        Generador.emitirSalto(etiquetaCuerpo);
        
        // Etiqueta del cuerpo
        Generador.emitirEtiqueta(etiquetaCuerpo);
        
        // Generar código del cuerpo
        sentencia.generarCodigo();
        
        // Evaluar condición
        // Si es verdadera, volver al cuerpo
        // Si es falsa, ir al fin
        condicion.generarCodigoCondicion(etiquetaCuerpo, etiquetaFin);
        
        // Etiqueta del fin
        Generador.emitirEtiqueta(etiquetaFin);
    }
}
