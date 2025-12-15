public class Generador {
    
    public static int temporal = 0;
    public static int etiqueta = 0;

    public static String nuevaTemporal() {
        String t = "$t" + temporal;
        temporal++;
        return t;
    }

    public static String nuevaEtiqueta() {
        String L = "L" + etiqueta;
        etiqueta++;
        return L;
    }

    public static void print(String exp) {
        System.out.println("\tprint " + exp + ";");
    }

    public static void suma(String ti, String a, String b) {
        System.out.println("\t" + ti + " = " + a + " + " + b + ";");
    }

    public static void resta(String ti, String a, String b) {
        System.out.println("\t" + ti + " = " + a + " - " + b + ";");
    }

    public static void multiplicacion(String ti, String a, String b) {
        System.out.println("\t" + ti + " = " + a + " * " + b + ";");
    }

    public static void division(String ti, String a, String b) {
        System.out.println("\t" + ti + " = " + a + " / " + b + ";");
    }

    public static void asigna(String id, String b) {
        System.out.println("\t" + id + " = " + b + ";");
    }

    public static void igualdad(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + a + " == " + b + ") goto " + l1 + ";");
        System.out.println("\tgoto " + l2 + ";");
    }

    public static void nigualdad(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + a + " == " + b + ") goto " + l2 + ";");
        System.out.println("\tgoto " + l1 + ";");
    }

    public static void menor(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + a + " < " + b + ") goto " + l1 + ";");
        System.out.println("\tgoto " + l2 + ";");
    }

    public static void mayor(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + b + " < " + a + ") goto " + l1 + ";");
        System.out.println("\tgoto " + l2 + ";");
    }

    public static void menoreq(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + b + " < " + a + ") goto " + l2 + ";");
        System.out.println("\tgoto " + l1 + ";");
    }

    public static void mayoreq(String a, String b, String l1, String l2) {
        System.out.println("\tif(" + a + " < " + b + ") goto " + l2 + ";");
        System.out.println("\tgoto " + l1 + ";");
    }

    public static void printEtiqueta(String etiqueta) {
        System.out.println(etiqueta + ":");
    }

    public static void gotoEtiqueta(String etiqueta) {
        System.out.println("\tgoto " + etiqueta + ";");
    }

    public static void error() {
        System.out.println("error;");
        System.out.println("halt;");
        System.exit(1);
    }
}
