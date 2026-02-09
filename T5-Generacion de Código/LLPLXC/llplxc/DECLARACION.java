/*
 * DECLARACION.java
 * Clase que representa la declaración de una variable
 * 
 * Al declarar una variable se reserva espacio en memoria (alloca)
 * y se inicializa a 0 (store).
 */

public class DECLARACION extends AST {
    
    // Nombre de la variable a declarar
    private String nombre;

    /*
     * Constructor
     */
    public DECLARACION(String nombre) {
        super(null, null);
        this.nombre = nombre;
    }

    /*
     * Genera código para declarar la variable
     * Emite: %nombre = alloca i32, align 4
     *        store i32 0, i32* %nombre
     */
    @Override
    public void generarCodigo() {
        // Registrar en tabla de símbolos
        TablaSimbolos.declarar(nombre);
        
        // Reservar espacio en memoria
        Generador.emitirAlloca(nombre);
        
        // Inicializar a 0
        Generador.emitirStore("0", nombre);
    }
}
