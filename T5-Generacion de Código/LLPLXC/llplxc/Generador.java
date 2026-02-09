/*
 * Generador.java
 * Clase utilitaria para generar código LLVM IR
 * 
 * Contiene métodos estáticos para emitir instrucciones LLVM IR,
 * gestionar variables temporales y etiquetas.
 */

public class Generador {
    
    // Contador de variables temporales (%1, %2, %3, ...)
    private static int contadorTemporal = 0;
    
    // Contador de etiquetas (L0, L1, L2, ...)
    private static int contadorEtiqueta = 0;

    /*
     * Genera un nuevo nombre de variable temporal
     * Las temporales en LLVM se nombran %1, %2, %3, ...
     */
    public static String nuevaTemporal() {
        contadorTemporal++;
        return "%" + contadorTemporal;
    }

    /*
     * Genera un nuevo nombre de etiqueta
     * Las etiquetas se nombran L0, L1, L2, ...
     */
    public static String nuevaEtiqueta() {
        String etiqueta = "L" + contadorEtiqueta;
        contadorEtiqueta++;
        return etiqueta;
    }

    /*
     * Emite la cabecera estándar de un programa LLVM IR
     * Incluye la declaración de printf y la función main
     */
    public static void emitirCabecera() {
        System.out.println("@.str = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\", align 1");
        System.out.println("declare i32 @printf(i8*, ...)");
        System.out.println("declare void @exit(i32 noundef)");
        System.out.println("define i32 @main() {");
    }

    /*
     * Emite la instrucción de retorno y cierre de la función main
     */
    public static void emitirRetorno() {
        System.out.println("   ret i32 0");
        System.out.println("}");
    }

    /*
     * Emite una instrucción de reserva de memoria para una variable
     * %nombre = alloca i32, align 4
     */
    public static void emitirAlloca(String nombre) {
        System.out.println("   %" + nombre + " = alloca i32, align 4");
    }

    /*
     * Emite una instrucción para almacenar un valor en una variable
     * store i32 valor, i32* %nombre
     */
    public static void emitirStore(String valor, String nombre) {
        System.out.println("   store i32 " + valor + " , i32* %" + nombre);
    }

    /*
     * Emite una instrucción para cargar el valor de una variable en una temporal
     * temporal = load i32, i32* %nombre
     */
    public static String emitirLoad(String nombre) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = load i32, i32* %" + nombre);
        return temporal;
    }

    /*
     * Emite una instrucción de suma
     * temporal = add i32 operando1, operando2
     */
    public static String emitirSuma(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = add i32 " + op1 + " , " + op2 + " ");
        return temporal;
    }

    /*
     * Emite una instrucción de resta
     * temporal = sub i32 operando1, operando2
     */
    public static String emitirResta(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = sub i32 " + op1 + " , " + op2 + " ");
        return temporal;
    }

    /*
     * Emite una instrucción de multiplicación
     * temporal = mul i32 operando1, operando2
     */
    public static String emitirMul(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = mul i32 " + op1 + " , " + op2 + " ");
        return temporal;
    }

    /*
     * Emite una instrucción de división entera
     * temporal = sdiv i32 operando1, operando2
     */
    public static String emitirDiv(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = sdiv i32 " + op1 + " , " + op2 + " ");
        return temporal;
    }

    /*
     * Emite una instrucción de comparación de igualdad
     * temporal = icmp eq i32 operando1, operando2
     */
    public static String emitirIgual(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp eq i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una instrucción de comparación de desigualdad
     * temporal = icmp ne i32 operando1, operando2
     */
    public static String emitirNoIgual(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp ne i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una instrucción de comparación menor que
     * temporal = icmp slt i32 operando1, operando2
     */
    public static String emitirMenor(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp slt i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una instrucción de comparación menor o igual
     * temporal = icmp sle i32 operando1, operando2
     */
    public static String emitirMenorIgual(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp sle i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una instrucción de comparación mayor que
     * temporal = icmp sgt i32 operando1, operando2
     */
    public static String emitirMayor(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp sgt i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una instrucción de comparación mayor o igual
     * temporal = icmp sge i32 operando1, operando2
     */
    public static String emitirMayorIgual(String op1, String op2) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = icmp sge i32 " + op1 + " , " + op2);
        return temporal;
    }

    /*
     * Emite una etiqueta
     * etiqueta:
     */
    public static void emitirEtiqueta(String etiqueta) {
        System.out.println(etiqueta + ":");
    }

    /*
     * Emite un salto condicional
     * br i1 condicion, label %etiquetaVerdadero, label %etiquetaFalso
     */
    public static void emitirSaltoCondicional(String condicion, String etiquetaV, String etiquetaF) {
        System.out.println("   br i1 " + condicion + ", label %" + etiquetaV + " , label %" + etiquetaF);
    }

    /*
     * Emite un salto incondicional
     * br label %etiqueta
     */
    public static void emitirSalto(String etiqueta) {
        System.out.println("   br label %" + etiqueta);
    }

    /*
     * Emite una instrucción de print (llamada a printf)
     */
    public static void emitirPrint(String valor) {
        String temporal = nuevaTemporal();
        System.out.println("   " + temporal + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 " + valor + ")");
    }
}
