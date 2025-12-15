/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo suma
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * temp: String con el que se identifica la dicha expresion
 * SUMA :: expresion1 + expresion2
 */
public class MAS extends EXPRESION{

    /**
     * Constructor de la expresion en la cual se establecen las ramas izquierda y derecha
     * y se asigna ya un identificador temp.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MAS(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        temp = Generador.nuevaTemporal();
    }

    /**
     * Genera el codigo CTD siguiente
     * ti = exp1;
     * tj = exp2;
     * tk = ti+tj;
     */
    public void gc(){
        
        //Primero se procesa la expresion izquierda (ti = exp1;)
        if(this.izq!=null){
            this.izq.gc();
        }

        //Despues se procesa la expresion derecha (tj = exp2;)
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Por ultimo se imprime la expresion en que estamos ahora mismo (tk = ti+tj;)
        Generador.suma(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
    
}