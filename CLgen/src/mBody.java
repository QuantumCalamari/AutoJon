import java.util.ArrayList;

public class mBody {

	public static void main(String[] args) {
		
		String sstring = inp.sstring();
		boolean test = false, g1 = false, g2 = false, g3 = false, s1 = false;
		
		boolean nbool = false, jRefbool = false, compBool = false;
		String name = "Rhona Kennedy";
		String jRef = "RK2902";
		String company = "";
		String site = "LinkedIn";
		String title = "Scientific Software Engineer";
		
		if (name != "") {
			nbool = true;
		}
		if (jRef != "") {
			jRefbool = true;
		}
		if (company != "") {
			compBool = true;
		}
		
		ArrayList<String> searchTerms = new ArrayList<String>();
		
		searchTerms.add("C++");
		searchTerms.add("Java");
		searchTerms.add("Object Oriented");
		searchTerms.add("Object-Oriented");
		searchTerms.add("Object oriented");
		searchTerms.add("Object-oriented");
		searchTerms.add("OOP");
		searchTerms.add("HTML");
		searchTerms.add("CSS");
		searchTerms.add("JavaScript");
		searchTerms.add("Web Development");
		searchTerms.add("C#");
		searchTerms.add("Junior Software");
		searchTerms.add("Python");
		searchTerms.add("SQL");
		searchTerms.add("Data Analysis");
		
		boolean[] searched = new boolean[searchTerms.size()];
		
		for (int i = 0; i < searchTerms.size(); i++) {
			if (sstring.contains(searchTerms.get(i))) {
				searched[i] = true;
			}
		}
		
		
		for (int i = 0; i < searchTerms.size(); i++) {
			if (i < 6) {
				if (searched[i]) {
					g1 = true;
				}
			} 
			
			if (i > 6 || i < 10) {
				if (searched[i]) {
					g2 = true;
				} //this next line is a terrible way to do it and I'm sorry
			} else if (i <  (searchTerms.size()-1)){
				if (searched[i]) {
					g3 = true;
				}
			} else if (i == searchTerms.size()) {
				if (searched[i]) {
					s1 = true;
				}
			}
		}		
		
		g2 = true;
		
		if (g1 || g2 || g3) {		
			System.out.println(fileGen.letterGen(name, nbool, jRef, jRefbool, title, g1, g2, g3, s1, site, compBool, company));
			System.out.println(fileGen.emailGen(name, nbool, jRef, jRefbool, title));
			//System.out.println("true");
		} else {
			System.out.println("search returned no results");
		}
		
	}

}
