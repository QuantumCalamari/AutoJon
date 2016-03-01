package AutoJon.src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import AutoJon.src.*;

import org.jsoup.nodes.Document;

public class search {
	public static String ranking(Document doc, ArrayList<String> searchTerms, String site) {
		
		String search;
		String email, name;
		String CL;
		String title = "Lead Astronaut";
		boolean cpp = false, java = false, cs = false, wd = false, nbool = false, jrefbool;
		org.jsoup.select.Elements cont = doc.select("div#job-content");
		
		//System.out.println(cont);
		
		List myList = new ArrayList();
		
		search = cont.toString();
		//mathFunctions.hash(search);
		
		for (int i = 0; i < searchTerms.size(); i++) {
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
		
		email = AIs.emailSearch(search);
		name = AIs.nameSearch(email);
		System.out.println(name);
		
		CL = AIs.letterGen(name, nbool, "", false, title, wd, cs, cpp, java, site, false, "");
		
		
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
