public class CONDICION extends AST {

    private EtiquetaDoble etiquetas;
    private String ett;
    private String etf;

    
    
    public CONDICION(AST izq, AST dcha){
        super(izq, dcha);
        this.etiquetas = new EtiquetaDoble();
        this.ett = etiquetas.getET();
        this.etf = etiquetas.getEF();
    }

    public String getEtt(){
        return this.ett;
    }

    public String getEtf(){
        return this.etf;
    }

    public void setEtt(String et){
        this.ett = et;
    }

    public void setEtf(String ef){
        this.etf = ef;
    }

}
