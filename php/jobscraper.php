<?php

$crawl = "http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&order_by=date_posted";
//$crawl = "http://bestspace.co";

function get_links($url) {
	$input = @file_get_contents($url);
	$regex = "<a\s[*>]*href=(\"??)([^\" >]*?)\\1[^>]*>(.*)<\/a>";
	$regex = "<a\s[*>]*href=(\"??)([^\" >]*?)\\1[^>]*>(.*)<\/a>";
	preg_match_all("/$regex/siU", $input, $matches);
	
	$l = $matches[2];
	
	foreach($l as $link) {
		

		
		if(strpos($link, "#")) {
			$link = substr($link, 0, strpos($link, "#"));
		}	
		
		if(substr($link, 0, 1) == ".") {
			$link = substr($link, 1);
		}
		/*
		if(substr($link,0,7) == "http://") {
			$link = $link;
		} else if(substr($link,0,8) == "https://") {
			$link = $link;
		} else if(substr($link,0,2) == "//") {
			$link = substr($link, 2);
		}  else if(substr($link,0,1) == "#") {
			$link = $url;
		}  else if(substr($link,0,7) == "mailto:") {
			$link = "[".$link."]";
		} else if (substr($link,0,5) == "/job/") {
			$link = "http://www.s1jobs.com".$link;
		}*/
		
		if (substr($link,0,5) == "/job/") {
			if (strpos($link, "telecommunications")) {
				$link = "http://www.s1jobs.com".$link;
			} else {
				$link = $url;
			}
		} else {
			$link = $url;
		}
		
				echo $link."<br />";	
	}
}

//create array of stuff



get_links($crawl)
	
?>