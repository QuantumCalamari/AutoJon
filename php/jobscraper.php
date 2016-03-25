<h3>
	AutoJon
</h3>

<?php

$crawl = array("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20java&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20web%20developer&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior+developer&salary_lo=25000&salary_hi=55000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=4473909", "http://www.s1jobs.com/jobs/find?keywords_required=physics&salary_lo=15000&salary_hi=65000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=7235990");

$saved = array();

function scrapeHTML($url) {

	$ch = curl_init();
	$timeout = 5;
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
	$html = curl_exec($ch);
	curl_close($ch);
	
	if (strpos($html,"covering_letter_modal")) {
		echo "cover letter found<br />";
		if(isset($_POST['covering_letter_modal'])) {
			echo $_POST['covering_letter_modal'];
		} else {
			echo "nothing";
		}
	}
	
	get_links($url);
	
}

function coverletter($url) {

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
		
		return  $jobs;
		//echo $link."<br />";	
	}
}

//create array of stuff
foreach($crawl as $url) {
	//echo $url;
	$saved = array_merge($saved, get_links($url));
}

foreach($saved as $print) {
	echo $print;
}

?>