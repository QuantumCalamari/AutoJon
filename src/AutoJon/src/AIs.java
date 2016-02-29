package AutoJon.src;

public class AIs {

	public static String letterGen(String name, boolean nbool, String jRef, boolean jRefbool, String title, boolean cs, boolean cpp, boolean java, String site, boolean compBool, String company) {
		String letter, att, intro, p1, p2, p3, conc, sig;
		
		intro = "";
		p1 = "";
		p2 = "";
		p3 = "";
		
		//generate a header
		if (nbool) {
			att = name;
		} else {
			att = "Dear Recruiter\n \n";
		}
		
		if (jRefbool) {
			intro = "I would like to apply for the " + title + " with your client (ref: " + jRef + ") found on " + site + ".\n\n";
		}
		
		p1 = "I graduated in May 2014 from the University of Salford where I was awarded a First Class Master’s in Physics. "
				+ "At graduation I was among the top three students in my class for academic performance.  During my time at Salford I "
				+ "participated in an exchange year in the United States where I was included in the Dean’s List, which is reserved for "
				+ "students with exceptional grades, and where I completed my Bachelor’s Thesis in computational astrophysics.  For my "
				+ "Master’s thesis I was chosen for an internship at Daresbury Laboratory in Warrington, where I completed an internship in "
				+ "computational analysis of semiconductors.\n\n";
		
		if (cpp && java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work primarily in an object oriented system with C++ and Java, and I have solid knowledge of Fortran through updating legacy code.  "
					+ "I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (cpp && !java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with C++ and Java, though I also have experience of Fortran through updating legacy code.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (!cpp && java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with Java and C++, though I also have experience of Fortran through updating legacy code.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (cs) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with Java and C++, though I also have an interest in game development where I use C# for writing "
					+ "animation scripts in Unity.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";

		}
		
		if (!compBool) {
		conc = "Your client would benefit from my unique background, my knowledge in research and problem solving in addition to my proven track record across several disciplines. My excellent academic record and desire to grow within this role ensure that I would be a positive addition to your client's team. If you have any additional questions or require any further documentation, I am available to be contacted through phone or email. \n\n";
		} else {
			conc = company + " would benefit from my unique background, my knowledge in research and problem solving in addition to my proven track record across several disciplines. My excellent academic record and desire to grow within this role ensure that I would be a positive addition to your client's team. If you have any additional questions or require any further documentation, I am available to be contacted through phone or email. \n\n";
			
		}
		
		
		sig = "Regards, \n\nJon Collins";
				
		letter = att + intro + p1 + p2 + p3 + conc + sig;
		
		return letter;
	}
	
	public static String emailGen(String name, boolean nbool, String jRef, boolean jRefbool, String title) {
		String email, main, sig;
		
		if (!nbool) {
			name = "Dear Recruiter,\n\n";
		}
		
		if (jRefbool) {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position (ref:" + jRef + ") with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		} else {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		}
		
		sig = "Regards\n\nJon Collins, and AutoJon";
		
		email = name + main + sig;
		
		return email;
	}
	
}
