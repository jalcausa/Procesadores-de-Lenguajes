/**
 * Clase publica que representara el tipo de una expresion.
 * tipo: entero que representa el tipo
 * subtipo: entero que que en caso de ser un array representa el tipo de los elementos 
 *          del array. (ej: int[] tendrá tipo 5 y subtipo 1)
 * tam : entero que representa el tamaño de un array o de un string. Por defecto viene a 0
 *       en todos los tipos existentes
 */
public class TIPO {
    public static final int NOASIGNADO = 0;
    public static final int ENTERO = 1;
    public static final int REAL = 2;
    public static final int CARACTER = 3;
    public static final int CADENA = 4;
    public static final int VECTOR = 5;
    public static final int CONDICION = 6;

    private int tipo;
    private int subtipo;
    private int tam;

    /**
     * Constructor auxiliar para inicializar los tipos y tamaño aun sin asignar
     */
    public TIPO(){
        tipo = 0;
        subtipo = 0;
        tam = 0;
    }


    /**
     * Constructor de los tipos simples y los Strings
     * @param t tipo
     */
    public TIPO(int t){
        tipo = t;
        subtipo = -1;
        tam = 0;
    }

    /**
     * Constructor de los tipos compuestos (array)
     * @param t tipo: deberia ser siempre 5
     * @param st subtipo: deberia ser 1,2 o 3
     * @param exptam tamaño con el que se declara el array. 
     */
    public TIPO(int t, int st, int exptam){
        tipo = t;
        subtipo = st;
        tam = exptam;
    }


    /**
     * Devuelve el tipo
     * @return tipo
     */
    public int getTipo(){
        return tipo;
    }


    /**
     * Devuelve el subtipo
     * @return subtipo
     */
    public int getSubtipo(){
        return subtipo;
    }

    /**
     * Metodo publico para obtener el tamaño de un tipo vector o string
     * @return
     */
    public int getTam(){
        return this.tam;
    }

    /**
     * Metodo publico para cambiar el tipo de una expresion
     * @param nt
     */
    public void setTipo(int nt){
        tipo = nt;
    }
    

    /**
     * Metodo publico para cambiar el subtipo de una expresion
     * @param nst
     */
    public void setSubtipo(int nst){
        subtipo = nst;
    }


    /**
     * Metodo publico cambiar el tamaño de un tipo vector o string
     * @param t
     */
    public void setTam(int t){
        this.tam = t;
    }

    
}
