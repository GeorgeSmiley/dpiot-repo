package exercises1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Get_url {

	public static void main(String[] args) {
		
		try {
			
			URL my_url = new URL(args[0]);
			URLConnection my_connection = my_url.openConnection();
			my_connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(my_connection.getInputStream()));
			
			String input;
			String url = null;
			Matcher m = null;
			Pattern p = Pattern.compile("href=\"https(.*?)\"");
			
			while((input = in.readLine()) != null) {
				m = p.matcher(input);
				if (m.find()) {
					url = m.group(1);
					System.out.println("https" + url);
				}
			}	
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
