public class AST {

    protected AST izq;
    protected AST dcha;

    public AST(AST i, AST d) {
        izq = i;
        dcha = d;
    }

    public AST getIzq() {
        return izq;
    }

    public AST getDer() {
        return dcha;
    }

    public void gc() {
        if (izq != null) {
            izq.gc();
        }
        if (dcha != null) {
            dcha.gc();
        }
    }
}
