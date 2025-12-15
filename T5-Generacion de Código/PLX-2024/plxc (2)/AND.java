/**
 * Clase AND que extiende de CONDICION y representa precisamente la operacion AND entre 
 * dos condiciones.
 * izq: CONDICION condicion1
 * dcha: CONDICION condicion2
 * etiquetas: etiquetas correspondientes a la condicion
 * AND :: condicion1 && condicion2
 */
public class AND extends CONDICION {

    /**
     * Constructor de la clase AND. Asigna condiciones
     * @param izq CONDICION condicion1
     * @param dcha CONDICION condicion2
     */
    public AND(EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        this.setTipo(TIPO.CONDICION);
        if(izq.getTipo() != TIPO.CONDICION || dcha.getTipo()!= TIPO.CONDICION){
            Generador.error(Generador.E_NOBOOLEAN);
        }
    }

    /**
     * Metodo que genera el siguiente codigo
     * if expcond1 goto Lt1
     * goto Lf1
     * Lt1: if expcond2 goto Lt2
     *      goto Lf2
     * Lf1: goto Lf2
     * 
     * Después asignamos a la condicion AND que tenga como ett el valor de lt2 y etf lf2
     */
    public void gc(){
        //Procesamos la primera condicion e imprimirmos las dos primeras lineas
        if(this.izq!=null){
            this.izq.gc();
        }

        //Imprimimos Lt1:
        String lt1 = ((CONDICION)this.izq).getEtt();
        String lf1 = ((CONDICION)this.izq).getEtf();
        Generador.printlabel(lt1);

        //Imprimimos el contenido de detro de lt1, que no es mas que procesar la segunda condicion
        if(this.dcha!=null){
            this.dcha.gc();
        }

        //Imprimimos Lf1: goto Lf2
        String lt2 = ((CONDICION)this.dcha).getEtt();
        String lf2 = ((CONDICION)this.dcha).getEtf();
        Generador.printlabel(lf1);
        Generador.gotolabel(lf2);

        //Asignamos la dirección de lt2 como la direccion a donde ir en caso de ser cierta 
        //la condición y la dirección de lf2 como la direccion a donde ir en caso de 
        //ser falsa.
        this.asignaEtiquetasNuevas(lt2, lf2);
        this.temp = Generador.nuevaTemporal();





    }

}


