import java.util.*;

/**
 * Clase publica que sirvira como tabla de simbolos para nuestro traductor a CTD
 * tablaActual: int que representara la tabla actual en que estamos, es decir, el indice de tabla
 * tablas: ArrayList<HashMap<String,Tipo> es una lista de tablas.
 *         Cada tabla esta representada por un HashMap que contiene los identificadores
 *         y el tipo de cada variable declarada.
 */
public class TablaSimbolos {

    private static int tablaActual = 0;
    private static ArrayList<HashMap<String, TIPO>> tablas = new ArrayList<>();

    /**
     * Seccion de codigo que ocurre al comienzo de la ejecucion para iniciliazar 
     * la primera tabla del array de tablas
     */
    static{
        tablaActual = 0;
        HashMap<String, TIPO> tablaVacia = new HashMap<>();
        tablas.add(tablaVacia);    
    }
    
    /**
     * Metodo publico empleado para crear una nueva tabla en nuestro array de tablas
     * y posicionarnos para trabajar sobre ella.
     * Este metodo ha de ser invocado cada vez que se abra un nuevo bloque.
     */
    public static void nuevaTabla(){
        tablaActual++;
        HashMap<String, TIPO> tablaVacia = new HashMap<>();
        tablas.add(tablaVacia);
    }

    /**
     * Metodo publico empleado para eliminar la tabla actual en que nos encontramos
     * una vez el entorno local o bloque ha finalizado
     */
    public static void cierraTabla(){
        tablas.remove(tablaActual);
        tablaActual--;
    }

    /**
     * Metodo publico que se encarga de comprobar si una variable ha sido ya declarada
     * dentro de el bloque actual o alguno previo.
     * @param id String que representa el nombre de la variable a buscar.
     * @return boolean indicador de si esta definida o no la variable.
     */
    public static boolean estaDefinida(String id){
        boolean res = false;
        int i = 0;
        while (i <= tablaActual && res == false){
            res = definidaEnTabla(i, id);
            i++;
        }
        return res;
    }

    /**
     * Metodo publico que se encarga de insertar una nueva variable con su tipo en la 
     * tabla de simbolos del bloque en que se este
     * @param t TIPO
     * @param id String identificador
     */
    public static void insertar(TIPO t, String id){
        tablas.get(tablaActual).put(id, t);
    }

    /**
     * Metodo publico que devuelve el tipo de una variable.
     * @param id String identificador de la variable
     * @return TIPO de la variable o null en caso de no estar definida
     */
    public static TIPO getTipo(String id){
        TIPO res;
        int i = indiceTabla(id);
        if (i==-1){
            res = null;
        } else {
            res = tablas.get(i).get(id);
        }
        return res;
    }

    /**
     * Metodo publico para modificar un par de la tabla de símbolos
     * @param id String identificador de la variable a modificar
     * @param t TIPO nuevo que se le asigna
     */
    public static void modificar(String id, TIPO t){
        int i = indiceTabla(id);
        tablas.get(i).put(id, t);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    /// METODOS AUXILIARES PRIVADOS
    ////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Metodo privado que indica si una variable esta definida en una tabla o no
     * @param i indice de tabla
     * @param id identificador de la variable
     * @return boolean indicador de si esta definida o no la variable en la tabla ti
     */
    private static boolean definidaEnTabla(int i, String id){
        boolean res;
        if (tablas.get(i).get(id)==null){
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    /**
     * Metodo privado que devuelve el indice de la tabla en que se define una variable
     * @param id String identificador de la variable
     * @return int indice de tabla o -1 en caso de no estar definida
     */
    private static int indiceTabla(String id){
        int res = -1;
        boolean found = false;
        int i = 0;
        while (i<=tablaActual && !found){
            found = definidaEnTabla(i, id);
            i++;
        }
        if(found){
            res = i-1;
        } else{
            res = -1;
        }
        return res;
    }




}