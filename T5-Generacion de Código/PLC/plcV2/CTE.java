public class CTE extends EXPRESION{

    public CTE(String izq, EXPRESION dcha){
        super(null, null);
        this.temp = izq;
    }

    //Aquí no necesitamos gc puesto que nunca tendremos una línea que sea x o una linea
    //que sea 5 solamente. 
}
