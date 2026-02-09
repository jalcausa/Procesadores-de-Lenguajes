import java.io.*;

public class PLXC {
    public static void main(String[] args) {
        try {
            parser p = new parser(new Yylex(new FileReader(args[0])));
            if(args.length > 1){
                PrintStream out = new PrintStream(new FileOutputStream(args[1]));
                System.setOut(out);
            }
            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
