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
        String priceParam = request.getParameter("price");

        if (qtyParam.isEmpty() || priceParam.isEmpty()) {
           
        	out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Invalid quantity or price</p>");
            RequestDispatcher rd = request.getRequestDispatcher("shop.html");
            rd.include(request, response);
            return; 
            
            
        }

        int qty;
        double price;

        try {
            qty = Integer.parseInt(qtyParam);
            price = Double.parseDouble(priceParam);
        } catch (NumberFormatException e) {
            out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Invalid quantity or price format</p>");
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
			out.println("    top: 20%;");
			out.println("    left: 50%;");
			out.println("    transform: translate(-50%, -50%);");
			out.println("font-weight: bold; font-size: 18px;}");
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
			out.println("    top: 20%;");
			out.println("    left: 50%;");
			out.println("    transform: translate(-50%, -50%);");
			out.println("font-weight: bold; font-size: 18px;}");
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
