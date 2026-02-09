/*
 * IF.java
 * Clase que representa la sentencia if (sin else)
 * 
 * Estructura:
 *   evaluar condición -> si verdadera ir a L1, si falsa ir a L0
 *   L1: ejecutar sentencia
 *       saltar a L0
 *   L0: (fin del if)
 */

public class IF extends AST {
    
    // Condición del if
    private CONDICION condicion;
    
    // Cuerpo del if
    private AST sentencia;

    /*
     * Constructor
     */
    public IF(CONDICION condicion, AST sentencia) {
        super(null, null);
        this.condicion = condicion;
        this.sentencia = sentencia;
    }

    /*
     * Genera código para la sentencia if
     */
    @Override
    public void generarCodigo() {
        // Crear etiquetas
        String etiquetaFin = Generador.nuevaEtiqueta();    // L0: fin del if
        String etiquetaCuerpo = Generador.nuevaEtiqueta(); // L1: cuerpo del if
        String etiquetaFalso = Generador.nuevaEtiqueta();  // L2: saltar cuando condición es falsa
        
        // Evaluar condición
        condicion.generarCodigoCondicion(etiquetaCuerpo, etiquetaFalso);
        
        // Etiqueta del cuerpo (condición verdadera)
        Generador.emitirEtiqueta(etiquetaCuerpo);
        
        // Generar código del cuerpo
        sentencia.generarCodigo();
        
        // Saltar al final
        Generador.emitirSalto(etiquetaFin);
        
        // Etiqueta de condición falsa
        Generador.emitirEtiqueta(etiquetaFalso);
        Generador.emitirSalto(etiquetaFin);
        
        // Etiqueta del fin
        Generador.emitirEtiqueta(etiquetaFin);
    }
}
