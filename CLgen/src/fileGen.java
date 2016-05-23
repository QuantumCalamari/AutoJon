
public class fileGen {

	public static String letterGen(String name, boolean nbool, String jRef, boolean jRefbool, String title, boolean g1, boolean g2, boolean g3, boolean s1, String siteRaw, boolean compBool, String company) {
		String letter, att, intro, p1, p2, p31, p32, conc, sig;
		
		intro = "";
		p1 = "";
		p2 = "";
		p31 = "";
		p32 = "";
	//	p33 = "";
		
		String site = "";
		
		//for (int i = 11; i < siteRaw.length(); i++) {
		//	site = site + siteRaw.charAt(i);
		//}
		
		//generate a header
		if (nbool) {
			att = name + ",\n\n";
		} else {
			att = "Dear Recruiter,\n \n";
		}
		
		if (jRefbool) {
			intro = "I would like to apply for the " + title + " with your client (ref: " + jRef + ") found on " + site + ".\n\n";
		} else {
			intro = "I would like to apply for the " + title + " with your client found on " + site + ".\n\n";
		}
		
		p1 = "I graduated in May 2014 from the University of Salford where I was awarded a First Class Master’s in Physics. "
				+ "At graduation I was among the top three students in my class for academic performance.  During my time at Salford I "
				+ "participated in an exchange year in the United States where I was included in the Dean’s List, which is reserved for "
				+ "students with exceptional grades, and where I completed my Bachelor’s Thesis in computational astrophysics.  For my "
				+ "Master’s thesis I was chosen for an internship at Daresbury Laboratory in Warrington, where I completed an internship in "
				+ "computational analysis of semiconductors.\n\n";
		
		p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit "
				+ "in Belgium where I am currently working on the application of automation in materials research.  "
				+ "I have already automated the calculation process and analysis of the subsequent output with some software "
				+ "written in C++ and development is ongoing, and I contribute to the Q Chem package through a collaboration "
				+ "with my co-promotor at the National University of Taiwan.\n\n";
		
	
		if (g1) {
			p31 = "Most of my code is written in object oriented languages C++ and Java, unless a specific problem requires another solution."
					+ "  I also have a solid knowledge of Fortran, as much of my work involves the update of legacy code.  In my time working"
					+ " on the development of code I have also improved my planning and design skills, which I’ve found to be crucial to a "
					+ "successful project.  ";
		} else if (g2) {
			p31 = "I mainly make use of HTML, CSS and JavaScript, and associated libraries such as d3.js, in my work for processing and "
					+ "display of data. In summer of 2015 I contracted to complete a web app for the completion of physics calculations "
					+ "and display of data to end users.  I am also the current webmaster for the website of my research group.  ";
		} else if (g3) {
			p31 = "My background in physics has provided me with a strong foundation in the mathematics required for game programming.  "
					+ "I have experience in using Blender for modelling, and have made a few models for myself, and I am gaining confidence"
					+ " with Unity and working toward producing a game of my own.  I also have a strong interest in physics engines: I "
					+ "have developed some fairly basic engines for 2D graphical output of calculation results and I am currently "
					+ "developing a 3D engine for my research group.  ";
			s1 = true;
		}
		
		if (s1) {
			p32 = "I am also required to regularly brief my colleagues and senior staff members in Belgium with updates on my work,"
					+ " and also to liaise with the development teams in Taiwan.\n\n";
		} else {
			
			p32 = "My background in physics has also provided me with a strong foundation in mathematics and problem solving, and in "
					+ "data handling.\n\n";
		}
		
		//if (!compBool) {
		//conc = "Your client would benefit from my unique background, my knowledge in research and problem solving in addition to my proven track record "
		//		+ "across several disciplines. My excellent academic record and desire to grow within this role ensure that I would be a positive "
		//		+ "addition to your client's team. If you have any additional questions or require any further documentation, I am available to be"
		//		+ " contacted through phone or email. \n\n";
		//} else {
			conc = "If you have any additional questions or require any further documentation, I am available to be"
					+ " contacted through phone or email. \n\n";
			
		//}
		
		
		sig = "Yours sincerely, \n\nJon Collins";
				
		letter = att + intro + p1 + p2 + p31 + p32 + conc + sig;
				
		return letter;
	}
	
	public static String emailGen(String name, boolean nbool, String jRef, boolean jRefbool, String title) {
		String email, main, sig;
		
		if (!nbool) {
			name = "Dear Recruiter";
		}
				
		if (jRefbool) {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position (ref:" + jRef + ") with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		} else {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		}
		
		sig = "Regards\n\nJon Collins, and AutoJon\n\n\n";
		
		//String sub = "We're still ironing out the kinks, so we're sorry if I got it wrong.  We're working on making me smarter.  Any feedback can be sent to AutoJonFeedback@gmail.com";
		
		email = "\n\n" + main;
	
		return email;
	}
	
}
