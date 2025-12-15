public class AST {

    /*
            Esta es la clase principal que instancia cada nodo del árbol
            Funciona como clase abstracta porque el resto de .java heredan de ella 
     */
    

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

    /*
            procesa el cambio a ctd (dentro se llamarán a las clases de Generador.java)
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