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
			
			BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
			
			URL my_url = new URL("https://github.com/lillo/dpiot-course/blob/master/ex1/exercises1.org");
			URLConnection my_connection = my_url.openConnection();
			my_connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(my_connection.getInputStream()));
			String input = "";
			
			String regex = "<a href\\s?=\\s?\"([^\"]+)\">";
		    Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(input);
		    
			while ((input = in.readLine()) != null)
				matcher = pattern.matcher(input);
			 	String wholething = matcher.group();
			 	String link = matcher.group(1);
				System.out.println(link);
			in.close();

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
