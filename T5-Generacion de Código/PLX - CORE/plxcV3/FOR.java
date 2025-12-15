
/**
 * Clase publica que extiende de AST y representa sentencias del tipo for
 * izq: EXPRESION es la expresion de inicializar el controlador del bucle for
 * dcha:WHILE es la correspondiente traducción de un bucle for a un while
 * FOR :: for (expresion1; condicion; expresion2) sentencia
 * NOTA: puede que las expresiones 1 y 2 sean vacias.
 * NOTA: se ve traducido como expresion1; while(condicion) {sentencia expresion2}
 */
public class FOR extends AST {
    /**
     * Constructor de la clase FOR. Asigna la expresion de inicializacion y el bucle while
     * @param izq EXPRESION expresion de inicializacion
     * @param dcha WHILE bucle correspondiente traducido
     */
    public FOR(EXPRESION izq, WHILE dcha){
        super(izq, dcha);
    }

    /**
     * Metodo que imprime los codigos corrrespondientes a la inicializacion y el bucle while
     */
    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }

        if(this.dcha!=null){
            this.dcha.gc();
        }
    }
    
}
