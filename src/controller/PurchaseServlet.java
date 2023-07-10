package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the item details from the request parameters
        String itemId = request.getParameter("item_id");
        String itemName = request.getParameter("item_name");
        double itemPrice = Double.parseDouble(request.getParameter("item_price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Calculate the total price
        double totalPrice = itemPrice * quantity;

        // Perform the purchase logic here (e.g., update the database, send confirmation email, etc.)

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the purchase details
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Purchase Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Purchase Confirmation</h1>");
        out.println("<p>Thank you for your purchase!</p>");
        out.println("<p>Item ID: " + itemId + "</p>");
        out.println("<p>Item Name: " + itemName + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<p>Total Price: $" + totalPrice + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
