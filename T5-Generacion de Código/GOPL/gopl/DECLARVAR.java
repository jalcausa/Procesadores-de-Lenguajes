/**
 * Clase publica que representa una sentencia del tipo declaracion de variable.
 * Extiende de AST aunque no se emplean estas en todos los casos.
 * izq: DECLARVAR con las declaraciones previas a la de la ultima variable de la sentencia
 * dcha: ASIG: ultima asignacion realizada
 * tipo: TIPO el tipo de la variable declarada
 * lastId: String el identificador de la variable declarada
 * 
 * DECLARVAR :: declarvar, id
 * DECLARVAR :: tipo id
 * DECLARVAR :: tipo id = exp
 * DECLARVAR :: declarvar, id = exp
 */
public class DECLARVAR extends AST{
    
    private TIPO tipo;
    private String lastID;

    /**
     * Constructor de la clase DECLARVAR para el caso mas sencillo (DECLARVAR :: tipo id)
     * Establece ambas ramas como nulas y asigna el tipo y el identificador
     * @param tipo TIPO tipo de la variable declarada
     * @param id String identificador de la variable declarada
     */
    public DECLARVAR(TIPO tipo, String id){
        super(null, null);
        this.tipo = tipo;
        this.lastID = id;
    }

    /**
     * Constructor de la clase DECLARVAR para los casos complejos (el resto)
     * @param izq DECLARVAR que contendrá las declaraciones de variables previas en caso de 
     *            que estas existan
     * @param tipo TIPO tipo de las variables declaradas
     * @param id String identificador de la ultima variable declarada
     * @param dcha ASIG asignacion realizada para la ultima variable declarada
     */
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

    /**
     * Metodo que genera el codigo ctd correspondiente a las asignaciones realizadas a 
     * lo largo de la declaracion
     */
    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }

        if(this.dcha!=null){
            this.dcha.gc();
        }
    }

}