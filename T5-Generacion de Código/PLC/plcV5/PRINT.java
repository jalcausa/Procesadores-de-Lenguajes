public class PRINT extends AST{

    /*
     * Constructor de la clase PRINT, que extiende a AST.
     */
    public PRINT(AST izq, AST dcha){
        super(izq, dcha);
    }

    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }

        if(this.dcha!=null){
            this.dcha.gc();
        }
        Generador.print(((EXPRESION)izq).getTemp());
    }
}
