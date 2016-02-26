package AutoJon.src;
import org.w3c.dom.Document;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import AutoJon.src.trawl;

public class main {

	public static void main(String[] args) {
		
		
		
		
		
		try {
			
			ArrayList<String> urlStore = new ArrayList<String>();
			ArrayList<String> jobStore = new ArrayList<String>();
			
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=java&onlyshowme=datesmart");
			urlStore.add("http://www.s1jobs.com/jobs/find?keywords_required=junior%20software&onlyshowme=datesmart");
			
			for (int i = 0; i < urlStore.size(); i++) {
				
				//System.out.println();
				//System.out.println(urlStore.get(i));
				//System.out.println();
				
				boolean add;
				
//				jobStore.add("Physics Teacher");
//				jobStore.add("Senior Programmer");
				
				org.jsoup.nodes.Document doc = Jsoup.connect(urlStore.get(i)).get();
				Elements links = doc.select("a[href]");
				
				String linkString = "";
				
				for (Element link : links) {
		            	
						linkString = link.attr("href");
		               	String linkInnerH = link.html();
		            	
		               	add = trawl.searchString(linkInnerH, linkString);
		               	
		               	if (add) {
		               		jobStore.add(linkString);
		               	}
		               	
		              // 	for (int j = 0; j < jobStore.size(); j++) {
		               	
		               //		System.out.println(linkInnerH);
		               		           	
		              // 	}
		            	/*
		            	if (linkInnerH.contains("Software")) {
		            		System.out.println(linkInnerH);
		            		System.out.println("www.s1jobs.com" + linkString);
		            		jobStore.add("www.s1jobs.com" + linkString);
		            		//System.out.println();
		            	}*/
		        	}
				
				System.out.println(jobStore.size());
			}
			
			//take job store and search for duplicates
			
			Set<String> set = new HashSet<String>(jobStore);

			System.out.println(set.size());
			System.out.println(jobStore.size());
			
			if (set.size() < jobStore.size()) {
				jobStore.clear();
				jobStore.addAll(set);
			}
			
			for (int i = 0; i < jobStore.size(); i++) {
				System.out.println("www.s1jobs.com" + jobStore.get(i));
			}
			
			//now I need to take this data and search each url
			
			for (int i = 0; i < jobStore.size(); i++) {
				trawl.pullJob(jobStore.get(i));
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
}
