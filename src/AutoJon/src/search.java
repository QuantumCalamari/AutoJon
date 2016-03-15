package AutoJon.src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import AutoJon.src.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class search {
	public static String ranking(Document doc, String site) {
		String search = "", emessage = "";
		String email = "autojonfeedback@gmail.com", name = "";
		String login = "";
		String password = "";
		String CL = "", hold, rsearch;
		String title = "";
		String jRef = "";
		String apply;
		
		System.out.println("this site: "+ site);
		
		ArrayList<String> titleSearch = new ArrayList<String>();
		titleSearch.add("analyst");
		titleSearch.add("developer");
		titleSearch.add("engineer");
		titleSearch.add("solutions");
		
				
		ArrayList<String> g1terms = new ArrayList<String>();
		ArrayList<String> g2terms = new ArrayList<String>();
		ArrayList<String> g3terms = new ArrayList<String>();
		ArrayList<String> s1terms = new ArrayList<String>();
		
		boolean g1 = false, g2 = false, g3 = false, s1 = false, nbool = false, jRefbool = false;
		if (site.contains("s1jobs")) {
			
			org.jsoup.select.Elements drsearch = doc.select("div#job-header-details");
			Elements sTags = drsearch.select("strong");
			int n = 0;
			for (Element sTag : sTags) {
				
				if (n == 3) {
					System.out.println(sTag);
					jRef = AIs.refSearch(sTag.toString());
					//System.out.println(jRef);
					jRefbool = true;
				}
				n++;
			}
			
			//if (rsearch.contains("ref")) {
			//	jRef = AIs.refSearch(rsearch);
			//	jRefbool = true;
			//	System.out.println(jRef);
			//}
			
			org.jsoup.select.Elements ttl = doc.select("div#job-header-title");
			Elements hTags = ttl.select("h1, h2, h3, h4, h5, h6");
			
			org.jsoup.select.Elements cont = doc.select("div#job-content");
			search = cont.toString();
			
			
			
			for (Element hTag : hTags) {
				
				hold = hTag.toString();
				for (int i = 4; i < hold.length(); i++) {
					if (hold.charAt(i) == '<') {
						i = hold.length();
					}
					if (i != hold.length()) {	
					title = title + hold.charAt(i);
					}
				}
				
				//System.out.println(title);
			}
		} else if (site.contains("jobsite")) {
			org.jsoup.select.Elements ttl = doc.select("div#cnt-right");
			Elements hTags = ttl.select("h1");
			//System.out.println("We get to here");
			
			//org.jsoup.select.Elements cont = doc.select("div#job-content");
		//	search = doc.toString();
			//for (Element hTag : hTags) {
				
				
				
			//	hold = hTag.toString();
			hold = doc.toString();
				
			if (hold.contains("title"))
				//System.out.println(hold.indexOf("title") + 16);
			
			
			//System.out.println(hold);
			
			for (int i = hold.indexOf("title")+16; i < hold.indexOf("title")+60; i++) {
			//	System.out.println(i);
			//	System.out.println(hold.charAt(i));
				title = title + hold.charAt(i);
				if (hold.charAt(i+1) == '"') {
					
					i = hold.indexOf("title")+61;
				} else if (hold.charAt(i+1) == ';') {
					
					i = hold.indexOf("title")+61;
				}
				//I will add a way to use the application feature on their website
			}
			
			if (hold.contains("Ref"))
				//System.out.println(hold.indexOf("Ref No") + 17);
			//System.out.println(hold.substring(hold.indexOf("Ref No")+57, hold.indexOf("Ref No")+100));
			
			//System.out.println(hold);
			
			for (int i = hold.indexOf("Ref")+55; i < hold.indexOf("title")+90; i++) {
			//	System.out.println(hold.charAt(i));
				jRef = jRef + hold.charAt(i);
				System.out.println(hold.charAt(i));
				if (hold.charAt(i+1) == '<') {
					
					i = hold.indexOf("Ref")+91;
				}
			}
			
			System.out.println(jRef);
			
			/*	for (int i = 0; i < titleSearch.size(); i++) {
					int s = 0, e = 0;
					System.out.println(hold);
					if(hold.contains(titleSearch.get(i))) {
						ttl.indexOf(titleSearch.get(i));
						while ((s < 30) && (hold.charAt(s) != '>')) {
							s--;
						}
						while ((e < 60) && (hold.charAt(e) != '>')) {
							e++;
						}
						title = hold.substring(s,  e);
						i = titleSearch.size();
					}
				}
				
				for (int i = 4; i < hold.length(); i++) {
					if (hold.charAt(i) == '<') {
						i = hold.length();
					}
					if (i != hold.length()) {	
					title = title + hold.charAt(i);
					}
				}
				System.out.println(title);
			//}
		}	*/
		
		//mathFunctions.hash(search);
		
		/*for (int i = 0; i < searchTerms.size(); i++) {
			if (i == 0) {
				cpp = search(search, searchTerms.get(i));
			} else if (i == 1) {
				java = search(search, searchTerms.get(i));
			} else if (i == 2) {
				wd = search(search, searchTerms.get(i));
			} else if (i == 3) {
				cs = search(search, searchTerms.get(i));
			}
		}
		*/
		
		//group 1 is OOP
		g1terms.add("OOP");
		g1terms.add("OO");
		g1terms.add("Object Oriented");
		g1terms.add("C++");
		g1terms.add("Java");
		
		//group 2 is web stuff
		g2terms.add("web dev");
		g2terms.add("web");
		g2terms.add("HTML");
		g2terms.add("CSS");
		g2terms.add("JavaScript");
		
		//group 3 is video games
		g1terms.add("C#");
		g1terms.add("games");
		
		s1terms.add("communication");
		//s1terms.add("data analysis");
		
		//clean this up with a method when I have more time
		for (int i = 0; i < g1terms.size(); i++) {
			if (search.contains(g1terms.get(i))) {
				g1 = true;
			}
		}
		
		for (int i = 0; i < g2terms.size(); i++) {
			if (search.contains(g2terms.get(i))) {
				g2 = true;
			}
		}
		
		for (int i = 0; i < g3terms.size(); i++) {
			if (search.contains(g3terms.get(i))) {
				g3 = true;
			}
		}
		
		for (int i = 0; i < s1terms.size(); i++) {
			if (search.contains(s1terms.get(i))) {
				s1 = true;
			}
		}
		
		org.jsoup.select.Elements drsearch = doc.select("div#apply-btn");
		Elements links = doc.select("a[href]");
		
		for (Element link : links) {
			
			String url = link.attr("href");
			String linkStr = link.toString();
			
			if (linkStr.contains("applynow")) {
				System.out.println(linkStr);
				System.out.println(url);
			}
			
			if(site.contains("jobsite")) {
				apply apl = new apply();
				apl.jobsite(url);
			}
			
		}
		
		
		
		email = AIs.emailSearch(search);
		
		//System.out.println("we're getting this far");
		
		if (!nbool  && (email != "")) {
				name = AIs.nameSearch(email);
				nbool = true;
		}
		CL = AIs.letterGen(name, nbool, jRef, jRefbool, title, g1, g2, g3, s1, site, false, "");
		
		emessage = AIs.emailGen(name, nbool, jRef, jRefbool, title);
		System.out.println(email);
		
		if (email.contains("</p>")) {
			email = email.substring(0, email.indexOf("</p>")-1);
		}
		
	//	if (email.charAt((email.length())) == '.') {
	//		email = email.substring(0, email.indexOf("com")+2);
		}
		
	/*	if (email.contains("bree")) {
			email = "autojonfeedback@gmail.com";
		}
		
		if (email.contains("newton")) {
			email = "autojonfeedback@gmail.com";
		}
		
		if (email == "") {
			email = "autojonfeedback@gmail.com";
		}
		*/
		
		System.out.println(email);
		AIs.mailer(login, password, emessage, title, email, CL);
				
		
		
		return CL;
		//here I want to search the cont for terms
		//by searching which terms are included the appropriateness of the job will be determined
		//any job with sufficient appropriateness should be submit to the next stage
		
	}
	
	public static boolean search(String doc, String term) {
		boolean val = false;
		
		if (doc.contains(term)) {
			val = true;
		}
		
		return val;
	}
}

