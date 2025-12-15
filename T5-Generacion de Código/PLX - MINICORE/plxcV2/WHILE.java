/**
 * Clase publica que extiende de AST y representa sentencias del tipo while
 * izq: CONDICION condicion del bucle
 * dcha: AST sentencias a ejecutar si se continua con el bucle
 * eiquetaWhile: String que localiza la parte del codigo a la que hay que volver en caso de 
 *               tener que repetir el bucle.
 * WHILE:: while (condicion) sentencia
 */
public class WHILE extends AST {

    private String etiquetaWhile;

    /**
     * Constructor de la clase While. Asigna la condicion, la sentencia y genera una nueva
     * etiqueta para el bucle
     * @param izq CONDICION condicion
     * @param dcha AST sentencia
     */
    public WHILE(CONDICION izq, AST dcha){
        super(izq, dcha);
        etiquetaWhile = Generador.nuevaLabel();
    }

    /**
     * Metodo que genera el siguiente codigo CTD.
     * Li: 
     *  if --- goto Lt
     *  goto Lf
     * Lt:
     *  sentencia
     *  goto Li
     * Lf:
     */
    public void gc(){

        //Imprimimos Li
        Generador.printlabel(etiquetaWhile);
        
        //Imprimimos la condicion
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos Lt:
        String Lt = ((CONDICION)this.izq).getEtt();
        String Lf = ((CONDICION)this.izq).getEtf();
        Generador.printlabel(Lt);

        // Imprimimos la sentencia a ejecutar del bucle
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Volvemos a comprobar la condicion del bucle 
        Generador.gotolabel(etiquetaWhile);

        //Imprimimos la continuacion del bucle
        Generador.printlabel(Lf);
    }
    
}
