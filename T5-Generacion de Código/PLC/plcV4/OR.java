public class OR extends CONDICION {

    public OR(CONDICION izq, CONDICION dcha){
        super(izq, dcha);
        //Aquí estamos consumiendo 2 etiquetas que luego no vamos a usar
    }

    /**
     * En el caso de un or se busca generar el código siguiente para esta condicion
     * 
     * if expcond1 goto Lt1
     * goto Lf1
     * Lt1: goto Lt2
     * Lf1: if expcond2 goto Lt2
     *      goto Lf2
     * 
     * después asignamos a la condicion del or que tenga como ett el valor de lt2 y etf lf1
     */
    public void gc(){

        //Imprimimos
        //if expcond1 goto lt1
        //goto lf1
        if(this.izq!=null){
            this.izq.gc();
        }

        String lt1 = ((CONDICION)this.izq).getEtt();
        String lf1 = ((CONDICION)this.izq).getEtf();
        
        //Imprimimos
        //Lt1: goto Lt2
        String lt2 = "";
        String lf2 = "";
        if(this.dcha!=null) {
            lt2 = ((CONDICION)this.dcha).getEtt();
            lf2 = ((CONDICION)this.dcha).getEtf();
            Generador.printlabel(lt1);
            Generador.gotolabel(lt2);
        }


        //Imprimimos 
        //lf1: if expcond2 goto lt2
        //     goto lf2
        Generador.printlabel(lf1);
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //asignamos a esta condición las etiquetas correspondientes, en caso afirmativo lt2
        //y en caso negativo lf2
        this.setEtf(lf2);
        this.setEtt(lt2);
    }

}
