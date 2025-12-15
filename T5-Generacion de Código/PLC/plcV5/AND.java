public class AND extends CONDICION {

    public AND(CONDICION izq, CONDICION dcha){
        super(izq, dcha);
        //Aquí estamos consumiendo 2 etiquetas que luego no vamos a usar
    }

    /**
     * En el caso de un and se busca generar el código siguiente para esta condicion
     * 
     * if expcond1 goto Lt1
     * goto Lf1
     * Lt1: if expcond2 goto Lt2
     *      goto Lf2
     * Lf1: goto Lf2
     * 
     * después asignamos a la condicion del and que tenga como ett el valor de lt2 y etf lf1
     */
    public void gc(){
        //impirmimos 
        // if expcond1 goto Lt1
        // goto Lf1
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos Lt1:
        String lt1 = ((CONDICION)this.izq).getEtt();
        String lf1 = ((CONDICION)this.izq).getEtf();

        Generador.printlabel(lt1);

        //Imprimimos el contenido dentro de Lt1
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Si caemos en caso falso de la primera condición, directamente nos vamos al caso
        //falso de la segunda condicion. Imprimimos
        //Lf1: goto Lf2
        String lt2 = ((CONDICION)this.dcha).getEtt();
        String lf2 = ((CONDICION)this.dcha).getEtf();

        //Asignamos la dirección de lt2 como la direccion a donde ir en caso de ser cierta 
        //la condición y la dirección de lf2 como la direccion a donde ir en caso de 
        //ser falsa.
        Generador.printlabel(lf1);
        Generador.gotolabel(lf2);
        this.setEtt(lt2);
        this.setEtf(lf2);





    }

}


