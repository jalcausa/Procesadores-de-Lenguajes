/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo asignacion
 * izq: EXPRESION VACIA
 * dcha: EXPRESION que representa el arbol derecho, es decir, la expresion asignada al identificador
 * temp: String correpondiente al identificador de la variable declarada
 * SUMA :: expresion1 + expresion2
 */
public class ASIG extends EXPRESION {

    /**
     * Constructor de la clase ASIG. 
     * @param izq String correspondiente al identificador de la variable declarada
     * @param dcha EXPRESION correspondiente al valor de la variable declarada
     */
    public ASIG(String izq, EXPRESION dcha){
        //En este el nodo izquierdo es nulo, su papel sería el ocupado por el string temp
        super(null, dcha);
        //Ahora no se genera una nueva temp pues esta directamente nos la dan en el codigo
        //origen PLC.
        this.temp = izq;
    }

    /**
     * Genera el codigo CTD siguiente:
     * ti = exp2;
     * x = ti;
     */
    public void gc(){
        this.dcha.gc();
        Generador.asigna(this.getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
    


    
}
