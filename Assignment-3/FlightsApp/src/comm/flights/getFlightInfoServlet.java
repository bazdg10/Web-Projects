package comm.flights;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class Offer
{

	private String source, destination;
	private int reduced_cost, time;

	public Offer(String source, String destination, int reduced_cost, int time)
	{
		this.source = source;
		this.destination = destination;
		this.reduced_cost = reduced_cost;
		this.time = time;
	}
}

class OfferList
{

	ArrayList<Offer> arrayList;

	public OfferList()
	{
		arrayList = new ArrayList<>();
	}

	public void addOffer(String source, String destination, int reduced_cost, int time)
	{
		Offer offer = new Offer(source, destination, reduced_cost, time);
		arrayList.add(offer);
	}
	public ArrayList<Offer> getOfferList() {
		return arrayList;
	}

}

/**
 * Servlet implementation class getFlightInfoServlet
 */
@WebServlet("/getFlightInfo")
public class getFlightInfoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFlightInfoServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		OfferList offerList = new OfferList();
		offerList.addOffer("Kolkata", "Bangalore", 1999, 2);
		offerList.addOffer("New Delhi", "Mumbai", 2499, 5);
		offerList.addOffer("Singapore", "New Delhi", 3999, 8);
		ArrayList<Offer> offers = offerList.getOfferList(); 
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		PrintWriter out = response.getWriter();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String json = gson.toJson(offers);
		out.print(json);

	}

}
