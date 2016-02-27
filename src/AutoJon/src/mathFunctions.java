package AutoJon.src;

public class mathFunctions {
		
	public static int hash(String key) {
		
		int h;
		
		h = key.length() % 32;
		
		return h;
	}
}
