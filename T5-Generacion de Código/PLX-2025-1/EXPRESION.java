public class EXPRESION extends AST {

    protected String temp; 
    
    public EXPRESION(AST izq, AST dcha) {
        super(izq, dcha);
    }
    
    public String getTemp() {
        return this.temp;
    }

    public void setTemp(String t) {
        this.temp = t;
    }
}
