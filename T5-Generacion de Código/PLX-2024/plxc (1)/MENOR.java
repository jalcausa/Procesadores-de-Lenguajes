/**
 * Clase publica que extiende de CONDICION y representa precisamente condiciones tipo <
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * etiquetas: las correspondientes a cada condicion
 * MENOR :: expresion1 < expresion2
 */
public class MENOR extends CONDICION{

    /**
     * Constructor de la clase MENOR. Asigna la expresion izquierda y derecha.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MENOR(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.setTipo(TIPO.CONDICION);
    }
    
    /**
     * Asigna etiquetas lt y lf a la condicion
     * Genera el codigo CTD siguiente:
     * ti = exp1;
     * tj = exp2;
     * if(ti<tj) goto lt;
     * goto lf;
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
        this.temp = Generador.nuevaTemporal();

        //Imprime las dos ultimas lineas que genera este metodo
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.menor(a,b, ev, ef);
    }
}