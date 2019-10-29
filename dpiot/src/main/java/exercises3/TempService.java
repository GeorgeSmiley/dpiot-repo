package exercises3;

import java.util.Random;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


public class TempService {

	@Path("/temperature")
	public class TempSensor {

		private static final String KELVIN = "Kelvin";
		private static final String FAHRENHEIT = "Fahrenheit";
		private static final String CELSIUS = "Celsius";
		private Random rand = new Random();

		// ...
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String getIt(@DefaultValue(KELVIN) @QueryParam("kind") String kind) {
			double temp = currentTemp(rand);
			switch (kind) {
			case CELSIUS:
				temp = toCelsius(temp);
				break;
			case FAHRENHEIT:
				temp = toFahrenheit(temp);
				break;
			}
			return String.valueOf(temp);
		}
	}
	
	private double toFahrenheit(double temp) {
		temp = (temp - 273.15)* 9/5 + 32;
		return temp;
	}

	private double toCelsius(double temp) {
		temp = (temp - 273.15);
		return 0;
	}

	public double currentTemp(Random rand) {
		return rand.nextDouble();	
	}

}

