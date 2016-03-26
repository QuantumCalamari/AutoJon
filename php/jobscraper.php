<h3>
	AutoJon
</h3>

<?php

//$crawl = array("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20java&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20web%20developer&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior+developer&salary_lo=25000&salary_hi=55000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=4473909", "http://www.s1jobs.com/jobs/find?keywords_required=physics&salary_lo=15000&salary_hi=65000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=7235990");

$crawl = array("http://www.s1jobs.com/jobs/find?keywords_required=physics&salary_lo=25000&salary_hi=55000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=7210653");

$search = array();

function hitbutton($url) {
	$ch = curl_init();
	$timeout = 5;
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
	$html = curl_exec($ch);
	curl_close($ch);
	
	echo "No Niall Bree";
	
	include("LIB_http.php");
	$action = "http://www.s1jobs.com/apply/apply-submit.cgi";
	$method= "POST";
	$ref = "" ;
	$response = http($target=$action, $ref, $method, $data_array="", EXCL_HEAD);
	
}


function scrapeHTML($url) {

	$ch = curl_init();
	$timeout = 5;
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
	$html = curl_exec($ch);
	curl_close($ch);
	
	$searchTerms = array();
	
	
	$regex = '#\<div id="job-header-title"\>(.+?)\<\/div\>#s';
	preg_match($regex, $html, $matches);
	$match = $matches[0];
	echo $match;
	
	if (strpos($html, "Niall Bree")) {
		echo "Niall Bree <br />";
	} else {	
		if ((strpos($match,"Senior")) || (strpos($match,"Teacher")) || (strpos($match,"Lead"))) {
			//	echo "found a bad term";
		} else {
			//go to apply page and hit the apply button
			apply($url);
			//echo "no bad terms found and no Niall Bree <br />";
		}
	}
	
	get_links($url);
	
}

function apply($url) {
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
		
		if (substr($link,0,7) == "/apply/") {
				$link = "http://www.s1jobs.com".$link;
				echo "What we're looking for '".$link."<br />";
			if (strpos($link, "jump")) {
				echo "I don't know what to do with that <br />";
			}	else {			
				hitbutton($link);	
			}
		} else {
			$link = $url;
		}
	}
}

function get_links($url) {
	$input = @file_get_contents($url);
	$regex = "<a\s[*>]*href=(\"??)([^\" >]*?)\\1[^>]*>(.*)<\/a>";
	$regex = "<a\s[*>]*href=(\"??)([^\" >]*?)\\1[^>]*>(.*)<\/a>";
	preg_match_all("/$regex/siU", $input, $matches);
	
	$l = $matches[2];
	$jobs = array();
	
	foreach($l as $link) {
		

		
		if(strpos($link, "#")) {
			$link = substr($link, 0, strpos($link, "#"));
		}	
		
		if(substr($link, 0, 1) == ".") {
			$link = substr($link, 1);
		}
		
		if (substr($link,0,5) == "/job/") {
			if (strpos($link, "telecommunications")) {
				$link = "http://www.s1jobs.com".$link;
				array_push($jobs, $link);
			} else {
				$link = $url;
			}
		} else {
			$link = $url;
		}
		
		
		//echo $link."<br />";	
	}
	return  $jobs;
}

//create array of stuff
foreach($crawl as $url) {
	$search = array_merge($search, get_links($url));
}

foreach($search as $p) {
		echo $p."<br />";
	}

echo "<br /> No duplicates <br />"; 
	
$search = array_unique($search);

foreach($search as $p) {
		scrapeHTML($p);
	echo $p."<br />";
	}

//go through each 


?>