/**
 * Clase publica que representa una sentencia del tipo declaracion de vector.
 * Extiende de AST aunque no se emplean estas en todos los casos.
 * izq: DECLARVER con las declaraciones previas a la del ultimo vector de la sentencia
 * dcha: ASIG: ultima asignacion realizada
 * tipo: TIPO el tipo de la variable declarada
 * id: String el identificador de la variable declarada
 * 
 * DECLARVEC :: declarvec, id[n]
 * DECLARVEC :: tipo id[n]
 * DECLARVEC :: tipo id[n] = expvector
 * DECLARVEC :: declarvec, id[n] = expvector
 */
public class DECLARVEC extends AST{
    
    private TIPO tipo;
    private String lastID;

    /**
     * Constructor de la clase DECLARVEC para el caso mas sencillo (DECLARVEC :: tipo id[n])
     * Establece ambas ramas como nulas y asigna el tipo y el identificador
     * @param tipo TIPO tipo de la variable declarada
     * @param id String identificador de la variable declarada
     */
    public DECLARVEC(TIPO tipo, String id){
        super(null, null);
        this.tipo = tipo;
        this.lastID = id;
    }

    /**
     * Constructor de la clase DECLARVEC para los casos complejos (el resto)
     * @param izq DECLARVEC que contendrá las declaraciones de variables previas en caso de 
     *            que estas existan
     * @param tipo TIPO tipo de los vectores declarados
     * @param id String identificador del ultimo vector declarado
     * @param dcha ASIG asignacion realizada para lel ultimo vector declarado
     */
    public DECLARVEC(DECLARVEC izq, TIPO tipo, String id, ASIG dcha){
        super(izq, dcha);
        this.tipo = tipo;
        this.lastID = id;
    }


    /**
     * Metodo publico que devuelve el tipo del vector declarado
     * @return TIPO tipo de vector declardo
     */
    public TIPO getTipo(){
        return this.tipo;
    }

    /**
     * Metodo publico que devuelve el identificador del vector declarado
     * @return String identificador del vector declarada
     */
    public String getLastId(){
        return this.lastID;
    }

    /**
     * Metodo que genera el codigo ctd correspondiente a las asignaciones realizadas a 
     * lo largo de la declaracion de un vector
     */
    public void gc(){
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos la longitud del vector
        Generador.printLength(lastID, tipo.getTam());

        if(this.dcha!=null){
            this.dcha.gc();
        }
    }

}