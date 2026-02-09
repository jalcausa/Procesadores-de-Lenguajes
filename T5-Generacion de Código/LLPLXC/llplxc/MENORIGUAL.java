/*
 * MENORIGUAL.java
 * Clase que representa la comparación menor o igual (<=)
 */

public class MENORIGUAL extends CONDICION {
    
    // Operandos
    private EXPRESION operando1;
    private EXPRESION operando2;

    /*
     * Constructor
     */
    public MENORIGUAL(EXPRESION op1, EXPRESION op2) {
        super(null, null);
        this.operando1 = op1;
        this.operando2 = op2;
    }

    /*
     * Genera código para la comparación menor o igual
     */
    @Override
    public void generarCodigoCondicion(String etiquetaV, String etiquetaF) {
        String val1 = operando1.generarCodigoExpresion();
        String val2 = operando2.generarCodigoExpresion();
        String resultado = Generador.emitirMenorIgual(val1, val2);
        Generador.emitirSaltoCondicional(resultado, etiquetaV, etiquetaF);
    }
}
