public class WHILE extends AST {

    private String etiquetaWhile;

    public WHILE(CONDICION izq, AST dcha) {
        super(izq, dcha);
        etiquetaWhile = Generador.nuevaEtiqueta();
    }

    public void gc() {
        Generador.printEtiqueta(etiquetaWhile);
        
        if (this.izq != null) {
            this.izq.gc();
        }

        String Lt = ((CONDICION)this.izq).getEtt();
        String Lf = ((CONDICION)this.izq).getEtf();
        Generador.printEtiqueta(Lt);

        if (this.dcha != null) {
            this.dcha.gc();
        }

        Generador.gotoEtiqueta(etiquetaWhile);
        Generador.printEtiqueta(Lf);
    }
}
