package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Emp;
import model.EmpDao;

@WebServlet("/log")
public class LogIn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String upass = request.getParameter("upass");
		
		Emp e = new Emp(email, upass);
		try {
			boolean verified = new EmpDao().verifyUser(e);

			if (verified) {
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
				out.println("<div class='center'>User Verified. Login Successful!</div>");
				out.println("</body>");
				out.println("</html>");
	           
				HttpSession session = request.getSession(true);///
	            session.setAttribute("email", email);///
	            session.setAttribute("upass", upass);///

				RequestDispatcher rd = request.getRequestDispatcher("shop.html");
				rd.include(request, response);

				// Perform further actions after successful login

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
				out.println("<div class='center'>Invalid username or password. Login failed!</div>");
				out.println("</body>");
				out.println("</html>");

				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			} 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
