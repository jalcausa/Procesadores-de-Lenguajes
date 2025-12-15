/**
    Clase que contiene los metodos necesarios para generar el codigo desde los metodos
    gc de las diferentes clases que extienden al AST.
    Ademas genera los identificadores de variables temporales auxiliares para traducir
    al codigo CTD y las etiquetas correspondientes para realizar saltos.
*/
public class Generador {
    
    public static int temporal = 0;
    public static int label = 0;

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
     * PLC: print(expresion);
     * CTD: print expresion ;
     * @param exp
     */
    public static void print(String exp){
        System.out.println("\t"+"print "+exp+";");
    }

    /**
     * Metodo publico para la traduccion de una sentencia suma de codigo PLC a CTD
     * PLC: expresion + expresion
     * CTD: ti = expresion + expresion;
     * @param ti donde se almacenara la suma
     * @param a el primer argumento de la suma
     * @param b el segundo argumento de la suma
     */
    public static void suma(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" + "+b+";");
    }

    /**
     * Metodo publico para la traduccion de una sentencia resta de codigo PLC a CTD
     * PLC: expresion - expresion
     * CTD: ti = expresion - expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void resta(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" - "+b+";");
    }

    /**
     * Metodo publico para la traduccion de una sentencia multiplicacion de codigo PLC a CTD
     * PLC: expresion * expresion
     * CTD: ti = expresion * expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void multiplicacion(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" * "+b+";");
    }

    /**
     * Metodo publico para la traduccion de una sentencia division de codigo PLC a CTD
     * PLC: expresion / expresion
     * CTD: ti = expresion / expresion;
     * @param ti donde se almacenara el resultado la operacion
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void division(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" / "+b+";");
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


    public static void error(){
        System.out.println("error;");
        System.out.println("halt;");
        System.exit(1);
    }
   
}