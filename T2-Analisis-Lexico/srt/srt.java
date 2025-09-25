import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class srt {
	protected static int subCount = 0;
	protected static int timeCount = 0;
	protected static int lineCount = 0;
	protected static int wordCount = 0;

	public static int countWords(String s) {
		String[] parts = s.split("\\s+");
	    return parts.length;
	}

	public static int countLines(String s) {
		String[] parts = s.split("\\n");
	    return parts.length;
	}

	public static int countTime(String s) {
		String[] parts = s.split("[-:>,\\n ]+");
		//System.out.println(Arrays.toString(parts));
		int h = Integer.parseInt(parts[4]) - Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[5]) - Integer.parseInt(parts[1]);
		int seg = Integer.parseInt(parts[6]) - Integer.parseInt(parts[2]);
		return (h*3600 + min*60 + seg);
	}

    public static void main(String arg[]) {
        if (arg.length>0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
                Yytoken yytoken = null;
				while (  (yytoken = lex.yylex()) != null  ) {
					if (yytoken.getToken() == Yytoken.NSUB)
						subCount++;
					else if (yytoken.getToken() == Yytoken.TIMESTAMP)
						timeCount += countTime(yytoken.getLexema());
					else {
						lineCount += countLines(yytoken.getLexema());
						wordCount += countWords(yytoken.getLexema());
					}
	    		}
				System.out.println("NUM_SUBTITULOS " + subCount + "\n" + "TIEMPO_TOTAL " + timeCount + "\n" + "NUM_LINEAS " + lineCount + "\n" + "NUM_PALABRAS " + wordCount);
			} catch (IOException e) {
	    	
        	}
		}	
	}
}