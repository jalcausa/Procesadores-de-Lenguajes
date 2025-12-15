/**
 * Clase publica que extiende de CONDICION y representa precisamente condiciones tipo >
 * izq: EXPRESION que representa el arbol izquierdo
 * dcha: EXPRESION que representa el arbol derecho
 * etiquetas: las correspondientes a cada condicion
 * MAYOR :: expresion1 > expresion2
 */
public class MAYOR extends CONDICION{

    /**
     * Constructor de la clase MAYOR. Asigna la expresion izquierda y derecha.
     * @param izq EXPRESION izquierda
     * @param dcha EXPRESION derecha
     */
    public MAYOR(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.setTipo(TIPO.CONDICION);
    }
    
    /**
     * Asigna etiquetas lt y lf a la condicion
     * Genera el codigo CTD siguiente:
     * ti = exp1;
     * tj = exp2;
     * if(tj<ti) goto lt;
     * goto lf;
     */
    public void gc(){
        //Procesa la primera expresion
        if(izq!=null){
            izq.gc();
        }

        //Procesa la segunda expresion
        if(dcha!=null){
            dcha.gc();
        }

        //Asignamos las etiquetas y temp
        this.temp = Generador.nuevaTemporal();
        this.asignaEtiquetasNuevas();
        
        //Imprime las dos ultimas lineas que genera este metodo
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.mayor(a,b, ev, ef);
    }
}
