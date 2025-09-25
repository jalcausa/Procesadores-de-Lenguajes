import java.io.FileReader;
import java.io.IOException;

public class wc {
	protected static int wordCount = 0;
	protected static int lineCount = 0;
	protected static int charCount = 0;

	public static void main(String arg[]) {
    
        if (arg.length>0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
                Yytoken yytoken = null;
				while (  (yytoken = lex.yylex()) != null  ) {
                    if (yytoken.getToken() == Yytoken.WORD)
					{
						wordCount++;
						charCount += yytoken.getLexema().length();
					}
					else if (yytoken.getToken() == Yytoken.NL)
					{
						lineCount++;
						charCount++;
					}
					else
					{
						charCount++;
					}
                }
				System.out.println(lineCount + "\t" + wordCount + "\t" + charCount + " " + arg[0]);
	    	} catch (IOException e) {
	    	
			}
        }
    }
}
