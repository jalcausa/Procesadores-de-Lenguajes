/**
 * Clase publica que extiende de CONDICION y representa precisamente condiciones tipo >=
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * etiquetas: las correspondientes a cada condicion
 * MAYOREQ :: expresion1 >= expresion2
 */
public class MAYOREQ extends CONDICION{

    /**
     * Constructor de la clase MAYOREQ. Asigna la expresion izquierda y derecha.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MAYOREQ(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.setTipo(TIPO.CONDICION);
    }
    
    /**
     * Asigna etiquetas lt y lf a la condicion
     * Genera el codigo CTD siguiente:
     * ti = exp1;
     * tj = exp2;
     * if(ti<tj) goto lf;
     * goto lt;
     */
    public void gc(){
        //Procesa la expresion 1
        if(izq!=null){
            izq.gc();
        }

        //Procesa la expresion 2
        if(dcha!=null){
            dcha.gc();
        }

        //Asignamos las etiquetas 
        this.temp = Generador.nuevaTemporal();
        this.asignaEtiquetasNuevas();

        //Imprime las dos ultimas lineas que genera este metodo
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.mayoreq(a,b, ev, ef);
    }
}