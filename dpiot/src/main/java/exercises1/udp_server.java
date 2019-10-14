package exercises1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udp_server {

	public static void main(String[] args) {
		
		try {
			
			DatagramSocket sock = new DatagramSocket(9999);
			int buffer_size = 1024;
			byte buffer_req[] = new byte[buffer_size];
			byte buffer_res[] = new byte[buffer_size]; 
			
			DatagramPacket request = new DatagramPacket(buffer_req, buffer_size);
			sock.receive(request);
			DatagramPacket response  = new DatagramPacket(buffer_res, buffer_size, request.getAddress(), request.getPort());
			sock.send(response);
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
