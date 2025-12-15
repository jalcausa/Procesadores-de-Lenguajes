public class MENOS extends EXPRESION {

    public MENOS(EXPRESION izq, EXPRESION dcha) {
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
        
        if (this.izq == null) {
            Generador.resta(this.getTemp(), "0", ((EXPRESION)this.dcha).getTemp());
        } else {
            Generador.resta(this.getTemp(), ((EXPRESION)this.izq).getTemp(), ((EXPRESION)this.dcha).getTemp());
        }
    }
}
