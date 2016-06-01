
public class letterWriter {

	public static String letterGen(int[] search) {
		String letter, p1, p2, p3, p4, conc, sig;
		
		for (int i = 0; i > search.length; i++) {
			System.out.println(search[i]);
		}
		
		p1 = parOne();
		p2 = parTwo();
		p3 = parThree();
		p4 = parFour(search);
		conc = finalPar();
		
		sig = "Yours sincerely, \n\nJon Collins";
				
		letter = p1 + "\n\n" + p2 + "\n\n" + p3 + "\n\n" + p4 + "\n\n" + conc + "\n\n" + sig;
				
		return letter;
	}
	
	static String parOne() {	
	
			return "Dear Recruiter,\n\n I would like to apply for the [ JOB TITLE ] position with [ COMPANY NAME ], as found on [ WEBSITE ].";	
		
	}
	
	static String parTwo() {
	//this is a needless function because it could be changed in the future
		String p2 = "I graduated in May 2014 from the University of Salford where I was awarded a First Class Master’s in Physics. At graduation I was among the top three students in my class for academic performance.  During my time at Salford I participated in an exchange year in the United States where I was included in the Dean’s List, which is reserved for students with exceptional grades, and where I completed my Bachelor’s Thesis in computational astrophysics.  For my Master’s thesis I was chosen for an internship at Daresbury Laboratory in Warrington, where I completed an internship in computational analysis of semiconductors.";
		
		return p2;
	}
	
	static String parThree() {
		//same as previous, leaving myself options to edit in the future
		String p3 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium where I am currently working on the application of automation in materials research.  As well as my research I am also the de facto lead developer of the group, I maintain the group’s web site and I have teaching duties for mathematics and physics classes. I also contribute to the Q Chem package through a collaboration with my co-promotor at the National University of Taiwan.";
		
		return p3;
	}
	
	static String parFour(int search[]) {
		
		String par = "";
		
		//if C++ is contained
		if (search[0] > 0) {
			par = par + ("I have developed many applications for scientific programming using C++, both in writing simulations themselves and tools for data extraction and analysis");
			//and if java is also contained
			if ((search[1] > 0) || (search[2] > 0)) {	
				par = par + (", the latter of which I also have experience of writing in Java.");
				//and if Fortran is mentioned
				if ((search[16] > 0) || (search[17] > 0)) {
					par = par + (".  Although I did not write my own software during my Master’s project, I worked on bug fixes and code improvements using Fortran and wrote small apps to automate data analysis and calculations.");
				}
				
				//check for mention of IDEs
				if ((search[27] > 0) || (search[28] > 0) || (search[29] > 0) || (search[30] > 0) || (search[31] > 0)) {
					par = par + (".  I prefer using Visual Studio with C++, Eclipse with Java and occasionally Dreamweaver, though I often write PHP in Notepad++ or Nano.  ");
				}				
				
			} // or if there is no Java but there is C# 
			else if (search[6] > 0) {
				par = par + (", and used C# for writing scripts in game development.");
				//check for mention of IDEs
				if ((search[27] > 0) || (search[28] > 0) || (search[29] > 0) || (search[30] > 0) || (search[31] > 0)) {
					par = par + ("  I prefer using Visual Studio with C++, Eclipse with Java and occasionally Dreamweaver, though I often write PHP in Notepad++ or Nano.  ");
				}
			}//need to add a full stop
			else {
				par = par + (".  ");
				
			}
			
		}//else if there's no C++ but there is Java
			else if ((search[1] > 0) || (search[2] > 0)) {
				par = par + ("As my research group use multiple operating systems I have become proficient in using Java to develop tools for data extraction and analysis");
				//and if Fortran is mentioned
				if ((search[16] > 0) || (search[17] > 0)) {
					par = par + (", and updating existing code from Fortran into more easily usable Java.  ");
					}
			} // or if neither, but fortran is mentioned somehow
			else if ((search[16] > 0) || (search[17] > 0)) {
				par = par + ("Though I used other software during my Master’s project, I worked on bug fixes and code improvements using Fortran and wrote small apps to automate data analysis and calculations.  ");
			}
		
		
		//if any mention of web technologies
		if ((search[3] > 0) || (search[4] > 0) || (search[5] > 0)) {
			par = par + ("  During the summer of 2015 I developed a web application for 4Energy in Nottingham to retrieve user's data and provide approximate power usage.  I designed and wrote the app myself based on the company's brief, and they were suitably impressed to offer me a position, though I had already accepted another offer.");
		} //a section about webbots using PHP
		else if (search[15] > 0) {
			par = par + ("  My work bots also requires a solid knowledge of web technologies to reverse engineer the web page into a readable form, or the use of API software when interacting with other Windows programs.");
				}//any mention of html, css or JS
		else if ((search[10] > 0) || (search[11] > 0) || (search[12] > 0) || (search[13] > 0) || (search[14] > 0 )) {
			par = par + ("  During the summer of 2015 I developed a web application for 4Energy in Nottingham to retrieve user's data and provide approximate power usage.  I designed and wrote the app myself based on the company's brief, and they were suitably impressed to offer me a position, though I had already accepted another offer.");
		} //a section about python
		else if ((search[22] > 0) || (search[23] > 0)) {
			par = par + ("  I have written web bots in Python to make use of certain libraries, though I have found PHP to be the best solution and now use it almost exclusively for webbots.");
		}
		
		
		//operating systems linux - windows, this could be expanded in the future
		if ((search[18] > 0) || (search[19] > 0)) {
		//	if ((search[20] > 0) || (search[21] > 0)) {
			par = par + ("  Primarily I use Windows when working on code, though I’m also very comfortable with Linux and OSx which I use it extensively in my research.");
		//	} else {
		//	}
		} //operating systems windows - linux
		else if ((search[20] > 0) || (search[21] > 0)) {
		//	if ((search[18] > 0) || (search[19] > 0)) {
			par = par + ("  Primarily I use Windows when working on code, though I’m also very comfortable with Linux and OSx which I use it extensively in my research.");
		//	}
		}
		//problem solving
		if ((search[24] > 0) || (search[25] > 0) || (search[26] > 0) || (search[32] > 0) || (search[33] > 0)) {
			par = par + ("  Due to my background in research I have very solid problem solving and mathematical abilities, I often discuss with my colleagues and I have taught classes to first year students, and I am familiar with tight timescales on projects.");
		}
		
		return par;
	}
	
	static String finalPar() {
	String pF = "Attached is a copy of my CV that further explains my background and technical skills and links to my LinkedIn profile, as well as my GitHub and WordPress where examples of my work can be found.  I can be reached anytime at +447402005066 or more easily via email at jon.collins@uhasselt.be. Thank you for your consideration. I look forward to speaking with you further about this position.";
		
		return pF;
	}
	
	
}



