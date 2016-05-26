import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.safety.Whitelist;

public class htmlScraper {

	static void parseData(String listing) throws IOException {
		ArrayList<String> searchTerms = new ArrayList<String>();
		int searchAmount[];
		
		//adding terms to the search has to be added to this number here but everything else is taken care of
		searchAmount = new int[34];
		
		org.jsoup.nodes.Document ad = Jsoup.connect(listing).get();
		
		String post = cleanTagPerservingLineBreaks(ad.text());
		String CL;
		String fileName;
		
	//	System.out.println(post);
		
		searchTerms.add("C++");					//0
		searchTerms.add("Java");				//1
		searchTerms.add("java");				//2
		searchTerms.add("Web Development");		//3
		searchTerms.add("Web development");		//4
		searchTerms.add("web development");		//5
		searchTerms.add("C#");					//6
		searchTerms.add("Junior Software");		//7
		searchTerms.add("Python");				//8  I have these twice I can reuse these pythons
		searchTerms.add("python");				//9
		searchTerms.add("HTML");				//10
		searchTerms.add("CSS");					//11
		searchTerms.add("JavaScript");			//12
		searchTerms.add("javaScript");			//13
		searchTerms.add("javascript");			//14
		searchTerms.add("PHP");					//15
		searchTerms.add("Fortran");				//16
		searchTerms.add("fortran");				//17
		searchTerms.add("Linux");				//18
		searchTerms.add("linux");				//19
		searchTerms.add("Windows");				//20
		searchTerms.add("windows");				//21
		searchTerms.add("Python");				//22
		searchTerms.add("python");				//23
		searchTerms.add("Problem solving");		//24
		searchTerms.add("Problem Solving");		//25
		searchTerms.add("problem solving");		//26
		searchTerms.add("Visual Studio");		//27
		searchTerms.add("visual studio");		//28
		searchTerms.add("Visual studio");		//29
		searchTerms.add("Eclipse");				//30
		searchTerms.add("eclipse");				//31
		searchTerms.add("communication");		//32
		searchTerms.add("Communication");		//33
		
		//System.out.println("\n\n\n" + post + "\n");
		
		for (int i = 0; i < searchTerms.size(); i++) {
			
				if( containsIgnoreCase( post, searchTerms.get(i)) ) {
				//  System.out.println( "Found " + searchTerms.get(i) + " within post." );
				  searchAmount[i]++;
				}
		}

		CL = letterWriter.letterGen(searchAmount);

		//String oldstring = "2011-01-18 00:00:00.0";
		//LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));    
		//fileName = datetime.toString();
		
		System.out.println(listing);
		
		//PrintWriter writer = new PrintWriter(("C:\\Users\\Jon\\Documents\\Job Search\\" + fileName + ".txt"), "UTF-8");
	//	writer.println(listing + "\n\n\n");		
	//	writer.println(CL);
	//	writer.close();
		
		
	}

	
	public static String cleanTagPerservingLineBreaks(String html) {
	    String result = "";
	    if (html == null)
	        return html;
	    Document document = Jsoup.parse(html);
	    document.outputSettings(new Document.OutputSettings().prettyPrint(false));// makes html() preserve linebreaks and
	                                        
	    document.select("br").append("\\n");
	    document.select("p").prepend("\\n\\n");
	    result = document.html().replaceAll("\\\\n", "\n");
	    result = Jsoup.clean(result, "", Whitelist.none(),
	            new Document.OutputSettings().prettyPrint(false));
	    return result;
	}
	
	public static boolean containsIgnoreCase( String haystack, String needle ) {
		  if(needle.equals(""))
		    return true;
		  if(haystack == null || needle == null || haystack .equals(""))
		    return false; 

		  Pattern p = Pattern.compile(needle,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
		  Matcher m = p.matcher(haystack);
		  return m.find();
		}
	
}
