public class REPEATTIMES extends AST {

    private EXPRESION limite;

    public REPEATTIMES(AST sentencia, EXPRESION limite) {
        super(sentencia, null);
        this.limite = limite;
    }

    public void gc() {
        String tempContador = Generador.nuevaTemporal();
        String etInicio = Generador.nuevaEtiqueta();
        String etFin = Generador.nuevaEtiqueta();
        
        Generador.asigna(tempContador, "1");
        Generador.printEtiqueta(etInicio);
        
        if (this.izq != null) {
            this.izq.gc();
        }
        
        this.limite.gc();
        String tempLimite = this.limite.getTemp();
        
        Generador.suma(tempContador, tempContador, "1");
        System.out.println("\tif(" + tempLimite + " < " + tempContador + ") goto " + etFin + ";");
        Generador.gotoEtiqueta(etInicio);
        Generador.printEtiqueta(etFin);
    }
}
