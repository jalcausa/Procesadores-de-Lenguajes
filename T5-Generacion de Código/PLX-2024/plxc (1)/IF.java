/**
 * Clase publica que extiende de AST y viene a representar sentencias if simples.
 * izq: CONDICION representa la condicion del if
 * decha: AST representa la sentencia a ejecutar en caso de ser cierta la condicion
 * IF :: if(cond) sentencia
 */
public class IF extends AST{

    /**
     * Constructor de la clase IF. Asigna la condicion y sentencia correspondientes
     * @param cond EXPREISON condicion del if
     * @param sent AST sentencia a ejecutar en caso de condicion cierta
     */
    public IF(EXPRESION cond, AST sent){
        super(cond, sent);
        if(cond.getTipo() != TIPO.CONDICION){           //Si no es una condicion lanzamos error
            Generador.error(Generador.E_NOBOOLEAN);
        }
    }

    /**
     * Metodo que genera el siguiente codigo CTD:
     *  if --- goto Lt
     *  goto Lf
     * Lt: 
     *  sentencia
     * Lf:
     */
    public void gc(){
        String etiquetaNoAux ="";
        //Imprimimos la parte de la condicion
        if(this.izq!=null){
            izq.gc();
        }

        //Si lo que nos llega es de la clase CONDICION y ya tiene etiquetas entonces imprimimos
        //la etiqueta del caso afirmativo. 
        //En caso de ser otra clase, en concreto la clase ASIG, se genera la condicion b, 
        //se asignan etiquetas y se imprimen.
        if(this.izq instanceof CONDICION){
            Generador.printlabel(((CONDICION)this.izq).getEtt());
        } else{
            String b = ((ASIG)this.izq).getNomVar();
            EtiquetaDoble etiquetas = new EtiquetaDoble();
            Generador.menor("0", b, etiquetas.getET(), etiquetas.getEF());
            Generador.printlabel(etiquetas.getET());
            etiquetaNoAux = etiquetas.getEF();
        }

        //Imprimimos la sentencia en sí
        if(this.dcha!=null){
            dcha.gc();
        }

        //Imprimimos la etiqueta del caso del no
        if(this.izq instanceof CONDICION){
            Generador.printlabel(((CONDICION)this.izq).getEtf());
        } else{
            Generador.printlabel(etiquetaNoAux);
        }

    }
    
}
