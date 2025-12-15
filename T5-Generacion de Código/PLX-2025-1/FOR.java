public class FOR extends AST {

    public FOR(EXPRESION izq, WHILE dcha) {
        super(izq, dcha);
    }

    public void gc() {
        if (this.izq != null) {
            this.izq.gc();
        }
        if (this.dcha != null) {
            this.dcha.gc();
        }
    }
}
