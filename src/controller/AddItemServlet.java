package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AddDao;
import model.AddItem;
import model.EmpDao;

@WebServlet("/additem")
public class AddItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    String name = request.getParameter("name");
	    String qtyParam = request.getParameter("qty");

	    if (qtyParam.isEmpty()) {
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<style>");
	        out.println(".center {");
	        out.println("    text-align: center;");
	        out.println("    color: red;");
	        out.println("    position: absolute;");
	        out.println("    top: 9%;");
	        out.println("    left: 50%;");
	        out.println("    transform: translate(-50%, -50%);");
	        out.println("    font-weight: bold; font-size: 18px;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='center'>Invalid action</div>");
	        out.println("</body>");
	        out.println("</html>");
	        RequestDispatcher rd = request.getRequestDispatcher("shop.html");
	        rd.include(request, response);
	        return;
	    }

	    int qty;
	    double price;

	    try {
	        qty = Integer.parseInt(qtyParam);

	        // Set the predefined price based on the selected item name
	        switch (name.toLowerCase()) {
	            case "bell pepper":
	                price = 45.00;
	                break;
	            case "strawberry":
	                price = 80.00;
	                break;
	            case "green beans":
	                price = 25.00;
	                break;
	            case "purple cabbage":
	                price = 99.00;
	                break;
	            case "tomatoe":
	                price = 80.00;
	                break;
	            case "brocolli":
	                price = 60.00;
	                break;
	            case "carrot":
	                price = 35.00;
	                break;
	            case "fruit Juice":
	                price = 15.00;
	                break;
	            case "onion":
	                price = 40.00;
	                break;
	            case "apple":
	                price = 90.00;
	                break;
	            case "garlic":
	                price = 20.00;
	                break;
	            case "chilli":
	                price = 20.00;
	                break;
	                
	            default:
	                price = 0.00; // Default price if the item name is not recognized
	        }
	    } catch (NumberFormatException e) {
	    	 out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        out.println(".center {");
		        out.println("    text-align: center;");
		        out.println("    color: red;");
		        out.println("    position: absolute;");
		        out.println("    top: 9%;");
		        out.println("    left: 50%;");
		        out.println("    transform: translate(-50%, -50%);");
		        out.println("    font-weight: bold; font-size: 18px;");
		        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='center'>Invalid price or quantity</div>");
	        out.println("</body>");
	        out.println("</html>");
	        RequestDispatcher rd = request.getRequestDispatcher("shop.html");
	        rd.include(request, response);
	        return; // Exit the method to prevent further execution
	    }
	    
	   
	    

	    AddItem a = new AddItem(name, qty, price);
	    int b = 0;
	    try {
	        b = new AddDao().save(a);
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    if (b > 0) {
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<style>");
	        out.println(".center {");
	        out.println("    text-align: center;");
	        out.println("    color: red;");
	        out.println("    position: absolute;");
	        out.println("    top: 9%;");
	        out.println("    left: 50%;");
	        out.println("    transform: translate(-50%, -50%);");
	        out.println("    font-weight: bold; font-size: 18px;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='center'>Item added Successfully...!</div>");
	        out.println("</body>");
	        out.println("</html>");
	        RequestDispatcher rd = request.getRequestDispatcher("shop.html");
	        rd.include(request, response);
	    } else {
	    	 out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        out.println(".center {");
		        out.println("    text-align: center;");
		        out.println("    color: red;");
		        out.println("    position: absolute;");
		        out.println("    top: 9%;");
		        out.println("    left: 50%;");
		        out.println("    transform: translate(-50%, -50%);");
		        out.println("    font-weight: bold; font-size: 18px;");
		        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='center'>Failed to add the item..</div>");
	        out.println("</body>");
	        out.println("</html>");
	        RequestDispatcher rd = request.getRequestDispatcher("shop.html");
	        rd.include(request, response);
	    }
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
