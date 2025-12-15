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

    public CADENA(String s, TIPO t){
        super(null, null);
        text = s;
        this.tipo = t;
        this.setTam(s.length());
        this.temp = Generador.nuevaTemporal();
    }

    public String getText(){
        return this.text;
    }

    public void gc(){
        for (int i = 0; i<this.tipo.getTam(); i++){
            String idchar = this.temp+"["+i+"]";
            String charac = String.valueOf((int)text.charAt(i));
            Generador.asigna(idchar, charac);
        }
        Generador.printLength(this.temp, this.getTam());
    }
}
