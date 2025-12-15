public class DOWHILE extends AST {

    public DOWHILE(AST sent, CONDICION cond) {
        super(sent, cond);
    }

    public void gc() {
        String etiquetaInicio = Generador.nuevaEtiqueta();
        Generador.printEtiqueta(etiquetaInicio);
        
        if (this.izq != null) {
            this.izq.gc();
        }

        if (this.dcha != null) {
            this.dcha.gc();
        }

        CONDICION cond = (CONDICION) this.dcha;
        Generador.printEtiqueta(cond.getEtt());
        Generador.gotoEtiqueta(etiquetaInicio);
        Generador.printEtiqueta(cond.getEtf());
    }
}
