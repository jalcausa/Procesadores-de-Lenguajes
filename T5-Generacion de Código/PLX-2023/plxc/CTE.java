public class CTE extends EXPRESION {

    public CTE(String valor, AST dcha, TIPO t){
        super(null, dcha);
        this.temp = valor;
        this.tipo = t;
    }

    public void gc(){
    }
}
