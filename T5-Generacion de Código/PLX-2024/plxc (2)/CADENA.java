/**
 * Clase publica CADENA que representa un String.
 * text: String el propio string
 * izq: AST null
 * dcha: AST null
 * temp: String identificador del string
 * tipo: TIPO del string (4, 0, tam)
 */
public class CADENA extends EXPRESION {
    private String text;

    /**
     * Constructor de la clase CADENA. Este asocia el string, el tipo y un nuevo id
     * para el string
     * @param s el propio string
     * @param t tipo
     */
    public CADENA(String s, TIPO t){
        super(null, null);
        text = s;
        this.tipo = t;
        this.setTam(s.length());
        this.temp = Generador.nuevaTemporal();
    }

    /**
     * Metodo publico para acceder al contenido del string
     * @return
     */
    public String getText(){
        return this.text;
    }

    /**
     * Metodo publico que genera el codigo CTD para representar un string
     *  st[0] = unicodechar0;
     *        |
     *  st[tam-1] = unicodecharn;
     *  st_length = tam;
     */
    public void gc(){
        for (int i = 0; i<this.tipo.getTam(); i++){
            String idchar = this.temp+"["+i+"]";
            String charac = String.valueOf((int)text.charAt(i));
            Generador.asigna(idchar, charac);
        }
        Generador.printLength(this.temp, this.getTam());
    }
}
