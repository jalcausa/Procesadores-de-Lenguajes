public class OR extends CONDICION {

    public OR(CONDICION izq, CONDICION dcha) {
        super(izq, dcha);
    }

    public void gc() {
        if (izq != null) {
            izq.gc();
        }
        CONDICION c1 = (CONDICION) izq;
        Generador.printEtiqueta(c1.getEtf());
        
        if (dcha != null) {
            dcha.gc();
        }
        CONDICION c2 = (CONDICION) dcha;
        
        this.asignaEtiquetasNuevas(c1.getEtt(), c2.getEtf());
        this.setEtt(c2.getEtt());
    }
}
