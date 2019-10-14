package exercises1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Udp_client {

	public static void main(String[] args) {
		
		try {	
			
			BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
			
			DatagramSocket sock = new DatagramSocket();
			
			InetAddress host = InetAddress.getLocalHost();
			byte buffer_req[] = new byte[1024];
			byte buffer_res[] = new byte[1024];
			
			System.out.println("Insert time zone ID\n");
			String sentence = user_input.readLine();
			
			buffer_req = sentence.getBytes();

			DatagramPacket request = new DatagramPacket(buffer_req, buffer_req.length, host, 9999);
			DatagramPacket response = new DatagramPacket(buffer_res, buffer_res.length);
			sock.send(request);
			sock.receive(response);
			
			String res = new String(response.getData());
			System.out.println("Current time: " + res);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
