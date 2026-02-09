/*
 * IFELSE.java
 * Clase que representa la sentencia if-else
 * 
 * Estructura:
 *   evaluar condición -> si verdadera ir a L1, si falsa ir a L2
 *   L1: ejecutar sentencia then
 *       saltar a L0
 *   L2: ejecutar sentencia else
 *       saltar a L0
 *   L0: (fin del if-else)
 */

public class IFELSE extends AST {
    
    // Condición del if
    private CONDICION condicion;
    
    // Cuerpo del then
    private AST sentenciaThen;
    
    // Cuerpo del else
    private AST sentenciaElse;

    /*
     * Constructor
     */
    public IFELSE(CONDICION condicion, AST sentenciaThen, AST sentenciaElse) {
        super(null, null);
        this.condicion = condicion;
        this.sentenciaThen = sentenciaThen;
        this.sentenciaElse = sentenciaElse;
    }

    /*
     * Genera código para la sentencia if-else
     */
    @Override
    public void generarCodigo() {
        // Crear etiquetas
        String etiquetaFin = Generador.nuevaEtiqueta();   // L0: fin del if-else
        String etiquetaThen = Generador.nuevaEtiqueta();  // L1: rama then
        String etiquetaElse = Generador.nuevaEtiqueta();  // L2: rama else
        
        // Evaluar condición
        condicion.generarCodigoCondicion(etiquetaThen, etiquetaElse);
        
        // Etiqueta del then (condición verdadera)
        Generador.emitirEtiqueta(etiquetaThen);
        
        // Generar código del then
        sentenciaThen.generarCodigo();
        
        // Saltar al final
        Generador.emitirSalto(etiquetaFin);
        
        // Etiqueta del else (condición falsa)
        Generador.emitirEtiqueta(etiquetaElse);
        
        // Generar código del else
        sentenciaElse.generarCodigo();
        
        // Saltar al final
        Generador.emitirSalto(etiquetaFin);
        
        // Etiqueta del fin
        Generador.emitirEtiqueta(etiquetaFin);
    }
}
