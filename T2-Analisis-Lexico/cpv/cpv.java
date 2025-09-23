import java.io.FileReader;
import java.io.IOException;

public class cpv {

	protected static int aCount = 0;
	protected static int bCount = 0;
	protected static int cCount = 0;
	protected static int dCount = 0;

	public static void printCount() {
		System.out.println("A" + " " + aCount);
		System.out.println("B" + " " + bCount);
		System.out.println("C" + " " + cCount);
		System.out.println("D" + " " + dCount);
	}

	public static void main(String arg[]) {
    
        if (arg.length>0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
                int yytoken = 0;
				while ((yytoken = lex.yylex()) != Yylex.YYEOF) {
                    switch (yytoken) {
						case 1:
							aCount++;
							break;
						case 2:
							bCount++;
							break;
						case 3:
							cCount++;
							break;
						case 4:
							dCount++;
							break;
						default:
							break;
					}
                }
				printCount();
	    	} catch (IOException e) {
	    	
			}
        }
    }
}