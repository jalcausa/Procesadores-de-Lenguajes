/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo resta
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * temp: String con el que se identifica la dicha expresion
 * RESTA :: expresion1 - expresion2
 */
public class MENOS extends EXPRESION{

    /**
     * Constructor de la expresion en la cual se establecen las ramas izquierda y derecha
     * y se asigna ya un identificador temp.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MENOS(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        temp = Generador.nuevaTemporal();
    }

    /**
     * Genera el codigo CTD siguiente
     * ti = exp1;
     * tj = exp2;
     * tk = ti-tj;
     */
    public void gc(){

        //Se procesa primero la expresion de la izquierda (ti = exp1;)
        if(this.izq!=null){
            this.izq.gc();
        }

        //Se procesa después la expresion de la derecha (tj = exp2;)
        if(this.dcha!=null){
            this.dcha.gc();
        }
        
        //En caso de que sea un MENOSUNARIO tomamos (tk = 0-tj) y en caso contrario
        //se toma tk = ti-tj;
        if(this.izq == null){
            Generador.resta(this.getTemp(), "0", ((EXPRESION)this.dcha).getTemp());
        } else {
            Generador.resta(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
        }
    }
    
}