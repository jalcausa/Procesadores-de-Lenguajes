/*
 * DIV.java
 * Clase que representa la operación de división entera
 */

public class DIV extends EXPRESION {
    
    // Operandos
    private EXPRESION operando1;
    private EXPRESION operando2;

    /*
     * Constructor
     */
    public DIV(EXPRESION op1, EXPRESION op2) {
        super(null, null);
        this.operando1 = op1;
        this.operando2 = op2;
    }

    /*
     * Genera código para la división entera
     * temporal = sdiv i32 valor1, valor2
     */
    @Override
    public String generarCodigoExpresion() {
        String val1 = operando1.generarCodigoExpresion();
        String val2 = operando2.generarCodigoExpresion();
        return Generador.emitirDiv(val1, val2);
    }
}
