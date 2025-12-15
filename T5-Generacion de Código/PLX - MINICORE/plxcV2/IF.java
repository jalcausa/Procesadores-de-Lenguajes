/**
 * Clase publica que extiende de AST y viene a representar sentencias if simples.
 * izq: CONDICION representa la condicion del if
 * decha: AST representa la sentencia a ejecutar en caso de ser cierta la condicion
 * IF :: if(cond) sentencia
 */
public class IF extends AST{

    /**
     * Constructor de la clase IF. Asigna la condicion y sentencia correspondientes
     * @param cond CONDICION del if
     * @param sent AST sentencia a ejecutar en caso de condicion cierta
     */
    public IF(CONDICION cond, AST sent){
        super(cond, sent);
    }

    /**
     * Metodo que genera el siguiente codigo CTD:
     *  if --- goto Lt
     *  goto Lf
     * Lt: 
     *  sentencia
     * Lf:
     */
    public void gc(){
        //Imprimimos la parte de la condicion
        if(this.izq!=null){
            izq.gc();
        }

        //Imprimimos la etiqueta del caso afirmativo
        Generador.printlabel(((CONDICION)this.izq).getEtt());

        //Imprimimos la sentencia en sí
        if(this.dcha!=null){
            dcha.gc();
        }

        //Imprimimos la etiqueta del caso del no
        Generador.printlabel(((CONDICION)this.izq).getEtf());

    }
    
}
