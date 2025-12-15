/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo multiplicacion
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * temp: String con el que se identifica la dicha expresion
 * tipo: TIPO tipo de la expresion
 * MULTIPLICACION :: expresion1 * expresion2
 */
public class POR extends EXPRESION{

    /**
     * Constructor de la expresion en la cual se establecen las ramas izquierda y derecha
     * y se asigna ya un identificador temp y un tipo.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public POR(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        temp = Generador.nuevaTemporal();
        this.tipo = Conversion.convierteTipos(izq.getTipo(), dcha.getTipo(), Conversion.PRODUCTO);
    }

    /**
     * Genera el codigo CTD siguiente
     * ti = exp1;
     * tj = exp2;
     * tk = ti*tj;
     */
    public void gc(){
        //Procesamos el primer operando
        if(this.izq!=null){
            this.izq.gc();
        }

        //Procesamos el segundo operando
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Imprimimos la operacion en  si
        Generador.multiplicacion(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp(), this.getTipo());
    }
    
}