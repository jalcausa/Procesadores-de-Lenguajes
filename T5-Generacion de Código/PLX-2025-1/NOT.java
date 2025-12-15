public class NOT extends CONDICION {

    public NOT(CONDICION cond, AST dcha) {
        super(cond, dcha);
    }

    public void gc() {
        if (izq != null) {
            izq.gc();
        }
        CONDICION c = (CONDICION) izq;
        this.asignaEtiquetasNuevas(c.getEtf(), c.getEtt());
    }
}
