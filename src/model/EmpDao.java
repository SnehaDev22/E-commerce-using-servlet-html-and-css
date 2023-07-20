package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmpDao {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/ecom";
	String uname="root";
	String pass="abc123";
	
	private Connection getConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con=	 DriverManager.getConnection(url,uname,pass);
		return con;
	}
    public int save(Emp e) throws SQLException, ClassNotFoundException
	{
    	Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("Insert into ecom.fruit11 values(?,?,?,?)");
		ps.setString(1, e.getUname());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getUpass());
		ps.setString(4, e.getUpass1());
			
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
    
    
    public boolean verifyUser(Emp e) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,pass);

        String query = "SELECT * FROM ecom.fruit11 WHERE email = ? AND upass = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, e.getEmail());
        stmt.setString(2, e.getUpass());

        ResultSet rs = stmt.executeQuery();
        boolean verified = rs.next(); // Check if the result set has a row
		return verified;
    }

	

    }
	