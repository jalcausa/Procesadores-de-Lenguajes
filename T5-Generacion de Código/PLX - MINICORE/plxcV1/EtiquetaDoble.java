/**
 * Clase que recreará una etiqueta doble formada por dos Strings.
 * Se empleara de forma auxiliar para los objetos de las clases que extiendan de CONDICION.
 */
public class EtiquetaDoble{
    private String etiqueta1;
    private String etiqueta2;


    public EtiquetaDoble(){
        etiqueta1 = Generador.nuevaLabel();
        etiqueta2 = Generador.nuevaLabel();
    }

    public EtiquetaDoble(String et, String ef){
        etiqueta1 = et;
        etiqueta2 = ef;
    }

    /**
     * Metodo para devolver la etiqueta del código en caso de ser una condición TRUE
     * @return String etiqueta1;
     */
    public String getET(){
        return etiqueta1;
    }

    /**
     * Metodo para devolver la etiqueta del código en caso de ser una condición FALSE
     * @return String etiqueta2;
     */
    public String getEF(){
        return etiqueta2;
    }

    /**
     * Metodo para establecer la etiqueta del codigo donde ir en caso de condicion TRUE
     * @param et nueva etiqueta cierta
     */
    public void setET(String et){
        etiqueta1 = et;
    }

    /**
     * Metodo para establecer la etiqueta del codigo donde ir en caso de condicion FALSE
     * @param ef nueva etiqueta falsa
     */
    public void setEF(String ef){
        etiqueta2 = ef;
    }
}