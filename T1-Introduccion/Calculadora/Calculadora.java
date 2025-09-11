import java.io.*;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter writer = null;
        
        try {
            // Configurar entrada
            if (args.length >= 1) {
                scanner = new Scanner(new File(args[0]));
            } else {
                scanner = new Scanner(System.in);
            }
            
            // Configurar salida
            if (args.length >= 2) {
                writer = new PrintWriter(new FileWriter(args[1]));
            } else {
                writer = new PrintWriter(System.out, true);
            }
            
            // Procesar cada línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    try {
                        int resultado = evaluarExpresion(linea);
                        writer.println(resultado);
                    } catch (Exception e) {
                        writer.println("Error: " + e.getMessage());
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    public static int evaluarExpresion(String expresion) throws Exception {
        // Eliminar espacios usando replace() simple
        expresion = expresion.replace(" ", "");
        
        // Encontrar el operador
        char operador = ' ';
        int posicionOperador = -1;
        
        // Buscar operadores binarios (+, -, *, /)
        // Empezar desde la posición 1 para permitir números negativos
        for (int i = 1; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operador = c;
                posicionOperador = i;
                break;
            }
        }
        
        if (posicionOperador == -1) {
            throw new Exception("No se encontró operador válido");
        }
        
        // Extraer los operandos
        String operando1Str = expresion.substring(0, posicionOperador);
        String operando2Str = expresion.substring(posicionOperador + 1);
        
        if (operando1Str.isEmpty() || operando2Str.isEmpty()) {
            throw new Exception("Operandos inválidos");
        }
        
        try {
            int operando1 = Integer.parseInt(operando1Str);
            int operando2 = Integer.parseInt(operando2Str);
            
            return realizarOperacion(operando1, operando2, operador);
        } catch (NumberFormatException e) {
            throw new Exception("Los operandos deben ser números enteros");
        }
    }
    
    public static int realizarOperacion(int operando1, int operando2, char operador) throws Exception {
        switch (operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                if (operando2 == 0) {
                    throw new Exception("División por cero");
                }
                return operando1 / operando2;
            default:
                throw new Exception("Operador no válido: " + operador);
        }
    }
}