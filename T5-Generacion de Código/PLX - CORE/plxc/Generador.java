/**
    Clase que contiene los metodos necesarios para generar el codigo desde los metodos
    gc de las diferentes clases que extienden al AST.
    Ademas genera los identificadores de variables temporales auxiliares para traducir
    al codigo CTD y las etiquetas correspondientes para realizar saltos.
*/
public class Generador {

    //Contadores para los identificadores temporales de varialbes y etiquetas 
    public static int temporal = 0;
    public static int label = 0;

    //Strings para la impresion de errores
    public static final String E_YADECLARADA = "# Variable ya declarada";
    public static final String E_TIPOS       = "# Error de tipos";
    public static final String E_VTIPOS      = "# Error de subtipos del vector";
    public static final String E_VLENGTH     = "# Error en la longitud del vector";
    public static final String E_VND         = "# Variable no declarada";


    ///////////////////////////////////////////////////////////////////////////////////
    /// METODOS GENERADORES DE ETIQUETAS E IDENTIFICADORES DE VARIABLES
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * Funcion para la consecucion de un nuevo identificador de variable temporal
     * @return El string "ti" donde i es un numero natural o 0.
     */
    public static String nuevaTemporal(){
        String t = "t"+temporal;
        temporal++;
        return t;
    }

    /**
     * Funcion para la consecucion de una nueva etiqueta
     * @return El string "Li" donde i es un numero natural o 0.
     */
    public static String nuevaLabel(){
        String L = "L"+label;
        label++;
        return L;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    /// METODOS DE IMPRESION DE CODIGO
    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo público para la traduccion de una sentencia print de codigo PLC a CTD
     * PLX: print(expresion);
     * CTD: print expresion ;
     * @param exp
     */
    public static void print(String exp){
        System.out.println("\t"+"print "+exp+";");
    }
    
    /**
     * Metodo publico para la traduccion de una sentencia print de codigo PLX a CTD
     * PLX: print(char)
     * CTD: printc char 
     * 
     * Este escribe el caracter pero NO hace salto de linea a continuacion.
     * @param expchar 
     */
    public static void writec(String expchar) {
        System.out.println("\t"+"writec "+expchar+";");
    }

    /**
     * Metodo publico para la traduccion de una sentencia print de codigo PLX a CTD
     * PLX: print(char)
     * CTD: printc char 
     * 
     * Este escribe el caracter y SI hace salto de linea a continuacion.
     * @param expchar
     */ 
    public static void printc(String expchar) {
        System.out.println("\t"+"printc "+expchar+";");
    }   

    /**
     * Metodo publico para la traduccion de una sentencia suma de codigo PLC a CTD
     * PLC: expresion + expresion
     * CTD: ti = expresion + expresion;
     * @param ti donde se almacenara la suma
     * @param a el primer argumento de la suma
     * @param b el segundo argumento de la suma
     * @param t el tipo del resultado
     */
    public static void suma(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO){
            System.out.println("\t"+ti+" = "+a+" + "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" +r "+b+";");
        }
    }

