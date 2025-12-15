public class CONDICION extends AST {

    private EtiquetaDoble etiquetas;
    
    public CONDICION(AST izq, AST dcha) {
        super(izq, dcha);
    }

    public String getEtt() {
        return this.etiquetas.getET();
    }

    public String getEtf() {
        return this.etiquetas.getEF();
    }

    public void setEtt(String et) {
        this.etiquetas.setET(et);
    }

    public void setEtf(String ef) {
        this.etiquetas.setEF(ef);
    }

    protected void asignaEtiquetasNuevas() {
        this.etiquetas = new EtiquetaDoble();
    }

    protected void asignaEtiquetasNuevas(String et, String ef) {
        this.etiquetas = new EtiquetaDoble(et, ef);
    }
}
