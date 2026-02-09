/*
 * MENOSUNARIO.java
 * Clase que representa el operador menos unario (negación)
 * 
 * Se implementa como 0 - expresión
 */

public class MENOSUNARIO extends EXPRESION {
    
    // Operando
    private EXPRESION operando;

    /*
     * Constructor
     */
    public MENOSUNARIO(EXPRESION op) {
        super(null, null);
        this.operando = op;
    }

    /*
     * Genera código para el menos unario
     * temporal = sub i32 0, valor
     */
    @Override
    public String generarCodigoExpresion() {
        String val = operando.generarCodigoExpresion();
        return Generador.emitirResta("0", val);
    }
}
