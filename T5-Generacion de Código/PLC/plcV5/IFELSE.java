public class IFELSE extends AST{

    public IFELSE(IF pif, AST sentelse){
        super(pif, sentelse);
    }

    public void gc(){
        
        CONDICION cond = null;
        AST sentif = null;

        if(this.izq!=null){
            cond = (CONDICION) this.izq.getIzq();
            sentif = this.izq.getDer();

        }

        //Imprimimos la parte de la condicion
        if(cond!=null){
            cond.gc();
        }

        //Imprimimos la parte de la sentencia del if, es decir, si la condicion es cierta
        //La etiqueta del caso afirmativo
        Generador.printlabel(cond.getEtt());

        //Imprimimos la sentencia del if
        if(this.dcha!=null){
            sentif.gc();
        }

        //Generamos una nueva etiqueta, donde continuara el codigo tras la sentencia del if
        //para asi conseguir saltarnos la parte del caso negativo o del else.
        //Estamos en un if simple y no habra else, pero lo dejamos preparado para cuando se
        //añada
        String etiquetaContinuacion = Generador.nuevaLabel();
        Generador.gotolabel(etiquetaContinuacion);

        //Imprimimos la etiqueta del caso del else
        Generador.printlabel(cond.getEtf());

        //Imprimimos las sentencias del else
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Imprimos la etiqueta de la continuacion del codigo
        Generador.printlabel(etiquetaContinuacion);
    }
    
}