    /**
     * Metodo publico para la traduccion de una sentencia resta de codigo PLC a CTD
     * PLC: expresion - expresion
     * CTD: ti = expresion - expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     * @param t el tipo del resultado
     */
    public static void resta(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO){
            System.out.println("\t"+ti+" = "+a+" - "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" -r "+b+";");
        }
    }

    /**
     * Metodo publico para la traduccion de una sentencia multiplicacion de codigo PLC a CTD
     * PLC: expresion * expresion
     * CTD: ti = expresion * expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     * @param t el tipo del resultado
     */
    public static void multiplicacion(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO){
            System.out.println("\t"+ti+" = "+a+" * "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" *r "+b+";");
        }
    }

    /**
     * Metodo publico para la traduccion de una sentencia division de codigo PLC a CTD
     * PLC: expresion / expresion
     * CTD: ti = expresion / expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     * @param t el tipo del resultado
     */
    public static void division(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO){
            System.out.println("\t"+ti+" = "+a+" / "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" /r "+b+";");
        }
    }

    /**
     * Metodo publico para la traduccion de una sentencia asignacion de codigo PLC a CTD
     * PLC: id = exp;
     * CTD: id = exp;
     * @param id identificador al cual se le asigna el valor del atributo b
     * @param b el valor asignado
     */
    public static void asigna(String id, String b){
        System.out.println("\t"+id+" = "+b+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion == de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a==b
     * CTD: if(a==b) goto l1
            goto l2
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void igualdad(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion != de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a!=b
     * CTD: if(a==b) goto l2
            goto l1
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void nigualdad(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion < de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a<b
     * CTD: if(a<b) goto l1
            goto l2
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void menor(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion > de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a>b
     * CTD: if(b<a) goto l1
            goto l2
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void mayor(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion <= de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a<=b
     * CTD: if(b<a) goto l2
            goto l1
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void menoreq(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    /**
     * Metedo publico para la traduccion de una condicion >= de una sentencia if de codigo
     * PLC a CTD.
     * PLC: a>=b
     * CTD: if(a<b) goto l2
            goto l1
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param l1 etiqueta en caso de ser una condicion cierta
     * @param l2 etiqueta en caso de ser un condicion falsa
     */
    public static void mayoreq(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    /**
     * Metodo empleado para imprimir etiquetas del codigo CTD
     * CTD: etiqueta: 
     * @param etiqueta
     */
    public static void printlabel(String etiqueta){
        System.out.println(etiqueta+":");
    }


    /**
     * Metodo empleado para imprimir sentencias de direccion a etiquetas del codigo cTd
     * CTD: goto etiqueta;
     * @param etiqueta
     */
    public static void gotolabel(String etiqueta){
        System.out.println("\t"+"goto "+etiqueta+";");
    }

    /**
     * Meotodo empelado para la impresion de la comprobacion de limites en el acceso a los
     * elementos de un vector. Controla los errores de index out of bounds 
     * @param indice String posicion a la que se accede
     * @param tam String con el tamaño del vector
     * @param labelIn String con la etiqueta a la que ir en caso de no haber ningun error
     * @param labelOut String con la etiqueta a la que ir en caso de error
     */
    public static void comprobacionLimitesVector(String indice, String tam, String labelIn, String labelOut) {
        System.out.println("\t"+"if("+indice+"<0) goto "+labelOut+";");
        System.out.println("\t"+"if("+tam+"<"+indice+") goto "+labelOut+";");
        System.out.println("\t"+"if("+tam+"=="+indice+") goto "+labelOut+";");
        gotolabel(labelIn);
    }

    /**
     * Metodo empleado para la impresion de la comprobacion de limites en el acceso a un
     * elemento de un String. Controla los errores index out of bounds
     * @param indice String posicion a la que se accede
     * @param idVector String con el identificador del string
     * @param labelIn String con la etiqueta a la que ir en caso de no haber error
     * @param labelOut String con la etiqueta a la que ir en caso de error
     */
    public static void comprobacionLimitesString(String indice, String idVector, String labelIn, String labelOut) {
        System.out.println("\t"+"if("+indice+"<0) goto "+labelOut);
        System.out.println("\t"+"if("+idVector+"_length<"+indice+") goto "+labelOut);
        System.out.println("\t"+"if("+idVector+"_length=="+indice+") goto "+labelOut);
        gotolabel(labelIn);
    }

    /**
     * Metodo empleado para la impresion de la longitud de un array en su declaracion
     * @param id String identificador del vector
     * @param tam int con la longitud del vector
     */
    public static void printLength(String id, int tam) {
        System.out.println("\t"+id+"_length"+ " = "+tam+";");
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /// METODOS DE ERROR
    /////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Metodo empleado para imprimir mensajes de error pero continuar la ejecucion
     * CTD: error;
     *      halt;
     */
    public static void printError(){
        System.out.println("\t"+"error;");
        System.out.println("\t"+"halt;");
    }
    
    /**
     * Metodo empleado para imprimir mensajes de error y detener la ejecucion, tanto en CTD
     * como en el propio traductor
     * CTD: error;
     *      halt;
     * 
     */
    public static void error(){
        System.out.println("error;");
        System.out.println("halt;");
        System.exit(1);
    }

     /**
     * Metodo empleado para imprimir mensajes de error y detener la ejecucion, tanto en CTD
     * como en el propio traductor
     * CTD: error;
     *      halt;
     *      # tipo del error
     * @param st String con el mensaje de error
     */
    public static void error(String st){
        System.out.println("error;");
        System.out.println("halt;");
        System.out.println(st);
        System.exit(1);
    }

   
}