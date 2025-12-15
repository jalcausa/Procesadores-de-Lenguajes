public class IFELSE extends AST {

    public IFELSE(IF pif, AST sentelse) {
        super(pif, sentelse);
    }

    public void gc() {
        CONDICION cond = null;
        AST sentif = null;
        if (this.izq != null) {
            cond = (CONDICION) this.izq.getIzq();
            sentif = this.izq.getDer();
        }

        if (cond != null) {
            cond.gc();
        }

        Generador.printEtiqueta(cond.getEtt());

        if (sentif != null) {
            sentif.gc();
        }

        String etiquetaContinuacion = Generador.nuevaEtiqueta();
        Generador.gotoEtiqueta(etiquetaContinuacion);

        Generador.printEtiqueta(cond.getEtf());

        if (this.dcha != null) {
            this.dcha.gc();
        }

        Generador.printEtiqueta(etiquetaContinuacion);
    }
}
