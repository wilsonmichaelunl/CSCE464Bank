package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BankDB;
import helpers.MonthYearFormatter;
import models.Bank;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MonthYearFormatter format = new MonthYearFormatter();
		Bank bank = new Bank();
		BankDB dbBank = new BankDB();
		int validBank = 0;
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String lastName = request.getParameter("lastName").trim();
		String firstName = request.getParameter("firstName").trim();
		String cardType = request.getParameter("cardType").trim();
		String cardNumber = request.getParameter("cardNumber".trim());
		String cvv = request.getParameter("securityNumber").trim();
		String expirationMonth = format.formatMonth(request.getParameter("expirationDateMonth").trim());
		String expirationYear = format.formatYear(request.getParameter("expirationDateYear").trim());
		String expirationDate = format.formatExpirationDate(expirationMonth, expirationYear);
		String billingAddress = request.getParameter("billingAddress").trim();
		String shippingAddress = request.getParameter("shippingAddress").trim();
		Number numOrderTotal = 0;
		try {
			numOrderTotal = NumberFormat.getInstance().parse(request.getParameter("shoppingCartTotal"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal orderTotal = new BigDecimal(numOrderTotal.toString());
		
		Bank creditCard = dbBank.getCreditCardByUserId(userId);
		int validDetails = bank.validateDetails(creditCard, lastName, firstName, cardType, cardNumber, cvv, expirationDate);
		
		if(validDetails == 1) {
			int validBalance = bank.validateBalance(creditCard, orderTotal);
			
			if(validBalance == 1) {
				validBank = 1;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println(validBank);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
