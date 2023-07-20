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
		        	out.println("<html>");
					out.println("<head>");
					out.println("<style>");
					out.println(".center {");
					out.println("    text-align: center;");
					out.println("    color: red;");
					out.println("    position: absolute;");
					out.println("    top: 10%;");
					out.println("    left: 50%;");
					out.println("    transform: translate(-50%, -50%);");
					out.println("font-weight: bold; font-size: 18px;}");
					out.println("</style>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div class='center'>Item deleted Successfully..!</div>");
					out.println("</body>");
					out.println("</html>");		            RequestDispatcher rd = request.getRequestDispatcher("cart1");
		            rd.include(request, response);
		        } else {
		        	out.println("<html>");
					out.println("<head>");
					out.println("<style>");
					out.println(".center {");
					out.println("    text-align: center;");
					out.println("    color: red;");
					out.println("    position: absolute;");
					out.println("    top: 10%;");
					out.println("    left: 50%;");
					out.println("    transform: translate(-50%, -50%);");
					out.println("font-weight: bold; font-size: 18px;}");
					out.println("</style>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div class='center'>Item deleted!</div>");
					out.println("</body>");
					out.println("</html>");		            RequestDispatcher rd = request.getRequestDispatcher("cart1");
		            rd.include(request, response); 
		        }
	        	
	          }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
