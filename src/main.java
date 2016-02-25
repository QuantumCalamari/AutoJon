import org.w3c.dom.Document;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class main {

	public static void main(String[] args) {
		
		try {
			
			String url = "http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart";
			org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
			
			Elements links = doc.select("a[href]");
			
			System.out.println("Links: " + links.size());
			
			for (Element link : links) {
	            	System.out.println(link.attr("abs:href"));
	        	}
			
		
//			String relHref = link.attr("href"); // == "/"
//			String absHref = link.attr("abs:href");
			
	//		System.out.println(relHref);
	//		System.out.println();
	//		System.out.println(absHref);
			
		//	String str = link.toString();
			
		//	Element text = doc.body().text("Teacher");
		//	System.out.println(text);
		
			//String doc = "<html><head><title>First parse</title></head>" + "<body><p>Parsed HTML into a doc.</p></body></html>";
			
			//org.jsoup.nodes.Document parsed = Jsoup.parse(doc);
			
			//System.out.println(parsed);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String title = doc.title();
		
		
		
		
		

	}

}
