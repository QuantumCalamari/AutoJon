<h3>
	AutoJon
</h3>

<?php

$crawl = "http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&order_by=date_posted";

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
				get_links($link);
			} else {
				$link = $url;
			}
		} else if (substr($link, 0, 7) == "/apply/") {
			$link = "http://www.s1jobs.com".$link;
			scrapeHTML($link);
		} else {
			$link = $url;
		}
		
		//echo $link."<br />";	
	}
}

//create array of stuff



get_links($crawl)
	
?>