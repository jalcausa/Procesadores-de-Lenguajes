import java.io.*;

public class PLXC {

    public static PrintStream salida;

    public static void main(String args[]) {
        try {
            Reader entrada = new InputStreamReader(System.in);
            salida = System.out;
            
            if (args.length > 0) { 
                entrada = new FileReader(args[0]);
            }
            if (args.length > 1) {
                salida = new PrintStream(new FileOutputStream(args[1]));
            }
            
            System.setOut(salida);
            System.setErr(salida);
            
            parser p = new parser(new Yylex(entrada));
            Object resultado = p.parse().value;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
