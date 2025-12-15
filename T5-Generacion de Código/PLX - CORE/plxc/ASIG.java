/**
 * Clase publica que extiende de EXPRESION y representa precisamente expresiones tipo asignacion
 * izq: EXPRESION VACIA
 * dcha: EXPRESION que representa el arbol derecho, es decir, la expresion asignada al identificador
 * temp: String correpondiente al identificador de la variable declarada
 * tipo: tipo que deberá tener la variable ident para poder asignarle la expresion
 * nomVar: String que recoge el IDENT de la variable declarada de forma auxiliar para el metodo gc 
 * 
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
     * Genera el codigo CTD correspondiente a los diferentes tipos de asignaciones.
     * Distinguimos los casos en que se asigna un vector, en que se asigna un string 
     * y en los que se asigna otro tipo de constante.
     */
    public void gc(){
        if(this.dcha!=null){

            //Primero siempre procesamos la expresion
            this.dcha.gc();

            //Cambiamos el temp de la variable por el de la expresion y guardamos el segundo
            this.temp = ((EXPRESION)this.dcha).getTemp();
            String tempExp = ((EXPRESION)this.dcha).getTemp();
            
            //Guardamos los tipos de la variable y de la expresion
            int tipoVariable = TablaSimbolos.getTipo(this.nomVar).getTipo();
            int tipoExpresion = ((EXPRESION)this.dcha).getTipo();

            // En caso de no necesitar casting para realizar la asignacion
            if(tipoVariable == tipoExpresion){
                
                //Para los vectores
                if(tipoVariable == TIPO.VECTOR){
                    //Comprobamos que los tipos de los elementos del vector y las longitudes
                    //de los vectores sean compatibles. En caso afirmativo imprimimos
                    //para cada elemento del array la asignacion correspondiente:
                    //  ti = exp[i]
                    //  id[i] = ti
                    // en caso negativo imprimimos un mensaje de error
                    int subtipoVariable = TablaSimbolos.getTipo(this.nomVar).getSubtipo();
                    int subtipoExpresion = ((EXPRESION)this.dcha).getSubtipo();
                    int tamVariable = TablaSimbolos.getTipo(this.nomVar).getTam();
                    int tamExpresion = ((EXPRESION)this.dcha).getTam();
                    if(subtipoExpresion == subtipoVariable){
                        if(tamExpresion<=tamVariable){
                            String aux = Generador.nuevaTemporal();
                            for(int i = 0; i<tamExpresion; i++){
                                Generador.asigna(aux, tempExp+"["+i+"]");
                                Generador.asigna(nomVar+"["+i+"]", aux);
                            }
                        } else {
                            Generador.error(Generador.E_VLENGTH);
                        }
                    } else {
                        Generador.error(Generador.E_VTIPOS);
                    }

                //En caso de ser un string imprimimos:
                //      #asignar array id <- texp
                //      id_length = 0;
                //      i = 0;
                //  etiqWhile:
                //      if(i<texp_length): goto LEt
                //      goto LEf
                //  LEt:
                //      taux = texp[i];
                //  E1: 
                //      id[i] = taux;
                //      id_length = id_lenth+1;
                //  E2: 
                //      i = i+1;
                //      goto etiqWhile;
                //  LEf:
                } else if(tipoVariable == TIPO.CADENA){
                    System.out.println("# asignar array "+nomVar+" <- "+tempExp);
                    Generador.printLength(nomVar, 0);

                    String i = Generador.nuevaTemporal();
                    Generador.asigna(i, "0");

                    String etiqWhile = Generador.nuevaLabel();

                    EtiquetaDoble e = new EtiquetaDoble();

                    Generador.printlabel(etiqWhile);

                    Generador.menor(i, tempExp+"_length", e.getET(), e.getEF());

                    Generador.printlabel(e.getET());
                    String aux = Generador.nuevaTemporal();
                    Generador.asigna(aux, tempExp+"["+i+"]");

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
                
                //En caso cualquier otro caso se imprime 
                // ti = texp;
                // id = ti;
                } else {
                    Generador.asigna(nomVar, tempExp);
                }
            
            //Si necesitamos un casting previo
            } else if (tipoVariable == TIPO.REAL && tipoExpresion == TIPO.ENTERO){
                String floatEntero = "(float) "+tempExp;
                Generador.asigna(nomVar, floatEntero);
            
            //En caso de incompatiblidad de tipos
            } else {
                Generador.error(Generador.E_TIPOS);
            }
        }
    }
    


    
}
