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
import model.HistoryDao;
import model.HistoryItem;

@WebServlet("/add")
public class SellHistory extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String qtyParam = request.getParameter("qty");
        String priceParam = request.getParameter("price");
        String custname = request.getParameter("custname"); // Added line

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
            return;
        }

        HistoryItem a = new HistoryItem(custname,name, qty, price);

        int b = 0;
        try {
            HistoryItem historyItem = null;
			b = new HistoryDao().save1(historyItem);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (b > 0) {
            saveToHistory(a, custname); // Save the item to history with customer name
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
            out.println("    font-weight: bold; font-size: 18px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='center'>Item added Successful!</div>");
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
            out.println("    font-weight: bold; font-size: 18px;}");
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

    private void saveToHistory(HistoryItem item, String customerName) {
        HistoryItem historyItem = new HistoryItem (item.getCustname(),item.getName(),item.getQty(),item.getPrice(),item.getTotal());
        
        try {
            new HistoryDao().save1(historyItem);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
