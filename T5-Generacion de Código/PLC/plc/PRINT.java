/**
 * Clase publica que extiende de AST y representa sentencias del tipo print
 * izq: expresion a imprimir
 * dcha: null
 */
public class PRINT extends AST{

    /**
     * Constructor de la clase PRINT. 
     * @param izq EXPRESION que se para como argumento para imprimir
     * @param dcha null
     */
    public PRINT(AST izq, AST dcha){
        super(izq, null);
    }

    /**
     * Metodo publico para generacion del siguiente codigo CTD:
     * ti = expresion;
     * print ti;
     */
    public void gc(){

        //Impresion de ti = expresion
        if(this.izq!=null){
            this.izq.gc();
        }
        
        Generador.print(((EXPRESION)izq).getTemp());
    }
}
