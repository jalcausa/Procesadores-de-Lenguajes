/*
 * NOIGUALDAD.java
 * Clase que representa la comparación de desigualdad (!=)
 */

public class NOIGUALDAD extends CONDICION {
    
    // Operandos
    private EXPRESION operando1;
    private EXPRESION operando2;

    /*
     * Constructor
     */
    public NOIGUALDAD(EXPRESION op1, EXPRESION op2) {
        super(null, null);
        this.operando1 = op1;
        this.operando2 = op2;
    }

    /*
     * Genera código para la comparación de desigualdad
     */
    @Override
    public void generarCodigoCondicion(String etiquetaV, String etiquetaF) {
        String val1 = operando1.generarCodigoExpresion();
        String val2 = operando2.generarCodigoExpresion();
        String resultado = Generador.emitirNoIgual(val1, val2);
        Generador.emitirSaltoCondicional(resultado, etiquetaV, etiquetaF);
    }
}
