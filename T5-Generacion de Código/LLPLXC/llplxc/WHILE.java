/*
 * WHILE.java
 * Clase que representa la sentencia while
 * 
 * Estructura:
 *   saltar a L0
 *   L0: evaluar condición -> si verdadera ir a L1, si falsa ir a L2
 *   L1: ejecutar cuerpo
 *       saltar a L0
 *   L2: (fin del while)
 */

public class WHILE extends AST {
    
    // Condición del while
    private CONDICION condicion;
    
    // Cuerpo del while
    private AST sentencia;

    /*
     * Constructor
     */
    public WHILE(CONDICION condicion, AST sentencia) {
        super(null, null);
        this.condicion = condicion;
        this.sentencia = sentencia;
    }

    /*
     * Genera código para la sentencia while
     */
    @Override
    public void generarCodigo() {
        // Crear etiquetas
        String etiquetaCondicion = Generador.nuevaEtiqueta(); // L0: evaluar condición
        String etiquetaCuerpo = Generador.nuevaEtiqueta();    // L1: cuerpo del while
        String etiquetaFin = Generador.nuevaEtiqueta();       // L2: fin del while
        
        // Saltar a evaluar condición
        Generador.emitirSalto(etiquetaCondicion);
        
        // Etiqueta de la condición
        Generador.emitirEtiqueta(etiquetaCondicion);
        
        // Evaluar condición
        condicion.generarCodigoCondicion(etiquetaCuerpo, etiquetaFin);
        
        // Etiqueta del cuerpo (condición verdadera)
        Generador.emitirEtiqueta(etiquetaCuerpo);
        
        // Generar código del cuerpo
        sentencia.generarCodigo();
        
        // Volver a evaluar condición
        Generador.emitirSalto(etiquetaCondicion);
        
        // Etiqueta del fin (condición falsa)
        Generador.emitirEtiqueta(etiquetaFin);
    }
}
