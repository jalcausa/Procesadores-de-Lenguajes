public class CTECOND extends CONDICION{

    /**
     * Constructor de la clase CTECOND. Esta es un identificador de una condicion
     * @param id String con el identificador de la condicion
     * @param tipo TIPO que debera ser una condicion
     */
    public CTECOND(String id, TIPO tipo){
        super(null, null);
        this.temp = id;
        this.tipo = tipo;
    }

    /**
     * Metodo publico que imprime el codigo CTD de esta condicion
     * 
     * if(0<id) goto L1;
     * goto L2
     */
    public void gc(){
        //Asignamos las etiquetas
        this.asignaEtiquetasNuevas();
     
        String ev = this.getEtt();
        String ef = this.getEtf();

        if(this.temp.equals("true")){
            Generador.menor("0", "1", ev, ef);

        } else if(this.temp.equals("false")){
            Generador.menor("0", "0", ev, ef);
        } else {
            Generador.menor("0", this.getTemp(), ev, ef);

        }
    }
    
}
