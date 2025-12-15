/**
 * Clase publica que extiende de AST y representa sentencias del tipo print
 * izq: expresion a imprimir
 * dcha: null
 */
public class PRINT extends AST{

    /**
     * Constructor de la clase PRINT. 
     * @param izq EXPRESION que se para como argumento para imprimir
     * @param dcha null
     */
    public PRINT(AST izq, AST dcha){
        super(izq, null);
    }

    /**
     * Metodo publico para generacion del siguiente codigo CTD correspondiente a la sentencia
     * print de PLX.
     */
    public void gc(){

        //Primero comenzamos procesando la expresion a imprimir
        if(this.izq!=null){
            this.izq.gc();
        }

        int tipo = ((EXPRESION)this.izq).getTipo();
        int subtipo = ((EXPRESION)this.izq).getSubtipo();
        int tam = ((EXPRESION)this.izq).getTam();
        String id = ((EXPRESION)this.izq).getTemp();

        //Segun el tipo de la expresion distinguimos que sentencias se deberan generar
        switch (tipo) {
            case TIPO.CARACTER:
                Generador.printc(id);
                break;

            
            case TIPO.VECTOR:
                //En el caso del vector debemos distinguir segun si es de caracteres
                //o de numeros
                String taux = Generador.nuevaTemporal();
                if(subtipo==TIPO.CARACTER){
                    for(int i = 0; i<tam; i++){
                        String exp = id+"["+i+"]";
                        Generador.asigna(taux, exp);
                        Generador.printc(taux);
                    }
                }
                if(subtipo==TIPO.ENTERO || subtipo==TIPO.REAL){
                    for(int i = 0; i<tam; i++){
                        String exp = id+"["+i+"]";
                        Generador.asigna(taux, exp);
                        Generador.print(taux);   
                    }
                }
                break;

                //En caso de ser una cadena debemos imprimir cada caracter en una 
                //misma linea
        
            case TIPO.CADENA:
                String i = Generador.nuevaTemporal();
                Generador.asigna(i, "0");

                String etiqWhile = Generador.nuevaLabel();
                EtiquetaDoble e = new EtiquetaDoble();
                
                Generador.printlabel(etiqWhile);

                Generador.menor(i, id+"_length", e.getET(), e.getEF());

                Generador.printlabel(e.getET());
                String aux = Generador.nuevaTemporal();
                String exp = id+"["+i+"]";
                Generador.asigna(aux, exp);
                Generador.writec(aux);
                Generador.asigna(i, i+"+"+1);
                Generador.gotolabel(etiqWhile);

                Generador.printlabel(e.getEF());
                Generador.writec("10");
                break;
                
            case TIPO.CONDICION:
                CONDICION cond = (CONDICION)this.izq;
                Generador.printlabel(cond.getEtt());
                Generador.writec("116");
                Generador.writec("114");
                Generador.writec("117");
                Generador.writec("101");
                Generador.writec("10");
                String etiquetaContinuacion = Generador.nuevaLabel();
                Generador.gotolabel(etiquetaContinuacion);
                Generador.printlabel(cond.getEtf());
                Generador.writec("102");
                Generador.writec("97");
                Generador.writec("108");
                Generador.writec("115");
                Generador.writec("101");
                Generador.writec("10");
                Generador.printlabel(etiquetaContinuacion);

                break;

                //En cualquier otro caso es un print normal
            default:
                Generador.print(((EXPRESION)izq).getTemp());
                break;
        }
        
    }
}
