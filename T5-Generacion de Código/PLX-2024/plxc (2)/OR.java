/**
 * Clase OR que extiende de CONDICION y representa precisamente la operacion OR entre 
 * dos condiciones.
 * izq: CONDICION condicion1
 * dcha: CONDICION condicion2
 * etiquetas: etiquetas correspondientes a la condicion
 * OR :: condicion1 || condicion2
 */
public class OR extends CONDICION {

    /**
     * Constructor de la clase OR. Asigna condiciones
     * @param izq CONDICION condicion1
     * @param dcha CONDICION condicion2
     */
    public OR(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.setTipo(TIPO.CONDICION);
        if(izq.getTipo() != TIPO.CONDICION || dcha.getTipo()!= TIPO.CONDICION){
            Generador.error(Generador.E_NOBOOLEAN);
        }
    }

    /**
     * Metodo que genera el siguiente codigo CTD:
     * if expcond1 goto Lt1
     * goto Lf1
     * Lf1: if expcond2 goto Lt2
     *      goto Lf2
     * Lt1: goto Lt2
     * 
     * Después asignamos a la condicion del or que tenga como ett y etf el valor de lt2 y lf2
     */
    public void gc(){

        //Procesamos la primera condicion e imprimirmos las dos primeras lineas
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos Lf1:
        String lt1 = ((CONDICION)this.izq).getEtt();
        String lf1 = ((CONDICION)this.izq).getEtf();
        Generador.printlabel(lf1);

        //Procesamos la segunda condicion
        if(this.dcha!=null){
            this.dcha.gc();
        }
        //Imprimimos Lt1: goto Lt2
        Generador.printlabel(lt1);
        String lt2 = ((CONDICION)this.dcha).getEtt();
        String lf2 = ((CONDICION)this.dcha).getEtf();
        Generador.gotolabel(lt2);

        //Asignamos a esta condición las etiquetas correspondientes, en caso afirmativo lt2
        //y en caso negativo lf2
        this.asignaEtiquetasNuevas(lt2, lf2);
        this.temp = Generador.nuevaTemporal();
    }

}
