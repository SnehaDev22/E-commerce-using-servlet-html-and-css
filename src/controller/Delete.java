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


@WebServlet("/delete1")
public class Delete extends HttpServlet {
	
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        int id = Integer.parseInt(request.getParameter("id"));

		        int b = 0;
		        try {
		            b = new AddDao().delete(id);
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }

		        if (b > 0) {
		            out.print("<p style=\"color: red; margin-top: 30px;text-align: center;font-weight: bold; font-size: 18px;\">Item deleted successfully</p>");
		            RequestDispatcher rd = request.getRequestDispatcher("cart1");
		            rd.include(request, response);
		        } else {
		            out.print("<p style=\"color: red; margin-top: 30px; text-align: center;font-weight: bold; font-size: 18px;\">Failed to delete item</p>");
		            RequestDispatcher rd = request.getRequestDispatcher("cart1");
		            rd.include(request, response); 
		        }
	        	
	          }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
