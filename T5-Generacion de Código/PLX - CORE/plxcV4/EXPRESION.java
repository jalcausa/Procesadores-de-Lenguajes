/**
 * Clase abstracta que sirve como forma común a todas las expresiones.
 * A su vez extiende de AST. Ademas de las ramas izquierda y derecha tiene un parametro temp
 * y un tipo.
 * El parametro temp no se asignara hasta que no se instancie a un tipo específico de 
 * expresion. El tipo nos indicara el tipo de la expresion, int, float, char, string o array
 * temp: String donde se almacena el nombre o identificador asignado a la expresion.
 * izq: AST donde se guarda la rama izquierda.
 * dcha: AST donde se guarda la rama derecha.
 * tipo: TIPO indica el tipo.
 */
public class EXPRESION extends AST{

    protected String temp; 
    protected TIPO tipo;
    
    /**
     * Constructor de la clase expresion. Se asignan las ramas izquierda y derecha y un tipo
     * inicializado pero aun no asignado.
     * @param izq AST izquierdo
     * @param dcha AST derecho
     */
    public EXPRESION(AST izq, AST dcha){
        super(izq, dcha);
        tipo = new TIPO();
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

    /**
     * Metodo publico para obtener el tipo de la expresion
     * @return int con el tipo de la expresion
     */
    public int getTipo(){
        return tipo.getTipo();
    }

    /**
     * Metodo publico para obtener el subtipo de la expresion
     * @return int con el subtipo de la expresion
     */
    public int getSubtipo(){
        return tipo.getSubtipo();
    }

    /**
     * Metodo publico para obtener el tamaño de la expresion
     * @return int con el tamaño de la expreison
     */
    public int getTam(){
        return this.tipo.getTam();
    }
    
    /**
     * Metodo publico para asignar un nuevo tipo a la expresion
     * @param i nuevo tipo
     */
    public void setTipo(int i){
        this.tipo.setTipo(i);
    }

    /**
     * Metodo publico para asignar un nuevo subtipo a la expresion
     * @param i nuevo subtipo
     */
    public void setSubtipo(int i){
        this.tipo.setSubtipo(i);
    }

    /**
     * Metodo publico para asigna el tamaño en caso de que el tipo sea vector o string
     * en caso contrario no hace nada
     * @param i asigna un tamaño para el vector o string
     */
    public void setTam(int i){
        if(getTipo()==TIPO.VECTOR || getTipo() == TIPO.CADENA){
            this.tipo.setTam(i);
        }
    }

}
