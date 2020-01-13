package exercises1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTcpClient {

	public static void main(String[] args) {

		String sentence;
		BufferedReader input_user = new BufferedReader(new InputStreamReader(System.in));
		Socket client_sock;
		try {
			client_sock = new Socket("localhost", 2018);
			DataOutputStream output = new DataOutputStream(client_sock.getOutputStream());
			BufferedReader from_server = new BufferedReader(new InputStreamReader(client_sock.getInputStream()));
			sentence = input_user.readLine();
			output.writeBytes(sentence + "\n");
			String line;
			while ((line = from_server.readLine()) != null) {
				System.out.println("Ricevuto: " + line);
				if (line.equals("Stop"))
			break;
			}
			
			from_server.close(); 
			input_user.close();
			output.close();
			client_sock.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
