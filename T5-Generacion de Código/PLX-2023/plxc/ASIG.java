public class ASIG extends EXPRESION {

    private String nomVar;

    public ASIG(String izq, EXPRESION dcha){
        super(null, dcha);
        this.temp = izq;
        this.nomVar = izq;
        if(dcha != null){
            this.tipo = dcha.getTipoObj();
        }
    }

    public String getNomVar(){
        return nomVar;
    }

    public void gc(){
        if(this.dcha != null){
            this.dcha.gc();
            
            EXPRESION exp = (EXPRESION) this.dcha;
            int tipoExp = exp.getTipo();
            
            if(tipoExp == TIPO.CONJUNTO){
                String tempExp = exp.getTemp();
                String lenExp = tempExp + "_length";
                String lenVar = nomVar + "_length";
                
                Generador.asigna(lenVar, "0");
                
                String i = Generador.nuevaTemporal();
                String elem = Generador.nuevaTemporal();
                
                String lInicio = Generador.nuevaLabel();
                String lCuerpo = Generador.nuevaLabel();
                String lFin = Generador.nuevaLabel();
                
                Generador.asigna(i, "0");
                Generador.printlabel(lInicio);
                Generador.menor(i, lenExp, lCuerpo, lFin);
                Generador.printlabel(lCuerpo);
                Generador.asigna(elem, tempExp + "[" + i + "]");
                Generador.asigna(nomVar + "[" + lenVar + "]", elem);
                Generador.asigna(lenVar, lenVar + " + 1");
                Generador.asigna(i, i + " + 1");
                Generador.gotolabel(lInicio);
                Generador.printlabel(lFin);
            } else {
                Generador.asigna(nomVar, exp.getTemp());
            }
            
            this.temp = exp.getTemp();
        }
    }
}
