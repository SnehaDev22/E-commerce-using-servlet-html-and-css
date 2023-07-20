package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Emp;
import model.EmpDao;

@WebServlet("/reg")
public class RegServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String upass = request.getParameter("upass");
		String upass1 = request.getParameter("upass1");

		Emp e = new Emp(uname, email, upass, upass1);

		try {
			if (upass.equals(upass1)) {
				
				int a = new EmpDao().save(e);
                
				if (a > 0) {
//					 
					 HttpSession session = request.getSession(true);
					 session.setAttribute("email", email);
					
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
					out.println("<div class='center'>Successfully Registered..!</div>");
					out.println("</body>");
					out.println("</html>");

					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				} else {
					out.print("data not inserted of password! ");
					RequestDispatcher rd = request.getRequestDispatcher("signup.html");
					rd.include(request, response);
				}
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
				out.println("<div class='center'> Not Registered..</div>");
				out.println("</body>");
				out.println("</html>");

				RequestDispatcher rd = request.getRequestDispatcher("signup.html");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}