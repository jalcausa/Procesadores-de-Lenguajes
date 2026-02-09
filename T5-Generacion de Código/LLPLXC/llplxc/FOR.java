/*
 * FOR.java
 * Clase que representa la sentencia for
 * 
 * for (inicialización; condición; incremento) sentencia
 * 
 * Es equivalente a:
 *   inicialización;
 *   while (condición) {
 *     sentencia;
 *     incremento;
 *   }
 * 
 * Estructura:
 *   ejecutar inicialización
 *   saltar a L0
 *   L0: evaluar condición -> si verdadera ir a L1, si falsa ir a L2
 *   L1: ejecutar cuerpo
 *       ejecutar incremento
 *       saltar a L0
 *   L2: (fin del for)
 */

public class FOR extends AST {
    
    // Expresión de inicialización
    private EXPRESION inicializacion;
    
    // Condición del for
    private CONDICION condicion;
    
    // Expresión de incremento
    private EXPRESION incremento;
    
    // Cuerpo del for
    private AST sentencia;

    /*
     * Constructor
     */
    public FOR(EXPRESION inicializacion, CONDICION condicion, EXPRESION incremento, AST sentencia) {
        super(null, null);
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.incremento = incremento;
        this.sentencia = sentencia;
    }

    /*
     * Genera código para la sentencia for
     */
    @Override
    public void generarCodigo() {
        // Crear etiquetas
        String etiquetaCondicion = Generador.nuevaEtiqueta(); // L0: evaluar condición
        String etiquetaCuerpo = Generador.nuevaEtiqueta();    // L1: cuerpo del for
        String etiquetaFin = Generador.nuevaEtiqueta();       // L2: fin del for
        
        // Ejecutar inicialización (si existe)
        if (inicializacion != null) {
            inicializacion.generarCodigoExpresion();
        }
        
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
        
        // Ejecutar incremento (si existe)
        if (incremento != null) {
            incremento.generarCodigoExpresion();
        }
        
        // Volver a evaluar condición
        Generador.emitirSalto(etiquetaCondicion);
        
        // Etiqueta del fin (condición falsa)
        Generador.emitirEtiqueta(etiquetaFin);
    }
}
