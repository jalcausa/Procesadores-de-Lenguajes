public class AND extends CONDICION {

    public AND(CONDICION izq, CONDICION dcha) {
        super(izq, dcha);
    }

    public void gc() {
        if (izq != null) {
            izq.gc();
        }
        CONDICION c1 = (CONDICION) izq;
        Generador.printEtiqueta(c1.getEtt());
        
        if (dcha != null) {
            dcha.gc();
        }
        CONDICION c2 = (CONDICION) dcha;
        
        this.asignaEtiquetasNuevas(c2.getEtt(), c1.getEtf());
        this.setEtf(c2.getEtf());
    }
}
