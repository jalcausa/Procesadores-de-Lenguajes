/**
 * Clase publica que representa los elementos de un vector. Extiende de EXPRESION. 
 * idVector : String que representa el identificador del vector
 * indice: String quee indica la posicion del vector a la cual se accede
 * izq: EXPRESION expresion para la posicion del vector a la que se intenta acceder
 * dhca: EXPRESION expresion que en caso de ser una asignacion representa la expresion asignada
 * temp: String que representa un identificador para el elemento del vector además de x[i]
 * tipo: TIPO que representa el tipo del elemento del vector
 * ELEMVECTOR :: x[i]
 * ELEMVECTOR :: x[i] = exp
 */
public class ELEMVECTOR extends EXPRESION{

    String idVector;
    String indice;

    /**
     * Constructor de la clase ELEMVECTOR. Asigna las ramas, el tipo y el id del vector.
     * El indice no se asigna hasta el momento en que se procese la expresion izquierda
     * en el metodo gc()
     * @param id String idVector (x)
     * @param izq EXPRESION posicion del array (expresion de i)
     * @param dcha EXPRESION expresion asignada al elemento del vector (exp)
     */
    public ELEMVECTOR(String id, EXPRESION izq, EXPRESION dcha){
        super(izq, dcha);
        idVector = id;
        TIPO tipoID = TablaSimbolos.getTipo(id);
        
        //Si estamos tratando de acceder a x[i] y este es un vector, le damos el subtimo
        if(tipoID.getTipo()==TIPO.VECTOR){
            this.tipo.setTipo(tipoID.getSubtipo()); 
        //Si no es un vector entonces x debe ser un string, luego sera un caracter
        } else {
            this.tipo.setTipo(TIPO.CARACTER);
        }
    }


    public void gc(){
        //Procesamos el indice
        if(this.izq!=null){
            this.izq.gc();
            this.indice = ((EXPRESION)this.izq).getTemp();
        }

        //En caso de ser un acceso al vector de la forma x[i] buscamos imprimir el codigo correspondiente
        if(this.dcha==null){

            //Generamos una nueva etiqueta ti
            this.temp = Generador.nuevaLabel();
           
            //Generamos etiquetas para controlar el acceso a las posiciones del vector
            String labelOut = Generador.nuevaLabel();
            String labelIn = Generador.nuevaLabel();

            //Imprimimos los mensajes que nos direccionen a un mensaje de error en caso
            //de un acceso incorrecto o a la variable en caso de acceso correcto
            if(TablaSimbolos.getTipo(this.idVector).getTipo()==TIPO.VECTOR){
                String tam = String.valueOf(TablaSimbolos.getTipo(this.idVector).getTam());
                Generador.comprobacionLimitesVector(this.indice, tam, labelIn, labelOut);
            }
            if(TablaSimbolos.getTipo(this.idVector).getTipo()==TIPO.CADENA){
                Generador.comprobacionLimitesString(this.indice, this.idVector, labelIn, labelOut);
            }

            //Imprimimos el caso de acceso fuera de indice con su error, pero sin detener
            //la ejecucion
            Generador.printlabel(labelOut);
            Generador.printError();
           
            //Imprimimos el caso dentro de indices
            Generador.printlabel(labelIn);
            String asignacion = this.idVector+"["+ this.indice +"]";
            Generador.asigna(this.temp, asignacion);
        
        //En caso de ser una asignacion a una posicion del vector, ie, x[i]=exp
        } else {
            this.temp = this.idVector+"["+this.indice+"]";

            //Procesamos la expresion que se asigna
            this.dcha.gc();

            //Comprobamos que los tipos son correctos
            //Llegado el momento, haremos el casting.
            if(((EXPRESION)this.dcha).getTipo()!=this.tipo.getTipo()){
                Generador.error();
            }

            //Generamos etiquetas para controlar el acceso a las posiciones del vector
            String labelOut = Generador.nuevaLabel();
            String labelIn = Generador.nuevaLabel();

            //Imprimimos los mensajes que nos direccionen a un mensaje de error en caso
            //de un acceso incorrecto o a la variable en caso de acceso correcto
            if(TablaSimbolos.getTipo(this.idVector).getTipo()==TIPO.VECTOR){
                String tam = String.valueOf(TablaSimbolos.getTipo(this.idVector).getTam());
                Generador.comprobacionLimitesVector(this.indice, tam, labelIn, labelOut);
            }
            if(TablaSimbolos.getTipo(this.idVector).getTipo()==TIPO.CADENA){
                Generador.comprobacionLimitesString(this.indice, this.idVector, labelIn, labelOut);
            }

            //Imprimimos el caso de acceso fuera de indice con su error, pero sin detener
            //la ejecucion. //Se imprime este primero puesto que luego cuando se interprete
            //el codigo ctd, si que se dentendra la ejecucion
            Generador.printlabel(labelOut);
            Generador.printError();
           
            //Imprimimos el caso dentro de indices
            Generador.printlabel(labelIn);
            String asignacion = ((EXPRESION)this.dcha).getTemp();
            Generador.asigna(this.temp, asignacion);


        }


        
    }
    
}
