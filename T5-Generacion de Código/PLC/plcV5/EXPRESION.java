public class EXPRESION extends AST{

    //Es el identificador de la expresión como variable temporal
    protected String temp; 
    
    /**
     * Constructor de la clase expresion. Representa las expresiones de cup.
     * Cuenta con un identificador temporal temp.
     * @param izq
     * @param dcha
     */
    public EXPRESION(AST izq, AST dcha){
        super(izq, dcha);
        
    }
    
    /**
     * Método público para el acceso al string temp
     * @return temp
     */
    public String getTemp(){
        return this.temp;
    }

    
}
