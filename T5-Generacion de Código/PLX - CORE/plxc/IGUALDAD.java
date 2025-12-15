/**
 * Clase publica que extiende de CONDICION y representa precisamente condiciones tipo ==
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * etiquetas: las correspondientes a cada condicion
 * IGUALDAD :: expresion1 == expresion2
 */
public class IGUALDAD  extends CONDICION{

    /**
     * Constructor de la clase IGUALDAD. Asigna la expresion izquierda y derecha.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public IGUALDAD(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
    }

    /**
     * Asigna etiquetas lt y lf a la condicion
     * Genera el codigo CTD siguiente:
     * ti = exp1;
     * tj = exp2;
     * if(ti==tj) goto lt;
     * goto lf;
     */
    public void gc(){

        //Procesamos la expresion1
        if(izq!=null){
            izq.gc();
        }

        //Procesamos la expresion2
        if(dcha!=null){
            dcha.gc();
        }

        //Asignamos las etiquetas
        this.asignaEtiquetasNuevas();
        
        //Imprimimos las dos últimas lineas de generadas por este metodo.
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.igualdad(a,b, ev, ef);
    }
}
