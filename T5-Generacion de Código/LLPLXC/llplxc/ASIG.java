/*
 * ASIG.java
 * Clase que representa una asignación a una variable
 * 
 * La asignación calcula el valor de la expresión y lo almacena
 * en la variable usando la instrucción store.
 */

public class ASIG extends EXPRESION {
    
    // Nombre de la variable destino
    private String nombre;
    
    // Expresión a asignar
    private EXPRESION expresion;

    /*
     * Constructor
     */
    public ASIG(String nombre, EXPRESION expresion) {
        super(null, null);
        this.nombre = nombre;
        this.expresion = expresion;
    }

    /*
     * Genera código para la asignación
     * Primero evalúa la expresión, luego almacena el resultado
     * Devuelve el valor asignado (para permitir asignaciones encadenadas)
     */
    @Override
    public String generarCodigoExpresion() {
        // Evaluar la expresión
        String valor = expresion.generarCodigoExpresion();
        
        // Almacenar en la variable
        Generador.emitirStore(valor, nombre);
        
        // Devolver el valor asignado (para encadenamientos como a = b = 1)
        return valor;
    }
}
