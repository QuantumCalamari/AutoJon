package AutoJon.src;
import org.w3c.dom.Document;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList;
import AutoJon.src.trawl;

public class main {

	public static void main(String[] args) {
		
		
		
		
		
		try {
			
		//	String[] urlStore = {"http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart",
		//			 "http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart",
		//			"http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart",
		//			"http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&onlyshowme=datesmart"
		//	};
			ArrayList<String> urlStore = new ArrayList<String>();
			ArrayList<String> jobStore = new ArrayList<String>();
			
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&onlyshowme=datesmart");
			
			for (int i = 0; i < urlStore.size(); i++) {
				
				System.out.println();
				System.out.println(urlStore.get(i));
				System.out.println();
				
				org.jsoup.nodes.Document doc = Jsoup.connect(urlStore.get(i)).get();
				Elements links = doc.select("a[href]");
				
				String linkString = "";
								
				//System.out.println(trawl.someFunc());
				
				for (Element link : links) {
		            	
						linkString = link.attr("href");
		               	String linkInnerH = link.html();
		            	
		            	
		            	if (linkInnerH.contains("Software")) {
		            		System.out.println(linkInnerH);
		            		System.out.println("www.s1jobs.com" + linkString);
		            		jobStore.add("www.s1jobs.com" + linkString);
		            		//System.out.println();
		            	}
		        	}
				
				System.out.println(jobStore.size());
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String title = doc.title();
		
		
		
		
		

	}

}
