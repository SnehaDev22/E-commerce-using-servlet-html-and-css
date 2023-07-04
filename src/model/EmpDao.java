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
	String driver="com.mysql.jdbc.Driver";
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

	/*public List<Emp> getAllData() throws ClassNotFoundException, SQLException {

		String sql="SELECT * FROM eco.fruit11";
		Connection con=getConnect();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Emp> le=new ArrayList<Emp>();
		
		
		while(rs.next())
		{
			Emp e=new Emp(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
			
			le.add(e);
		}
		
		
		return le;
	}
	
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("delete from eco.fruit11 where uname=?");
		ps.setString(1, uname);
	
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
	public Emp getOneEmp(int id) throws ClassNotFoundException, SQLException {


		String sql="SELECT * FROM eco.fruit11 where uname=?";
		Connection con=getConnect();
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		Emp e=null;
		while(rs.next())
		{
			e=new Emp(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
		}
		return e;
	    }
//	     if(rs.absolute(1))
//	       e=new Emp(rs.getInt(1),rs.getString(2), rs.getString(3));
//	
//		return e;
//	}
	public int update(Emp e) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("update eco.fruit11 set uname=? where email=?");
		
		ps.setString(1, e.getUname());
		ps.setString(2, e.getEmail());
			
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}*/
	
	/*public List<Emp> getAllCityData(String address) throws ClassNotFoundException, SQLException {

		String sql="SELECT * FROM emp22 where address=?";
		Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement(sql);
    	ps.setString(1, address);
		ResultSet rs=ps.executeQuery();
		
		List<Emp> le=new ArrayList<Emp>();
		
		
		while(rs.next())
		{
			Emp e=new Emp(rs.getInt(1),rs.getString(2), rs.getString(3));
			
			le.add(e);
		}
		
		
		return le;
	}*/

    }
	