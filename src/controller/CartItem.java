package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddDao;
import model.AddItem;

@WebServlet("/cart1")
public class CartItem extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		AddDao d = new AddDao();
		try {
			ArrayList<AddItem> ad = (ArrayList<AddItem>) d.getAllItems();

			out.print("<!DOCTYPE html>");
			out.print("<html lang='en'>");
			out.print("<head>");
			out.print("    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>");
			out.print("    <meta charset='utf-8'>");
			out.print("    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
			out.print(
					"    <link href='https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap' rel='stylesheet'>");
			out.print(
					"    <link href='https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap' rel='stylesheet'>");
			out.print(
					"    <link href='https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap' rel='stylesheet'>");
			out.print("    <link rel='stylesheet' href='css/open-iconic-bootstrap.min.css'>");
			out.print("    <link rel='stylesheet' href='css/animate.css'>");
			out.print("    <link rel='stylesheet' href='css/owl.carousel.min.css'>");
			out.print("    <link rel='stylesheet' href='css/owl.theme.default.min.css'>");
			out.print("    <link rel='stylesheet' href='css/magnific-popup.css'>");
			out.print("    <link rel='stylesheet' href='css/aos.css'>");
			out.print("    <link rel='stylesheet' href='css/ionicons.min.css'>");
			out.print("    <link rel='stylesheet' href='css/bootstrap-datepicker.css'>");
			out.print("    <link rel='stylesheet' href='css/jquery.timepicker.css'>");
			out.print("    <link rel='stylesheet' href='css/flaticon.css'>");
			out.print("    <link rel='stylesheet' href='css/icomoon.css'>");
			out.print("    <link rel='stylesheet' href='css/style.css'>");
			out.print("</head>");
			out.print("<body>");
			out.print(
					"    <nav class='navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light' id='ftco-navbar'>");
			out.print("        <div class='container'>");
			out.print("            <a class='navbar-brand' href='index.html'>Vegefoods</a>");
			out.print(
					"            <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#ftco-nav' aria-controls='ftco-nav' aria-expanded='false' aria-label='Toggle navigation'>");
			out.print("                <span class='oi oi-menu'></span> Menu");
			out.print("            </button>");
			out.print("            <div class='collapse navbar-collapse' id='ftco-nav'>");
			out.print("                <ul class='navbar-nav ml-auto'>");
			out.print("                    <li class='nav-item'><a href='index.html' class='nav-link'>Home</a></li>");
			out.print("                    <li class='nav-item active dropdown'>");
			out.print(
					"                        <a class='nav-link dropdown-toggle' href='#' id='dropdown04' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Shop</a>");
			out.print("                        <div class='dropdown-menu' aria-labelledby='dropdown04'>");
			out.print("                            <a class='dropdown-item' href='shop.html'>Shop</a>");
			out.print("                            <a class='dropdown-item' href='wishlist.html'>Wishlist</a>");
			out.print(
					"                            <a class='dropdown-item' href='product-single.html'>Single Product</a>");
			out.print("                            <a class='dropdown-item' href='cart.html'>Cart</a>");
			out.print("                            <a class='dropdown-item' href='checkout.html'>Checkout</a>");
			out.print("                        </div>");
			out.print("                    </li>");
			out.print("                    <li class='nav-item'><a href='about.html' class='nav-link'>About</a></li>");
			out.print("                    <li class='nav-item'><a href='blog.html' class='nav-link'>Blog</a></li>");
			out.print(
					"                    <li class='nav-item'><a href='contact.html' class='nav-link'>Contact</a></li>");
			out.print(
					"                    <li class='nav-item cta cta-colored'><a href='cart.html' class='nav-link'><span class='icon-shopping_cart'></span>[0]</a></li>");
			out.print("                </ul>");
			out.print("            </div>");
			out.print("        </div>");
			out.print("    </nav>");
			out.print("    <div  style='background-image: url('images/bg_1.jpg');'>");
			out.print("        <div class='container'>");
			out.print("            <div class='row no-gutters slider-text align-items-center justify-content-center'>");
			out.print("                <div class='col-md-9 ftco-animate text-center'>");
			out.print(
					"                    <p class='breadcrumbs'><span class='mr-2'><a href='index.html'>Home</a></span> <span>Cart</span></p>");
			out.print("                    <h1 class='mb-0 bread'>My Cart</h1>");
			out.print("                </div>");
			out.print("            </div>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("    <style>");
			out.print("        .ftco-cart table {");
			out.print("            width: 40%;");
			out.print("            margin: 0 auto;");
			out.print("            padding: 2px;");
			out.print("        }");
			out.print("        .ftco-cart th, .ftco-cart td {");
			out.print("            padding: 2px 4px;");
			out.print("        }");
			out.print("    </style>");
			out.print("    <section class='ftco-section ftco-cart'>");
			out.print("        <div class='container'>");
			out.print("            <div class='row'>");
			out.print("                <div class='col-md-12 ftco-animate'>");
			out.print("                    <div class='cart-list'>");
			out.print("                        <table class='table table-sm ftco-cart'>");
			out.print("                            <thead class='thead-primary'>");
			out.print("                                <tr class='text-center'>");
			out.print("                                    <th>&nbsp;</th>");
			out.print("                                    <th>Product name</th>");
			out.print("                                    <th>Price</th>");
			out.print("                                    <th>Quantity</th>");
			out.print("                                    <th>Total</th>");
			out.print("                                </tr>");
			out.print("                            </thead>");
			out.print("                            <tbody id='cart-items'>");
			for (AddItem ad1 : ad) {
				out.print("                                <tr class='text-center'>");
				out.print("                                    <td class='product-remove'>");
				out.print(
						"                                        <a href='#' class='delete'><span class='ion-ios-close'></span></a>");
				out.print("                                    </td>");
				out.print("                                    <td class='product-name'>");
				out.print("                                        <h3>" + ad1.getName() + "</h3>");
				out.print("                                    </td>");
				out.print("                                    <td class='price'>$" + ad1.getPrice() + "</td>");
				out.print("                                    <td class='quantity'>");
				out.print("                                        <div class='input-group mb-3'>");
				out.print(
						"                                            <input type='text' class='quantity form-control input-number' value='"
								+ ad1.getQty() + "' min='1' max='1000'>");
				out.print("                                        </div>");
				out.print("                                    </td>");
				out.print("                                    <td class='total'>$" + (ad1.getPrice() * ad1.getQty())
						+ "</td>");
				out.print("                                </tr>");
			}
			out.print("                            </tbody>");
			out.print("                        </table>");
			out.print("                    </div>");
			out.print("                </div>");
			out.print("            </div>");
			out.print("        </div>");
			out.print("    </section>");

			out.print("    <script src='js/jquery.min.js'></script>");
			out.print("    <script src='js/jquery-migrate-3.0.1.min.js'></script>");
			out.print("    <script src='js/popper.min.js'></script>");
			out.print("    <script src='js/bootstrap.min.js'></script>");
			out.print("    <script src='js/jquery.easing.1.3.js'></script>");
			out.print("    <script src='js/jquery.waypoints.min.js'></script>");
			out.print("    <script src='js/jquery.stellar.min.js'></script>");
			out.print("    <script src='js/owl.carousel.min.js'></script>");
			out.print("    <script src='js/jquery.magnific-popup.min.js'></script>");
			out.print("    <script src='js/aos.js'></script>");
			out.print("    <script src='js/jquery.animateNumber.min.js'></script>");
			out.print("    <script src='js/bootstrap-datepicker.js'></script>");
			out.print("    <script src='js/jquery.timepicker.min.js'></script>");
			out.print("    <script src='js/scrollax.min.js'></script>");
			out.print("    <script src='js/main.js'></script>");
			out.print("</body>");
			out.print("</html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
