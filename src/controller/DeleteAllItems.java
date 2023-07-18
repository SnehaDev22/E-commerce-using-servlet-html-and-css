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
			//out.print("deleted all");
			   out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Payment successfull</p>");
			 request.getRequestDispatcher("cardpay").forward(request, response);   
           }
		else{
			//out.print("not deleted all");
			   out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Payment failed</p>");
			request.getRequestDispatcher("cardpay").forward(request, response); 
		}
		
        
    }
}
