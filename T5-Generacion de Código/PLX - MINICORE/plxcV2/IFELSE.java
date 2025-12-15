/**
 * Clase publica que extiende de AST y viene a representar sentencias ifelse.
 * izq: IF representa la condicion del if y la sentencia a ejecutar en caso de ser cierta
 * decha: AST representa la sentencia a ejecutar en caso de no ser cierta la condicion
 * IF :: if(cond) sentencia1 else sentencia2
 */
public class IFELSE extends AST{

    /**
     * Constructor de la clase IFELSE
     * @param pif IF representa condicion y sentencia afirmativa
     * @param sentelse AST representa la sentencia negativa
     */
    public IFELSE(IF pif, AST sentelse){
        super(pif, sentelse);
    }

    /**
     * Metodo que genera el siguiente codigo CTD
     *  if --- goto Lt
     *  goto Lf
     * Lt:
     *  sentencia1
     *  goto Lc
     * Lf:
     *  sentencia2
     * Lc:
     */
    public void gc(){

        //Extraemos la condicion y sentencia afirmativa del IF
        CONDICION cond = null;
        AST sentif = null;
        if(this.izq!=null){
            cond = (CONDICION) this.izq.getIzq();
            sentif = this.izq.getDer();
        }

        //Imprimimos la parte de la condicion
        if(cond!=null){
            cond.gc();
        }

        //Imprimimos la etiqueta del caso afirmativo
        Generador.printlabel(cond.getEtt());

        //Imprimimos la sentencia afirmativa 
        if(sentif!=null){
            sentif.gc();
        }

        //Generamos una nueva etiqueta, donde continuara el codigo tras la sentencia del if
        //para asi conseguir saltarnos la parte del else.
        String etiquetaContinuacion = Generador.nuevaLabel();
        Generador.gotolabel(etiquetaContinuacion);

        //Imprimimos la etiqueta del caso del else
        Generador.printlabel(cond.getEtf());

        //Imprimimos las sentencias del else
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Podría añadirse la opcion de añadir un goto Lc pero no es necesaria

        //Imprimos la etiqueta de la continuacion del codigo
        Generador.printlabel(etiquetaContinuacion);
    }
    
}