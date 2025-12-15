public class ASIG extends EXPRESION {

    public ASIG(String izq, EXPRESION dcha){
        super(null, dcha);
        this.temp = izq;
    }

    public void gc(){
        this.dcha.gc();
        Generador.asigna(this.getTemp(), ((EXPRESION)this.dcha).getTemp());
    }
    


    
}
