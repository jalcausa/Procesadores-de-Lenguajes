public class Generador {

    public static int temporal = 0;
    public static int label = 0;

    public static final String E_YADECLARADA = "# Variable ya declarada";
    public static final String E_TIPOS       = "# Error de tipos";
    public static final String E_VND         = "# Variable no declarada";

    public static String nuevaTemporal(){
        String t = "t"+temporal;
        temporal++;
        return t;
    }

    public static String nuevaLabel(){
        String L = "L"+label;
        label++;
        return L;
    }
    
    public static void print(String exp){
        System.out.println("\t"+"print "+exp+";");
    }
    
    public static void writec(String expchar) {
        System.out.println("\t"+"writec "+expchar+";");
    }

    public static void write(String exp){
        System.out.println("\t"+"write "+exp+";");
    }

    public static void suma(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO || t == TIPO.CARACTER){
            System.out.println("\t"+ti+" = "+a+" + "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" +r "+b+";");
        }
    }

    public static void resta(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO || t == TIPO.CARACTER){
            System.out.println("\t"+ti+" = "+a+" - "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" -r "+b+";");
        }
    }

    public static void multiplicacion(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO || t == TIPO.CARACTER){
            System.out.println("\t"+ti+" = "+a+" * "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" *r "+b+";");
        }
    }

    public static void division(String ti, String a, String b, int t){
        if(t == TIPO.ENTERO || t == TIPO.CARACTER){
            System.out.println("\t"+ti+" = "+a+" / "+b+";");
        } else if(t == TIPO.REAL){
            System.out.println("\t"+ti+" = "+a+" /r "+b+";");
        }
    }

    public static void asigna(String id, String b){
        System.out.println("\t"+id+" = "+b+";");
    }

    public static void igualdad(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    public static void nigualdad(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" == "+b+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    public static void menor(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    public static void mayor(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+l1+";");
        System.out.println("\t"+"goto "+l2+";");
    }

    public static void menoreq(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+b+" < "+a+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    public static void mayoreq(String a, String b, String l1, String l2){
        System.out.println("\t"+"if("+a+" < "+b+")"+" goto "+l2+";");
        System.out.println("\t"+"goto "+l1+";");
    }

    public static void printlabel(String etiqueta){
        System.out.println(etiqueta+":");
    }

    public static void gotolabel(String etiqueta){
        System.out.println("\t"+"goto "+etiqueta+";");
    }

    public static void printLength(String id, int tam) {
        System.out.println("\t"+id+"_length"+ " = "+tam+";");
    }

    public static void error(){
        System.out.println("error;");
        System.out.println("halt;");
        System.exit(1);
    }

    public static void error(String st){
        System.out.println("error;");
        System.out.println("halt;");
        System.out.println(st);
        System.exit(1);
    }
}
