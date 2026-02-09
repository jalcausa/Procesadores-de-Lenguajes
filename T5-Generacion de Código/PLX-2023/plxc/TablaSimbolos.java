import java.util.*;

public class TablaSimbolos {

    private static int tablaActual = 0;
    private static ArrayList<HashMap<String, TIPO>> tablas = new ArrayList<>();

    static{
        tablaActual = 0;
        HashMap<String, TIPO> tablaVacia = new HashMap<>();
        tablas.add(tablaVacia);    
    }
    
    public static void nuevaTabla(){
        tablaActual++;
        HashMap<String, TIPO> tablaVacia = new HashMap<>();
        tablas.add(tablaVacia);
    }

    public static void cierraTabla(){
        tablas.remove(tablaActual);
        tablaActual--;
    }

    public static boolean estaDefinida(String id){
        boolean res = false;
        int i = 0;
        while (i <= tablaActual && res == false){
            res = definidaEnTabla(i, id);
            i++;
        }
        return res;
    }

    public static void insertar(TIPO t, String id){
        tablas.get(tablaActual).put(id, t);
    }

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

    public static void modificar(String id, TIPO t){
        int i = indiceTabla(id);
        if(i != -1){
            tablas.get(i).put(id, t);
        }
    }

    private static boolean definidaEnTabla(int i, String id){
        return tablas.get(i).containsKey(id);
    }

    private static int indiceTabla(String id){
        int i = tablaActual;
        boolean encontrado = false;
        while(i >= 0 && !encontrado){
            encontrado = definidaEnTabla(i, id);
            if(!encontrado){
                i--;
            }
        }
        return i;
    }
}
