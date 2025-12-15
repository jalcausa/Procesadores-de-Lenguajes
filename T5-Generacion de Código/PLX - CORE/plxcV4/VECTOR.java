import java.util.ArrayList;

public class VECTOR extends EXPRESION{


    protected ArrayList<EXPRESION> elementos;
    
    /**
     * Contructor de la clave VECTOR.
     * Este asigna ambas ramas nulas, inicializa la lista de elementos vacia y 
     * asigna el tipo vector. Subtipo, Temp y Tam aun no se deciden.
     */
    public VECTOR(){
        super(null, null);
        elementos = new ArrayList<>();
        this.setTipo(TIPO.VECTOR);
        this.setTemp(Generador.nuevaTemporal());

        //this.temp es asignado e iniciado como un ti. Después volcaremos este vector, en
        //otro con el nombre realmente asignado.

        //aun no podemos asignar el subtipo this.setsubtipo(0);
        //como es vacio, de momento asignamos tamaño 0 y se hace al asignar el tipo
    }

    /**
     * Metodo publico empleado para añadir expresiones a un vector
     * @param e EXPRESION expresion a añadir
     */
    public void anyadir(EXPRESION e){
        //Añadimos el primer elemento y decidimos el subtipo
        if(this.getTam()==0){
            this.tipo.setSubtipo(e.getTipo());
            this.elementos.add(e);
            this.setTam(1);
        //Añadimos el resto de elementos comprobando tipos y actualizamos el tamaño.
        } else {
            if(this.getSubtipo()==e.getTipo()){
                this.elementos.add(e); 
                this.setTam(elementos.size());               
            } else {
                //System.out.println(this.getSubtipo());
                //System.out.println(e.getTipo());
                //En caso de intentar añadir otros tipos diferentes se lanza un error y 
                //se detiene la ejecucion 
                Generador.error();
                //En un futuro se podrian incorporar metodos de casting
            }
        }
    }

    /**
     * Metodo publico que genera el codigo correspondiente al procesado de cada expresion
     * incluida en el vector
     * 
     * AQUI HAY DIFERENCIAS CON LO DE NURIA
     */
    public void gc(){
        for (int i = 0; i < this.elementos.size(); i++){
            EXPRESION e = this.elementos.get(i);
            e.gc();
            String etiq = this.temp+"["+i+"]";
            Generador.asigna(etiq, e.getTemp());


        }
    }
    
}
