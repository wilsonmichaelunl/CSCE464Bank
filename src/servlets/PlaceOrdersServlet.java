package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import database.BankDB;
import helpers.MonthYearFormatter;
import models.Bank;

/**
 * Servlet implementation class PlaceOrdersServlet
 */
@WebServlet("/PlaceOrdersServlet")
public class PlaceOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log 
    = Logger.getLogger(PlaceOrdersServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Bank bank = new Bank();
		BankDB dbBank = new BankDB();
		String jsonCart = request.getParameter("jsonCart");
		System.out.println("in place order servlet: " + jsonCart);
		
//		try {
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			Number numOrderTotal = 0;
//		    numOrderTotal = NumberFormat.getInstance().parse(request.getParameter("shoppingCartTotal"));
//			BigDecimal orderTotal = new BigDecimal(numOrderTotal.toString());
//			Bank creditCard = dbBank.getCreditCardByUserId(userId);
//		}catch(Exception e) {
//			out.println("Exception/Error information is written on the log file.");
//			log.error("This is an error message: ", e);	
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
