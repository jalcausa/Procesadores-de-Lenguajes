/*
 * VARIABLE.java
 * Clase que representa el uso de una variable en una expresión
 * 
 * Cuando una variable se usa en una expresión, se debe cargar su valor
 * desde memoria a una temporal usando la instrucción load.
 */

public class VARIABLE extends EXPRESION {
    
    // Nombre de la variable
    private String nombre;

    /*
     * Constructor
     */
    public VARIABLE(String nombre) {
        super(null, null);
        this.nombre = nombre;
    }

    /*
     * Genera código para cargar el valor de la variable
     * Emite: temporal = load i32, i32* %nombre
     */
    @Override
    public String generarCodigoExpresion() {
        return Generador.emitirLoad(nombre);
    }
}
