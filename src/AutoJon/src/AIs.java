package AutoJon.src;

public class AIs {

	public static String letterGen(String name, boolean nbool, String jRef, boolean jRefbool, String title, boolean cpp, boolean java) {
		String letter, att, intro, p1, p2, p3, conc;
		
		//generate a header
		if (nbool) {
			att = name;
		} else {
			att = "Dear Recruiter %n %n";
		}
		
		if (jRefbool) {
			intro = "Having completed a Master’s project researching the relativistic effects of spin-orbit interactions in semiconductors, I am very interested in the open " + title + " position " + jRef + ".  Over the course of my degree I worked on many related projects, and have since been working on improving my computer science knowledge and as a result have become increasingly interested in pursuing software development.%n %n";
		}
		
		p2 = "thing I did at uni";
		
		if (cpp && java) {
			p2 = "C++ and Java";
			p3 = "software experience";
		} else if (cpp && !java) {
			p2 = "only C++";
		} else if (!cpp && java) {
			p2 = "only Java";
		}
		
		
		letter = att;
		
		return letter;
	}
	
}
