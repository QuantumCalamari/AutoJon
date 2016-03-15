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
			ArrayList<String> remTerms = new ArrayList<String>();
			
			searchTerms.add("C++");
			searchTerms.add("Java");
			searchTerms.add("Web Development");
			searchTerms.add("C#");
			searchTerms.add("Junior Software");
			searchTerms.add("Python");
			searchTerms.add("SQL");
			searchTerms.add("HTML");
			searchTerms.add("CSS");
			searchTerms.add("JavaScript");
			searchTerms.add("Object Oriented");
			searchTerms.add("OOP");
			searchTerms.add("Data Analysis");
			
			remTerms.add("Senior");
			remTerms.add("Teacher");
			remTerms.add("Lead");
			
			
			/*urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&salary_lo=0&salary_hi=165000&non_default_salary=0&facet_search=1&order_by=best-match&cb=380861&page=2");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&salary_lo=0&salary_hi=165000&non_default_salary=0&facet_search=1&order_by=best-match&cb=380861&page=3");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=12");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=13");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=14");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=15");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=8");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=9");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=10");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=11");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart&page=2");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart&page=2");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=2");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=3");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=4");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=5");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=6");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&page=7");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart&page=3");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart&page=4");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart&page=5");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&onlyshowme=datesmart");
			
			*/
			
			//urlStore.add("http://www.irishjobs.ie/ShowResults.aspx?Keywords=c%2B%2B&Location=0&Category=&Recruiter=Company&Recruiter=Agency");
			//urlStore.add("https://www.ninjaproxy.ninja/browse.php/TsaySMa3/DC3K7Ik0/jKC953cY/9FmNvyoy/9DRHmdPp/ROpHBhmY/lH6YK55P/GuQNpvn3/98coEZCW/tnIZqhmh/hWYjE9uj/rol_2Be1/m_2F_2Bo/4P_2FPkV/HoIivZo9/7w_3D_3D/b29/#.Vtl-iZwrKhd");
			//urlStore.add("https://www.ninjaproxy.ninja/browse.php/TsaySMa3/DC3K7Ik0/jKC953cY/9FmNvyoy/9DRHmdPp/ROpHBhmY/lH6YK55P/GuQNpvCz/s_2BQrTL/zf_2FTEC/qgi4lzo1/F4mps4hm/ekU_3D/b29/#.Vtl-oJwrKhc");
			//urlStore.add("https://www.ninjaproxy.ninja/browse.php/TsaySMa3/DC3K7Ik0/jKC953cY/9FmNvyoy/9DRHmdPp/ROpHBhmY/lH6YK55P/GuQNpvCn/q_2BxiUf/eBtDEFow/uik3U0UJ/KirJx0YF/6n4IZXpf/wAD5Q8sY/k7/b29/#.Vtl-uZwrKhc");
			//urlStore.add("https://www.ninjaproxy.ninja/browse.php/TsaySMa3/DC3K7Ik0/jKC953cY/9FmNvyoy/9DRHmdPp/ROpHBhmY/lH6YK55P/GuQNpuq6/vPZkQKGV/6ywGvAy9/nXA8E8Co/oZFie1yx/_2F5c_3D/b29/#.Vtl-y5wrKhc");
		
			// temporary use of London for testing
			urlStore.add("http://www.jobsite.co.uk/vacancies?search_type=quick&query=junior+developer&location=scotland&radius=20");
		//	urlStore.add("http://www.indeed.co.uk/jobs?q=software+engineer&l=london");
		//	urlStore.add("http://www.irishjobs.ie/ShowResults.aspx?Keywords=C%2B%2B+Developer&Location=0&Category=&Recruiter=Company&Recruiter=Agency");
			
			for (int i = 0; i < urlStore.size(); i++) {
				
				boolean add;
				
				org.jsoup.nodes.Document doc = Jsoup.connect(urlStore.get(i)).get();
				Elements links = doc.select("a[href]");
				
				String linkString = "";
				
				for (Element link : links) {
					
						linkString = link.attr("href");
		               	String linkInnerH = link.html();
		            	
		               	add = trawl.searchString(linkInnerH, linkString, searchTerms, remTerms);
		               /*	
		               	if (i < 4) {
							site = "http://www.s1jobs.com";
						} else if (i < 5) {
							site = "http://www.indeed.com";
						}
		               	*/
		               	
		               	site = "http://www.jobsite.co.uk";
		              	//site = "http://www.irishjobs.ie";
		               	
		               	if (add) {
		               		jobStore.add(site + linkString);
		               	}
		            	
		        	}
			}
			
			//take job store and search for duplicates
			
			Set<String> set = new HashSet<String>(jobStore);

			if (set.size() < jobStore.size()) {
				jobStore.clear();
				jobStore.addAll(set);
			}
			
			AIs.server();
			for (int i = 0; i < jobStore.size(); i++) {
			
			}
			
			//now I need to take this data and search each url
			
			for (int i = 0; i < jobStore.size(); i++) {
				org.jsoup.nodes.Document doc = Jsoup.connect(jobStore.get(i)).get();
				thisCL = search.ranking(doc, site);
				CL.add(thisCL);
			}
			
		//	for (int i = 0; i < CL.size(); i++) {
				//System.out.println(CL.get(i));
				//put this in an output file
		//	}

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}	
}
