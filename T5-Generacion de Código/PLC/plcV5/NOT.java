public class NOT extends CONDICION{
    
    public NOT(CONDICION izq, CONDICION dcha){
        super(izq, dcha);
    }
    
    //Al ser un not, simplemente cambiamos las direcciones del caso afirmativo y del 
    //caso negativo y entonces imprimimos la condicion cambiada.
    public void gc(){
        if(izq!=null){
            String newetf = ((CONDICION)this.izq).getEtt();
            String newett = ((CONDICION)this.izq).getEtf();
            ((CONDICION)this.izq).setEtf(newetf);
            ((CONDICION)this.izq).setEtt(newett);
            this.izq.gc();
        }

    }
}
