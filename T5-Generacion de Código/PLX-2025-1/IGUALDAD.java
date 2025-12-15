public class IGUALDAD extends CONDICION {

    public IGUALDAD(EXPRESION izq, EXPRESION dcha) {
        super(izq, dcha);
    }

    public void gc() {
        if (izq != null) {
            izq.gc();
        }
        if (dcha != null) {
            dcha.gc();
        }
        this.asignaEtiquetasNuevas();
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.igualdad(a, b, ev, ef);
    }
}
