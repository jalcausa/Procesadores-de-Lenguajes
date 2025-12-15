/**
 * Clase abstracta que sirve como forma común a todas las expresiones.
 * A su vez extiende de AST. Ademas de las ramas izquierda y derecha tiene un parametro temp.
 * El parametro temp no se asignara hasta que no se instancie a un tipo específico de 
 * expresion.
 * temp: String donde se almacena el nombre o identificador asignado a la expresion.
 * izq: AST donde se guarda la rama izquierda.
 * dcha: AST donde se guarda la rama derecha.
 */
public class EXPRESION extends AST{

    protected String temp; 
    
    /**
     * Constructor de la clase expresion. Solamente se asignan las ramas izquierda y derecha.
     * @param izq AST izquierdo
     * @param dcha AST derecho
     */
    public EXPRESION(AST izq, AST dcha){
        super(izq, dcha);
        
    }
    
    /**
     * Metodo publico para el acceso al String temp
     * @return temp
     */
    public String getTemp(){
        return this.temp;
    }

    /**
     * Metodo publico para modificar el String temp, es decir, cambiar el nombre
     * de la expresion.
     * @param t String que sera el nuevo nombre de la expresion
     */
    public void setTemp(String t){
        this.temp = t;
    }

    
}
