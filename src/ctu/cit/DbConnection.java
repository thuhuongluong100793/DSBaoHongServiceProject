package ctu.cit;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DbConnection {
	public Connection GetConnection() throws Exception
	{
		try
		{
			String connectionURL = "jdbc:mysql://localhost:3306/qlkhdn";
			Connection connection = null;
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "admin", "qlkhdn");
		    return connection;
		}
		catch (SQLException e)
		{
			throw e;	
		}
		catch (Exception e)
		{
			throw e;	
		}
	}

}
