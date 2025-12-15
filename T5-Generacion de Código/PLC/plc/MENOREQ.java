/**
 * Clase publica que extiende de CONDICION y representa precisamente condiciones tipo <=
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * etiquetas: las correspondientes a cada condicion
 * MENOREQ :: expresion1 < expresion2
 */
public class MENOREQ extends CONDICION{

    /**
     * Constructor de la clase MENOREQ. Asigna la expresion izquierda y derecha.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MENOREQ(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
    }
    
    /**
     * Asigna etiquetas lt y lf a la condicion
     * Genera el codigo CTD siguiente:
     * ti = exp1;
     * tj = exp2;
     * if(tj<ti) goto lf;
     * goto lt;
     */
    public void gc(){

        //Procesa la expresion1
        if(izq!=null){
            izq.gc();
        }

        //Procesa la expresion2
        if(dcha!=null){
            dcha.gc();
        }

        //Asignamos las etiquetas
        this.asignaEtiquetasNuevas();

        //Imprime las dos ultimas lineas
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.menoreq(a,b, ev, ef);
    }
}