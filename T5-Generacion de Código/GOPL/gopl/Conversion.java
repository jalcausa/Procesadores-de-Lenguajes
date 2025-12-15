/**
 * Clase publica que se dedicara a realizar la asignacion automatica entre tipos
 * para todas las operaciones realizadas.
 */
public class Conversion {

    public static final int SUMA = 1;
    public static final int RESTA = 2;
    public static final int PRODUCTO = 3;
    public static final int DIVISON = 4;
    
    /**
     * Metodo publico para realizar la conversion automatica de tipos
     * @param tipo1 TIPO tipo del primer operando
     * @param tipo2 TIPO tipo del segundo operando
     * @param op int correspondiente a la operacion que se esté realizando
     * @return TIPO tipo de la nueva expresion
     */
    public static TIPO convierteTipos(int tipo1, int tipo2, int op){
        TIPO res = new TIPO();

        //En caso de ser alguno de los tipos un vector, no admiten las operaciones
        //suma, resta, producto y division, así que se genera un mensaje de error y 
        //se detiene la ejecucion. Se deja preparado para que si admita otras operaciones.
        if(tipo1 == TIPO.VECTOR || tipo2==TIPO.VECTOR){
            if(op == SUMA || op == RESTA || op == PRODUCTO || op == DIVISON){
                Generador.error();
            }      
        }

        //En caso de ser un String solamente se admite la operacion de concatenacion de 
        //strings String + String
        if(tipo1 == TIPO.CADENA || tipo2 == TIPO.CADENA){
            if(op != SUMA || tipo1 != tipo2){
                Generador.error();
            }
        }

        //Los caracteres a la hora de realizar operaciones se consideran como el valor 
        //entero del codigo unicode asociado, asi que consideramos el tipo CARACTER como si
        //fuese un tipo ENTERO
        if(tipo1==TIPO.CARACTER){
            tipo1 = TIPO.ENTERO;
        }

        if(tipo2==TIPO.CARACTER){
            tipo2 = TIPO.ENTERO;
        }

        //Ya solo nos quedan ENTERO y REAL. En cualquiera de las operaciones
        //SUMA, RESTA, PRODUCTO, DIVISION tenemos que si los tipos coinciden, el del
        //resultado se mantiene, si los tipos son diferentes, entonces el tipo del 
        //resultado pasa a ser un REAL.
        if(op == SUMA || op == RESTA || op == PRODUCTO || op == DIVISON){
            if((tipo1 == TIPO.REAL || tipo1 == TIPO.ENTERO) &&  (tipo2 == TIPO.REAL || tipo2 == TIPO.ENTERO)){
                if(tipo1 == tipo2){
                    res.setTipo(tipo1);
                } else {
                    res.setTipo(TIPO.REAL);
                }
            }
        }
        
        //Esto es un mensaje de comprobacion
        if(res.getTipo()==0){
            System.out.println("NO HAY NINGUN TIPO SOCORRO");
        }

        return res;
    }
}
