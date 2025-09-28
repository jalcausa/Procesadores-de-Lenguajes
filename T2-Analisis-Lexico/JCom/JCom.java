import java.io.FileReader;
import java.io.IOException;

public class JCom {
	
    public static void main(String arg[]) {
        if (arg.length>0) {
            Yylex lex = null;
            try {
                lex = new Yylex(new FileReader(arg[0]));
                lex.yylex();
             } catch (IOException e) {
             } 
        }
    }
}
