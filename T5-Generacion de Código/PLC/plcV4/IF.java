public class IF extends AST{

    public IF(AST cond, AST sent){
        super(cond, sent);
    }

    public void gc(){
        //Imprimimos la parte de la condicion
        if(this.izq!=null){
            izq.gc();
        }

        //Imprimimos la parte de la sentencia
        //La etiqueta del caso afirmativo
        Generador.printlabel(((CONDICION)this.izq).getEtt());

        //Imprimimos la sentencia en sí
        if(this.dcha!=null){
            dcha.gc();
        }

        //Generamos una nueva etiqueta, donde continuara el codigo tras la sentencia del if
        //para asi conseguir saltarnos la parte del caso negativo o del else.
        //Estamos en un if simple y no habra else, pero lo dejamos preparado para cuando se
        //añada
        String etiquetaContinuacion = Generador.nuevaLabel();
        Generador.gotolabel(etiquetaContinuacion);

        //Imprimimos la etiqueta del caso del no
        Generador.printlabel(((CONDICION)this.izq).getEtf());

        //En una futura clase ifelse aqui iran las sentencias del else

        //Imprimos la etiqueta de la continuacion del codigo
        Generador.printlabel(etiquetaContinuacion);
    }
    
}
