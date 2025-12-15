/**
 * Clase publica que representa un casting. Extiende la clase EXPRESION
 * Es una expresion generica solo que precede del tipo que espera asignarle
 * CASTING: ( tipo ) EXPRESION
 */
public class CASTING extends EXPRESION {

    /**
     * Constructor de la clase CASTING. Asigna el tipo y la expresion.
     * @param t
     * @param e
     */
    public CASTING(TIPO t, EXPRESION e){
        super(null, e);
        this.tipo = t;
    }

    /**
     * Metodo publico para la generacion del codio de un casting.
     * 
     * ti = (tipo) exp
     */
    public void gc(){

        //Se procesa la expresion
        if(this.dcha != null){
            this.dcha.gc();
        }

        //Se toman los tipos y la etiqueta de la expresion para facilitar el trabajo
        int nuevoTipo = this.getTipo();
        int antiguoTipo = ((EXPRESION)this.dcha).getTipo();
        String etiqExpresion = ((EXPRESION)this.dcha).getTemp();

        //Si los tipos son diferentes puede realizarse el casting
        if(nuevoTipo != antiguoTipo){

            //Caso de casting: (float) entero.
            // ti = (float) exp
            if(nuevoTipo == TIPO.REAL && antiguoTipo == TIPO.ENTERO){
                String etiq = Generador.nuevaTemporal();
                this.setTemp(etiq);
                String convertido = "(float) "+ etiqExpresion;
                Generador.asigna(etiq, convertido);
            }

            //Caso del casting: (int) real
            // ti = (int) exp
            if(nuevoTipo == TIPO.ENTERO && antiguoTipo == TIPO.REAL){
                String etiq = Generador.nuevaTemporal();
                this.setTemp(etiq);
                String convertido = "(int) "+ etiqExpresion;
                Generador.asigna(etiq, convertido);
            }

            //Caso del casting: (char) entero
            //Como un char es un unicode, no hace falta conversion, solamente se asocia la 
            //etiqueta
            if(nuevoTipo == TIPO.CARACTER && antiguoTipo == TIPO.ENTERO){
                this.setTemp(etiqExpresion);
            }

            //Caso del casting (int) char
            //De nuevo, no vuelve a hacer falta conversion, solo se asocia la etiqueta
            if(nuevoTipo == TIPO.ENTERO && antiguoTipo == TIPO.CARACTER){
                this.setTemp(etiqExpresion);
            }

        //En caso de que los tipos sean los mismos, no hace falta casting, se asocia
        //la etiqueta directamente
        } else {
            this.setTemp(etiqExpresion);
        }
    }
    
}
