/**
    Clase que contiene los métodos necesarios para generar el código desde los métodos
    gc de las diferentes clases que extienden al AST.
    Además genera los identificadores de variables temporales auxiliares para traducir
    al código CTD y las etiquetas correspondientes para realizar saltos.
*/
public class Generador {
    
    public static int temporal = 0;
    public static int label = 0;

    public final static int IGUALDAD = 1;
    public final static int NOTIGUALDAD = 2;
    public final static int MAYOR = 3;
    public final static int MAYOROIGUAL = 4;   
    public final static int MENOR = 5;
    public final static int MENOROIGUAL = 6;
    public final static int AND = 7;
    public final static int OR = 8;
    public final static int NOT = 10;


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

    /**
     * Método público para la generación del código CTD correspondiente a una sentencia
     * print(expresion) del código fuente PLC
     * @param exp
     */
    public static void print(String exp){
        System.out.println("\t"+"print "+exp+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a una suma de la forma 
     * ti = a + b donde a y b son variables ya definidas previamente.
     * @param ti donde se almacenara la suma
     * @param a el primer argumento de la suma
     * @param b el segundo argumento de la suma
     */
    public static void suma(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" + "+b+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a una resta de la forma 
     * ti = a - b donde a y b son variables ya definidas previamente.
     * @param ti donde se almacenara el resultado
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void resta(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" - "+b+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a una multiplicacion de la forma 
     * ti = a * b donde a y b son variables ya definidas previamente.
     * @param ti donde se almacenara el resultado
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void multiplicacion(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" * "+b+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a una division de la forma 
     * ti = a / b donde a y b son variables ya definidas previamente.
     * @param ti donde se almacenara el resultado
     * @param a el primer argumento de la operacion
     * @param b el segundo argumento de la operacion
     */
    public static void division(String ti, String a, String b){
        System.out.println("\t"+ti+" = "+a+" / "+b+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a una asignacion de la forma 
     * id = t donde t es una variable ya definidas previamente.
     * @param id identificador al cual se le asigna el valor del atributo b
     * @param b el valor asignado
     */
    public static void asigna(String id, String b){
        System.out.println("\t"+id+" = "+b+";");
    }

    /**
     * Metedo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia. Esta se traduce en codigo CTD como
     * if(condicion) goto l1
     * goto l2
     * l1:
     *    sentencia
     *    l3
     * l2:
     * l3:
     * No obstante, en esta sección del código solamente se imprimen las dos primeras lineas,
     * el resto se encarga de imprimirlas las sentencia if
     * Este metodo en concreto es para condiciones del tipo a == b
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser una condicion cierta
     * @param ef etiqueta en caso de ser un condicion falsa
     */
    public static void igualdad(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+ev+";");
        System.out.println("\t"+"goto "+ef+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia, al igual que el método previo.
     * Este es el caso de las condiciones a != b. Esto es equivalente a una condicion a==b 
     * pero yendo a ef en lugar de ev.
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser la condicion cierta
     * @param ef etiqueta en caso de ser la condicion falsa
     */
    public static void nigualdad(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+ef+";");
        System.out.println("\t"+"goto "+ev+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia, al igual que el metodo previo.
     * Este es el caso de las condiciones a<b
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser la condicion cierta
     * @param ef etiqueta en caso de ser la condicion falsa
     */
    public static void menor(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+ev+";");
        System.out.println("\t"+"goto "+ef+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia, al igual que el metodo previo.
     * Este es el caso de las condiciones a>b, lo cual equivale a que se cumpla que b<a.
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser la condicion cierta
     * @param ef etiqueta en caso de ser la condicion falsa
     */
    public static void mayor(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+ev+";");
        System.out.println("\t"+"goto "+ef+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia, al igual que el metodo previo.
     * Este es el caso de las condiciones a<=b, lo cual equivale a que se cumpla que b no
     * no es menor que a, luego equivale a que b<a y cambiamos ev por ef.
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser la condicion cierta
     * @param ef etiqueta en caso de ser la condicion falsa
     */
    public static void menoreq(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+ef+";");
        System.out.println("\t"+"goto "+ev+";");
    }

    /**
     * Metodo publico para generar el codigo CTD correspondiente a la parte de la condicion
     * de una sentencia de la forma if(condicion) sentencia, al igual que el metodo previo.
     * Este es el caso de las condiciones a>=b, lo cual equivale a que se cumpla que a no
     * no es menor que b, luego equivale a que a<b y cambiamos ev por ef.
     * @param a expresion1 de la condicion
     * @param b expresion2 de la condicion
     * @param ev etiqueta en caso de ser la condicion cierta
     * @param ef etiqueta en caso de ser la condicion falsa
     */
    public static void mayoreq(String a, String b, String ev, String ef){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+ef+";");
        System.out.println("\t"+"goto "+ev+";");
    }

    /**
     * Metodo empleado para imprimir etiquetas del codigo CTD
     * @param etiqueta
     */
    public static void printlabel(String etiqueta){
        System.out.println(etiqueta+":");
    }


    /**
     * Metodo empleado para imprimir sentencias goto label del codigo CTD
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