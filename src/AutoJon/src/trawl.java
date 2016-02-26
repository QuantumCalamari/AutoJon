package AutoJon.src;

import java.util.ArrayList;

public class trawl {

	public static boolean searchString(String listing, String url) {
		
		boolean add = false;
		
		ArrayList<String> searchTerm = new ArrayList<String>();
		
		searchTerm.add("C++");
		searchTerm.add("Junior Software");
		searchTerm.add("Java");
		
		for (int i = 0; i < searchTerm.size(); i++) {
			if (listing.contains(searchTerm.get(i))) {
				//System.out.println(searchTerm.get(i));
				//System.out.println(listing);
				//System.out.println(url);
				//System.out.println();
				
				add = true;
				
			}	
		}
		return add;
	}
	
	public static void pullJob(String url) {
		
	}
}
