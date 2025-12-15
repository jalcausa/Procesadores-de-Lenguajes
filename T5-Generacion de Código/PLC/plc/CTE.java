/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo constante
 * izq: EXPRESION vacia
 * dcha: EXPRESION vacia
 * temp: String correpondiente al valor de la constante
 * CONSTANTE :: valor
 */
public class CTE extends EXPRESION{

    /**
     * Constructor de una nueva constante
     * @param izq String con el valor de la constante
     * @param dcha null, podría suprimirse
     */
    public CTE(String izq, EXPRESION dcha){
        //Es un nodo hoja, no tiene ninguna rama y por ello se ponen como nulas
        super(null, null);

        //Se establece el valor de la constante
        this.temp = izq;
    }

    //Aquí no necesitamos gc puesto que nunca tendremos una línea que sea x o una linea
    //que sea 5 solamente, estas ex
}
