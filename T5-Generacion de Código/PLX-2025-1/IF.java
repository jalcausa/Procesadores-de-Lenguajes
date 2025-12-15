public class IF extends AST {

    public IF(CONDICION cond, AST sent) {
        super(cond, sent);
    }

    public void gc() {
        if (this.izq != null) {
            izq.gc();
        }
        Generador.printEtiqueta(((CONDICION)this.izq).getEtt());
        if (this.dcha != null) {
            dcha.gc();
        }
        Generador.printEtiqueta(((CONDICION)this.izq).getEtf());
    }
}
