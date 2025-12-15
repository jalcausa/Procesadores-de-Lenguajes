/**
 * Clase publica que representara el tipo de una expresion.
 * tipo: entero que representa el tipo
 * subtipo: entero que que en caso de ser un array representa el tipo de los elementos 
 *          del array. (ej: int[] tendrá tipo 5 y subtipo 1)
 */
public class TIPO {
    public static final int NOASIGNADO = 0;
    public static final int ENTERO = 1;
    public static final int REAL = 2;
    public static final int CARACTER = 3;
    public static final int CADENA = 4;
    public static final int VECTOR = 5;

    private int tipo;
    private int subtipo;

    /**
     * Constructor auxiliar para inicializar los tipos aun sin asignar
     */
    public TIPO(){
        tipo = 0;
        subtipo = 0;
    }

    /**
     * Constructor de los tipos simples y los Strings
     * @param t tipo
     */
    public TIPO(int t){
        tipo = t;
        subtipo = -1;
    }


    /**
     * Constructor de los tipos compuestos.
     * @param t tipo que será 5
     * @param st subtipo 
     */
    public TIPO (int t, int st){
        tipo = t;
        subtipo = st;
        //si nos pasan un array de char lo vemos como un String
        if(t==5 && st==3){
            tipo = 4;
            subtipo = -1;
        }
    }

    /**
     * Devuelve el tipo
     * @return tipo
     */
    public int getTipo(){
        return tipo;
    }

    public void setTipo(int nt){
        tipo = nt;
    }

    public void setSubtipo(int nst){
        subtipo = nst;
    }

    /**
     * Devuelve el subtipo
     * @return subtipo
     */
    public int getSubtipo(){
        return subtipo;
    }
    
}
