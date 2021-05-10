package comm.flights;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Item
{
	public String source;
	public String destination;
	public int time;
}

class Flight
{
	public String source;
	public String destination;
	public int time;
	public int price;
	public int legs;

	public Flight(String source, String destination, int price, int time, int legs)
	{
		this.source = source;
		this.destination = destination;
		this.price = price;

		this.time = time;
		this.legs = legs;
	}
}

/**
 * Servlet implementation class showFlightInfo
 */
@WebServlet("/showFlightInfo")
public class showFlightInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showFlightInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Item item = new Item();
		item.source = request.getParameter("source");
		item.destination = request.getParameter("destination");
		item.time = Integer.parseInt(request.getParameter("time"));

		System.out.println(item.source);
		ArrayList<Flight> flights = new ArrayList<>();
		flights.add(new Flight("Kolkata", "Mumbai", 4500, 3, 1));
		flights.add(new Flight("Kolkata", "Mumbai", 4000, 6, 2));
		flights.add(new Flight("Kolkata", "Mumbai", 4900, 19, 1));
		flights.add(new Flight("New Delhi", "Mumbai", 5100, 12, 2));
		flights.add(new Flight("New Delhi", "Mumbai", 5500, 14, 1));
		flights.add(new Flight("New Delhi", "Mumbai", 7500, 21, 1));
		flights.add(new Flight("Kolkata", "New Delhi", 3500, 11, 1));
		flights.add(new Flight("Kolkata", "New Delhi", 6500, 16, 1));
		flights.add(new Flight("Kolkata", "New Delhi", 7500, 20, 2));
		flights.add(new Flight("Mumbai", "New Delhi", 3500, 1, 2));
		flights.add(new Flight("Mumbai", "New Delhi", 6600, 8, 2));
		flights.add(new Flight("Mumbai", "New Delhi", 7100, 22, 1));

		ArrayList<Flight> result = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.source.equals(item.source) && flight.destination.equals(item.destination)
					&& flight.time >= item.time)
				result.add(flight);
		}

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson2 = gsonBuilder.create();
		String json = gson2.toJson(result);
		out.print(json);

	}

}
