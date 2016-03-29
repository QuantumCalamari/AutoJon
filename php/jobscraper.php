<h3>
	AutoJon
</h3>

<?php

define("COOKIE_FILE", $cookie_file_location);

define("EXCL_HEAD", FALSE);
define("INCL_HEAD", TRUE);

$crawl = array("http://www.s1jobs.com/jobs/find?keywords_required=c%2B%2B&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20java&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior%20web%20developer&onlyshowme=datesmart&order_by=date_posted", "http://www.s1jobs.com/jobs/find?keywords_required=junior+developer&salary_lo=25000&salary_hi=55000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=4473909", "http://www.s1jobs.com/jobs/find?keywords_required=physics&salary_lo=15000&salary_hi=65000&non_default_salary=0&facet_search=1&order_by=date_posted&cb=7235990");
//$crawl = array("http://www.s1jobs.com/jobs/find?keywords_required=physics&onlyshowme=datesmart");
$search = array();

function http($target, $ref, $method, $data_array, $incl_head)
	{
    # XXX TODO: Run and test for 406 responses on otherwise acceptable
    #           downloads, as a result of the Accepts: header. This may
    #           well have a neglible effect: I understand many servers
    #           ignore it.
    # XXX TODO: Run and test for 206 and 416 responses from Range: header.
    # XXX TODO: Setup callback on HEAD to cancel download if given a
    #           content-type we can't handle 
    # Initialize PHP/CURL handle
	$ch = curl_init();
    # Process data, if presented
    if(is_array($data_array))
        {
	    # Convert data array into a query string (ie animal=dog&sport=baseball)
        foreach ($data_array as $key => $value) 
            {
            if(strlen(trim($value))>0)
                $temp_string[] = $key . "=" . urlencode($value);
            else
                $temp_string[] = $key;
            }
        $query_string = join('&', $temp_string);
        }
        
    # HEAD method configuration
    if($method == "HEAD")
        {
	    curl_setopt($ch, CURLOPT_HEADER, TRUE);                // No http head
	    curl_setopt($ch, CURLOPT_NOBODY, TRUE);                // Return body
        }
    else
        {
        # GET method configuration
        if($method == "GET")
            {
            if(isset($query_string))
                $target = $target . "?" . $query_string;
            curl_setopt ($ch, CURLOPT_HTTPGET, TRUE); 
            curl_setopt ($ch, CURLOPT_POST, FALSE); 
            }
        # POST method configuration
        if($method == "POST")
            {
            if(isset($query_string))
                curl_setopt ($ch, CURLOPT_POSTFIELDS, $query_string);
            curl_setopt ($ch, CURLOPT_POST, TRUE); 
            curl_setopt ($ch, CURLOPT_HTTPGET, FALSE); 
            }
            curl_setopt($ch, CURLOPT_HEADER, $incl_head);   // Include head as needed
	    curl_setopt($ch, CURLOPT_NOBODY, FALSE);        // Return body
        }
        
	curl_setopt($ch, CURLOPT_COOKIEJAR, COOKIE_FILE);   // Cookie management.
	curl_setopt($ch, CURLOPT_COOKIEFILE, COOKIE_FILE);
	curl_setopt($ch, CURLOPT_TIMEOUT, CURL_TIMEOUT);    // Timeout
	curl_setopt($ch, CURLOPT_USERAGENT, WEBBOT_NAME);   // Webbot name
	curl_setopt($ch, CURLOPT_URL, $target);             // Target site
	curl_setopt($ch, CURLOPT_REFERER, $ref);            // Referer value
	curl_setopt($ch, CURLOPT_VERBOSE, FALSE);           // Minimize logs
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);    // No certificate
	curl_setopt($ch, CURLOPT_FOLLOWLOCATION, TRUE);     // Follow redirects
	curl_setopt($ch, CURLOPT_MAXREDIRS, 4);             // Limit redirections to four
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);     // Return in string
	curl_setopt($ch, CURLOPT_HEADERFUNCTION, 'read_header'); // Callback function
	curl_setopt($ch, CURLOPT_HTTPHEADER,array('accept: text/*')); // Ask for text only
	
	global $fetchrangeonly,$maxfetchsize;
	if ($fetchrangeonly === true)
	    curl_setopt($ch, CURLOPT_RANGE, "0-".strval($maxfetchsize-1)); // Size limit
    # Create return array
    $return_array['FILE']   = curl_exec($ch); 
    $return_array['STATUS'] = curl_getinfo($ch);
    $return_array['ERROR']  = curl_error($ch);
    
    # Close PHP/CURL handle
  	curl_close($ch);
    
    # Return results
  	return $return_array;
    }

function hitbutton($url) {
	$ch = curl_init();
	$timeout = 5;
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
	$html = curl_exec($ch);
	curl_close($ch);
	
	echo "No Niall Bree";
	
	
	
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