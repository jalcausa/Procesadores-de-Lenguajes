public class SELECT extends AST {

    private String variable;
    private String modo;
    private EXPRESION desde;
    private EXPRESION hasta;
    private EXPRESION paso;
    private EXPRESION defecto;
    private AST cuerpo;

    public SELECT(String var, String modo, EXPRESION desde, EXPRESION hasta, 
                  EXPRESION paso, EXPRESION defecto, AST cuerpo) {
        super(null, null);
        this.variable = var;
        this.modo = modo;
        this.desde = desde;
        this.hasta = hasta;
        this.paso = paso;
        this.defecto = defecto;
        this.cuerpo = cuerpo;
    }

    public void gc() {
        this.desde.gc();
        this.hasta.gc();
        this.paso.gc();
        this.defecto.gc();
        
        String tempDesde = this.desde.getTemp();
        String tempHasta = this.hasta.getTemp();
        String tempPaso = this.paso.getTemp();
        String tempDefecto = this.defecto.getTemp();
        
        String etInicio = Generador.nuevaEtiqueta();
        String etEncontrado = Generador.nuevaEtiqueta();
        String etFin = Generador.nuevaEtiqueta();
        String tempResultado = Generador.nuevaTemporal();
        
        Generador.asigna(this.variable, tempDesde);
        Generador.asigna(tempResultado, tempDefecto);
        
        Generador.printEtiqueta(etInicio);
        
        System.out.println("\tif(" + tempHasta + " < " + this.variable + ") goto " + etFin + ";");
        
        if (this.cuerpo instanceof SELECTWHERE) {
            SELECTWHERE sw = (SELECTWHERE) this.cuerpo;
            CONDICION cond = sw.getCondicion();
            cond.gc();
            
            Generador.printEtiqueta(cond.getEtt());
            
            if (this.modo.equals("first")) {
                Generador.asigna(tempResultado, this.variable);
                Generador.gotoEtiqueta(etFin);
            } else {
                Generador.asigna(tempResultado, this.variable);
            }
            
            Generador.printEtiqueta(cond.getEtf());
        } else if (this.cuerpo instanceof SELECT) {
            SELECT selectInterno = (SELECT) this.cuerpo;
            
            String etInternoEncontrado = Generador.nuevaEtiqueta();
            String etInternoContinuar = Generador.nuevaEtiqueta();
            
            selectInterno.gcInterno(etInternoEncontrado, etInternoContinuar);
            
            Generador.printEtiqueta(etInternoEncontrado);
            if (this.modo.equals("first")) {
                Generador.asigna(tempResultado, this.variable);
                Generador.gotoEtiqueta(etFin);
            } else {
                Generador.asigna(tempResultado, this.variable);
            }
            
            Generador.printEtiqueta(etInternoContinuar);
        }
        
        Generador.suma(this.variable, this.variable, tempPaso);
        Generador.gotoEtiqueta(etInicio);
        
        Generador.printEtiqueta(etFin);
        Generador.asigna(this.variable, tempResultado);
    }

    public void gcInterno(String etEncontrado, String etContinuar) {
        this.desde.gc();
        this.hasta.gc();
        this.paso.gc();
        this.defecto.gc();
        
        String tempDesde = this.desde.getTemp();
        String tempHasta = this.hasta.getTemp();
        String tempPaso = this.paso.getTemp();
        String tempDefecto = this.defecto.getTemp();
        
        String etInicio = Generador.nuevaEtiqueta();
        String etFinInterno = Generador.nuevaEtiqueta();
        String tempResultado = Generador.nuevaTemporal();
        String tempEncontrado = Generador.nuevaTemporal();
        
        Generador.asigna(this.variable, tempDesde);
        Generador.asigna(tempResultado, tempDefecto);
        Generador.asigna(tempEncontrado, "0");
        
        Generador.printEtiqueta(etInicio);
        
        System.out.println("\tif(" + tempHasta + " < " + this.variable + ") goto " + etFinInterno + ";");
        
        if (this.cuerpo instanceof SELECTWHERE) {
            SELECTWHERE sw = (SELECTWHERE) this.cuerpo;
            CONDICION cond = sw.getCondicion();
            cond.gc();
            
            Generador.printEtiqueta(cond.getEtt());
            
            if (this.modo.equals("first")) {
                Generador.asigna(tempResultado, this.variable);
                Generador.asigna(tempEncontrado, "1");
                Generador.gotoEtiqueta(etFinInterno);
            } else {
                Generador.asigna(tempResultado, this.variable);
                Generador.asigna(tempEncontrado, "1");
            }
            
            Generador.printEtiqueta(cond.getEtf());
        } else if (this.cuerpo instanceof SELECT) {
            SELECT selectInterno = (SELECT) this.cuerpo;
            
            String etInternoEncontrado = Generador.nuevaEtiqueta();
            String etInternoContinuar = Generador.nuevaEtiqueta();
            
            selectInterno.gcInterno(etInternoEncontrado, etInternoContinuar);
            
            Generador.printEtiqueta(etInternoEncontrado);
            if (this.modo.equals("first")) {
                Generador.asigna(tempResultado, this.variable);
                Generador.asigna(tempEncontrado, "1");
                Generador.gotoEtiqueta(etFinInterno);
            } else {
                Generador.asigna(tempResultado, this.variable);
                Generador.asigna(tempEncontrado, "1");
            }
            
            Generador.printEtiqueta(etInternoContinuar);
        }
        
        Generador.suma(this.variable, this.variable, tempPaso);
        Generador.gotoEtiqueta(etInicio);
        
        Generador.printEtiqueta(etFinInterno);
        Generador.asigna(this.variable, tempResultado);
        
        System.out.println("\tif(" + tempEncontrado + " == 1) goto " + etEncontrado + ";");
        Generador.gotoEtiqueta(etContinuar);
    }
}
