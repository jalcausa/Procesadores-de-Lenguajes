public class EtiquetaDoble {
    private String etiqueta1;
    private String etiqueta2;

    public EtiquetaDoble() {
        etiqueta1 = Generador.nuevaEtiqueta();
        etiqueta2 = Generador.nuevaEtiqueta();
    }

    public EtiquetaDoble(String et, String ef) {
        etiqueta1 = et;
        etiqueta2 = ef;
    }

    public String getET() {
        return etiqueta1;
    }

    public String getEF() {
        return etiqueta2;
    }

    public void setET(String et) {
        etiqueta1 = et;
    }

    public void setEF(String ef) {
        etiqueta2 = ef;
    }
}
