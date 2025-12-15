/**
 * Clase publica que extiende de AST y representa sentencias del tipo do-while
 * dcha: CONDICION condicion del bucle
 * izq: AST sentencias a ejecutar si se continua con el bucle
 * eiquetaDoWhile: String que localiza la parte del codigo a la que hay que volver en caso de 
 *                 tener que repetir el bucle.
 * DOWHILE:: do sentencia while (condicion);
 */
public class DOWHILE extends AST{

    private String etiquetaDoWhile;

    /**
     * Generador de la clase DOWHILE. Asigna la sentencia, la condición y la etiquetaDoWhile
     * @param izq AST sentencia
     * @param dcha CONDICION condicion
     */
    public DOWHILE(AST izq, CONDICION dcha){
        super(izq,dcha);
        etiquetaDoWhile = Generador.nuevaLabel();
    }    

    /**
     * Metodo que genera el siguiente codigo CTD
     * Lw:
     *  sentencia
     *  if --- goto Lt
     *  goto Lf
     * Lt: goto Lw
     * Lf:
     * 
     */
    public void gc(){
        //Imprimimos lt
        Generador.printlabel(etiquetaDoWhile);

        //Imprimimos la sentencia
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos la condicion
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Imprimimos Lt: goto Lw
        String Lt = ((CONDICION)this.dcha).getEtt();
        Generador.printlabel(Lt);
        Generador.gotolabel(etiquetaDoWhile);

        //Imprimimos Lf:
        String Lf = ((CONDICION)this.dcha).getEtf();
        Generador.printlabel(Lf);
    }
}
