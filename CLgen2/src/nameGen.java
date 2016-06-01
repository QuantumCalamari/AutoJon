
public class nameGen {

	static String name() {
		String n = "";
		char temp;
		
		
		for (int i = 0; i < 8; i++) {
			int randomNum = 0 + (int)(Math.random() * 26); 
			temp = findLetter(randomNum);
			
			n = n + temp;
		}
		
		System.out.println(n);
		
		return n;
	}
	
	static char findLetter(int randomNum) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char L;
		
		int upper = 0 + (int)(Math.random() * 2);
				
		L = AB.charAt(randomNum);
		
		if (upper == 1) {
			L = Character.toLowerCase(L);
		}
		
		return L;
		
	}
	
}
