public class DIV extends EXPRESION {

    public DIV(EXPRESION izq, EXPRESION dcha) {
        super(izq, dcha);
        temp = Generador.nuevaTemporal();
    }

    public void gc() {
        if (this.izq != null) {
            this.izq.gc();
        }
        if (this.dcha != null) {
            this.dcha.gc();
        }
        Generador.division(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
}
