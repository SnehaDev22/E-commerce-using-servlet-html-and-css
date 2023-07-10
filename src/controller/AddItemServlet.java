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
        int qty=Integer.parseInt(request.getParameter("qty"));
        double price = Double.parseDouble(request.getParameter("price"));
        //double total=price*qty;
       //  total=Double.parseDouble(request.getParameter("total"));
        
       // AddItem a = new AddItem(name, qty, price,total);
        AddItem a = new AddItem(name, qty, price);
        int b = 0;
        try {
            b = new AddDao().save(a);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (b > 0) {
            out.print("<p style=\"color: red; margin-top: 30px;text-align: center;\">Item added successfully</p>");
            RequestDispatcher rd = request.getRequestDispatcher("shop.html");
            rd.include(request, response);
        } else {
            out.print("<p style=\"color: red; margin-top: 30px; text-align: center;\">Failed to add item</p>");
            RequestDispatcher rd = request.getRequestDispatcher("shop.html");
            rd.include(request, response);
        }

        // Generate a response
        
        /* * response.setContentType("text/html");
         * 
         * out.println("<html><body>"); out.println("<h1>Item Added</h1>");
         * out.println("<p>Item Name: " + name + "</p>");
         * out.println("<p>Price: " + price + "</p>");
         * out.println("</body> </html>");*/
         
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        doGet(request, response);
    }
}
