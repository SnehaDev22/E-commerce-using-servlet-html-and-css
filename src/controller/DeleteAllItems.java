package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddDao;
import model.AddItem;

@WebServlet("/deleteAllItems")
public class DeleteAllItems extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //AddDao d = new AddDao();
    	PrintWriter out = response.getWriter();
          
			int c = 0;
			try {
				c = new AddDao().deleteAllItems();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
          
		if(c>0){
			//out.print("deleted all");out.println("<html>");
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
			out.println("<div class='center'>Payment successfull...!</div>");
			out.println("</body>");
			out.println("</html>");
			 request.getRequestDispatcher("cardpay").include(request, response);   
           }
		else{
			
			//out.print("not deleted all");
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
			out.println("<div class='center'>Payment failed...!</div>");
			out.println("</body>");
			out.println("</html>");
			request.getRequestDispatcher("cardpay").include(request, response); 
		}
		
        
    }
}
