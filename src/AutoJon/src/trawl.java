package AutoJon.src;

import java.util.ArrayList;
//import org.jsoup.Jsoup;
//import AutoJon.src.search;

public class trawl {

	public static boolean searchString(String listing, String url, ArrayList<String> searchTerm) {
		
		boolean add = false;
		
		for (int i = 0; i < searchTerm.size(); i++) {
			if (listing.contains(searchTerm.get(i))) {				
				add = true;		
			}	
		}

		if (listing.contains("Senior") || listing.contains("Teacher")) {
			add = false;
		}
		
		return add;
	}
	
	/*public static void pullJob(String url, ArrayList<String> jobScore, ArrayList<String> searchTerms) {
		try {
		org.jsoup.nodes.Document doc = Jsoup.connect("http://www.s1jobs.com" + url).get();
		//System.out.println(doc);
		
		//search.ranking(doc, jobScore, searchTerms);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//I have to search this document for certain search terms
	}*/
}
