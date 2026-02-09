import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LPC {
	
    public static boolean DEBUG = false;
    public static FileReader in;
    public static PrintWriter out;
    
    protected static void print_cabecera(String prog) {
        out.println("import java.util.ArrayList;");
        out.println("import java.util.List;");
        out.println("");
        out.println("public class "+prog+ "{");
        out.println("   public static void main(String[] args) {");
    }
    
    protected static void print_cola(String prog) {
        out.println("   }");
        out.println("} // "+ prog);
    }

	private static int contador = 1;
    public static String nuevaTemp() {
    	return "_temp"+contador++;
    }


    /* ********************************************* */
    /*   MAIN                                        */
    /* ********************************************* */


    public static void main(String arg[]) {
        try {
          parser p = null; 	
          String inputFile;
          String outputFile;
          String prog=null;
          int i=0;
          while (i<arg.length) {
              if ("+v".equals(arg[i])) {
            	  DEBUG = true;
              } else  {
                  inputFile = arg[i];
                  prog =  arg[i].substring(0, arg[i].lastIndexOf('.')) ;
                  outputFile = prog + ".java";
                  in = new FileReader(inputFile);
                  out = new PrintWriter(outputFile);
                  p = new parser(new Yylex(in));
              }
              i++;
          }
          if (p!=null && out!=null) {
              print_cabecera(prog);
              p.parse();
              print_cola(prog);
              out.close();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    
}
