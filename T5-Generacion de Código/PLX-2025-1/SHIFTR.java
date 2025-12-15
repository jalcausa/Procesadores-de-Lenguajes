public class SHIFTR extends EXPRESION {

    public SHIFTR(EXPRESION izq, EXPRESION dcha) {
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
        
        EXPRESION expIzq = (EXPRESION) this.izq;
        EXPRESION expDcha = (EXPRESION) this.dcha;
        
        if (expDcha instanceof CTE && ((CTE)expDcha).esConstante()) {
            int veces = ((CTE)expDcha).getValor();
            String resultado = expIzq.getTemp();
            for (int i = 0; i < veces; i++) {
                if (i == 0) {
                    Generador.division(this.temp, resultado, "2");
                } else {
                    Generador.division(this.temp, this.temp, "2");
                }
            }
            if (veces == 0) {
                Generador.asigna(this.temp, resultado);
            }
        } else {
            String tempValor = Generador.nuevaTemporal();
            String tempContador = Generador.nuevaTemporal();
            String etInicio = Generador.nuevaEtiqueta();
            String etFin = Generador.nuevaEtiqueta();
            
            Generador.asigna(tempValor, expIzq.getTemp());
            Generador.asigna(tempContador, "1");
            Generador.printEtiqueta(etInicio);
            System.out.println("\tif(" + expDcha.getTemp() + " < " + tempContador + ") goto " + etFin + ";");
            Generador.division(tempValor, tempValor, "2");
            Generador.suma(tempContador, tempContador, "1");
            Generador.gotoEtiqueta(etInicio);
            Generador.printEtiqueta(etFin);
            this.temp = tempValor;
        }
    }
}
