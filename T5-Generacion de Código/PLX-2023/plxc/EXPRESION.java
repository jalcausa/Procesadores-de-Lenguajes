public class EXPRESION extends AST{

    protected String temp; 
    protected TIPO tipo;
    
    public EXPRESION(AST izq, AST dcha){
        super(izq, dcha);
        tipo = new TIPO();
    }
    
    public String getTemp(){
        return this.temp;
    }

    public void setTemp(String t){
        this.temp = t;
    }

    public int getTipo(){
        return tipo.getTipo();
    }

    public int getSubtipo(){
        return tipo.getSubtipo();
    }

    public int getTam(){
        return this.tipo.getTam();
    }
    
    public void setTipo(int i){
        this.tipo.setTipo(i);
    }

    public void setSubtipo(int i){
        this.tipo.setSubtipo(i);
    }

    public void setTam(int i){
        this.tipo.setTam(i);
    }

    public TIPO getTipoObj(){
        return this.tipo;
    }

    public void setTipoObj(TIPO t){
        this.tipo = t;
    }
}
