/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo asignacion
 * izq: EXPRESION VACIA
 * dcha: EXPRESION que representa el arbol derecho, es decir, la expresion asignada al identificador
 * temp: String correpondiente al identificador de la variable declarada
 * tipo: tipo que deberá tener la variable ident para poder asignarle la expresion 
 * ASIG: IDENT = expresion
 */
public class ASIG extends EXPRESION {

    private String nomVar;

    /**
     * Constructor de la clase ASIG. 
     * @param izq String correspondiente al identificador de la variable declarada
     * @param dcha EXPRESION correspondiente al valor de la variable declarada
     */
    public ASIG(String izq, EXPRESION dcha){
        //En este el nodo izquierdo es nulo, su papel sería el ocupado por el string temp
        super(null, dcha);
        //Ahora no se genera una nueva temp pues esta directamente nos la dan en el codigo
        //origen PLC.
        this.temp = izq;
        this.nomVar = izq;
        this.tipo = dcha.tipo;
    }

    /**
     * Genera el codigo CTD correspondiente a los diferentes tipos de asignaciones
     *
     */
    public void gc(){
        if(this.dcha!=null){

            //Primero siempre procesamos la expresion
            this.dcha.gc();

            this.temp = ((EXPRESION)this.dcha).getTemp();

            String codExp = ((EXPRESION)this.dcha).getTemp();
            
            int tipoVariable = TablaSimbolos.getTipo(this.nomVar).getTipo();
            int tipoExpresion = ((EXPRESION)this.dcha).getTipo();

            if(tipoVariable == tipoExpresion){

                if(tipoVariable == TIPO.VECTOR){
                    int subtipoVariable = TablaSimbolos.getTipo(this.nomVar).getSubtipo();
                    int subtipoExpresion = ((EXPRESION)this.dcha).getSubtipo();
                    int tamVariable = TablaSimbolos.getTipo(this.nomVar).getTam();
                    int tamExpresion = ((EXPRESION)this.dcha).getTam();
                    if(subtipoExpresion == subtipoVariable && tamExpresion<=tamVariable){
                        String aux = Generador.nuevaTemporal();
                        for(int i = 0; i<tamExpresion; i++){
                            Generador.asigna(aux, codExp+"["+i+"]");
                            Generador.asigna(nomVar+"["+i+"]", aux);
                        }
                    } else {
                        Generador.error();
                    }

                } else if(tipoVariable == TIPO.CADENA){
                    System.out.println("# asignar array "+nomVar+" <- "+codExp);
                    Generador.printLength(nomVar, 0);

                    String i = Generador.nuevaTemporal();
                    Generador.asigna(i, "0");

                    String etiqWhile = Generador.nuevaLabel();

                    EtiquetaDoble e = new EtiquetaDoble();

                    Generador.printlabel(etiqWhile);

                    Generador.menor(i, codExp+"_length", e.getET(), e.getEF());

                    Generador.printlabel(e.getET());
                    String aux = Generador.nuevaTemporal();
                    Generador.asigna(aux, codExp+"["+i+"]");

                    String e1 = Generador.nuevaLabel();
                    String e2 = Generador.nuevaLabel();
                    
                    Generador.printlabel(e1);
                    Generador.asigna(nomVar+"["+nomVar+"_length]", aux);
                    Generador.asigna(nomVar+"_length", nomVar+"_length + 1");

                    Generador.printlabel(e2);
                    Generador.asigna(i, i+" + 1");
                    Generador.gotolabel(etiqWhile);

                    Generador.printlabel(e.getEF());

                    TIPO taux = ((EXPRESION)this.dcha).tipo;
                    TablaSimbolos.modificar(nomVar, taux);
                } else {
                    Generador.asigna(nomVar, codExp);
            
                }
            }
        }
    }
    


    
}
