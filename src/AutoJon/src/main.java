package AutoJon.src;
import org.w3c.dom.Document;
import java.io.Console;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import AutoJon.src.*;

public class main {

	public static void main(String[] args) {	
			
		try {
			
			String site = "S1 Jobs";
			String thisCL = "";
			String login = "", password = "";
			Console cnsl = null;	
			
			cnsl = System.console();
			//Console pword = System.console();
			if (cnsl != null) {
			login = cnsl.readLine("Login: ");
			password = cnsl.readLine("Password: ");
			} else {
				
			}
			//login = lin.toString();
			//password = pword.toString();
			//theres no password right now
			
			
			ArrayList<String> urlStore = new ArrayList<String>();
			ArrayList<String> jobStore = new ArrayList<String>();
			ArrayList<String> searchTerms = new ArrayList<String>();
			ArrayList<String> CL = new ArrayList<String>();
			
			searchTerms.add("C++");
			searchTerms.add("Java");
			searchTerms.add("Web Development");
			searchTerms.add("C#");
			searchTerms.add("Junior Software");
			
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart");
			
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&onlyshowme=datesmart");
			
			for (int i = 0; i < urlStore.size(); i++) {
				
				boolean add;
				
				org.jsoup.nodes.Document doc = Jsoup.connect(urlStore.get(i)).get();
				//org.jsoup.nodes.Document doc = Jsoup.connect("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart").get();
				Elements links = doc.select("a[href]");
				
				String linkString = "";
				
				for (Element link : links) {
					
						linkString = link.attr("href");
		               	String linkInnerH = link.html();
		            	
		               	add = trawl.searchString(linkInnerH, linkString, searchTerms);
		               	
		               	if (i < 4) {
							site = "http://www.s1jobs.com";
						} else if (i < 5) {
							site = "http://www.indeed.com";
						}
		               	
		               	if (add) {
		               		jobStore.add(site + linkString);
		               	}
		            	
		        	}
				
				//size = jobStore.size();
			}
			
			//take job store and search for duplicates
			
			Set<String> set = new HashSet<String>(jobStore);

			if (set.size() < jobStore.size()) {
				jobStore.clear();
				jobStore.addAll(set);
			}
			
		//	AIs.server();
		//	for (int i = 0; i < jobStore.size(); i++) {
		//	AIs.mailer(login, password);
		//	}
			
			//now I need to take this data and search each url
			
			for (int i = 0; i < jobStore.size(); i++) {
				//System.out.println(jobStore.get(i));
				//search every url in the list
				org.jsoup.nodes.Document doc = Jsoup.connect(jobStore.get(i)).get();
				thisCL = search.ranking(doc, searchTerms, site);
				CL.add(thisCL);
			}
			
			//take output of search.ranking and generate cover letter with it
			
			
			
			//System.out.println(AIs.letterGen("none", false, "1234", true, "Lead Astronaut", true, true, true, "S1 Jobs", false, "none"));
			//System.out.println(AIs.letterGen("none", false, "1234", true, "Lead Astronaut", false, true, true, "S1 Jobs", false, "none"));
			//System.out.println(AIs.letterGen("none", false, "1234", true, "Lead Astronaut", false, false, true, "S1 Jobs", false, "none"));
			//System.out.println(AIs.emailGen("none", false, "1234", true, "Lead Astronaut"));
			
			//how to send email
			//http://www.tutorialspoint.com/java/java_sending_email.htm
			for (int i = 0; i < CL.size(); i++) {
				//System.out.println(CL.get(i));
				//put this in an output file
			}
			
			//do the emailing
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}	
}
