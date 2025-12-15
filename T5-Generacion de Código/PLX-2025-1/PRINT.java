public class PRINT extends AST {

    public PRINT(AST izq, AST dcha) {
        super(izq, null);
    }

    public void gc() {
        if (this.izq != null) {
            this.izq.gc();
        }
        Generador.print(((EXPRESION)izq).getTemp());
    }
}
