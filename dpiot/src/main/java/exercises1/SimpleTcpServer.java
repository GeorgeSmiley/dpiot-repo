package exercises1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTcpServer {

	public static void main(String[] args) {
		
		try {
			
			String client_input;
			ServerSocket server_sock = new ServerSocket(2018);
			
			while (true) {
				Socket connection_sock = server_sock.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection_sock.getInputStream()));
				DataOutputStream output = new DataOutputStream(connection_sock.getOutputStream());
				  
				client_input = new String(in.readLine());
				System.out.println("Received: " + client_input);
				
				output.writeBytes("something\n");
			}   
								   
				   //output.writeBytes();
				  		 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
