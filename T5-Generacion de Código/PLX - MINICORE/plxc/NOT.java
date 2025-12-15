/**
 * Clase NOT que extiende de CONDICION y representa precisamente la operacion unaria NOT 
 * izq: CONDICION condicion1
 * dcha: CONDICION null
 * etiquetas: etiquetas correspondientes a la condicion
 * NOT :: !condicion
 */
public class NOT extends CONDICION{
    
    /**
     * Constructor de la clase NOT. Asigna condicion a negar
     * @param izq CONDICION condicion a negar
     * @param dcha CONDICION null podria ser suprimida
     */
    public NOT(CONDICION izq, CONDICION dcha){
        super(izq, null);
    }
    
    /**
     * Metodo publico que genera el siguiente codigo CTD
     * if condIzq goto Lt
     * goto Lf
     * 
     * Tras ello intercambia los papeles de Lt y Lf para que en el IF se cambien las
     * etiquetas de lugar y consigamos el efecto contrario de condIzq, es decir, la negación
     */
    public void gc(){
        if(izq!=null){

            //Procesamos la condicion 
            this.izq.gc();

            //Intercambiamos los papeles
            String newetf = ((CONDICION)this.izq).getEtt();
            String newett = ((CONDICION)this.izq).getEtf();

            this.asignaEtiquetasNuevas(newett, newetf);

        }

    }
}
