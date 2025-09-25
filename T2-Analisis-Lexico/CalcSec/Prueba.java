public class Prueba {
	public static void main(String arg[]) {
		String lexema = "++2";
		String[] parts = lexema.split("\\+");

		for (String s : parts) {
			System.out.println(s);
		}
	}
}
