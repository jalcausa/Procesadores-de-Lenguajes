/**
 * Clase abstracta que sirve como forma común a todas las condiciones
 * A su vez extiende de AST. Ademas de las ramas izquierda y derecha tiene un parametro etiquetas.
 * El parametro etiquetas no se asignara hasta que no se vaya a representar un tipo 
 * especifico de condicion
 * izq: AST donde se guarda la rama izquierda.
 * dcha: AST donde se guarda la rama derecha.
 * etiquetas: EtiquetaDoble donde se guardan las etiquetas Ett y Etf que indican la ubicacion
              del codigo por donde seguir en caso de que la condicion se TRUE o FALSE.
 */
public class CONDICION extends EXPRESION {

    protected EtiquetaDoble etiquetas;
    
    /**
     * Constructor de la clase CONDICION donde simplemente se asignan las ramas de la condicion
     * @param izq rama izquierda
     * @param dcha rama derecha
     */
    public CONDICION(AST izq, AST dcha){
        super(izq, dcha);
    }

    /**
     * Metodo publico para obtener la etiqueta del caso de ser una condicion TRUE
     * @return String ett
     */
    public String getEtt(){
        return this.etiquetas.getET();
    }

    /**
     * Metodo publico para obtener la etiqueta del caso de ser una condicion FALSE
     * @return String etf
     */
    public String getEtf(){
        return this.etiquetas.getEF();
    }

    /**
     * Metodo publico para modificar la etiqueta del caso de condicion TRUE
     * @param et nueva etiqueta true
     */
    public void setEtt(String et){
        this.etiquetas.setET(et);
    }

    /**
     * Metodo publico para modificar la etiqueta del caso de condicion FALSE
     * @param et nueva etiqueta false
     */
    public void setEtf(String ef){
        this.etiquetas.setEF(ef);
    }

    /**
     * Metodo protegido para asignar las etiquetas a la condicion en el momento necesario
     */
    protected void asignaEtiquetasNuevas(){
        this.etiquetas = new EtiquetaDoble();
    }

    /**
     * Metodo progregido para asignar las etiquetas a la condicion en el momento necesario
     * @param et etiqueta true
     * @param ef etiqueta false
     */
    protected void asignaEtiquetasNuevas(String et, String ef){
        this.etiquetas = new EtiquetaDoble(et, ef);
    }

}
