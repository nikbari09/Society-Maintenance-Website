package internship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Backend_for_form {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.driver");
		Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login_database","username","password");
		if(con != null)
		{
			System.out.println("Connection successful");
		}
		else
		{
			System.out.println("Connection failed.");
		}
		Statement stmt=null;
		stmt=con.createStatement();
		ResultSet rs=null;
		rs=stmt.executeQuery("Select * from login_page;");
		
		while(rs.next())
		{
			System.out.println("Name:"+rs.getString("name"));
			System.out.println("Email:"+rs.getString("email"));
			System.out.println("password:"+rs.getString("password"));
			System.out.println("Number:"+rs.getDouble("number"));
		}	
		con.close();
		
		
		
	}

}
