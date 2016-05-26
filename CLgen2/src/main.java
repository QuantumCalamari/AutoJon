import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;

		try {

			//this is to temporarily hold the listing
			String CurrentLine;
			//this stores the listing
			ArrayList<String> listings = new ArrayList<String>();
			//this is our file
			br = new BufferedReader(new FileReader("C:\\Users\\Jon\\Documents\\shitlist.txt"));
			
			while ((CurrentLine = br.readLine()) != null) {
				listings.add(CurrentLine);
			}
			
			for (int i = 0; i < listings.size(); i++) {
				//System.out.println("listing: " + listings.get(i));
				htmlScraper.parseData(listings.get(i));
			}
			// just in case any exceptions arise, which some times will happen
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}		
	}
}
