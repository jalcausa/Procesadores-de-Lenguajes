/**
 * Clase abstracta que implementa un Abstract Syntax Tree. 
 * Esta clase es la principal del programa y de ella extenderán el resto de clases
 * empleadas para generar el código específico en CTD.
 */
public class AST {

    //Ramas del arbol
    protected AST izq;
    protected AST dcha;

    /**
     * Constructor de la clase AST y del resto de clases que extiendan de él en su defecto
     * @param i arbol de la derecha
     * @param d arbol de la izquierda
     */
    public AST(AST i, AST d){
        izq = i;
        dcha = d;
    }

    /**
     * Metodo publico para el acceso a la ramificación izquierda del arbol
     * @return AST izq
     */
    public AST getIzq(){
        return izq;
    }

    /**
     * Metodo publico para el acceso a la ramificacion derecha del arbol
     * @return AST dcha
     */
    public AST getDer(){
        return dcha;
    }

    /**
     * Metodo que genera el código CTD. Un AST general simplemente delega esta tarea en sus
     * ramas no nulas y son estos, las clases que extienden de AST quienes generan el codigo
     * llamando a metodos estaticos de la clase Generador.
     */
    public void gc(){
        if(izq != null){
            izq.gc();
        }
        if(dcha != null){
            dcha.gc();
        }
    }

}