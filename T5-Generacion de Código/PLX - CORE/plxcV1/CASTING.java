public class CASTING extends EXPRESION {

    public CASTING(TIPO t, EXPRESION e){
        super(null, e);
        this.tipo = t;
    }

    public void gc(){
        if(this.dcha != null){
            this.dcha.gc();
        }

        int nuevoTipo = this.getTipo();
        int nuevoSubtipo = this.getSubtipo();
        int antiguoTipo = ((EXPRESION)this.dcha).getTipo();
        int antiguoSubtipo = ((EXPRESION)this.dcha).getSubtipo();
        String etiqExpresion = ((EXPRESION)this.dcha).getTemp();

        if(nuevoTipo != antiguoTipo){

            if(nuevoTipo == TIPO.REAL && antiguoTipo == TIPO.ENTERO){
                String etiq = Generador.nuevaTemporal();
                this.setTemp(etiq);
                String convertido = "(float) "+ etiqExpresion;
                Generador.asigna(etiq, convertido);
            }

            if(nuevoTipo == TIPO.ENTERO && antiguoTipo == TIPO.REAL){
                String etiq = Generador.nuevaTemporal();
                this.setTemp(etiq);
                String convertido = "(int) "+ etiqExpresion;
                Generador.asigna(etiq, convertido);
            }

        } else {
            this.setTemp(etiqExpresion);
        }
    }
    
}
