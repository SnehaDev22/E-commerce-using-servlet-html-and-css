package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cardpay")
public class Cardpay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        double receivedValue = (double) request.getAttribute("tbill");
//        System.out.println("Received value: " + receivedValue);
//        
        
        
        String email = (String) request.getSession().getAttribute("email");
        System.out.println("cust name: "+email);
        
        
       
       
         //Object bill = null;
		if (email == null) {
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
			out.println("<div class='center'>Please login to complete purchase </div>");
			out.println("</body>");
			out.println("</html>");
             response.sendRedirect("login.html"); // Replace "login.html" with your login page URL
             return;
         }
		/*if (bill == null) {
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
			out.println("<div class='center'>Cart is empty</div>");
			out.println("</body>");
			out.println("</html>");
        	 RequestDispatcher rd = request.getRequestDispatcher("cart1");
             rd.include(request, response); // Replace "cart1 servlet" with your login page URL
            return;
        }*/
        
      //  double bill = (double) request.getAttribute("tbill");
         out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("  <head>");
        out.print("    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>");
        out.print("    <meta charset='utf-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
        out.print("    ");
        out.print("    <link href='https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap' rel='stylesheet'>");
        out.print("    <link href='https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap' rel='stylesheet'>");
        out.print("    <link href='https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap' rel='stylesheet'>");
        out.print("");
        out.print("    <link rel='stylesheet' href='css/open-iconic-bootstrap.min.css'>");
        out.print("    <link rel='stylesheet' href='css/animate.css'>");
        out.print("    ");
        out.print("    <link rel='stylesheet' href='css/owl.carousel.min.css'>");
        out.print("    <link rel='stylesheet' href='css/owl.theme.default.min.css'>");
        out.print("    <link rel='stylesheet' href='css/magnific-popup.css'>");
        out.print("");
        out.print("    <link rel='stylesheet' href='css/aos.css'>");
        out.print("");
        out.print("    <link rel='stylesheet' href='css/ionicons.min.css'>");
        out.print("");
        out.print("    <link rel='stylesheet' href='css/bootstrap-datepicker.css'>");
        out.print("    <link rel='stylesheet' href='css/jquery.timepicker.css'>");
        out.print("");
        out.print("    ");
        out.print("    <link rel='stylesheet' href='css/flaticon.css'>");
        out.print("    <link rel='stylesheet' href='css/icomoon.css'>");
        out.print("    <link rel='stylesheet' href='css/style.css'>");
        out.print("  </head>");
        out.print("   <body class='goto-here'>");
        out.print("		<div class='py-1 bg-primary'>");
        out.print("		<div class='container'>");
        out.print("			<div");
        out.print("				class='row no-gutters d-flex align-items-start align-items-center px-md-0'>");
        out.print("				<div class='col-lg-12 d-block'>");
        out.print("					<div class='row d-flex'>");
        out.print("						");
        out.print("						");
        out.print("						");
        out.print("					<div class='col-md-5 pr-4 d-flex topper align-items-center text-lg-right'>");
        out.print("					<span class='text'>3-5 Business days delivery &amp; Free");
        out.print("								Returns</span>");
        out.print("						</div>");
        out.print("					</div>");
        out.print("				</div>");
        out.print("			</div>");
        out.print("		</div>");
        out.print("	</div>");
        out.print("   <nav");
        out.print("		class='navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light'");
        out.print("		id='ftco-navbar'>");
        out.print("		<div class='container'>");
        out.print("			<a class='navbar-brand' href='index.html'>Vegefoods</a>");
        out.print("			<button class='navbar-toggler' type='button' data-toggle='collapse'");
        out.print("				data-target='#ftco-nav' aria-controls='ftco-nav'");
        out.print("				aria-expanded='false' aria-label='Toggle navigation'>");
        out.print("				<span class='oi oi-menu'></span> Menu");
        out.print("			</button>");
        out.print("");
        out.print("			<div class='collapse navbar-collapse' id='ftco-nav'>");
        out.print("				<ul class='navbar-nav ml-auto'>");
        out.print("					<li class='nav-item active'><a href='index.html'");
        out.print("						class='nav-link'>Home</a></li>");
        out.print("<li class='nav-item'><a href='shop.html' class='nav-link'>Shop</a></li>");

		out.print(
				"                    <li class='nav-item cta cta-colored'><a href='cart1' class='nav-link'><span class='icon-shopping_cart'></span>[0]</a></li>");
        out.print("");
        out.print("");
        out.print("					");
        out.print("                    <li class='nav-item'><a href='logout' class='nav-link'>Logout");
        out.print("							</a></li>");
        out.print("");
        out.print("				</ul>");
        out.print("			</div>");
        out.print("		</div>");
        out.print("	</nav>");
        out.print("    ");
        out.print("    <!-- END nav -->");
        out.print("");
        out.print("   ");
        out.print("");
        out.print("    <style>");
        out.print("      .greeting {");
        out.print("        text-align: center;");
        out.print("        font-size: 18px;");
        out.print("        color: #333;");
        out.print("        margin-top: 20px;");
        out.print("      }");
        out.print("    </style>");
        out.print("  </head>");
        out.print("  <body class='goto-here'>");
        out.print("    <div class='greeting'>"); // Opening div for the greeting message
        out.print("      <h5>Cust email :  " + email + "</h5>"); // Display the greeting message with email
        out.print("    </div>");
        // Moved the <h3> tag here to display the greeting message
        out.print("    <style>");
        out.print("      .center-container {");
        out.print("        display: flex;");
        out.print("        justify-content: center;");
        out.print("        align-items: center;");
        out.print("        height: 80vh;"); // Adjust the height to your preference
        out.print("      }");
        out.print("    </style>");

        out.print("  <div class='center-container'>");
        out.print("    <div class='row block-12'>");
        out.print("      <div class='col-md-20 d-flex'>");

        out.print("        <form action='deleteAllItems' class='bg-white px-5 contact-form' method='post'>");
        out.print("          <h3 style='text-align: center;'>Card Details</h3>");



     //   out.print("<h1>Total Bill: " + bill + "</h1>");
      
        out.print("          <div class='form-group'>");
        out.print("           Card holder Name: <input type='text' class='form-control' name='cname' placeholder='Card holder name'  required>");
        out.print("          </div>");
       
        out.print("          <div class='form-group'>");
        out.print("            Card Number: <input type='number' class='form-control' name='num' placeholder='Card number' maxlength='12' pattern='[0-9]{12}'  required>");
        out.print("          </div>");
        out.print("          <div class='form-group'>");
        out.print("            Expiry Date: <input type='date' class='form-control' name='date' placeholder='Expiry date' required>");
        out.print("          </div>");
        out.print("          <div class='form-group'>");
        out.print("           CVV: <input type='number' class='form-control' name='cvv' placeholder='cvv' maxlength='3' pattern='[0-9]{3}' required>");
        out.print("          </div>");
        out.print("");
     
        out.print("          <div class='form-group'>");
        out.print("            <input type='submit' value='Pay Now' class='btn btn-primary py-15 px-5'>");
        out.print("          </div>");
        out.print("        </form>");
        out.print("      </div>");
        out.print("      <div class='col-md-6'>");
        out.print("        <!-- Right column content -->");
        out.print("      </div>");
        out.print("    </div>");
        out.print("  </div>");
        out.print("");
        out.print("");
        out.print("    ");
        out.print("  ");
        out.print("");
        out.print("  <!-- loader -->");
        out.print("  <div id='ftco-loader' class='show fullscreen'><svg class='circular' width='48px' height='48px'><circle class='path-bg' cx='24' cy='24' r='22' fill='none' stroke-width='4' stroke='#eeeeee'/><circle class='path' cx='24' cy='24' r='22' fill='none' stroke-width='4' stroke-miterlimit='10' stroke='#F96D00'/></svg></div>");
        out.print("");
        out.print("");
        out.print("  <script src='js/jquery.min.js'></script>");
        out.print("  <script src='js/jquery-migrate-3.0.1.min.js'></script>");
        out.print("  <script src='js/popper.min.js'></script>");
        out.print("  <script src='js/bootstrap.min.js'></script>");
        out.print("  <script src='js/jquery.easing.1.3.js'></script>");
        out.print("  <script src='js/jquery.waypoints.min.js'></script>");
        out.print("  <script src='js/jquery.stellar.min.js'></script>");
        out.print("  <script src='js/owl.carousel.min.js'></script>");
        out.print("  <script src='js/jquery.magnific-popup.min.js'></script>");
        out.print("  <script src='js/aos.js'></script>");
        out.print("  <script src='js/jquery.animateNumber.min.js'></script>");
        out.print("  <script src='js/bootstrap-datepicker.js'></script>");
        out.print("  <script src='js/scrollax.min.js'></script>");
        out.print("  <script src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false'></script>");
        out.print("  <script src='js/google-map.js'></script>");
        out.print("  <script src='js/main.js'></script>");
        out.print("    ");
        out.print("  </body>");
        out.print("</html>");

        
        
}

}


