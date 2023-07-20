package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoryDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ecom";
	String uname = "root";
	String pass = "abc123";

	private Connection getConnect1() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, pass);
		return con;
	}


	
	   

	    public int save1(HistoryItem historyItem) throws ClassNotFoundException, SQLException {
	         Connection con = getConnect1();
	             PreparedStatement statement = con.prepareStatement("INSERT INTO ecom.addhist VALUES (?, ?, ?, ?,?)");
               
	            statement.setString(1, historyItem.getCustname());
	            statement.setString(2, historyItem.getName());
	            statement.setInt(3, historyItem.getQty());
	            statement.setDouble(4, historyItem.getPrice());
	            statement.setDouble(5, historyItem.getTotal());

	            return statement.executeUpdate();
	    }
	    
	    public int update(HistoryItem historyItem) throws ClassNotFoundException, SQLException {
	         Connection con = getConnect1();
	             PreparedStatement statement = con.prepareStatement("update ecom.addhist where custname=?");
              
	            statement.setString(1, historyItem.getCustname());
	          
	            return statement.executeUpdate();
	    }
	    
	   
	    
	    
	}


