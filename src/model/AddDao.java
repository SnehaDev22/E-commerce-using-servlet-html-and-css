package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ecom";
	String uname = "root";
	String pass = "abc123";

	private Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, pass);
		return con;
	}

	
	public int save(AddItem a) throws SQLException, ClassNotFoundException {
	    String sql = "INSERT INTO ecom.additem11 (name, qty, price) VALUES (?, ?, ?)";
	    Connection con = getConnect();
	    PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    statement.setString(1, a.getName());
	    statement.setInt(2, a.getQty());
	    statement.setDouble(3, a.getPrice());

	    int rowsInserted = statement.executeUpdate();

	    if (rowsInserted > 0) {
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            a.setId(generatedKeys.getInt(1));
	        }
	    }

	    return a.getId();
	}

	public ArrayList<AddItem> getAllItems() throws SQLException, ClassNotFoundException {
		Connection con = getConnect();
		String sql = "SELECT * FROM ecom.additem11";
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<AddItem> i = new ArrayList<>();
		while (rs.next()) {

		//	AddItem ad = new AddItem(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4));
			// AddItem item = new AddItem(name, qty, price,total);
			AddItem ad = new AddItem(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5));

			i.add(ad);

		}
		con.close();
		return i;
	}

	
        public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("delete from ecom.additem11 where id=?");
		
	    ps.setInt(1, id);
	    
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
        
        
        public int deleteAllItems() throws ClassNotFoundException, SQLException {
            // Establish a database connection
        	Connection con=getConnect();
        	PreparedStatement ps=con.prepareStatement("delete from ecom.additem11 ");
        	int d=ps.executeUpdate();
    		con.close();
    		return  d; }

	
	}


