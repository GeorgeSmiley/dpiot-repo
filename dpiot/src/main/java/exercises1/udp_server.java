package exercises1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class udp_server {

	public static void main(String[] args) {
		
		try {
			
			DatagramSocket sock = new DatagramSocket(9999);
			byte buffer_req[] = new byte[1024];
			byte buffer_res[] = new byte[1024]; 
			
			System.out.println("Waiting fo connections");
			
			while(true) {
				DatagramPacket request = new DatagramPacket(buffer_req, buffer_req.length);
				sock.receive(request);
				String sentence = new String(request.getData());
				System.out.println("Received Time ID: " + sentence);
				
				Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(sentence),Locale.ITALY);
				Date today = calendar.getTime();
				buffer_res = today.toString().getBytes();
				
				DatagramPacket response  = new DatagramPacket(buffer_res, buffer_res.length, request.getAddress(), request.getPort());
				sock.send(response);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
