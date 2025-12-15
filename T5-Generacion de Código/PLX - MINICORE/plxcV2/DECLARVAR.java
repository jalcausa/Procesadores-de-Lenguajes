/**
 * Clase publica que representa una sentencia del tipo declaracion de variable.
 * Extiende de AST aunque sus ramas son siempre nulas puesto que no finalmente se trata como 
 * una unica declaracion individual. 
 * tipo: TIPO el tipo de la variable declarada
 * id: String el identificador de la variable declarada
 * 
 * DECLARVAR :: declarvar, id
 * DECLARVAR :: tipo id
 */
public class DECLARVAR extends AST{
    
    private TIPO tipo;
    private String lastID;

    public DECLARVAR(TIPO tipo, String id){
        super(null, null);
        this.tipo = tipo;
        this.lastID = id;
    }

    public DECLARVAR(DECLARVAR izq, TIPO tipo, String id, ASIG dcha){
        super(izq, dcha);
        this.tipo = tipo;
        this.lastID = id;
    }


    /**
     * Metodo publico que devuelve el tipo de la variable declarada
     * @return TIPO tipo de variable declarada
     */
    public TIPO getTipo(){
        return this.tipo;
    }

    /**
     * Metodo publico que devuelve el identificador de la variable declarada
     * @return String identificador de la variable declarada
     */
    public String getLastId(){
        return this.lastID;
    }

    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }

        if(this.dcha!=null){
            this.dcha.gc();
        }
    }

}