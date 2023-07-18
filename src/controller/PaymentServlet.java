package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 response.setContentType("text/html");
    	 PrintWriter out = response.getWriter();
    	// Retrieve form data
        String name = request.getParameter("name");
        int qty = Integer.parseInt(request.getParameter("qty"));
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");

        // Perform payment processing logic here

        // Send response
       
       out.println("<h2>Payment Successful</h2>");
       out.println("<p>Vegetable: " + name + "</p>");
       out.println("<p>Quantity: " + qty + "</p>");
       out.println("<p>Card Number: " + cardNumber + "</p>");
    }
}
