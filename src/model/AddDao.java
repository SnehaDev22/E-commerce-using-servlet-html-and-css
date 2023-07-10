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
    public int save(AddItem a) throws SQLException, ClassNotFoundException
	{
    	Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("Insert into ecom.additem1(name,qty,price) values(?,?,?)");
		ps.setString(1, a.getName());
		ps.setInt(2, a.getQty());
		ps.setDouble(3, a.getPrice());
		
			
		int b=ps.executeUpdate();
		con.close();
		return  b;
	}
    public ArrayList<AddItem> getAllItems() throws SQLException, ClassNotFoundException {
        Connection con = getConnect();
        String sql="SELECT * FROM ecom.additem1";
      Statement st=con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);

        ArrayList<AddItem> i = new ArrayList<>();
        while (rs.next()) {
            

     AddItem ad=new AddItem(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getDouble(4));
           // AddItem item = new AddItem(name, qty, price,total);
       i.add(ad);  
            
             }
            con.close();
        return i;
    }
    
}
