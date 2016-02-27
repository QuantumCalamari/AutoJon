package AutoJon.src;
import java.util.ArrayList;
import AutoJon.src.*;

import org.jsoup.nodes.Document;

public class search {
	public static void ranking(Document doc, ArrayList<String> jobScore, ArrayList<String> searchTerms) {
		
		String search;
		int inc = 0;
		
		org.jsoup.select.Elements cont = doc.select("div#job-content");
		
		search = cont.toString();
		mathFunctions.hash(search);
		
		if (search.contains("C++")) {
			inc++;
		}
		
		//here I want to search the cont for terms
		//by searching which terms are included the appropriateness of the job will be determined
		//any job with sufficient appropriateness should be submit to the next stage
		
	}
}
