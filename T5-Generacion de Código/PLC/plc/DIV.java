/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo division
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * temp: String con el que se identifica la dicha expresion
 * DIVISON :: expresion1 / expresion2
 */
public class DIV extends EXPRESION{

    /**
     * Constructor de la expresion en la cual se establecen las ramas izquierda y derecha
     * y se asigna ya un identificador temp.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public DIV(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.temp = Generador.nuevaTemporal();

    }

    /**
     * Genera el codigo CTD siguiente
     * ti = exp1;
     * tj = exp2;
     * tk = ti/tj;
     */
    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }
        if(this.dcha!=null){
            this.dcha.gc();
        }
        Generador.division(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
    
}