public class MENOR extends CONDICION{

    public MENOR(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
    }
    
    public void gc(){
        if(izq!=null){
            izq.gc();
        }

        if(dcha!=null){
            dcha.gc();
        }
        
        String a = ((EXPRESION)izq).getTemp();
        String b = ((EXPRESION)dcha).getTemp();
        String ev = this.getEtt();
        String ef = this.getEtf();
        Generador.menor(a,b, ev, ef);
    }
}