/**
 * Clase abstracta que implementa un Abstract Syntax Tree. 
 * Esta clase es la principal del programa y de ella extenderán el resto de clases
 * empleadas para generar el código específico en CTD.
 */
public class AST {

    protected AST izq;
    protected AST dcha;

    public AST(AST i, AST d){
        izq = i;
        dcha = d;
    }

    public AST getIzq(){
        return izq;
    }

    public AST getDer(){
        return dcha;
    }

    /**
     * Metodo que genera el código CTD. Estos se implementaran especificamente en las clases
     * que extiendan de AST y se hara llamando a metodos estaticos de la clase Generador.
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