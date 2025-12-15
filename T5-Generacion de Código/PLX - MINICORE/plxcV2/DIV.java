/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo division
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * temp: String con el que se identifica la dicha expresion
 * DIVISON :: expresion1 / expresion2
 */
public class DIV extends EXPRESION{

    /**
     * Constructor de la expresion en la cual se establecen las ramas izquierda y derecha,
     * se asigna ya un identificador temp y un tipo,
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public DIV(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.temp = Generador.nuevaTemporal();
        //Asignamos el tipo mediante la conversion automatica
        this.tipo = Conversion.convierteTipos(izq.getTipo(), dcha.getTipo(), Conversion.DIVISON);

    }

    /**
     * Genera el codigo CTD siguiente
     * ti = exp1;
     * tj = exp2;
     * tk = ti/tj;
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

        //Imprimimos la expresion de la division
        Generador.division(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
    
}