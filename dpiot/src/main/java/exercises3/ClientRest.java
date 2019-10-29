package exercises3;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientRest {

	public static final String BASE_URI = "http://jsonplaceholder.typicode.com/";

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target1 = client.target(BASE_URI).path("comments").queryParam("postId", "1");
		WebTarget target2 = client.target(BASE_URI).path("posts").queryParam("postId", "1");
		WebTarget target3 = client.target(BASE_URI).path("posts").queryParam("postId", "1");
		
		Invocation.Builder request1 = target1.request(MediaType.APPLICATION_JSON);
		Invocation.Builder request2 = target2.request(MediaType.APPLICATION_JSON);
		Invocation.Builder request3 = target3.request(MediaType.APPLICATION_JSON);
		Response res1 = request1.get();
		Response res2 = request2.get();
		Response res3 = request3.get();
		System.out.println("Request status " + res1.getStatus());
		System.out.println(res1.readEntity(String.class));
		System.out.println("Request status " + res2.getStatus());
		System.out.println(res2.readEntity(String.class));
		System.out.println("Request status " + res3.getStatus());
		System.out.println(res3.readEntity(String.class));

	}

}
